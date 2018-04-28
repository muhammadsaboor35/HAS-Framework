package DeviceControllers.VirtualDeviceControllers;

import DeviceControllers.DeviceControllerContainer;
import DeviceControllers.UltrasonicSensorController;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.net.InetSocketAddress;
import java.net.InetAddress;
import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import com.xuggle.mediatool.IMediaWriter;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.xuggler.ICodec;
import com.xuggle.xuggler.IPixelFormat;
import com.xuggle.xuggler.IVideoPicture;
import com.xuggle.xuggler.video.ConverterFactory;
import com.xuggle.xuggler.video.IConverter;
import stream.agent.StreamServerAgent;

public class VirtualCameraController implements VirtualDeviceController {
   static final private int FPS = 1000/3;
   static private long videoDuration;
   private boolean state;
   private BufferedImage image;
   private Timer imageRefreshTimer;
   private Timer intrusionTimer;
   private DeviceControllerContainer controllers;
   
   public VirtualCameraController( long videoDuration, DeviceControllerContainer controllers ) {
      this.state = false;
      this.image = null;
      this.videoDuration = videoDuration;
      this.controllers = controllers;
      
      this.imageRefreshTimer = new Timer();
      this.intrusionTimer = new Timer();
      this.imageRefreshTimer.schedule( new TimerTask() {
         
         @Override
         public void run() {
            if( VirtualCameraController.this.state ) {
               VirtualCameraController.this.refreshImage();
            }
         }
      }, 0, 5000 );
      this.intrusionTimer.schedule( new TimerTask() {
         
         @Override
         public void run() {
            
            boolean intrusion = false;
            
            for( int i = 0; i < controllers.size(); i++ ) {
               if( controllers.getDeviceController(i) instanceof UltrasonicSensorController ) {
                  if( ( (UltrasonicSensorController) controllers.getDeviceController(i) ).getIntrusionTimestamp() != null ) {
                     intrusion = true;
                     break;
                  }
               }
            }
            if( intrusion ) {
               VirtualCameraController.this.record( VirtualCameraController.videoDuration );
            }
         }
      }, 0, 1000 );
   }
   
   public BufferedImage getImage() {
      return this.image;
   }
   public void record( long secondsDuration ) {
      File file = new File("output.ts");
      
      IMediaWriter writer = ToolFactory.makeWriter(file.getName());
      Dimension size = WebcamResolution.QVGA.getSize();
      
      writer.addVideoStream(0, 0, ICodec.ID.CODEC_ID_H264, size.width, size.height);
      
      Webcam webcam = Webcam.getDefault();
      webcam.setViewSize(size);
      webcam.open(true);
      
      long start = System.currentTimeMillis();
      
      for (int i = 0; i < FPS * secondsDuration; i++) {
         
         BufferedImage image = ConverterFactory.convertToType(webcam.getImage(), BufferedImage.TYPE_3BYTE_BGR);
         IConverter converter = ConverterFactory.createConverter(image, IPixelFormat.Type.YUV420P);
         
         IVideoPicture frame = converter.toPicture(image, (System.currentTimeMillis() - start) * 1000);
         frame.setKeyFrame(i == 0);
         frame.setQuality(0);
         
         writer.encodeVideo(0, frame);
         
         try {
            // 30 FPS
            Thread.sleep(FPS);
         }
         catch( Exception e ) {
            System.out.println( e.getMessage() );
         }
      }
      
      writer.close();
      
      System.out.println("Video recorded in file: " + file.getAbsolutePath());
   }
   
   public void setCameraState( boolean state ) {
      this.state = state;
   }
   
   public boolean getCameraState() {
      return this.state;
   }
   
   public void refreshImage() {
      Webcam webcam = Webcam.getDefault();
      webcam.open();
      
      this.image = webcam.getImage();
      webcam.close();
   }
   
   public void startStreamServer() {
      Webcam.setAutoOpenMode(true);
      Webcam webcam = Webcam.getDefault();
      Dimension dimension = WebcamResolution.QVGA.getSize();
      webcam.setViewSize(dimension);
      
      StreamServerAgent serverAgent = new StreamServerAgent(webcam, dimension);
      try {
         serverAgent.start(new InetSocketAddress(InetAddress.getLocalHost().getHostAddress(), 20000));
      }
      catch( Exception e ) {
         System.out.println( e.getMessage() );
      }
   }
   
}