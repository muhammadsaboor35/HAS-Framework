package DeviceControllers.VirtualDeviceControllers;


/**
 * @author Muhammad Saboor
 * @version 28/4/2018
 */
public class VirtualHeaterController implements VirtualDeviceController {
   private boolean state;
   
   public VirtualHeaterController() {
      this.state = false;
   }
   
   public boolean getHeaterState() {
      return this.state;
   }
   
   public void setHeaterState( boolean state ) {
      this.state = state;
   }
}