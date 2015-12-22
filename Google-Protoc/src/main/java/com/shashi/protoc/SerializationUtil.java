package com.shashi.protoc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shashi on 21/12/15.
 *
 * @param <T> Type of class to Serialize and Deserialize from
 */
public class SerializationUtil<T extends Serializable> {

    /**
     * Logger for the class
     */
    public Logger LOG = LoggerFactory.getLogger("WHAT to Write here instead of T.class");

    /**
     * Serializes the given {@link T} object and save it into a file
     * @param filePath File in which {@link T} object is to be saved
     * @param types {@link T} List to be Serialized
     *
     * @return boolean specifying if {@link T} object has been serialized
     */
    public boolean serialize(String filePath, T... types) {

        List<T> typeList = new ArrayList<>();

        for(T type: types)
        {
            typeList.add(type);
        }

        try(FileOutputStream fileStream = new FileOutputStream(filePath);
                ObjectOutputStream objectStream = new ObjectOutputStream(fileStream)) {
            objectStream.writeObject(typeList);
        }catch(IOException inputOutputException){
            LOG.error("Exception Occurred while Serializing {}. Message is ", "WHAT to Write here instead of T.class", inputOutputException.getMessage());

            return false;
        }

        return true;
    }

    /**
     * De-Serializes the given {@link T} object from the given file
     * @param fileName File from which {@link T} object has to be retrieved
     *
     * @return deserialized {@link T} object from the file
     */
    public List<T> deSerialize(String fileName) {

        List<T> employee = null;
        try(FileInputStream fileStream = new FileInputStream(fileName);
            ObjectInputStream objectStream = new ObjectInputStream(fileStream)) {
            employee = (List<T>)objectStream.readObject();
        }catch(IOException | ClassNotFoundException inputOutputException){
            LOG.error("Exception Occurred while Serializing {}. Message is ", "WHAT to Write here instead of T.class", inputOutputException.getMessage());
        }

        return employee;
    }
}
