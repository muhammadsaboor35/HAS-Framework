import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL; 
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;


/**
 * @author Taha Khurram
 * @author Muhammad Saboor
 * @version 4/28/2018
 */
public class GoogleSessionManager {
   static final String CLIENT_ID = "837386847506-t72liabf75j0m20ssibv8bgej2rur0av.apps.googleusercontent.com";
   static final String CLIENT_SECRET = "-5PnXturrRB3sOAWAgbIc7HM";
   static final String REDIRECT_URI = "urn:ietf:wg:oauth:2.0:oob:auto";
   static final String AUTH_GRANT_TYPE = "authorization_code";
   static final String REFRESH_GRANT_TYPE = "refresh_token";
   static final String URL = "https://www.googleapis.com/oauth2/v4/token";
   
   boolean logged_in;
   String access_token;
   String id_token;
   String refresh_token;
   int expires_in;
   String token_type;
   Timer t;
   
  
   public GoogleSessionManager( String code ) {
      try {
         URL url = new URL( URL );
         
         
         String query = "code="+(code); 
         query += "&client_id="+(CLIENT_ID);
         query += "&client_secret="+(CLIENT_SECRET);
         query += "&redirect_uri="+(REDIRECT_URI);
         query += "&grant_type="+(AUTH_GRANT_TYPE);
         
         HttpURLConnection conn = (HttpURLConnection)url.openConnection();
         conn.setRequestMethod("POST");
         conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
         
         conn.setDoOutput(true);
         DataOutputStream writer = new DataOutputStream( conn.getOutputStream());
         writer.writeBytes(query);
         writer.flush();
         
         String line, outputString = "";
         BufferedReader in = new BufferedReader(new InputStreamReader( conn.getInputStream()));
         
         StringBuilder sb = new StringBuilder();
         for (int c; (c = in.read()) >= 0;) {
            sb.append((char)c);
         }
         
         String response = sb.toString();
         
         //parse this response to JSON and extract fields
         JSONObject json = new JSONObject( response );
         this.access_token = json.getString( "access_token" );
         this.id_token = json.getString( "id_token" );
         this.refresh_token = json.getString( "refresh_token" );
         this.token_type = json.getString( "token_type" );
         this.expires_in = json.getInt( "expires_in" );
         
         
         System.out.println( this.access_token );
         System.out.println( this.id_token );
         System.out.println( this.refresh_token );
         System.out.println( this.token_type );
         System.out.println( this.expires_in );
         
         logged_in = true;
         
         t = new Timer();
         t.schedule( new TimerTask() {
            
            @Override
            public void run() {
               if( logged_in ) {
                  refresh();
               }
            }
         }, ( ( this.expires_in - 5 ) * 1000 ), ( ( this.expires_in - 5 ) * 1000 ) ); //( ( this.expires_in - 5 ) * 1000 )
      }
      catch( Exception e ) {
         System.out.println( e.getMessage() );
         logged_in = false;
      }
   }
   public void refresh() {
      try {
         URL url = new URL( URL );
         
         String query = "&client_id="+(CLIENT_ID);
         query += "&client_secret="+(CLIENT_SECRET);
         query += "&refresh_token="+(refresh_token);
         query += "&grant_type="+(REFRESH_GRANT_TYPE);
         
         HttpURLConnection conn = (HttpURLConnection)url.openConnection();
         conn.setRequestMethod("POST");
         conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
         
         conn.setDoOutput(true);
         DataOutputStream writer = new DataOutputStream( conn.getOutputStream());
         writer.writeBytes(query);
         writer.flush();
         
         BufferedReader in = new BufferedReader(new InputStreamReader( conn.getInputStream()));
         
         StringBuilder sb = new StringBuilder();
         for (int c; (c = in.read()) >= 0;) {
            sb.append((char)c);
         }
         
         String response = sb.toString();
         
         //parse this response to JSON and extract fields
         JSONObject json = new JSONObject( response );
         this.access_token = json.getString( "access_token" );
         this.token_type = json.getString( "token_type" );
         this.expires_in = json.getInt( "expires_in" );
         
         System.out.println( "======================" );
         System.out.println( this.access_token );
         System.out.println( this.token_type );
         System.out.println( this.expires_in );
      }
      catch( Exception e ) {
         System.out.println( e.getMessage() );
         this.logged_in = false;
      }
   }
   
   public void logout() {
      this.access_token = null;
      this.id_token = null;
      this.refresh_token = null;
      this.token_type = null;
      this.logged_in = false;
      
      //revoke access
      //visit logout page for google
   }
   
   public String getAccessToken() {
      return this.access_token;
   }
   
}
