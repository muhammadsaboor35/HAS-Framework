package com.has.base;
import java.io.Serializable;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.List;
import java.util.ArrayList;

/**
 * The list of local options:
 * 1. video download path : String
 * 2. security pin : qwertyuiopasdfghjklzxcvbnm
 * @author Taha Khurram
 * @version 5/5/2018
 */
public class LocalOptions implements Serializable {
   //properties
   DataContainer properties;
   
   //contructors
   public LocalOptions( String jsonText ) {
      try {
         JSONObject json = new JSONObject( jsonText );
         
         String video_download_path = json.getString( "video_download_path" );
         
         JSONArray arr = json.getJSONArray( "security_pin" );
         List<String> security_pin = new ArrayList<String>();
         for(int i = 0; i < arr.length(); i++){
            security_pin.add(arr.getString(i));
         }
         System.out.println( video_download_path );
         for( String x : security_pin ) {
            System.out.println( x );
         }
      }
      catch( Exception e ) {
         System.out.println( e.getMessage() );
      }
   }
   
   //methods
   
   /**
    * returns the properties
    * @return DataContainer properties
    */
   public DataContainer getProperties() {
      return properties;
   }
}
