package DeviceControllers.VirtualDeviceControllers;

import java.sql.Timestamp;
import java.util.Timer;
import java.util.TimerTask;

public class VirtualUltrasonicSensorController implements VirtualDeviceController {
   private final double THRESHOLD;
   
   private double distance;
   private Timestamp intrusionTimestamp;
   
   public VirtualUltrasonicSensorController( double threshold ) {
      this.THRESHOLD = threshold;
      this.distance = 0;
      this.intrusionTimestamp = null;
      
      Timer timer = new Timer();
      timer.schedule( new TimerTask() {
         
         @Override
         public void run() {
            if( VirtualUltrasonicSensorController.this.distance < threshold ) {
               VirtualUltrasonicSensorController.this.intrusionTimestamp = new Timestamp(System.currentTimeMillis());
            }
            else {
               VirtualUltrasonicSensorController.this.intrusionTimestamp = null;
            }
         }
      }, 0, 1000 );
   }
   
   public double getDistance() {
      return this.distance;
   }
   
   public Timestamp getIntrusionTimestamp() {
      return this.intrusionTimestamp;
   }
   
   public void setDistance( double distance ) {
      this.distance = distance;
   }
   
}