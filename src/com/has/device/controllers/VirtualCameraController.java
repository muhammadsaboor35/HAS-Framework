package com.has.device.controllers;

import java.awt.image.BufferedImage;

import com.has.device.devices.CameraDevice;

/**
 * 
 * 
 * @author Ufuk BOMBAR
 * @since 01.05.2018 23:07
 * @version 1.0
 */
public class VirtualCameraController extends CameraController
{
    /**
     * Turn camera on or off
     * @param on camera state
     */
    @Override
    public void setCameraState( boolean on )
    {
        
    }

    /**
     * Gets camera state
     * @return true if on, false if off
     */
    @Override
    public boolean getCameraState()
    {
        return false;
    }

    /**
     * Starts recording for specified seconds
     * @param forSeconds specified seconds
     */
    @Override
    public void record( long forSeconds )
    {

    }

    /**
     * Gets the image
     * @return image
     */
    @Override
    public BufferedImage getImage()
    {
        return null;
    }

    /**
     * Sets the image
     * @param image the image
     */
    public void setImage( BufferedImage image )
    {
        // Something like this: 
        ( ( CameraDevice ) device).setImage( image );
    }

    @Override
    public boolean isVirtual()
    {
        return true;
    }
}