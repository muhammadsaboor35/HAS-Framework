package com.has.device.controllers;

/**
 * 
 * 
 * @author Ufuk BOMBAR
 * @since 01.05.2018 23:07
 * @version 1.0
 */
public class VirtualFanController extends FanController
{
    public void setFanState( boolean on )
    {
        // Also update the data inside super.device
    }

    public boolean getFanState()
    {
        return false;
    }
    
    @Override
    public boolean isVirtual()
    {
        return true;
    }
}