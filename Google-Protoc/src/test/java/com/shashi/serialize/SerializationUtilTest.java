package com.shashi.serialize;

import com.shashi.serialize.Constants.EmployeeConstants;
import com.shashi.serialize.bean.Employee;
import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import com.shashi.files.FileUtility.Files;

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
        serializationUtil.serialize(Files.SERIALIZE_FILE.getPath(), EmployeeConstants.employee1);
    }

    @Test
    public void deSerializesSingleEmployee() throws IOException, ClassNotFoundException {
        serializationUtil.serialize(Files.SERIALIZE_FILE.getPath(), EmployeeConstants.employee1);
        List<Employee> employees = serializationUtil.deSerialize(Files.SERIALIZE_FILE.getPath());

        assertTrue(employees.size() == 1);
        assertTrue(employees.get(0).compareTo(EmployeeConstants.employee1) == 0);
    }
}
