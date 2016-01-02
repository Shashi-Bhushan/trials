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
    public void deserialize_VersionOneObject_ToVersionTwo() throws IOException, ClassNotFoundException {
        List<Employee> employees = serializationUtil.deSerialize(FileUtility.Files.SERIALIZE_FILE.getPath());
        assertTrue(employees.get(0) != null);
    }
}
