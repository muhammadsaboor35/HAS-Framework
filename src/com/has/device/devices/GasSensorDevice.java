package com.has.device.devices;

import com.has.device.Pin;
import com.has.device.Room;
import com.has.device.controllers.DeviceController;

/**
 * 
 * 
 * @author Ufuk BOMBAR
 * @since 01.05.2018 23:07
 * @version 1.0
 */
public class GasSensorDevice extends Device
{
    private double lpg;
    private double methane;
    private double ethane;
    private double propane;
    private double co;
    private double smoke;

    /**
     * Constructor of abstract device. Adds itself to room automatically!
     * @param id the id
     * @param room the room, adds itself automatically
     * @param displayName display name for UI
     * @param pin pin number
     * @param dc pair DeviceController object
     */
    public GasSensorDevice( int id, Room room, String displayName, Pin pin, DeviceController dc ) throws Exception
    {
        super( id, room, displayName, pin, dc );
        lpg = 0.0d;
        methane = 0.0d;
        ethane = 0.0d;
        propane = 0.0d;
        co = 0.0d;
        smoke = 0.0d;
    }

    /**
     * @return the lpg
     */
    public double getLPGConcentratoin()
    {
        return lpg;
    }

    /**
     * @return the methane
     */
    public double getMethaneConcentratoin()
    {
        return methane;
    }

    /**
     * @return the ethane
     */
    public double getEthaneConcentratoin()
    {
        return ethane;
    }

    /**
     * @return the propane
     */
    public double getPropaneConcentratoin()
    {
        return propane;
    }

    /**
     * @return the co
     */
    public double getCOConcentratoin()
    {
        return co;
    }

    /**
     * @return the smoke
     */
    public double getSmokeConcentratoin()
    {
        return smoke;
    }

    /**
     * @param lpg the lpg to set
     */
    public void setLPGConcentratoin( double lpg )
    {
        this.lpg = lpg;
    }

    /**
     * @param methane the methane to set
     */
    public void setMethaneConcentratoin( double methane )
    {
        this.methane = methane;
    }

    /**
     * @param ethane the ethane to set
     */
    public void setEthaneConcentratoin( double ethane )
    {
        this.ethane = ethane;
    }

    /**
     * @param propane the propane to set
     */
    public void setPropaneConcentratoin( double propane )
    {
        this.propane = propane;
    }

    /**
     * @param co the co to set
     */
    public void setCOConcentratoin( double co )
    {
        this.co = co;
    }

    /**
     * @param smoke the smoke to set
     */
    public void setSmokeConcentratoin( double smoke )
    {
        this.smoke = smoke;
    }
}