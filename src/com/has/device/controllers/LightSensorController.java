package com.has.device.controllers;

/**
 * 
 * 
 * @author Ufuk BOMBAR
 * @since 01.05.2018 23:07
 * @version 1.0
 */
public class LightSensorController extends DeviceController
{
    /**
     * 
     * @return double intensity
     */
    public double getIntensity()
    {
        return 0;
    }

    @Override
    public boolean isVirtual()
    {
        return false;
    }
}