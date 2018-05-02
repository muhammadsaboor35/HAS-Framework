package com.has.device.controllers;

/**
 * 
 * 
 * @author Ufuk BOMBAR
 * @since 01.05.2018 23:07
 * @version 1.0
 */
public class VirtualLightController extends LightController
{
    /**
     * 
     * @param state state
     */
    @Override
    public void setState( boolean state )
    {

    }

    /**
     * 
     * @return boolean state
     */
    @Override
    public boolean getState()
    {
        return false;
    }
    
    @Override
    public boolean isVirtual()
    {
        return true;
    }
}