package com.has.device;

import java.util.ArrayList;

/**
 * Pin is the object representation of a pin in raspberry-pi
 *
 * @author Ufuk BOMBAR, Ege Ozan Özyedek
 * @since 01.05.2018 23:07
 * @version 2.0
 */
public class Pin
{
    public static final int VIRTUAL_PIN = -1;
    public static ArrayList<Integer> occupiedPins;
    private int pin;

    /**
     * Constructor, initalizes pin number by argument pin. Throws an {@link Exception} if argument is not valid
     * @param pin the pin
     */
    public Pin( int pin ) throws Exception
    {
        if ( !isValid( ) )
        {
            pin = Pin.VIRTUAL_PIN;
            throw new Exception( "Pin number is not valid!" );

        }
        else
            occupiedPins.add( pin);
            this.pin = pin;

    }

    /**
     * Constructor, constructs a virtual Pin object
     */
    public Pin()
    {
        this.pin = Pin.VIRTUAL_PIN;
    }

    // TODO #001: Write input-output methods that will controll the harware in raspberry-pi, also add code to constructor


    /**
     * Gets the pin number
     * @return pin number
     */
    public int getPin()
    {
        return pin;
    }

    /**
     * Checks the pin is valid
     * @return true if pin is virtual or valid, false otherwise
     */
    public boolean isValid()
    {
        if ( ( pin > 0 && occupiedPins.indexOf( pin) == -1) || isVirtual())
            return true;
        else
            return false;
    }

    /**
     * Checks if the pin is virtual
     * @return true if pin is virtual, false otherwise
     */
    public boolean isVirtual()
    {
        return pin == VIRTUAL_PIN ? true : false;
    }

    /**
     * Gets the string representation
     * @return String representation
     */
    @Override
    public String toString()
    {
        return pin == VIRTUAL_PIN ? "VIRTUAL_PIN" : pin + "";
    }

}
