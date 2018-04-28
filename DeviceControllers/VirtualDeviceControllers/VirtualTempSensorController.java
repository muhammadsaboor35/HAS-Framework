package DeviceControllers.VirtualDeviceControllers;

public class VirtualTempSensorController implements VirtualDeviceController {
   private double temperature;
   
   public VirtualTempSensorController() {
      this.temperature = 0;
   }
   
   public double getTemperature() {
      return this.temperature;
   }
   
   public void setTemperature( double temperature ) {
      this.temperature = temperature;
   }
}