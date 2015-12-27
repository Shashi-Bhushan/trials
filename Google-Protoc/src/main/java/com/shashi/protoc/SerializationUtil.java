package com.shashi.protoc;

import com.shashi.protoc.Constants.EmployeeConstants;
import com.shashi.protoc.bean.Employee;
import com.shashi.protoc.bean.Employees;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

/**
 * {@link SerializationUtil}
 *          contains utils for {@link #serialize(Path, Serializable[]) Serializing},
 *          {@link #deSerialize(Path) De-Serializing},
 *          {@link #marshallJAXBObjectToXML(Path, Employee[]) Marshalling} and
 *          {@link #unmarshallXMLToJAXBObject(Path) Unmarshalling}
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
     * {@link JAXBContext}
     *          object for marshalling and unmarshalling of List of {@link T}
     */
    private JAXBContext jaxbContext;

    /**
     * Convenience Constructor saves the Type of class into an instance variable for reference
     * @param clazz
     *          class of Generic type <T>
     *
     * @throws {@link JAXBException}
     *          when could not create a new {@link JAXBContext} object for {@link T} class
     */
    protected SerializationUtil(Class<T> clazz){
        this.clazz = clazz;

        LOG = LoggerFactory.getLogger(this.returnedClass());

        try {
            jaxbContext = JAXBContext.newInstance(Employees.class);
        } catch (JAXBException cause) {
            LOG.error("Exception Occurred while Creating JAXB Intance of {}. Message is ", this.returnedClass(), cause);
        }
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

        fileStream.close();
        objectStream.close();

        return employee;
    }

    /**
     * Marshall the Given List of {@link T} and saves into File at {@code filePath}
     * @param filePath full or relative path where List of {@link T}
     *                 objects will be saved
     * @param types at least one {@link T} object to save
     *
     * @throws {@link JAXBException}
     *          when creating {@code marshaller} for List of {@link T} or
     *          when marshalling List of {@link T}
     * @throws {@link javax.xml.bind.PropertyException}
     *          if could not set property to {@code marshaller}
     */
    public void marshallJAXBObjectToXML(Path filePath, Employee... types) throws JAXBException, IOException {
        Marshaller marshaller = jaxbContext.createMarshaller();

        /**
         * For Pretty Print of XML
         */
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        List<Employee> typeList = Arrays.asList(types);

        Employees employeeList = new Employees();
        employeeList.setEmployees(typeList);

        Files.deleteIfExists(filePath);
        marshaller.marshal(employeeList, filePath.toFile());
    }

    /**
     * Unmarshells the given file at {@code filePath} into List of {@link T}
     * @param filePath Path where the file is located
     *
     * @return List of {@link T}
     *
     * @throws {@link JAXBException}
     *          while creating {@code unmarshaller} for List of {@link T} or
     *          when unmarshalling from {@code filePath}
     */
    public Employees unmarshallXMLToJAXBObject(Path filePath) throws JAXBException {
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (Employees)unmarshaller.unmarshal(filePath.toFile());
    }

    /**
     * deletes the file at {@code filePath} if it exists
     * @param filePath the path of the file to check
     */
    private void deleteIfFileExists(String filePath){
        File file = new File(filePath);

        if(file.exists()){
            file.delete();
        }
    }
}
