package com.shashi.jaxb;

import com.shashi.jaxb.Constants.EmployeeConstants;
import com.shashi.jaxb.Constants.EmployeeFile;
import com.shashi.jaxb.bean.Employee;
import com.shashi.jaxb.bean.Employees;
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
public class JAXBUtilTest {

    private static JAXBUtil<Employee> jaxbUtil;

    @Before
    public void setUp() {
        BasicConfigurator.configure();

        jaxbUtil = new JAXBUtil<>(Employee.class);
    }

    @Test
    public void marshallSingleEmployee() throws IOException, JAXBException {
        jaxbUtil.marshallJAXBObjectToXML(EmployeeFile.MARSHALL_FILE.getPath(), EmployeeConstants.employee1);
    }

    @Test
    public void umMarshallSingleEmployee() throws IOException, ClassNotFoundException, JAXBException {
        jaxbUtil.marshallJAXBObjectToXML(EmployeeFile.MARSHALL_FILE.getPath(), EmployeeConstants.employee1);

        Employees employees = jaxbUtil.unmarshallXMLToJAXBObject(EmployeeFile.MARSHALL_FILE.getPath());

        assertTrue(employees.size() == 1);
        assertTrue(employees.get(0).compareTo(EmployeeConstants.employee1) == 0);
    }

    @Test
    public void marshallMultipleEmployee() throws IOException, JAXBException {
        jaxbUtil.marshallJAXBObjectToXML(EmployeeFile.MARSHALL_FILE.getPath(), EmployeeConstants.employee1, EmployeeConstants.employee2);
    }

    @Test
    public void umMarshallMultipleEmployee() throws IOException, ClassNotFoundException, JAXBException {
        jaxbUtil.marshallJAXBObjectToXML(EmployeeFile.MARSHALL_FILE.getPath(), EmployeeConstants.employee1, EmployeeConstants.employee2);

        Employees employees = jaxbUtil.unmarshallXMLToJAXBObject(EmployeeFile.MARSHALL_FILE.getPath());

        assertTrue(employees.size() == 2);
        assertTrue(employees.get(0).compareTo(EmployeeConstants.employee1) == 0);
        assertFalse(employees.get(0).compareTo(EmployeeConstants.employee2) == 0);
        assertTrue(employees.get(1).compareTo(EmployeeConstants.employee2) == 0);
    }
}
