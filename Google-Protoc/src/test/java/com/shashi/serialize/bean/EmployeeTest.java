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
import java.util.*;

import static org.junit.Assert.assertFalse;
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

    @Test
    public void equateSameEmployeeObjects_ShouldReturnTrue(){
        Employee employee = Employee.newBuilder(1, "Shashi")
                .setGender(Employee.Properties.Gender.MALE).build();

        Employee employee2 = Employee.newBuilder(1, "Shashi")
                .build();

        assertFalse(employee.equals(employee2));
        assertTrue(employee2.equals(employee));
    }

    @Test
    public void setTest_addEmployeesInSet_ShouldRetrieveProperly(){
        Employee employee = new Employee.Builder(1, "Shashi")
                .setGender(Employee.Properties.Gender.MALE).build();

        Employee employee2 = new Employee.Builder(1, "Shashi")
                .setGender(Employee.Properties.Gender.MALE).build();

        Set<Employee> employees = new HashSet<Employee>();
        employees.add(employee);

        assertFalse(employees.add(employee));
        assertTrue(employees.add(employee2));
    }

    @Test
    public void mapTest_addEmployeesInMap_ShouldRetrieveProperly(){
        Employee employee = new Employee.Builder(1, "Shashi")
                .setGender(Employee.Properties.Gender.MALE).build();

        Employee employee2 = new Employee.Builder(1, "Bhushan")
                .setGender(Employee.Properties.Gender.MALE).build();

        Map<String,Employee> employees = new HashMap<>();
        employees.put("emp1", employee);
        employees.put("emp2", employee2);

        assertTrue(employees.get("emp2") != null);
    }

    @Test//(expected = ClassCastException.class)
    public void deserialize_VersionOneObject_ToAnotherVersion() throws IOException, ClassNotFoundException {
        List<Employee> employees = serializationUtil.deSerialize(FileUtility.Files.SERIALIZE_FILE.getPath());

        Employee employee = employees.get(0);
        assertTrue(employee.getClass() != null);
    }

    @Test
    public void test(){
        Map<com.shashi.serialize.bean.Employee, String> map = new HashMap<>();

        com.shashi.serialize.bean.Employee employee = com.shashi.serialize.bean.Employee.newBuilder(1, "Shashi")
                .setGender(com.shashi.serialize.bean.Employee.Properties.Gender.MALE).build();

        com.shashi.serialize.bean.Employee secondEmployee = com.shashi.serialize.bean.Employee.newBuilder(1, "Shashi")
                .setGender(com.shashi.serialize.bean.Employee.Properties.Gender.MALE).build();

        map.put(employee, "shashi");

        System.out.println("map.get(employee) = " + map.get(secondEmployee));
    }
}
