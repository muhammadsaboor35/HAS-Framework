package com.has.base;

import java.io.Serializable;

/**
 * Represents a structured data, used on {@link DataContainer}
 * 
 * @author Ufuk BOMBAR
 * @since 28.04.2018 00:51
 * @version 1.0
 */
public class DataStructure implements Serializable
{
    public static final long serialVersionUID = 48L;

    private DataType[] types;

    /**
     * Constructor, creates a {@link DataType} array size of the parameter
     * @param size size
     * @param type type of it
     */
    public DataStructure( int size, DataType type )
    {
        types = new DataType[ size ];

        for ( int i = 0; i < this.size(); i++ )
            types[ i ] = type;
    }

    /**
     * Creates a structure that size is the argument count
     * @param type1 type of that data
     */
    public DataStructure( DataType type1 )
    {
        types = new DataType[]{ 
            type1 };
    }

    /**
     * Creates a structure that size is the argument count
     * @param type1 type of that data
     * @param type2 type of that data
     */
    public DataStructure( DataType type1, DataType type2 )
    {
        types = new DataType[]{ 
            type1, 
            type2 };
    }

    /**
     * Creates a structure that size is the argument count
     * @param type1 type of that data
     * @param type2 type of that data
     * @param type3 type of that data
     */
    public DataStructure( DataType type1, DataType type2, DataType type3 )
    {
        types = new DataType[]{ 
            type1, 
            type2,
            type3 };
    }

    /**
     * Creates a structure that size is the argument count
     * @param type1 type of that data
     * @param type2 type of that data
     * @param type3 type of that data
     * @param type4 type of that data
     */
    public DataStructure( DataType type1, DataType type2, DataType type3, DataType type4 )
    {
        types = new DataType[]{ 
            type1, 
            type2,
            type3,
            type4 };
    }

    /**
     * Creates a structure that size is the argument count
     * @param type1 type of that data
     * @param type2 type of that data
     * @param type3 type of that data
     * @param type4 type of that data
     * @param type5 type of that data
     */
    public DataStructure( DataType type1, DataType type2, DataType type3, DataType type4, DataType type5 )
    {
        types = new DataType[]{ 
            type1, 
            type2,
            type3,
            type4,
            type5 };
    }

    /**
     * Creates a structure that size is the argument count
     * @param type1 type of that data
     * @param type2 type of that data
     * @param type3 type of that data
     * @param type4 type of that data
     * @param type5 type of that data
     * @param type6 type of that data
     */
    public DataStructure( DataType type1, DataType type2, DataType type3, DataType type4, DataType type5, DataType type6 )
    {
        types = new DataType[]{ 
            type1, 
            type2,
            type3,
            type4,
            type5,
            type6 };
    }

    /**
     * Creates a structure that size is the argument count
     * @param type1 type of that data
     * @param type2 type of that data
     * @param type3 type of that data
     * @param type4 type of that data
     * @param type5 type of that data
     * @param type6 type of that data
     * @param type7 type of that data
     */
    public DataStructure( DataType type1, DataType type2, DataType type3, DataType type4, DataType type5, DataType type6, DataType type7 )
    {
        types = new DataType[]{ 
            type1, 
            type2,
            type3,
            type4,
            type5,
            type6,
            type7 };
    }

    /**
     * Creates a structure that size is the argument count
     * @param type1 type of that data
     * @param type2 type of that data
     * @param type3 type of that data
     * @param type4 type of that data
     * @param type5 type of that data
     * @param type6 type of that data
     * @param type7 type of that data
     * @param type8 type of that data
     */
    public DataStructure( DataType type1, DataType type2, DataType type3, DataType type4, DataType type5, DataType type6, DataType type7, DataType type8 )
    {
        types = new DataType[]{ 
            type1, 
            type2,
            type3,
            type4,
            type5,
            type6,
            type7,
            type8 };
    }

    /**
     * Gets the datatype on the specified index
     * @param i index
     * @return type of data on index
     */
    public DataType getDataType( int i )
    {
        return types[ i ];
    }

    /**
     * Returns the length
     * @return size of the structure
     */
    public int size()
    {
        return types.length;
    }

    /**
     * Adds the argument structure to itself
     * @param structure given structure for merging
     */
    public void merge( DataStructure structure )
    {
        DataType[] tmp = new DataType[ this.size() + structure.size() ];

        for ( int i = 0; i < this.size(); i++ )
            tmp[ i ] = this.types[ i ];
        
         for ( int i = this.size(); i < structure.size(); i++ )
            tmp[ i ] = structure.types[ i ];

        this.types = tmp;
    }

}