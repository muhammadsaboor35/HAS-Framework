package com.has.base;
import java.io.Serializable;
import java.util.ArrayList;
import com.has.device.controllers.DeviceController;
import com.has.device.Room;

/**
 * @author Taha Khurram
 * @version 5/5/2018
 */
public class Configuration implements Serializable {
   
   //Properties
   protected ArrayList<DeviceController> controllers;
   protected ArrayList<Room> rooms;
   
   //constructors
   
   Configuration() {
      
   }
   
   Configuration( String jsonText ) {
      
   }
   
   //methods
   
   /**
    * 
    */
   public ArrayList<DeviceController> getControllers() {
      return controllers;
   }
   
   
   /**
    * 
    */
   public ArrayList<Room> getRooms() {
      return rooms;
   }
}