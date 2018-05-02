package com.has.device.controllers;

/**
 * 
 * 
 * @author Ufuk BOMBAR
 * @since 01.05.2018 23:07
 * @version 1.0
 */
public class TempSensorController extends DeviceController
{
    /**
     * 
     * @return double temp
     */
    public double getTemperature()
    {
        return 0;
    }

    @Override
    public boolean isVirtual()
    {
        return false;
    }
}