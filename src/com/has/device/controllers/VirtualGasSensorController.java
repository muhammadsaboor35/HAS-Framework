package com.has.device.controllers;

/**
 * 
 * 
 * @author Ufuk BOMBAR
 * @since 01.05.2018 23:07
 * @version 1.0
 */
public class VirtualGasSensorController extends GasSensorController
{

    /**
     * @return the lpg
     */
    @Override
    public double getLPGConcentratoin()
    {
        return 0;
    }

    /**
     * @return the methane
     */
    @Override
    public double getMethaneConcentratoin()
    {
        return 0;
    }

    /**
     * @return the ethane
     */
    @Override
    public double getEthaneConcentratoin()
    {
        return 0;
    }

    /**
     * @return the propane
     */
    @Override
    public double getPropaneConcentratoin()
    {
        return 0;
    }

    /**
     * @return the co
     */
    @Override
    public double getCOConcentratoin()
    {
        return 0;
    }

    /**
     * @return the smoke
     */
    @Override
    public double getSmokeConcentratoin()
    {
        return 0;
    }

    /**
     * @param lpg the lpg to set
     */
    public void setLPGConcentratoin( double lpg )
    {
        
    }

    /**
     * @param methane the methane to set
     */
    public void setMethaneConcentratoin( double methane )
    {
        
    }

    /**
     * @param ethane the ethane to set
     */
    public void setEthaneConcentratoin( double ethane )
    {
        
    }

    /**
     * @param propane the propane to set
     */
    public void setPropaneConcentratoin( double propane )
    {
        
    }

    /**
     * @param co the co to set
     */
    public void setCOConcentratoin( double co )
    {
        
    }

    @Override
    public boolean isVirtual()
    {
        return true;
    }
}