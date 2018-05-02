package com.has.device.devices;

import com.has.device.Pin;
import com.has.device.Room;
import com.has.device.controllers.DeviceController;

/**
 * 
 * 
 * @author Ufuk BOMBAR
 * @since 01.05.2018 23:07
 * @version 1.0
 */
public class UltrasonicSensorDevice extends Device
{
    private double distance;

    /**
     * Constructor of abstract device. Adds itself to room automatically!
     * @param id the id
     * @param room the room, adds itself automatically
     * @param displayName display name for UI
     * @param pin pin number
     * @param dc pair DeviceController object
     */
    public UltrasonicSensorDevice( int id, Room room, String displayName, Pin pin, DeviceController dc ) throws Exception
    {
        super( id, room, displayName, pin, dc );
        distance = 0.0d;
    }

    /**
     * Sets the value in memory, not in real!
     * @param distance
     */
    public void setDistance( double distance )
    {
        this.distance = distance;
    }

    /**
     * Gets the value in memory, not from i/o pins!
     * @return double distance
     */
    public double getDistance()
    {
        return this.distance;
    }
}