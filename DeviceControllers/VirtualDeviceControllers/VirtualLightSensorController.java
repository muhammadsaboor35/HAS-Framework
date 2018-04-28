package DeviceControllers.VirtualDeviceControllers;

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