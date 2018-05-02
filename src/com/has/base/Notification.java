
package com.has.base;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Notification wrangler. Also contains Priority sub-enum
 * 
 * @author Ufuk BOMBAR
 * @since 28.04.2018 09:04
 * @version 1.0
 */
public class Notification implements Serializable
{
    public static final long serialVersionUID = 46L;

    public enum Priority
    {
        LOW,
        MEDIUM,
        HIGH,
        VERY_HIGH
    }

    private String title;
    private String description;
    private String iconName;
    private Timestamp creation;
    private Priority priority;

    /**
     * Constructor for creating notifications
     * @param title the title
     * @param description the description
     * @param iconName name of the icon
     * @param creation creation {@link Timestamp} of notification
     * @param priority the priority
     */
    public Notification( String title, String description, String iconName, Timestamp creation, Priority priority )
    {
        this.title = title;
        this.description = description;
        this.iconName = iconName;
        this.creation = creation;
        this.priority = priority;
    }

    /**
     * Constructor for creating notifications with the current time
     * @param title the title
     * @param description the description
     * @param iconName name of the icon
     * @param priority the priority
     */
    public Notification( String title, String description, String iconName, Priority priority )
    {
        this( title, description, iconName, new Timestamp( System.currentTimeMillis() ), priority );
    }

    /**
     * Gets the creation {@link Timestamp}
     * @return the creation
     */
    public Timestamp getCreation()
    {
        return creation;
    }

    /**
     * Gets the description text
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Gets the icon name
     * @return the iconName
     */
    public String getIconName()
    {
        return iconName;
    }

    /**
     * Gets the priority
     * @return the priority
     */
    public Priority getPriority()
    {
        return priority;
    }

    /**
     * Gets the title
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }
}