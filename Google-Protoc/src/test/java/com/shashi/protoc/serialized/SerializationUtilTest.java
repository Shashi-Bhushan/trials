package com.shashi.protoc.serialized;

import com.shashi.protoc.serialized.Constants.EmployeeConstants;
import com.shashi.protoc.serialized.Constants.EmployeeFile;
import com.shashi.protoc.serialized.bean.Employee;
import com.shashi.protoc.serialized.bean.Employees;
import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by shashi on 21/12/15.
 */
public class SerializationUtilTest {

    private static SerializationUtil<Employee> serializationUtil;

    @Before
    public void setUp() {
        BasicConfigurator.configure();

        serializationUtil = new SerializationUtil<>(Employee.class);
    }

    @Test
    public void serializeSingleEmployee() throws IOException {
        serializationUtil.serialize(EmployeeFile.SERIALIZE_FILE.getPath(), EmployeeConstants.employee1);
    }

    @Test
    public void deSerializesSingleEmployee() throws IOException, ClassNotFoundException {
        serializationUtil.serialize(EmployeeFile.SERIALIZE_FILE.getPath(), EmployeeConstants.employee1);
        List<Employee> employees = serializationUtil.deSerialize(EmployeeFile.SERIALIZE_FILE.getPath());

        assertTrue(employees.size() == 1);
        assertTrue(employees.get(0).compareTo(EmployeeConstants.employee1) == 0);
    }

    @Test
    public void marshallSingleEmployee() throws IOException, JAXBException {
        serializationUtil.marshallJAXBObjectToXML(EmployeeFile.MARSHALL_FILE.getPath(), EmployeeConstants.employee1);
    }

    @Test
    public void umMarshallSingleEmployee() throws IOException, ClassNotFoundException, JAXBException {
        serializationUtil.marshallJAXBObjectToXML(EmployeeFile.MARSHALL_FILE.getPath(), EmployeeConstants.employee1);

        Employees employees = serializationUtil.unmarshallXMLToJAXBObject(EmployeeFile.MARSHALL_FILE.getPath());

        assertTrue(employees.size() == 1);
        assertTrue(employees.get(0).compareTo(EmployeeConstants.employee1) == 0);
    }

    @Test
    public void marshallMultipleEmployee() throws IOException, JAXBException {
        serializationUtil.marshallJAXBObjectToXML(EmployeeFile.MARSHALL_FILE.getPath(), EmployeeConstants.employee1, EmployeeConstants.employee2);
    }

    @Test
    public void umMarshallMultipleEmployee() throws IOException, ClassNotFoundException, JAXBException {
        serializationUtil.marshallJAXBObjectToXML(EmployeeFile.MARSHALL_FILE.getPath(), EmployeeConstants.employee1, EmployeeConstants.employee2);

        Employees employees = serializationUtil.unmarshallXMLToJAXBObject(EmployeeFile.MARSHALL_FILE.getPath());

        assertTrue(employees.size() == 2);
        assertTrue(employees.get(0).compareTo(EmployeeConstants.employee1) == 0);
        assertFalse(employees.get(0).compareTo(EmployeeConstants.employee2) == 0);
        assertTrue(employees.get(1).compareTo(EmployeeConstants.employee2) == 0);
    }
}
