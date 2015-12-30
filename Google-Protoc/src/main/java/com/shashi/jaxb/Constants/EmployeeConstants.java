package com.shashi.jaxb.Constants;

import com.shashi.jaxb.bean.Employee;

import java.time.LocalDate;
import java.time.Month;

/**
 * @author  Shashi Bhushan
 *          created on 12/25/15.
 */
public interface EmployeeConstants {
    /**
     * Static {@link Employee} objects for reference.
     */
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
}
