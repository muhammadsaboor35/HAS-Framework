package com.has.base;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import org.json.JSONObject;
import org.json.JSONArray;

/**
 * List of global properties
 * 1. sleeping time : int[4]
 * 2. temperature for smart control : integer
 * 3. notification email : String
 * 4. send email notifications : boolean
 * 5. email frequency : Frequencies ( make an enum )
 * 6. intrusion video length : integer
 * 7. google drive videos' size limit : integer
 * @author Taha Khurram
 * @version 5/5/2018
 */
public class GlobalOptions {
   //properties
   DataContainer properties;
   
   //contructors
   public GlobalOptions( String jsonText ) {
      try {
         JSONObject json = new JSONObject( jsonText );
         
         int temperature_for_smart_control = json.getInt( "temperature_for_smart_control" );
         String notification_email = json.getString( "notification_email" );
         boolean send_email_notifications = json.getBoolean( "send_email_notifications" );
         int email_frequency = json.getInt( "email_frequency" );
         int intrusion_video_length = json.getInt( "intrusion_video_length" );
         int google_drive_videos_size_limit = json.getInt( "google_drive_videos_size_limit" );
         
         JSONArray arr = json.getJSONArray( "sleeping_time" );
         List<Integer> sleeping_time = new ArrayList<Integer>();
         for(int i = 0; i < arr.length(); i++){
            sleeping_time.add(arr.getInt(i));
         }
         
         System.out.println( temperature_for_smart_control );
         System.out.println( notification_email );
         System.out.println( send_email_notifications );
         System.out.println( email_frequency );
         System.out.println( intrusion_video_length );
         System.out.println( google_drive_videos_size_limit );
         for( int x : sleeping_time ) {
            System.out.println( x );
         }
      }
      catch( Exception e ) {
         System.out.println( e.getMessage() );
      }
      
      this.properties = new DataContainer( new DataStructure( temperature_for_smart_control, notification_email, send_email_notifications, email_frequency
                                                            , intrusion_video_length, google_drive_videos_size_limit ) );
   }
   
   //methods
   
   /**
    * returns the property as a data container
    * @return DataContainer properties
    */
   public DataContainer getProperties() {
      return properties;
   }
}
