package com.shashi.protoc;

import com.shashi.protoc.bean.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by shashi on 21/12/15.
 */
public class SerializationUtilTest {

    // Employee to Deserialize
    private static Employee employee;
    // De-Serialized Employee
    private static List<Employee> deSerializedEmployee;

    // Utility class for Serialization
    private static SerializationUtil<Employee> serializationUtil;

    // Provide Abstraction for Constants used
    interface Constants {
        String EMP_NAME = "Shashi";
        String FILE_PATH = "/home/shashi/Emp-File.serialize";
    }

    @Before
    public void setUp(){
        employee = new Employee(Constants.EMP_NAME);

        serializationUtil = new SerializationUtil<Employee>();

        serializationUtil.serialize(Constants.FILE_PATH, employee);
        deSerializedEmployee = serializationUtil.deSerialize(Constants.FILE_PATH);
    }

    /**
     * Test Case checks that atleast one employee object is there in List of {@link Employee}
     */
    @Test
    public void employeeNotNullTest(){
        assertTrue(deSerializedEmployee.size() != 0);
    }

    /**
     * Test Case checks if the name of the first {@link Employee} is equal to the name that is serialized
     */
    @Test
    public void employeeNameEqualTest(){
        assertTrue(Constants.EMP_NAME.equals(deSerializedEmployee.get(0).getName()));
    }
}
