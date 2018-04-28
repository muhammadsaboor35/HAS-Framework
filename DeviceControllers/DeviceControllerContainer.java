package DeviceControllers;

import java.util.ArrayList;

public class DeviceControllerContainer {
   private ArrayList< DeviceController > deviceControllers;
   
   public DeviceControllerContainer() {
      this.deviceControllers = new ArrayList<>();
   }
   
   public DeviceController getDeviceController( int index ) {
      try{
         return this.deviceControllers.get( index );
      }
      catch( Exception e ) {
         System.out.println( e.getMessage() );
         return null;
      }
   }
   
   public void addDeviceController( DeviceController controller ) {
      this.deviceControllers.add( controller );
   }
   
   public void addDeviceController( DeviceController controller, int index ) {
      this.deviceControllers.add( index, controller );
   }
   
   public int size() {
      return this.deviceControllers.size();
   }
   
   public void removeDeviceController( DeviceController controller ) {
      this.deviceControllers.remove( controller );
   }
}