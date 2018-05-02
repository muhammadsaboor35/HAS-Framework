package com.has.base;

import java.io.Serializable;

/**
 * Command class which contains commandName and arguments
 * @author Ege Ozan Özyedek, Ufuk BOMBAR
 * @version v1.0
 * @since 24.04.2018 12:00
 */
public class Command implements Serializable
{
    public static final long serialVersionUID = 42L;
    private static long lastID = 0;

    private CommandName commandName;
    private DataContainer arguments;
    private long id;

    /**
     * Initalizes the id system, this method must be called whenever a new connection has been made.
     * This method initalizes the lastID variable to zero, this variable is static and incremented
     * everytime a command is created.
     * 
     * The id is initialized to lastID variable in the constructor. So that every Command object in
     * an application will have a unique id and becomes trackable. This method helps us to determine
     * the which responses made for which command objects.
     */
    @SuppressWarnings( "all" )
    private static void initalize()
    {
        lastID = 0;
    }
  
    /**
    * Command class constructor, gets commandName and arguments and holds them
    * @param commandName, the name of the command
    * @param arguments, DataConatiner which holds the arguments*
    */
    public Command( CommandName commandName, DataContainer arguments )
    {
        this.commandName = commandName;
        this.arguments = arguments;
        this.id = lastID;
        lastID++;
    }
  
  
    /**
    * A method which returns the arguments of command
    * @return arguments, the property of Command
    */
    public DataContainer getArgument()
    {
        return arguments;
    }
  
    /**
    * A method which returns the name of command
    * @return commandName, the property of Command
    */
    public CommandName getName()
    {
        return commandName;
    }

    /**
     * Gets the identifier of command
     * @return the id
     */
    public long getID()
    {
        return id;
    }
}