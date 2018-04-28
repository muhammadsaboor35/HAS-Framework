package DeviceControllers.VirtualDeviceControllers;

public class VirtualPushButtonController implements VirtualDeviceController {
   private boolean pressed;
   
   public VirtualPushButtonController() {
      this.pressed = false;
   }
   
   public boolean isPressed() {
      return this.pressed;
   }
   public void setPressed( boolean pressed ) {
      this.pressed = pressed;
   }
}