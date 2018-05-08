package com.has.base;

import com.has.device.controllers.*;
import com.has.google.GoogleSessionManager;
import com.has.network.Connection;
import javafx.animation.AnimationTimer;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;
import static com.has.base.DataType.*;

/**
 * @author EgeOzan
 * @since
 * @version
 *
 */
public class LinuxCommandExecutor
{
    private Options options;
    private Configuration configuration;
    private GoogleSessionManager sessionManager;
    private Connection connection;
    private Timer timer;
    private boolean nobodyHomeModeEnabled = false;

    /**
     * Constructor of class, takes parameters and initializes them
     * @param connection, connection to pass the commands
     * @param options, the specified options
     * @param config, the configuration
     * @param session, google session
     */
    public LinuxCommandExecutor( Connection connection, Options options, Configuration config, GoogleSessionManager session )
    {
        this.connection = connection;
        this.options = options;
        this.configuration = config;
        this.sessionManager = session;

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run()
            {
                // TODO saboor refresh google session
            }
        };
        timer.schedule( timerTask, 625724572);
        timerTask.run();

        while ( true )
            doTask( connection.fetch() );
    }

    /**
     * A method to execute commands
     * @param s, serializable object
     */
    private void doTask( Serializable s )
    {
        /**
         * Explain
         */
        if ( s instanceof GoogleSessionManager )
        {
            this.sessionManager = (GoogleSessionManager) s;
        }
        /**
         * Explain
         */
        else if ( s instanceof Response )
        {
            //TODO ???
        }
        /**
         * If s is a Command then the code will flow through here
         */
        else if ( s instanceof Command ) {
            Command command = (Command) s;
            DeviceController controller = configuration.getDeviceControllerById(command.getArgument().getData( 0));

            /**
             * If the conttroller is not virtual it will print out an error since there is no real device
             */
            if ( !controller.isVirtual()) {
                //TODO error
            }

            else{
                /**
                 * Switch case which either executes commands by their names or prints an error message if the case is not
                 * executed
                 */
                switch (command.getName()) {
                    DataContainer container;
                    Response response;

                    /**
                     * Case which sends the config in a data container via connection
                     */
                    case GET_CONFIG:
                        // Construct a response add config and send it
                        container = new DataContainer(new DataStructure(DataType.CONFIG));
                        container.setData(0, configuration);
                        response = new Response(command.getName(), command.getID(), container);
                        connection.send(response);
                        break;

                    /**
                     * Case which sets the light state on the given device id
                     */
                    case SET_LIGHT_STATE:
                        if (command.getArgument().equals(new DataStructure(INT, BOOL)))
                            ((LightController) configuration.getDeviceControllerById((long) command.getArgument().getData(0)))
                                    .setState((Boolean) command.getArgument().getData(1));
                        break;

                    /**
                     * Case which sets the button state on the given device id
                     */
                    case SET_BUTTON_STATE:
                        if (command.getArgument().equals(new DataStructure(INT, BOOL)))
                            ((VirtualPushButtonController) configuration.getDeviceControllerById((long) command.getArgument().getData(0)))
                                    .setState((Boolean) command.getArgument().getData(1));
                        break;

                    /**
                     * Case which sets the fan state on the given device id
                     */
                    case SET_FAN_STATE:
                        if (command.getArgument().equals(new DataStructure(INT, BOOL)))
                            ((FanController) configuration.getDeviceControllerById((long) command.getArgument().getData(0)))
                                    .setState((Boolean) command.getArgument().getData(1));
                        break;

                    /**
                     * Case which sets the heater state on the given device id
                     */
                    case SET_HEATER_STATE:
                        if (command.getArgument().equals(new DataStructure(INT, BOOL)))
                            ((HeaterController) configuration.getDeviceControllerById((long) command.getArgument().getData(0)))
                                    .setState((Boolean) command.getArgument().getData(1));
                        break;

                    /**
                     * Case which sets the camera state on the given device id
                     */
                    case SET_CAMERA_STATE:
                        if (command.getArgument().equals(new DataStructure(INT, BOOL)))
                            ((CameraController) configuration.getDeviceControllerById((long) command.getArgument().getData(0)))
                                    .setState((Boolean) command.getArgument().getData(1));
                        break;

                    /**
                     * Cases which get the state from device with specified id
                     */
                    case GET_BUTTON_STATE:
                    case GET_CAMERA_STATE:
                    case GET_FAN_STATE:
                    case GET_HEATER_STATE:
                    case GET_LIGHT_STATE:
                        if (command.getArgument().equals(new DataStructure(INT))) {
                            container = new DataContainer(new DataStructure(DataType.BOOL));
                            container.setData(0, confguration.getDeviceControllerById(command.getArgument().getData(0)).getState());
                            response = new Response(command.getName(), command.getID(), container);
                            connection.send(response);
                        }
                        break;

                    /**
                     * Case which sends a container with the image
                     */
                    case GET_CAMERA_IMAGE:
                        if (command.getArgument().equals(new DataStructure(INT))) {
                            container = new DataContainer(new DataStructure(DataType.BUFFERED_IMAGE));
                            container.setData(0, confguration.getDeviceControllerById(command.getArgument().getData(0)).getImage());
                            response = new Response(command.getName(), command.getID(), container);
                            connection.send(response);
                        }
                        break;

                    /**
                     * Case which sends a container with the CO concentration
                     */
                    case GET_CO_CONCENTRATION:
                        if (command.getArgument().equals(new DataStructure(INT))) {
                            container = new DataContainer(new DataStructure(DataType.DOUBLE));
                            container.setData(0, confguration.getDeviceControllerById(command.getArgument().getData(0)).getCOConcentration());
                            response = new Response(command.getName(), command.getID(), container);
                            connection.send(response);
                        }
                        break;

                    /**
                     * Case which sends a container with the Methane concentration
                     */
                    case GET_METHANE_CONCENTRATION:
                        if (command.getArgument().equals(new DataStructure(INT))) {
                            container = new DataContainer(new DataStructure(DataType.DOUBLE));
                            container.setData(0, confguration.getDeviceControllerById(command.getArgument().getData(0)).getMethaneConcentration());
                            response = new Response(command.getName(), command.getID(), container);
                            connection.send(response);
                        }
                        break;

                    /**
                     * Case which sends a container with the LPG concentration
                     */
                    case GET_LPG_CONCENTRATION:
                        if (command.getArgument().equals(new DataStructure(INT))) {
                            container = new DataContainer(new DataStructure(DataType.DOUBLE));
                            container.setData(0, confguration.getDeviceControllerById(command.getArgument().getData(0)).getLPGConcentration());
                            response = new Response(command.getName(), command.getID(), container);
                            connection.send(response);
                        }
                        break;

                    /**
                     * Case which sends a container with the Propane concentration
                     */
                    case GET_PROPANE_CONCENTRATION:
                        if (command.getArgument().equals(new DataStructure(INT))) {
                            container = new DataContainer(new DataStructure(DataType.DOUBLE));
                            container.setData(0, confguration.getDeviceControllerById(command.getArgument().getData(0)).getPropaneConcentration());
                            response = new Response(command.getName(), command.getID(), container);
                            connection.send(response);
                        }
                        break;

                    /**
                     * Case which sends a container with the Smoke concentration
                     */
                    case GET_SMOKE_CONCENTRATION:
                        if (command.getArgument().equals(new DataStructure(INT))) {
                            container = new DataContainer(new DataStructure(DataType.DOUBLE));
                            container.setData(0, confguration.getDeviceControllerById(command.getArgument().getData(0)).getSmokeConcentration());
                            response = new Response(command.getName(), command.getID(), container);
                            connection.send(response);
                        }
                        break;

                    /**
                     * Case which sends a container with the Ethane concentration
                     */
                    case GET_ETHANE_CONCENTRATION:
                        if (command.getArgument().equals(new DataStructure(INT))) {
                            container = new DataContainer(new DataStructure(DataType.DOUBLE));
                            container.setData(0, confguration.getDeviceControllerById(command.getArgument().getData(0)).getEthaneConcentration());
                            response = new Response(command.getName(), command.getID(), container);
                            connection.send(response);
                        }
                        break;

                    /**
                     * Case which sends a container with the concentration of all gas types
                     */
                    case GET_GAS_CONCENTRATION:
                        if (command.getArgument().equals(new DataStructure(6, INT))) {
                            container = new DataContainer(new DataStructure(6, DataType.DOUBLE));
                            container.setData(0, confguration.getDeviceControllerById(command.getArgument().getData(0)).getPropaneConcentration());
                            container.setData(1, confguration.getDeviceControllerById(command.getArgument().getData(1)).getEthaneConcentration());
                            container.setData(2, confguration.getDeviceControllerById(command.getArgument().getData(2)).getMethaneConcentration());
                            container.setData(3, confguration.getDeviceControllerById(command.getArgument().getData(3)).getLPGConcentration());
                            container.setData(4, confguration.getDeviceControllerById(command.getArgument().getData(4)).getSmokeConcentration());
                            container.setData(5, confguration.getDeviceControllerById(command.getArgument().getData(5)).getCOConcentration());

                            response = new Response(command.getName(), command.getID(), container);
                            connection.send(response);
                        }
                        break;

                    /**
                     * Case which records for the desired amount of time on the desired device
                     */
                    case RECORD_FOR:
                        if (command.getArgument().equals(new DataStructure(INT, LONG)))
                            confguration.getDeviceControllerById(command.getArgument().getData(0)).recordFor(command.getArgument().getData(1));
                        break;

                    /**
                     * Case which sends a container with the distance value
                     */
                    case GET_DISTANCE:
                        if (command.getArgument().equals(new DataStructure(INT))) {
                            container = new DataContainer(new DataStructure(DataType.DOUBLE));
                            container.setData(0, confguration.getDeviceControllerById(command.getArgument().getData(0)).getDistance());
                            response = new Response(command.getName(), command.getID(), container);
                            connection.send(response);
                        }
                        break;

                    /**
                     * Case which sends a container with the temperature value
                     */
                    case GET_TEMPERATURE:
                        if (command.getArgument().equals(new DataStructure(INT))) {
                            container = new DataContainer(new DataStructure(DataType.DOUBLE));
                            container.setData(0, confguration.getDeviceControllerById(command.getArgument().getData(0)).getTemprature());
                            response = new Response(command.getName(), command.getID(), container);
                            connection.send(response);
                        }
                        break;

                    /**
                     * Case which sets the temprature value to a specified value
                     */
                    case SET_TEMPERATURE:
                        if (command.getArgument().equals(new DataStructure(INT, DOUBLE)))
                            ((TempSensorController) configuration.getDeviceControllerById((long) command.getArgument().getData(0)))
                                    .setTemprature((double) command.getArgument().getData(1));
                        break;

                    /**
                     * Case which sets the light intensity value to a specified value
                     */
                    case SET_LIGHT_INTENSITY:
                        if (command.getArgument().equals(new DataStructure(INT, DOUBLE)))
                            ((TempSensorController) configuration.getDeviceControllerById((long) command.getArgument().getData(0)))
                                    .setIntensity((double) command.getArgument().getData(1));
                        break;

                    /**
                     * Case which sends a container with the temperature value
                     */
                    case GET_LIGHT_INTENSITY:
                        if (command.getArgument().equals(new DataStructure(INT))) {
                            container = new DataContainer(new DataStructure(DataType.DOUBLE));
                            container.setData(0, confguration.getDeviceControllerById(command.getArgument().getData(0)).getIntensity());
                            response = new Response(command.getName(), command.getID(), container);
                            connection.send(response);
                        }
                        break;

                    /**
                     * Case which sets the LPG concentration value to a specified value
                     */
                    case SET_LPG_CONCENTRATION:
                        if (command.getArgument().equals(new DataStructure(INT, DOUBLE)))
                            ((TempSensorController) configuration.getDeviceControllerById((long) command.getArgument().getData(0)))
                                    .setLPGConcentration((double) command.getArgument().getData(1));
                        break;

                    /**
                     * Case which sets the CO concentration value to a specified value
                     */
                    case SET_CO_CONCENTRATION:
                        if (command.getArgument().equals(new DataStructure(INT, DOUBLE)))
                            ((TempSensorController) configuration.getDeviceControllerById((long) command.getArgument().getData(0)))
                                    .setCOConcentration((double) command.getArgument().getData(1));
                        break;

                    /**
                     * Case which sets the Methane concentration value to a specified value
                     */
                    case SET_METHANE_CONCENTRATION:
                        if (command.getArgument().equals(new DataStructure(INT, DOUBLE)))
                            ((TempSensorController) configuration.getDeviceControllerById((long) command.getArgument().getData(0)))
                                    .setMethaneConcentration((double) command.getArgument().getData(1));
                        break;

                    /**
                     * Case which sets the Ethane concentration value to a specified value
                     */
                    case SET_ETHANE_CONCENTRATION:
                        if (command.getArgument().equals(new DataStructure(INT, DOUBLE)))
                            ((TempSensorController) configuration.getDeviceControllerById((long) command.getArgument().getData(0)))
                                    .setEthaneConcentration((double) command.getArgument().getData(1));
                        break;

                    /**
                     * Case which sets the Smoke concentration value to a specified value
                     */
                    case SET_SMOKE_CONCENTRATION:
                        if (command.getArgument().equals(new DataStructure(INT, DOUBLE)))
                            ((TempSensorController) configuration.getDeviceControllerById((long) command.getArgument().getData(0)))
                                    .setSmokeConcentration((double) command.getArgument().getData(1));
                        break;

                    /**
                     * Case which sets the Propane concentration value to a specified value
                     */
                    case SET_PROPANE_CONCENTRATION:
                        if (command.getArgument().equals(new DataStructure(INT, DOUBLE)))
                            ((TempSensorController) configuration.getDeviceControllerById((long) command.getArgument().getData(0)))
                                    .setPropaneConcentration((double) command.getArgument().getData(1));
                        break;

                    /**
                     *
                     */
                    case SET_GAS_CONCENTRATION:
                        break;

                    /**
                     * Case which sets the camera image to a specified image
                     */
                    case SET_CAMERA_IMAGE:
                        if (command.getArgument().equals(new DataStructure(INT, BUFFERED_IMAGE)))
                            ((TempSensorController) configuration.getDeviceControllerById((long) command.getArgument().getData(0)))
                                    .setImage((BufferedImage) command.getArgument().getData(1));
                        break;


                    /**
                     * Case which sets the distance value to a specified value
                     */
                    case SET_DISTANCE:
                        if (command.getArgument().equals(new DataStructure(INT, double)))
                        ((TempSensorController) configuration.getDeviceControllerById((long) command.getArgument().getData(0)))
                                .setDistance((double) command.getArgument().getData(1));
                        break;

                    /**
                     * TODO
                     */
                    case NOTIFICATION:
                    case SET_INTRUSION_TIMESTAMP:
                    case GET_OPTIONS:
                    case RESPONSE:
                    case SET_NOBODY_HOME_MODE:
                    case GET_INTRUSION_TIMESTAMP:
                    case ENABLE_DEVELOPER_SESSION:
                    default:
                        //TODO error | invalid command?

                }
            }
        }
    }
}