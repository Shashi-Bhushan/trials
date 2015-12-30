package com.shashi.jaxb.bean;

import javax.xml.bind.annotation.*;
import java.time.LocalDate;
import java.time.Period;

/**
 * {@link Employee}
 *          Convert the Employee Object to XML using JAX-B
 *          Annotations are JAX-B Annotations
 */

@XmlRootElement(name = "employee")
@XmlAccessorType (XmlAccessType.FIELD)
public class Employee implements Comparable<Employee>{

    private int id;
	private String name;
    /**
     * Transient Variable not supposed to be Serialized
     * cannot add Transient modifier due to JAXB constraint
     */
    @XmlTransient
    private int age;
    private Role role;
    private Gender gender;

    public Employee(){
        /**
         * Empty Convenience Constructor and Setter for name
         * For JAX-B Requirements
         **/
    }

    public int getId() {
        return id;
    }

    public Employee setId(int id) {
        this.id = id;
        return this;
    }

    public Employee setName(String name){
        this.name = name;
        return this;
    }

    public String getName(){
		return name;
	}

    public Employee setBirthday(LocalDate birthday) {
        /**
         * Set {@code age}
         */
        LocalDate today = LocalDate.now();
        Period period = Period.between(birthday, today);
        this.age = period.getYears();

        return this;
    }

    public int getAge() {
        return age;
    }

    public Role getRole() {
        return role;
    }

    public Employee setRole(Role role) {
        this.role = role;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Employee setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public enum Gender{
        MALE,
        FEMALE
    }

    public enum Role{
        JUNIOR_SOFTWARE_ENGINEER,
        SOFTWARE_ENGINEER,
        SENIOR_SOFTWARE_ENGINEER,
        CONSULTANT,
        SENIOR_CONSULTANT,
        ARCHITECT
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", role='" + role + '\'' +
                ", gender=" + gender +
                '}';
    }

    /**
     * compares the {@link Employee} object to the given object
     * on the basis of {@code id}, {@code name}, {@code Role} &
     * {@code Gender}
     *
     * @param compareWith
     *          {@link Employee} object to compare with
     * @return
     *          {@code int} value specifying if objects are equal
     *          return zero if both are equal otherwise one
     */
    @Override
    public int compareTo(Employee compareWith) {
        if(this.id == compareWith.getId()
                && this.name.equals(compareWith.getName())
                && this.role.equals(compareWith.getRole())
                && this.gender.equals(compareWith.getGender())
                ){
            return 0;
        }
        return 1;
    }
}
