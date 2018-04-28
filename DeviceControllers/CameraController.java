package DeviceControllers;

import java.awt.image.BufferedImage;

public interface CameraController extends DeviceController {
   public BufferedImage getImage();
   public void record( long secondsDuration );
   public void setCameraState( boolean state );
   public void getCameraState();
}