package com.has.device.controllers;

import com.has.device.devices.Device;

/**
 * 
 * 
 * @author Ufuk BOMBAR
 * @since 01.05.2018 23:07
 * @version 1.0
 */
public abstract class DeviceController
{
    protected Device device;

    /**
     * Empty constructor
     */
    public DeviceController() { }

    /**
     * The device should be setted via setDevice method, before using specific methods
     * @param device the device
     */
    public void setDevice(  Device device )
    {
        this.device = device;
    }

    /**
     * This method gets if the DeviceController is virtual or not
     * @return true if virtual, false if not
     */
    public abstract boolean isVirtual();
}