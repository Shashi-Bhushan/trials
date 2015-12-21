package com.shashi.protoc;

import com.shashi.protoc.bean.SerializableEmployee;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by shashi on 21/12/15.
 */
public class SerializationUtilTest {

    // Employee to Deserialize
    private static SerializableEmployee employee;
    // De-Serialized Employee
    private static SerializableEmployee deSerializedEmployee;

    // Utility class for Serialization
    private static SerializationUtil<SerializableEmployee> serializationUtil;

    // Provide Abstraction for Constants used
    interface Constants {
        String EMP_NAME = "Shashi";
        String FILE_NAME = "Emp-File";
    }

    @Before
    public void setUp(){
        employee = new SerializableEmployee(Constants.EMP_NAME);

        serializationUtil = new SerializationUtil<SerializableEmployee>();

        serializationUtil.serialize(employee, Constants.FILE_NAME);
        deSerializedEmployee = serializationUtil.deSerialize(Constants.FILE_NAME);
    }

    @Test
    public void employeeNotNullTest(){
        assertTrue(deSerializedEmployee != null);
    }

    @Test
    public void employeeNameEqualTest(){
        assertTrue(Constants.EMP_NAME.equals(deSerializedEmployee.getName()));
    }
}
