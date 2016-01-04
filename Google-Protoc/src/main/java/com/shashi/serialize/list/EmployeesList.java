package com.shashi.serialize.list;

import com.shashi.serialize.bean.Employee;

import java.time.LocalDate;
import java.time.Month;

/**
 * @author  Shashi Bhushan
 *          created on 12/25/15.
 */
public interface EmployeesList {
    /**
     * Static {@link Employee} objects
     */
    Employee employeeOne = new Employee()
            .setId(1)
            .setName("Employee 1")
            .setBirthday(LocalDate.of(1980, Month.JANUARY,1))
            .setGender(Employee.Properties.Gender.MALE)
            .setRole(Employee.Properties.Role.ARCHITECT)
            .setVersion(Employee.Properties.Version.ONE);
    Employee employeeTwo = new Employee()
            .setId(2)
            .setName("Employee 2")
            .setBirthday(LocalDate.of(1980, Month.JANUARY, 2))
            .setGender(Employee.Properties.Gender.FEMALE)
            .setRole(Employee.Properties.Role.CONSULTANT)
            .setVersion(Employee.Properties.Version.ONE);;
}
