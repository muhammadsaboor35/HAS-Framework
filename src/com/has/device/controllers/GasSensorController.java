package com.has.device.controllers;

/**
 * 
 * 
 * @author Ufuk BOMBAR
 * @since 01.05.2018 23:07
 * @version 1.0
 */
public class GasSensorController extends DeviceController
{
    
    /**
     * @return the lpg
     */
    public double getLPGConcentratoin()
    {
        return 0;
    }

    /**
     * @return the methane
     */
    public double getMethaneConcentratoin()
    {
        return 0;
    }

    /**
     * @return the ethane
     */
    public double getEthaneConcentratoin()
    {
        return 0;
    }

    /**
     * @return the propane
     */
    public double getPropaneConcentratoin()
    {
        return 0;
    }

    /**
     * @return the co
     */
    public double getCOConcentratoin()
    {
        return 0;
    }

    /**
     * @return the smoke
     */
    public double getSmokeConcentratoin()
    {
        return 0;
    }
    
    @Override
    public boolean isVirtual()
    {
        return false;
    }
}