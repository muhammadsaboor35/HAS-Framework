package com.has.base;
import java.io.Serializable;
import java.io.IOException;
import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author Taha Khurram
 * @version 5/5/2018
 */
public class Options {
   
   //properties
   GlobalOptions globalOptions;
   LocalOptions localOptions;
   
   //contructor
   public Options( String localOptionsPath,String globalOptionsPath ) throws IOException {
      
      this.localOptions = new LocalOptions( Options.readFile( localOptionsPath ) );
      this.globalOptions = new GlobalOptions( Options.readFile( globalOptionsPath ) );
      
   }
   
   //methods
   
   /**
    * 
    */
   public LocalOptions getLocal() {
      return this.localOptions;
   }
   
   /**
    * 
    */
   public GlobalOptions getGlobal() {
      return this.globalOptions;
   }
   
   private static String readFile(String pathname) throws IOException {

    File file = new File(pathname);
    StringBuilder fileContents = new StringBuilder((int)file.length());
    Scanner scanner = new Scanner(file);
    String lineSeparator = System.getProperty("line.separator");

    try {
        while(scanner.hasNextLine()) {
            fileContents.append(scanner.nextLine() + lineSeparator);
        }
        return fileContents.toString();
    } finally {
        scanner.close();
    }
}
}