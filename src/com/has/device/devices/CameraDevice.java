package com.has.device.devices;

import java.awt.image.BufferedImage;

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
public class CameraDevice extends Device
{
    private boolean state;
    private BufferedImage image;

    /**
     * Constructor of abstract device. Adds itself to room automatically!
     * @param id the id
     * @param room the room, adds itself automatically
     * @param displayName display name for UI
     * @param pin pin number
     * @param dc pair DeviceController object
     */
    public CameraDevice( int id, Room room, String displayName, Pin pin, DeviceController dc ) throws Exception
    {
        super( id, room, displayName, pin, dc );
        state = false;
        image = null;
    }

    /**
     * Sets the value in memory, not in real!
     * @param state state
     */
    public void setState( boolean state )
    {
        this.state = state;
    }

    /**
     * Gets the value in memory, not from i/o pins!
     * @return boolean state
     */
    public boolean getState()
    {
        return this.state;
    }

    /**
     * @return the image
     */
    public BufferedImage getImage()
    {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage( BufferedImage image )
    {
        this.image = image;
    }
}