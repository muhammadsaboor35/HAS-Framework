package com.has.device.controllers;

import java.awt.image.BufferedImage;

/**
 * 
 * 
 * @author Ufuk BOMBAR
 * @since 01.05.2018 23:07
 * @version 1.0
 */
public class CameraController extends DeviceController
{
    /**
     * Turn camera on or off
     * @param on camera state
     */
    public void setCameraState( boolean on )
    {
        
    }

    /**
     * Gets camera state
     * @return true if on, false if off
     */
    public boolean getCameraState()
    {
        return false;
    }

    /**
     * Starts recording for specified seconds
     * @param forSeconds specified seconds
     */
    public void record( long forSeconds )
    {

    }

    /**
     * Gets the image
     * @return image
     */
    public BufferedImage getImage()
    {
        return null;
    }

    @Override
    public boolean isVirtual()
    {
        return false;
    }
}