package com.has.device.controllers;

/**
 * 
 * 
 * @author Ufuk BOMBAR
 * @since 01.05.2018 23:07
 * @version 1.0
 */
public class PushButtonController extends DeviceController
{
    /**
     * 
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