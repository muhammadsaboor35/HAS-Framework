package DeviceControllers.VirtualDeviceControllers;


/**
 * @author Muhammad Saboor
 * @version 28/4/2018
 */
public class VirtualLightSensorController implements VirtualDeviceController {
   private double intensity;
   
   public VirtualLightSensorController() {
      this.intensity = 0;
   }
   
   public double getIntensity() {
      return this.intensity;
   }
   
   public void setIntensity( double intensity ) {
      this.intensity = intensity;
   }
}