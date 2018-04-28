package Pin;


/**
 * @author Muhammad Saboor
 * @version 28/4/2018
 */
public class Pin {
   private int pinNumber;
   
   public Pin( int pinNumber ) {
      if( isValidPinNumber( pinNumber ) ) {
         this.pinNumber = pinNumber;
      }
      else {
         System.out.println( "Invalid Pin Number" );
      }
   }
   
   public void setPinNumber( int pinNumber ) {
      if( isValidPinNumber( pinNumber ) ) {
         this.pinNumber = pinNumber;
      }
      else {
         System.out.println( "Invalid Pin Number" );
      }
   }
   
   public int getPinNumber() {
      return this.pinNumber;
   }
   
   public static boolean isValidPinNumber( int pinNumber ) {
      if( pinNumber == -1 || pinNumber > 0 ) {
         return true;
      }
      return false;
   }
}
         