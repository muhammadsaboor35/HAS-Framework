import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.googleapis.media.MediaHttpDownloaderProgressListener;
import com.google.api.client.googleapis.media.MediaHttpUploaderProgressListener;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.googleapis.media.MediaHttpUploaderProgressListener;
import com.google.api.services.drive.model.ParentReference;
import java.io.IOException;
import java.text.NumberFormat;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.api.client.http.InputStreamContent;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.*;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


/**
 * @author Taha Khurram
 * @author Muhammad Saboor
 * @version 4/28/2018
 */
public class GoogleDriveManager {
   private static ArrayList<File> FILES = new ArrayList<>();
   
   private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
   
   
   public static ArrayList<File> getListOfAllFiles( String authToken ) {
      ArrayList<File> files = new ArrayList<>();
      String pageToken = null;
      try {
         final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
         GoogleCredential credential = new GoogleCredential();
         credential.setAccessToken(authToken);
         
         Drive drive = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).build();
         if (drive != null) {
            do {
               FileList list = drive.files().list()
                  .setFields("nextPageToken, items(id, title, mimeType, embedLink, downloadUrl, fileSize)")
                  .setPageToken(pageToken)
                  .execute();
               
               for (File file : list.getItems()) {
                  files.add( file );
                  FILES.add( file );
               }
               // items(id, title, mimeType)
               //only for debug purposes
//               for (File file : list.getItems()) {
//                  System.out.printf("Found file: %s\n",
//                                    file.getEmbedLink());
//               }
               pageToken = list.getNextPageToken();
            } while (pageToken != null );
            System.out.println( "done" );
         }
      }
      catch( Exception e ) {
         System.out.println( e.getMessage() );
      }
      return files;
   }
   
   public static void download( String title, String authToken, String path ) {
      try {
         final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
         GoogleCredential credential = new GoogleCredential();
         credential.setAccessToken(authToken);
         
         Drive drive = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).build();
         
         if (drive != null) {
            String fileID = null;
            String extension = null;
            FileList list = drive.files().list().setQ( "title contains '" + title + "'" )
               .setFields("items(id, fileExtension)")
               .execute();
            for (File file : list.getItems()) {
               fileID = file.getId();
               extension = file.getFileExtension();
            }
            System.out.println( fileID );
            
            class CustomProgressListener implements MediaHttpDownloaderProgressListener {
               public void progressChanged(MediaHttpDownloader downloader) {
                  switch (downloader.getDownloadState()) {
                     case MEDIA_IN_PROGRESS:
                        System.out.println(downloader.getProgress());
                        break;
                     case MEDIA_COMPLETE:
                        System.out.println("Download is complete!");
                  }
               }
            }
            
            OutputStream out = new FileOutputStream(path + title + "." + extension);
            
            Drive.Files.Get request = drive.files().get(fileID);
            request.getMediaHttpDownloader().setProgressListener(new CustomProgressListener());
            request.executeMediaAndDownloadTo(out);
            
            System.out.println( "done" );
            out.flush();
         }   
      }
      catch( Exception e ) {
         System.out.println( e.getMessage() );
      }
   }
   
   public static String getStreamUrl( String title, String authToken ) {
      String url = null;
      try {
         final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
         GoogleCredential credential = new GoogleCredential();
         credential.setAccessToken(authToken);
         
         Drive drive = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).build();
         
         if (drive != null) {
            FileList list = drive.files().list().setQ( "title contains '" + title + "'" )
               .setFields("items(embedLink)")
               .execute();
            for (File file : list.getItems()) {
               url = file.getEmbedLink();
            }
            System.out.println( url );
            
         }
      }
      catch( Exception e ) {
         System.out.println( e.getMessage() );
      }
      return url;
   }
   
   public static void delete( String title, String authToken ) {
      try {
         final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
         GoogleCredential credential = new GoogleCredential();
         credential.setAccessToken(authToken);
         
         Drive drive = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).build();
         
         if (drive != null) {
            FileList list = drive.files().list().setQ( "title contains '" + title + "'" )
               .setFields("items(id)")
               .execute();
            for (File file : list.getItems()) {
               drive.files().delete(file.getId()).execute();
            }
         }
         System.out.println( "done" );
      }
      catch( Exception e ) {
         System.out.println( e.getMessage() );
      }
   }
   
   public static void createFolder( String name, String authToken ) {
      try {
         final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
         GoogleCredential credential = new GoogleCredential();
         credential.setAccessToken(authToken);
         
         Drive drive = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).build();
         
         File fileMetadata = new File();
         fileMetadata.setTitle(name);
         fileMetadata.setMimeType("application/vnd.google-apps.folder");
         
         File file = drive.files().insert(fileMetadata)
            .setFields("id")
            .execute();
         System.out.println("Folder ID: " + file.getId());
      }
      catch( Exception e ) {
         System.out.println( e.getMessage() );
      }
   }
   
   public static void uploadFileInFolder( String path, String folderName, String authToken ) {
      try {
         class FileUploadProgressListener implements MediaHttpUploaderProgressListener {
            
            @Override
            public void progressChanged(MediaHttpUploader uploader) throws IOException {
               switch (uploader.getUploadState()) {
                  case INITIATION_STARTED:
                     System.out.println("Upload Initiation has started.");
                     break;
                  case INITIATION_COMPLETE:
                     System.out.println("Upload Initiation is Complete.");
                     break;
                  case MEDIA_IN_PROGRESS:
                     System.out.println("Upload is In Progress: "
                                           + NumberFormat.getPercentInstance().format(uploader.getProgress()));
                     break;
                  case MEDIA_COMPLETE:
                     System.out.println("Upload is Complete!");
                     break;
               }
            }
         }
         
         
         
         final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
         GoogleCredential credential = new GoogleCredential();
         credential.setAccessToken(authToken);
         
         Drive drive = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).build();
         String folderID = null;
         if (drive != null) {
            FileList list = drive.files().list().setQ( "mimeType = 'application/vnd.google-apps.folder' and title contains '" + folderName + "'" )
               .setFields("items(id)")
               .execute();
            for (File file : list.getItems()) {
               folderID = file.getId();
            }
         }
         
         java.io.File file = new java.io.File(path);
         File fileMetadata  = new File();
         
         fileMetadata.setTitle(file.getName() );
         fileMetadata.setMimeType("video/mp4");
         fileMetadata.setParents(Collections.singletonList(new ParentReference().setId(folderID)));
         System.out.println( folderID );
         
         FileContent mediaContent = new FileContent("video/mp4", file);
         
         Drive.Files.Insert request = drive.files().insert(fileMetadata, mediaContent);
         MediaHttpUploader uploader = request.getMediaHttpUploader();
         uploader.setProgressListener(new FileUploadProgressListener());
         request.execute();
      }
      catch( Exception e ) {
         System.out.println( e.getMessage() );
      }
   }
}
