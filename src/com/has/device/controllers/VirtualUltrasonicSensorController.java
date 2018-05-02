package com.has.device.controllers;

/**
 * 
 * 
 * @author Ufuk BOMBAR
 * @since 01.05.2018 23:07
 * @version 1.0
 */
public class VirtualUltrasonicSensorController extends UltrasonicSensorController
{
    /**
     * 
     * @param distance
     */
    public void setDistance( double distance )
    {

    }

    /**
     * 
     * @return double distance
     */
    @Override
    public double getDistance()
    {
        return 0;
    }

    @Override
    public boolean isVirtual()
    {
        return true;
    }
}