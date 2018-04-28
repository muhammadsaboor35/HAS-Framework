package Devices;

import Pin.Pin;


/**
 * @author Muhammad Saboor
 * @version 28/4/2018
 */
public abstract class Device {
   private Pin pin;
   private String room;
   private String name;
   
   public Device( String name, String room, int pinNumber ) {
      this.name = name;
      this.room = room;
      this.pin = new Pin( pinNumber );
   }
   
   public String getName() {
      return this.name;
   }
   
   public String getRoom() {
      return this.room;
   }
   
   public Pin getPin() {
      return this.pin;
   }
   
   public int getPinNumber() {
      return this.pin.getPinNumber();
   }
   
   public void setName( String name ) {
      this.name = name;
   }
}