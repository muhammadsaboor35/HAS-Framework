package DeviceControllers.VirtualDeviceControllers;

public class VirtualLightController implements VirtualDeviceController {
   private boolean state;
   
   public VirtualLightController() {
      this.state = false;
   }
   
   public boolean getLightState() {
      return this.state;
   }
   
   public void setLightState( boolean state ) {
      this.state = state;
   }
}