package com.has.device.controllers;

/**
 * 
 * 
 * @author Ufuk BOMBAR
 * @since 01.05.2018 23:07
 * @version 1.0
 */
public class VirtualLightSensorController extends LightSensorController
{
    /**
     * 
     * @param intensity
     */
    public void setIntensity( double intensity )
    {
        
    }

    /**
     * 
     * @return double intensity
     */
    @Override
    public double getIntensity()
    {
        return 0;
    }

    @Override
    public boolean isVirtual()
    {
        return true;
    }
}