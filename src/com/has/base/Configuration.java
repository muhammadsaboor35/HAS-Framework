package com.has.base;
import java.io.Serializable;
import java.util.ArrayList;
import com.has.device.controllers.DeviceController;
import com.has.device.Room;
import com.has.device.Pin;
import com.has.device.devices.Device;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Taha Khurram, Ege Ozan Özyedek
 * @version 5/5/2018
 */
public class Configuration implements Serializable {
   
   public static final String PATH_FOR_WINDOWS = " ";
   public static final String PATH_FOR_LINUX = " ";
   
   //Properties
   protected ArrayList<DeviceController> controllers;
   protected ArrayList<Room> rooms;
   
   //constructors
   
   Configuration(){
      
      String configuration = "";
      if( isWindows() ) {
         configuration = new LocalOptions( Options.readFile( Configuration.PATH_FOR_WINDOWS ) );
      }
      if( isLinux() ) {
         configuration = new LocalOptions( Options.readFile( Configuration.PATH_FOR_LINUX ) );
      }
      
      Configuration.parseJSON( configuration );
   }
   
   //methods
   
   /**
    * 
    */
   public ArrayList<DeviceController> getControllers() {
      return this.controllers;
   }
   
   
   /**
    * 
    */
   public ArrayList<Room> getRooms() {
      return this.rooms;
   }
   
   public static void parseJSON( String json ) {
      JSONObject json = new JSONObject( jsonText );
      
      JSONArray roomsJsonArray = json.getJsonArray( "rooms" );
      JSONArray devicesJsonArray = json.getJsonArray( "devices" );
      
      List<Device> devices = new ArrayList<Device>();
      this.rooms = new ArrayList<Room>();
      
      for(int i = 0; i < devicesJsonArray.length(); i++){
         JSONObject device = devicesJsonArray.getJSONObject( i );
         
         int id = device.getInt( "id" );
         String displayName = device.getString( "device_name" );
         String deviceType = device.getString( "device_type" );
         JSONArray pinsJsonArray = device.getJSONObject( "pins" );
         
         List<Pin> pins = new ArrayList<Pin>();
         for( int j = 0, j < pinsJsonArray.length; j++ ) {
            JSONObject pin = pinsJsonArray.getJSONObject( j );
            
            int pinNumber = pin.getInt( "pin" );
            
            pins.add( new Pin( pinNumber ) );
         }
         
         devices.add( createDevice( id, displayName, pins, deviceType ) );
      }
      
      for( int i = 0; i < roomsJsonArray.length(); i++ ) {
         JSONObject room = roomsJsonArray.getJSONObject( i );
         
         int id = room.getInt( "id" );
         String displayName = room.getString( "device_name" );
         JSONArray devicesJsonArray = room.getJSONObject( "devices_id" );
         
         List<Integers> deviceIds = new ArrayList<Integer>();
         for( int j = 0; j < devicesJsonArray.length(); j++ ) {
            deviceIds.add( devicesJsonArray.getInt( j ) );
         }
         
         Room temp = new Room( id, displayName );
         for( int j = 0; j < deviceIds.size(); j++ ) {
            int device_id = deviceIds.get( j );
            for( Device device : devices ) {
               if( device.getId() == device_id ) {
                  temp.add( device );
               }
            }
         }
         rooms.add( temp );
      }
      
      for( Device device : devices ) {
         DeviceController deviceController = new DeviceController();
         deviceController.setDevice( device );
         
         this.controllers.add( deviceController );
      }
   }
   
   public static Device createDevice( int id, String displayName, Pins[] pins, String deviceType ) {
      if( deviceType.equals( "CameraDevice" ) ) {
         return New CameraDevice( id, displayName, pins );
      }
      else if( deviceType.equals( "FanDevice" ) ) {
         return New FanDevice( id, displayName, pins );
      }
      else if( deviceType.equals( "GasSensorDevice" ) ) {
         return New GasSensorDevice( id, displayName, pins );
      }
      else if( deviceType.equals( "HeaterDevice" ) ) {
         return New HeaterDevice( id, displayName, pins );
      }
      else if( deviceType.equals( "LightDevice" ) ) {
         return New LightDevice( id, displayName, pins );
      } 
      else if( deviceType.equals( "LightSensorDevice" ) ) {
         return New LightSensorDevice( id, displayName, pins );
      }
      else if( deviceType.equals( "PushButtonDevice" ) ) {
         return New PushButtonDevice( id, displayName, pins );
      } 
      else if( deviceType.equals( "TempSensorDeviceDevice" )  ){
         return New TempSensorDevice( id, displayName, pins );
      } 
      else if( deviceType.equals( "UltrasonicSensorDevice" ) ) {
         return New UltrasonicSensorDevice( id, displayName, pins );
      }
      throws new IllegalArgumentException();
   }
   
   /**
   * A method that returns configuration as a JSON code
   * @return result, the result String
   */
   public String getJSON() {
        String result;
        result = "{\"rooms\":[\n";
        for ( int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get( i);
            result += "{\n\"id\":" + room.getId()+ ",\n";
            result += "\"display_name\":\"" + room.getDisplayName() + "\",\n";
            result += "devices_id:" + room.getDevices().toString() + "\n}" ;
            if ( i != rooms.size() - 1)
                result += ",\n";
        }

        result += "\n],\n\"devices\":[\n";


        for ( int i = 0; i < controllers.size(); i++) {
            Device device = controller.get(i);

            result += "{\n\"id\":" + device.getId() + ",\n ";
            result += "\"device_name\":" + device.getDisplayName() + ",\n ";
            result += "\"device_type\":" + device.getDeviceType() + ",\n{ ";
            result += "\"pins\":[\n{\n";

            for ( int j = 0; j < device.getPinCount(); j++)
                result += "\"pin\":" + device.getPin( j) + ",\n";

            result += "}\n]\n}";
            if ( i != controllers.size() - 1)
                result += ",\n";
        }

        result += "]\n}";
        System.out.println( result);
        return result;
    }
   
   public static void writeStringToFile( String pathName, String text ) throws IOException, FileNotFoundException {
      try (PrintWriter out = new PrintWriter(pathName)) {
         out.println(text);
      }
      catch( Exception e ) {
         System.out.println( e.getMessage() );
      }
   }
}
