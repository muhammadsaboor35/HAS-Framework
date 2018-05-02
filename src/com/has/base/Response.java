package com.has.base;

import java.io.Serializable;

/**
 * Represents a resposnse
 * 
 * @author Ufuk BOMBAR
 * @since 28.04.2018 11:27
 * @version 1.0
 */
public class Response implements Serializable
{
    public static final long serialVersionUID = 43L;
    private long commandID;
    private CommandName commandName;
    private DataContainer response;

    public Response( CommandName commandName, long commandID, DataContainer response )
    {
        this.commandID = commandID;
        this.commandName = commandName;
        this.response = response;
    }

    /**
     * Gets commands is
     * @return the commandID
     */
    public long getCommandID()
    {
        return commandID;
    }

    /**
     * Gets {@link CommandName}
     * @return the commandName
     */
    public CommandName getCommandName()
    {
        return commandName;
    }

    /**
     * Gets {@link DataContainer} of the response
     * @return the response
     */
    public DataContainer getResponse()
    {
        return response;
    }
}