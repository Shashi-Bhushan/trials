package com.shashi.serialize;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

/**
 * {@link SerializationUtil}
 *          contains utils for {@link #serialize(Path, Serializable[]) Serializing},
 *          {@link #deSerialize(Path) De-Serializing},
 *
 * @author  Shashi Bhushan
 *          created on 21/12/15.
 * @param <T> @extends {@link Serializable}
 *          Type of class to Serialize and Deserialize from
 */
public class SerializationUtil<T extends Serializable> {

    /**
     * Get Type {@link T} of class
     * due to Type-Erasure in Java
     * @see
     *          <a href="https://docs.oracle.com/javase/tutorial/java/generics/erasure.html">Type Erasure</a>
     */
    private final Class<T> clazz;
    private final Logger LOG ;

    /**
     * Convenience Constructor saves the Type of class into an instance variable for reference
     * @param clazz
     *          class of Generic type <T>
     */
    protected SerializationUtil(Class<T> clazz){
        this.clazz = clazz;

        LOG = LoggerFactory.getLogger(this.returnedClass());
    }

    /**
     * Returns the Generic Type <T> of class, for which {@link SerializationUtil} is called
     * @return Generic Type of class
     */
    private Class returnedClass(){
        return this.clazz;
    }

    /**
     * Serializes the given {@link T} object and save it into a file
     * at {@code filePath}
     * @param filePath File in which {@link T} object is to be saved
     *        @see {@link Path}
     * @param types {@link T} List to be Serialized
     *
     * @throws {@link IOException}
     *          if the Stream could not be opened or if could not complete writing to {@code filePath}
     */
    public void serialize(Path filePath, T... types) throws IOException {

        List<T> typeList = Arrays.asList(types);

        Files.deleteIfExists(filePath);

        FileOutputStream fileStream = new FileOutputStream(filePath.toFile());
        ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);

        objectStream.writeObject(typeList);

        /**
         * CleanUp after using {@link FileOutputStream} and {@link ObjectOutputStream} Streams
         */
        fileStream.close();
        objectStream.close();
    }

    /**
     * De-Serializes the given {@link T} object from {@code filePath}
     * @param filePath
     *          File from which {@link T} object has to be retrieved
     *
     * @return deserialized {@link T} object from {@code filePath}
     *
     * @throws  {@link IOException}
     *          when {@link FileInputStream} and {@link ObjectInputStream}
     *          could not be opened
     * @throws {@link IOException} and {@link ClassNotFoundException}
     *          when List of {@link T} could not be read from {@code filePath}
     */
    public List<T> deSerialize(Path filePath) throws IOException, ClassNotFoundException {

        List<T> employee = null;

        FileInputStream fileStream = new FileInputStream(filePath.toFile());
        ObjectInputStream objectStream = new ObjectInputStream(fileStream);

        employee = (List<T>)objectStream.readObject();

        /**
         * CleanUp after using {@link FileInputStream} and {@link ObjectInputStream} Streams
         */
        fileStream.close();
        objectStream.close();

        return employee;
    }
}
