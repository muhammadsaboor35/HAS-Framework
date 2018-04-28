package DeviceControllers;

import java.awt.image.BufferedImage;


/**
 * @author Muhammad Saboor
 * @version 28/4/2018
 */
public interface CameraController extends DeviceController {
   public BufferedImage getImage();
   public void record( long secondsDuration );
   public void setCameraState( boolean state );
   public void getCameraState();
}