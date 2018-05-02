package com.has.device.controllers;

/**
 * 
 * 
 * @author Ufuk BOMBAR
 * @since 01.05.2018 23:07
 * @version 1.0
 */
public class VirtualTempSensorController extends TempSensorController
{
    /**
     * 
     * @param temp
     */
    public void setTemperature( double temp )
    {

    }

    /**
     *m
     * @return double temp
     */
    @Override
    public double getTemperature()
    {
        return 0;
    }

    @Override
    public boolean isVirtual()
    {
        return true;
    }
}