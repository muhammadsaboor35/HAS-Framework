package com.has.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a generic array of data, also serializable
 * 
 * @author Ufuk BOMBAR
 * @since 28.04.2018 00:31
 * @version 1.0
 */
public class DataContainer implements Iterable<Object>, Serializable
{
    public static final long serialVersionUID = 49L;

    @SuppressWarnings( "all" )
    private Object[] data;
    private DataStructure structure;

    /**
     * DataContainer.DataIterator.class implements Iterator
     * 
     * @author Ufuk BOMBAR
     * @since 28.04.2018 08:22
     * @version 1.0
     */
    private class DataIterator implements Iterator<Object>
    {
        DataContainer dc;
        int index;

        /**
         * Default constructor of {@link DataIterator}
         * @param dc {@link DataContainer} instance
         */
        public DataIterator( DataContainer dc )
        {
            index = 0;
            this.dc = dc;
        }

        /**
         * Checks if the object has another object
         * @return true if it does, false otherwise
         */
        @Override
        public boolean hasNext()
        {
            return index < dc.size();
        }

        /**
         * Gets the next object on the list
         * @return next object
         */
        @Override
        public Object next()
        {
            index++;
            return dc.getData( index - 1 );
        }
    }

    /**
     * Initalizes the class itself with the help of {@link DataStructure}
     * @param ds structure
     */
    public DataContainer( DataStructure ds )
    {
        data = new Object[ ds.size() ];
        structure = ds;
    }

    /**
     * Initalizes an empty DataContainer
     */
    public DataContainer()
    {
        data = null;
        structure = null;
    }

    /**
     * Gets if the container is empty
     */
    public boolean isEmpty()
    {
        return structure == null ? true : false;
    }

    /**
     * Sets the {@link Object} on specified index.
     * If i is greather than size() then throws {@link IndexOutOfBoundsException}
     * @param i index
     * @param obj object
     */
    public void setData( int i, Object obj )
    {
        data[ i ] = obj;
    }

    /**
     * Gets the {@link Object} on specified index.
     * If i is greather than size() then throws {@link IndexOutOfBoundsException}
     * @param i index
     * @return {@link Object} of that specified index
     */
    public Object getData( int i )
    {
        return data[ i ];
    }

    /**
     * Gets the {@link DataType} of specified index.
     * If i is greather than size() then throws {@link IndexOutOfBoundsException}
     * @param i index
     * @return {@link DataType} of that specified index
     */
    public DataType getDataType( int i )
    {
        return structure.getDataType( i );
    }

    /**
     * Gets the size of {@link DataContainer}
     * @return size as integer
     */
    public int size()
    {
        return data.length;
    }

    /**
     * Merges another DataContainer to the end
     * @param container other DataContainer
     */
    public void merge( DataContainer container )
    {
        this.structure.merge( container.structure );

        Object[] tmp = new Object[ this.size() + container.size() ];

        for ( int i = 0; i < this.size(); i++ )
            tmp[ i ] = this.data[ i ];
        
         for ( int i = this.size(); i < container.size(); i++ )
            tmp[ i ] = container.data[ i ];

        this.data = tmp;
    }

    /**
     * Gets the {@link DataIterator}
     * @return {@link DataIterator}
     */
    public Iterator<Object> iterator()
    {
        return new DataContainer.DataIterator( this );
    }

    /**
     * Converts {@link DataContainer} to a {@link String}.
     * Example: {"java.lang.Integer":"23","java.lang.Boolean":"true"}
     * @return {@link String} representation of {@link DataContainer}
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder( "{" );
        for ( int i = 0; i < this.size() - 1; i++ )
        {
            sb.append( "\"" );
            sb.append( this.structure.getDataType( i ) );
            sb.append( "\":" );
            sb.append( "\"" );
            sb.append( this.data[ i ].toString() );
            sb.append( "\"" );
        }
        if ( this.size() != 0 )
        {
            sb.append( "\"" );
            sb.append( this.structure.getDataType( this.size() - 1 ) );
            sb.append( "\":" );
            sb.append( "\"" );
            sb.append( this.data[ this.size() - 1 ].toString() );
            sb.append( "\"," );
        }
        sb.append( "}" );

        return sb.toString();
    }
}