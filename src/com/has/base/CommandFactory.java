package com.has.base;

import java.awt.image.BufferedImage;
import java.sql.Timestamp;

/*
 * CommandFactory which makes it easier to create commands
 * @author Ege Ozan Özyedek
 * @version v1.0
 * @date 28/04/18
 */
public class CommandFactory {

    //BASIC NON-DEVICE COMMANDS

    /**
     * Creates desired command type
     * @return Command, a new command with specified name and container
     */
    public static Command createGetConfigCommand() {
        DataContainer arguments = new DataContainer();
        return new Command(CommandName.GET_CONFIG, arguments);
    }

    /**
     * Creates desired command type
     * @return Command, a new command with specified name and container
     */
    public static Command createGetOptionsCommand() {
        DataContainer arguments = new DataContainer();
        return new Command(CommandName.GET_OPTIONS, arguments);
    }

    /**
     * Creates desired command type
     * @param state, the state of Nobody Home Mode
     * @return Command, a new command with specified name and container
     */
    public static Command createSetNobodyHomeModeCommand(boolean state) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.BOOL));
        arguments.setData(0, state);
        return new Command(CommandName.SET_NOBODY_HOME_MODE, arguments);
    }

    /**
     * Creates desired command type
     * @return Command, a new command with specified name and container
     */
    public static Command createEnableDeveloperSessionCommand() {
        DataContainer arguments = new DataContainer();
        return new Command(CommandName.ENABLE_DEVELOPER_SESSION, arguments);
    }

    /**
     * Creates desired command type
     * @param n, the notification
     * @return Command, a new command with specified name and container
     */
    public static Command createNotificationCommand(Notification n) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.NOTIFICATION));
        arguments.setData(0, n);
        return new Command(CommandName.NOTIFICATION, arguments);
    }

    /**
     * Creates desired command type
     * @return Command, a new command with specified name and container
     */
    public static Command createResponseCommand() {
        DataContainer arguments = new DataContainer();
        return new Command(CommandName.RESPONSE, arguments);
    }

    //DEVICE COMMANDS

    /**
     * Creates desired command type
     * @param deviceId, the ID of device that the Command will get data from
     * @return Command, a new command with specified name and container
     */
    public static Command createGetTempratureCommand(int deviceId) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT));
        arguments.setData(0, deviceId);
        return new Command(CommandName.GET_TEMPERATURE, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, the ID of device that the Command will get data from
     * @return Command, a new command with specified name and container
     */
    public static Command createGetDistanceCommand(int deviceId) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT));
        arguments.setData(0, deviceId);
        return new Command(CommandName.GET_DISTANCE, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, the ID of device that the Command will get data from
     * @return Command, a new command with specified name and container
     */
    public static Command createGetIntrusionTimestampCommand(int deviceId) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT));
        arguments.setData(0, deviceId);
        return new Command(CommandName.GET_INTRUSION_TIMESTAMP, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, the ID of device that the Command will get data from
     * @return Command, a new command with specified name and container
     */
    public static Command createGetButtonStateCommand(int deviceId) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT));
        arguments.setData(0, deviceId);
        return new Command(CommandName.GET_BUTTON_STATE, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, the ID of device that the Command will get data from
     * @return Command, a new command with specified name and container
     */
    public static Command createGetLightIntensityCommand(int deviceId) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT));
        arguments.setData(0, deviceId);
        return new Command(CommandName.GET_LIGHT_INTENSITY, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, the ID of device that the Command will get data from
     * @param state, state of said Light
     * @return Command, a new command with specified name and container
     */
    public static Command createSetLightStateCommand(int deviceId, boolean state) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT, DataType.BOOL));
        arguments.setData(0, deviceId);
        arguments.setData(1, state);
        return new Command(CommandName.SET_LIGHT_STATE, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, the ID of device that the Command will get data from
     * @return Command, a new command with specified name and container
     */
    public static Command createGetLightStateCommand(int deviceId) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT));
        arguments.setData(0, deviceId);
        return new Command(CommandName.GET_LIGHT_STATE, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, the ID of device that the Command will get data from
     * @param state, state of said Fan
     * @return Command, a new command with specified name and container
     */
    public static Command createSetFanStateCommand(int deviceId, boolean state) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT, DataType.BOOL));
        arguments.setData(0, deviceId);
        arguments.setData(1, state);
        return new Command(CommandName.SET_FAN_STATE, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, the ID of device that the Command will get data from
     * @return Command, a new command with specified name and container
     */
    public static Command createGetFanStateCommand(int deviceId) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT));
        arguments.setData(0, deviceId);
        return new Command(CommandName.GET_FAN_STATE, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, the ID of device that the Command will get data from
     * @param state, state of said Heater
     * @return Command, a new command with specified name and container
     */
    public static Command createSetHeaterStateCommand(int deviceId, boolean state) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT, DataType.BOOL));
        arguments.setData(0, deviceId);
        arguments.setData(1, state);
        return new Command(CommandName.SET_HEATER_STATE, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, the ID of device that the Command will get data from
     * @return Command, a new command with specified name and container
     */
    public static Command createGetHeaterStateCommand(int deviceId) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT));
        arguments.setData(0, deviceId);
        return new Command(CommandName.GET_HEATER_STATE, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, the ID of device that the Command will get data from
     * @param state, state of said Camera
     * @return Command, a new command with specified name and container
     */
    public static Command createSetCameraStateCommand(int deviceId, boolean state) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT, DataType.BOOL));
        arguments.setData(0, deviceId);
        arguments.setData(1, state);
        return new Command(CommandName.SET_CAMERA_STATE, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, the ID of device that the Command will get data from
     * @return Command, a new command with specified name and container
     */
    public static Command createGetCameraStateCommand(int deviceId) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT));
        arguments.setData(0, deviceId);
        return new Command(CommandName.GET_CAMERA_STATE, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, the ID of device that the Command will get data from
     * @return Command, a new command with specified name and container
     */
    public static Command createGetCameraImageCommand(int deviceId) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT));
        arguments.setData(0, deviceId);
        return new Command(CommandName.GET_CAMERA_IMAGE, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, the ID of device that the Command will get data from
     * @param duration, the record duration
     * @return Command, a new command with specified name and container
     */
    public static Command createRecordForCommand(int deviceId, long duration) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT, DataType.LONG));
        arguments.setData(0, deviceId);
        arguments.setData(1, duration);
        return new Command(CommandName.RECORD_FOR, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, the ID of device that the Command will get data from
     * @return Command, a new command with specified name and container
     */
    public static Command createGetLPGConcentraitonCommand(int deviceId) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT));
        arguments.setData(0, deviceId);
        return new Command(CommandName.GET_LPG_CONCENTRATION, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, the ID of device that the Command will get data from
     * @return Command, a new command with specified name and container
     */
    public static Command createGetMethaneConcentraitonCommand(int deviceId) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT));
        arguments.setData(0, deviceId);
        return new Command(CommandName.GET_METHANE_CONCENTRATION, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, the ID of device that the Command will get data from
     * @return Command, a new command with specified name and container
     */
    public static Command createGetEthaneConcentraitonCommand(int deviceId) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT));
        arguments.setData(0, deviceId);
        return new Command(CommandName.GET_ETHANE_CONCENTRATION, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, the ID of device that the Command will get data from
     * @return Command, a new command with specified name and container
     */
    public static Command createGetPropaneConcentraitonCommand(int deviceId) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT));
        arguments.setData(0, deviceId);
        return new Command(CommandName.GET_PROPANE_CONCENTRATION, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, the ID of device that the Command will get data from
     * @return Command, a new command with specified name and container
     */
    public static Command createGetCOConcentraitonCommand(int deviceId) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT));
        arguments.setData(0, deviceId);
        return new Command(CommandName.GET_CO_CONCENTRATION, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, the ID of device that the Command will get data from
     * @return Command, a new command with specified name and container
     */
    public static Command createGetSmokeConcentraitonCommand(int deviceId) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT));
        arguments.setData(0, deviceId);
        return new Command(CommandName.GET_SMOKE_CONCENTRATION, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, the ID of device that the Command will get data from
     * @return Command, a new command with specified name and container
     */
    public static Command createGetGasConcentraitonCommand(int deviceId) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT));
        arguments.setData(0, deviceId);
        return new Command(CommandName.GET_GAS_CONCENTRATION, arguments);
    }

    //NON-DEVELOPER DATABASE COMMANDS

    /**
     * Creates desired command type
     * @param start, start date of database to be returned
     * @param end, start date of database to be returned
     * @param res, the data per second that will be returned
     * @return Command, a new command with specified name and container
     */
    public static Command createGetTempDataCommand( Timestamp start, Timestamp end, long res) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.TIMESTAMP, DataType.TIMESTAMP, DataType.LONG));
        arguments.setData(0, start);
        arguments.setData(1, end);
        arguments.setData( 2, res );
        return new Command(CommandName.GET_TEMP_DATA, arguments);
    }

    /**
     * Creates desired command type
     * @param start, start date of database to be returned
     * @param end, start date of database to be returned
     * @param res, the data per second that will be returned
     * @return Command, a new command with specified name and container
     */
    public static Command createGetGasDataCommand( Timestamp start, Timestamp end, long res) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.TIMESTAMP, DataType.TIMESTAMP, DataType.LONG));
        arguments.setData(0, start);
        arguments.setData(1, end);
        arguments.setData( 2, res );
        return new Command(CommandName.GET_GAS_DATA, arguments);
    }

    /**
     * Creates desired command type
     * @param start, start date of database to be returned
     * @param end, start date of database to be returned
     * @param res, the data per second that will be returned
     * @return Command, a new command with specified name and container
     */
    public static Command createGetConsumptionDataCommand( Timestamp start, Timestamp end, long res) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.TIMESTAMP, DataType.TIMESTAMP, DataType.LONG));
        arguments.setData(0, start);
        arguments.setData(1, end);
        arguments.setData( 2, res );
        return new Command(CommandName.GET_CONSUMPTION_DATA, arguments);
    }

    /**
     * Creates desired command type
     * @return Command, a new command with specified name and container
     */
    public static Command createUpdateConsumptionDatabaseCommand() {
        DataContainer arguments = new DataContainer();
        return new Command(CommandName.UPDATE_CONSUMPTION_DATABASE, arguments);
    }

    //DEVELOPER DEVICE COMMANDS

    /**
     * Creates desired command type
     * @param deviceId, ID of device that the temperature will be set for
     * @param temp, temperature value that will be set
     * @return Command, a new command with specified name and container
     */
    public static Command createSetTempratureCommand(int deviceId, double temp) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT, DataType.DOUBLE));
        arguments.setData(0, deviceId);
        arguments.setData(1, temp);
        return new Command(CommandName.SET_TEMPERATURE, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, ID of device that the temperature will be set for
     * @param dist, distance value that will be set
     * @return Command, a new command with specified name and container
     */
    public static Command createSetDistanceCommand(int deviceId, double dist) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT, DataType.DOUBLE));
        arguments.setData(0, deviceId);
        arguments.setData(1, dist);
        return new Command(CommandName.SET_DISTANCE, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, ID of device that the temperature will be set for
     * @param ts, Timestamp that will be set for intrusion
     * @return Command, a new command with specified name and container
     */
    public static Command createSetIntrusionTimestampCommand( int deviceId, Timestamp ts) {
        DataContainer arguments = new DataContainer(new DataStructure( DataType.INT, DataType.TIMESTAMP));
        arguments.setData(0, deviceId);
        arguments.setData(1, ts);
        return new Command(CommandName.SET_INTRUSION_TIMESTAMP, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, ID of device that the temperature will be set for
     * @param state, state of button
     * @return Command, a new command with specified name and container
     */
    public static Command createSetButtonStateCommand( int deviceId, boolean state) {
        DataContainer arguments = new DataContainer(new DataStructure( DataType.INT, DataType.BOOL));
        arguments.setData(0, deviceId);
        arguments.setData(1, state);
        return new Command(CommandName.SET_BUTTON_STATE, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, ID of device that the temperature will be set for
     * @param intensity, the intensity of light to be set
     * @return Command, a new command with specified name and container
     */
    public static Command createSetLightIntensityCommand(int deviceId, double intensity) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT, DataType.DOUBLE));
        arguments.setData(0, deviceId);
        arguments.setData(1, intensity);
        return new Command(CommandName.SET_LIGHT_INTENSITY, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, ID of device that the temperature will be set for
     * @param img, Buffered Image to be set to camera
     * @return Command, a new command with specified name and container
     */
    public static Command createSetCameraImageCommand(int deviceId, BufferedImage img) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT, DataType.BUFFERED_IMAGE));
        arguments.setData(0, deviceId);
        arguments.setData(1, img);
        return new Command(CommandName.SET_CAMERA_IMAGE, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, ID of device that the temperature will be set for
     * @param concentration, gas value to be set
     * @return Command, a new command with specified name and container
     */
    public static Command createSetLPGConcentrationCommand(int deviceId, double concentration) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT, DataType.DOUBLE));
        arguments.setData(0, deviceId);
        arguments.setData(1, concentration);
        return new Command(CommandName.SET_LPG_CONCENTRATION, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, ID of device that the temperature will be set for
     * @param concentration, gas value to be set
     * @return Command, a new command with specified name and container
     */
    public static Command createSetMethaneConcentrationCommand(int deviceId, double concentration) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT, DataType.DOUBLE));
        arguments.setData(0, deviceId);
        arguments.setData(1, concentration);
        return new Command(CommandName.SET_METHANE_CONCENTRATION, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, ID of device that the temperature will be set for
     * @param concentration, gas value to be set
     * @return Command, a new command with specified name and container
     */
    public static Command createSetEthaneConcentrationCommand(int deviceId, double concentration) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT, DataType.DOUBLE));
        arguments.setData(0, deviceId);
        arguments.setData(1, concentration);
        return new Command(CommandName.SET_ETHANE_CONCENTRATION, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, ID of device that the temperature will be set for
     * @param concentration, gas value to be set
     * @return Command, a new command with specified name and container
     */
    public static Command createSetPropaneConcentrationCommand(int deviceId, double concentration) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT, DataType.DOUBLE));
        arguments.setData(0, deviceId);
        arguments.setData(1, concentration);
        return new Command(CommandName.SET_PROPANE_CONCENTRATION, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, ID of device that the temperature will be set for
     * @param concentration, gas value to be set
     * @return Command, a new command with specified name and container
     */
    public static Command createSetCOConcentrationCommand(int deviceId, double concentration) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT, DataType.DOUBLE));
        arguments.setData(0, deviceId);
        arguments.setData(1, concentration);
        return new Command(CommandName.SET_CO_CONCENTRATION, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, ID of device that the temperature will be set for
     * @param concentration, gas value to be set
     * @return Command, a new command with specified name and container
     */
    public static Command createSetSmokeConcentrationCommand(int deviceId, double concentration) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT, DataType.DOUBLE));
        arguments.setData(0, deviceId);
        arguments.setData(1, concentration);
        return new Command(CommandName.SET_SMOKE_CONCENTRATION, arguments);
    }

    /**
     * Creates desired command type
     * @param deviceId, ID of device that the temperature will be set for
     * @param cLPG, LPG concentration value to be set
     * @param cMET, Methane concentration value to be set
     * @param cETH, Ethane concentration value to be set
     * @param cPRO, Propane concentration value to be set
     * @param cCO2, CO2 concentration value to be set
     * @param cSMO, Smoke concentration value to be set
     * @return Command, a new command with specified name and container
     */
    public static Command createSetGasConcentrationCommand(int deviceId, double cLPG, double cMET, double cETH, double cPRO,
                                                           double cCO2, double cSMO) {
        DataContainer arguments = new DataContainer(new DataStructure(DataType.INT, DataType.DOUBLE, DataType.DOUBLE, DataType.DOUBLE,
                                                           DataType.DOUBLE, DataType.DOUBLE, DataType.DOUBLE));
        arguments.setData(0, deviceId);
        arguments.setData(1, cLPG);
        arguments.setData(2, cMET);
        arguments.setData(3, cETH);
        arguments.setData(4, cPRO);
        arguments.setData(5, cCO2);
        arguments.setData(6, cSMO);
        return new Command(CommandName.SET_GAS_CONCENTRATION, arguments);
    }

    //DEVELOPER DATABASE COMMANDS

    /**
     * Creates desired command type
     * @return Command, a new command with specified name and container
     */
    public static Command createResetDatabaseCommand() {
        DataContainer arguments = new DataContainer();
        return new Command(CommandName.RESET_DATABASE, arguments);
    }

    /**
     * Creates desired command type
     * @param queryText, written in SQL
     * @return Command, a new command with specified name and container
     */
    public static Command createRunDatabaseQueryCommand( String queryText ) {
        DataContainer arguments = new DataContainer( new DataStructure( DataType.STRING ) );
        return new Command( CommandName.RUN_DATABASE_QUERY, arguments );
    }

    /**
     * Creates desired command type
     * @param ts, time stamp that the values will be set on
     * @param temp, temperature value to  be set
     * @return Command, a new command with specified name and container
     */
    public static Command createSetTempDataCommand( Timestamp ts, double temp ) {
        DataContainer arguments = new DataContainer( new DataStructure( DataType.TIMESTAMP, DataType.DOUBLE ) );
        arguments.setData( 0, ts );
        arguments.setData( 1, temp );
        return new Command( CommandName.SET_TEMP_DATA, arguments );
    }

    /**
     * Creates desired command type
     * @param ts, time stamp that the values will be set on
     * @param cLPG, LPG concentration value to be set
     * @param cMET, Methane concentration value to be set
     * @param cETH, Ethane concentration value to be set
     * @param cPRO, Propane concentration value to be set
     * @param cCO2, CO2 concentration value to be set
     * @param cSMO, Smoke concentration value to be set
     * @return Command, a new command with specified name and container
     */
    public static Command createSetGasDataCommand( Timestamp ts, double cLPG, double cMET, double cETH, double cPRO, double cCO2, double cSMO) {
        DataContainer arguments = new DataContainer(new DataStructure(
            DataType.TIMESTAMP, 
            DataType.DOUBLE, 
            DataType.DOUBLE, 
            DataType.DOUBLE,
            DataType.DOUBLE, 
            DataType.DOUBLE, 
            DataType.DOUBLE));

        arguments.setData(0, ts);
        arguments.setData(1, cLPG);
        arguments.setData(2, cMET);
        arguments.setData(3, cETH);
        arguments.setData(4, cPRO);
        arguments.setData(5, cCO2);
        arguments.setData(6, cSMO);
        return new Command(CommandName.SET_GAS_DATA, arguments);
    }

    /**
     * Creates desired command type
     * @param ts, time stamp that the values will be set on
     * @param consumption, consumption value to  be set
     * @return Command, a new command with specified name and container
     */
    public static Command createSetConsumptionDataCommand( Timestamp ts, double consumption) {
        DataContainer arguments = new DataContainer( new DataStructure( DataType.TIMESTAMP, DataType.DOUBLE));
        arguments.setData( 0, ts);
        arguments.setData( 1, consumption);
        return new Command(CommandName.SET_CONSUMPTION_DATA, arguments);
    }

}
