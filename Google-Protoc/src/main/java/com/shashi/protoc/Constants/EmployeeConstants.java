package com.shashi.protoc.Constants;

import com.shashi.protoc.bean.Employee;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created by shashi on 26/12/15.
 */
public interface EmployeeConstants {
    Employee employee1 = new Employee()
            .setId(1)
            .setName("Employee 1")
            .setBirthday(LocalDate.of(1980, Month.JANUARY,1))
            .setGender(Employee.Gender.MALE)
            .setRole(Employee.Role.ARCHITECT);
    Employee employee2 = new Employee()
            .setId(2)
            .setName("Employee 2")
            .setBirthday(LocalDate.of(1980, Month.JANUARY,2))
            .setGender(Employee.Gender.FEMALE)
            .setRole(Employee.Role.CONSULTANT);
    String[] SERIALIZE_FILE_PATHS = {
            "/home/shashi/Emp-File.serialize",
            "/Users/SBhushan/IdeaProjects/Emp-File.serialize"
    };
    String[] MARSHALL_FILE_PATHS = {
            "/home/shashi/Emp-File.xml",
            "/Users/SBhushan/IdeaProjects/Emp-File.xml"
    };
}
