package com.shashi.protoc;

import com.shashi.protoc.bean.Employee;
import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by shashi on 21/12/15.
 */
public class SerializationUtilTest {

    private static Employee employee;
    private static List<Employee> deSerializedEmployee;
    private static List<Employee> unMarshalledEmployee;
    private static SerializationUtil<Employee> serializationUtil;

    private static final Logger LOG = LoggerFactory.getLogger(SerializationUtilTest.class);

    // Provide Abstraction for Constants used
    interface Constants {
        String EMP_NAME = "Shashi";
        String SERIALIZE_FILE_PATH = "/home/shashi/Emp-File.serialize";
        String MARSHALL_FILE_PATH="/home/shashi/Emp-File.xml";
    }

    @Before
    public void setUp(){
        BasicConfigurator.configure();
        LocalDate birthday = LocalDate.of(1988, Month.DECEMBER , 4);
        employee = new Employee().setId(1).setName(Constants.EMP_NAME).setBirthday(birthday);

        serializationUtil = new SerializationUtil<Employee>(Employee.class);

        try {
            serializationUtil.serialize(Constants.SERIALIZE_FILE_PATH, employee);
            deSerializedEmployee = serializationUtil.deSerialize(Constants.SERIALIZE_FILE_PATH);

            serializationUtil.marshallJAXBObjectToXML(Constants.MARSHALL_FILE_PATH, employee);
            unMarshalledEmployee = serializationUtil.unmarshallXMLToJAXBObject(Constants.MARSHALL_FILE_PATH);
        } catch (IOException e) {
            LOG.error("IOException Occurred while Serializing Testing {}. Message is ", this.getClass(), e.getMessage());
        } catch (ClassNotFoundException e) {
            LOG.error("ClassNotFoundException Occurred while Serializing Testing {}. Message is ", this.getClass(), e.getMessage());
        } catch (JAXBException e) {
            LOG.error("Exception Occurred while Marshelling Testing {}. Message is ", this.getClass(), e);
        }
    }

    /**
     * Test Case checks that atleast one employee object is there in List of {@link Employee}
     */
    @Test
    public void employeeNotNullTest(){
        assertTrue(deSerializedEmployee.size() != 0);
//        assertTrue(unMarshalledEmployee.size() != 0);
    }

    /**
     * Test Case checks if the name of the first {@link Employee} is equal to the name that is serialized
     */
    @Test
    public void employeeNameEqualTest(){
        assertTrue(Constants.EMP_NAME.equals(deSerializedEmployee.get(0).getName()));
//        assertTrue(Constants.EMP_NAME.equals(unMarshalledEmployee.get(0).getName()));
    }
}
