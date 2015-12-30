package com.shashi.jaxb;

import com.shashi.jaxb.bean.Employee;
import com.shashi.jaxb.bean.Employees;
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
 * {@link com.shashi.jaxb.JAXBUtil}
 *          contains utils for {@link #marshallJAXBObjectToXML(Path, Employee[]) Marshalling}
 *          and {@link #unmarshallXMLToJAXBObject(Path) Unmarshalling}
 *
 * @author  Shashi Bhushan
 *          created on 21/12/15.
 * @param <T> @extends {@link Comparable} of {@link Employee}
 *          Type of class to Marshal To and Un-Marshall From
 */
public class JAXBUtil<T extends Comparable<Employee>> {

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
    protected JAXBUtil(Class<T> clazz){
        this.clazz = clazz;

        LOG = LoggerFactory.getLogger(this.returnedClass());

        try {
            jaxbContext = JAXBContext.newInstance(Employees.class);
        } catch (JAXBException cause) {
            LOG.error("Exception Occurred while Creating JAXB Intance of {}. Message is ", this.returnedClass(), cause);
        }
    }

    /**
     * Returns the Generic Type <T> of class, for which {@link com.shashi.serialize.SerializationUtil} is called
     * @return Generic Type of class
     */
    private Class returnedClass(){
        return this.clazz;
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
     * Unmarshal the given file at {@code filePath} into List of {@link T}
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
}
