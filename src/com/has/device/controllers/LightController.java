package com.has.device.controllers;

/**
 * 
 * 
 * @author Ufuk BOMBAR
 * @since 01.05.2018 23:07
 * @version 1.0
 */
public class LightController extends DeviceController
{
    /**
     * Sets the value in memory, not in real!
     * @param state state
     */
    public void setState( boolean state )
    {

    }

    /**
     * Gets the value in memory, not from i/o pins!
     * @return boolean state
     */
    public boolean getState()
    {
        return false;
    }
    
    @Override
    public boolean isVirtual()
    {
        return false;
    }
}