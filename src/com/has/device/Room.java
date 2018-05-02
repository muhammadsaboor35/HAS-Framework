package com.has.device;

import java.util.ArrayList;
import com.has.device.devices.Device;

/**
 * 
 * 
 * @author Ufuk BOMBAR
 * @since 01.05.2018 23:07
 * @version 1.0
 */
public class Room
{
    private int id;
    private ArrayList<Device> devices;
    private String displayName;

    /**
     * Constructor, creates a room object
     * @param id the id of the string
     * @param displayName display name for UI
     */
    public Room( int id, String displayName )
    {
        this.id = id;
        this.displayName = displayName;
        devices = new ArrayList<Device>();
    }

    /**
     * Gets the device list located on room
     * @return the devices
     */
    public ArrayList<Device> getDevices()
    {
        return devices;
    }

    /**
     * Gets this id
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * Gets the display name of the room
     * @return the displayName
     */
    public String getDisplayName()
    {
        return displayName;
    }

    /**
     * Sets the diplay name of the room
     * @param displayName the displayName to set
     */
    public void setDisplayName( String displayName )
    {
        this.displayName = displayName;
    }
}