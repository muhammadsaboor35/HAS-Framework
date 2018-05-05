package com.has.device.devices;

import com.has.device.Pin;
import com.has.device.Room;
import com.has.device.controllers.DeviceController;

/**
 *
 *
 * @author Ufuk BOMBAR, Ege Ozan Özyedek
 * @since 01.05.2018 23:07
 * @version 2.0
 */
public abstract class Device
{

    public static final int MAIN_PIN_ID = 0;

    protected int id;
    protected Room room;
    protected String displayName;
    protected Pin[] pins;
    protected final DeviceController dc;

    /**
     * Constructor of abstract device. Adds itself to room automatically!
     * @param id the id
     * @param room the room, adds itself automatically
     * @param displayName display name for UI
     * @param pin pin number
     * @param dc pair DeviceController object
     */
    public Device( int id, Room room, String displayName, Pin[] pin, DeviceController dc ) throws Exception
    {
        boolean virtual;
        virtual = true;
        for (int i = 0; i < pin.length; i++) {
            if ( !pin[i].isVirtual()) {
                virtual = false;
                i = pin.length;
            }
        }

        if ( !this.isVirtual() && virtual )
            throw new Exception( "Non-virtual Device cannot have a virtual pin" );

        this.id = id;
        this.room = room;
        this.displayName = displayName;
        pins = pin;
        this.dc = dc;
        room.getDevices().add( this );
    }

    /**
     * This is the abstract method for seeing is the object is abstract or not
     * @return true if it is virtual, false if it is real
     */
    public boolean isVirtual()
    {
        return dc.isVirtual();
    }

    /**
     * Gets the id
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * Gets the DeviceController
     * @return the DeviceController
     */
    public DeviceController getDeviceController()
    {
        return dc;
    }

    /**
     * Gets the room
     * @return the room
     */
    public Room getRoom()
    {
        return room;
    }

    /**
     * Gets the display name
     * @return the displayName
     */
    public String getDisplayName()
    {
        return displayName;
    }

    /**
     * Sets the display name
     * @param displayName the displayName to set
     */
    public void setDisplayName( String displayName )
    {
        this.displayName = displayName;
    }

    /**
     * Method to return the number of pins
     * @return the number of pins
     */
    public int getPinCount() {
        return pins.length;
    }

    /**
     * Method which returns a specific pin at the desired index
     * @param index, the Pin index
     * @return Pin at the requested index
     */
    public Pin getPin( int index) {
        return pins[ index];
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder( this.getClass().toString() );
        sb.append( " name: " );
        sb.append( displayName );

        sb.append( " id: " );
        sb.append( id );

        sb.append( " pin: " );
        sb.append( pin.toString() );

        return sb.toString();
    }


}
