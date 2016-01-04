package com.shashi.serialize.bean;

import com.shashi.files.FileUtility;
import com.shashi.serialize.SerializationUtil;
import com.shashi.serialize.list.EmployeesList;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author Shashi Bhushan
 *         Created on 31/12/15.
 *         For Google-Protoc
 */
public class EmployeeTest {

    private static SerializationUtil<Employee> serializationUtil;

    @BeforeClass
    public static void setup() throws IOException {
        serializationUtil = new SerializationUtil<>(Employee.class);
    }

    @Test @Ignore
    public void setupForInitialSerialization_OnlyToSerializeVersionOne()
            throws IOException {
        Path filePath = FileUtility.Files.SERIALIZE_FILE.getPath();
        Files.deleteIfExists(filePath);

        serializationUtil.serialize(filePath, EmployeesList.employeeOne);
    }

    @Test//(expected = ClassCastException.class)
    public void deserialize_VersionOneObject_ToAnotherVersion() throws IOException, ClassNotFoundException {
        List<Employee> employees = serializationUtil.deSerialize(FileUtility.Files.SERIALIZE_FILE.getPath());

        Employee employee = employees.get(0);
        assertTrue(employee.getClass() != null);
    }

    @Test
    public void testSet_id() throws Exception {

    }

    @Test
    public void testSet_name() throws Exception {

    }

    @Test
    public void testSet_birthday() throws Exception {

    }

    @Test
    public void testSet_age() throws Exception {

    }

    @Test
    public void testSet_role() throws Exception {

    }

    @Test
    public void testSet_gender() throws Exception {

    }

    @Test
    public void testSet_version() throws Exception {

    }

    @Test
    public void testCreateEmployee() throws Exception {

    }
}
