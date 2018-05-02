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
public class TempSensorDevice extends Device
{
    private double temp;

    /**
     * Constructor of abstract device. Adds itself to room automatically!
     * @param id the id
     * @param room the room, adds itself automatically
     * @param displayName display name for UI
     * @param pin pin number
     * @param dc pair DeviceController object
     */
    public TempSensorDevice( int id, Room room, String displayName, Pin pin, DeviceController dc ) throws Exception
    {
        super( id, room, displayName, pin, dc );
        temp = 0.0d;
    }

    /**
     * Sets the value in memory, not in real!
     * @param temp
     */
    public void setTemperature( double temp )
    {
        this.temp = temp;
    }

    /**
     * Gets the value in memory, not from i/o pins!
     * @return double temp
     */
    public double getTemperature()
    {
        return this.temp;
    }
}