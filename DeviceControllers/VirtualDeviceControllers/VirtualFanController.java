package DeviceControllers.VirtualDeviceControllers;

public class VirtualFanController implements VirtualDeviceController {
   private boolean state;
   
   public VirtualFanController( ) {
      this.state = false;
   }
   
   public boolean getFanState() {
      return this.state;
   }
   
   public void setFantState( boolean state ) {
      this.state = state;
   }
}