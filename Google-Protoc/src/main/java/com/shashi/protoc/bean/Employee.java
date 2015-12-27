package com.shashi.protoc.bean;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

/**
 * Converting the same to XML using JAX-B
 * Annotations are for JAX-B
 */

@XmlRootElement(name = "employee")
@XmlAccessorType (XmlAccessType.FIELD)
public class Employee implements Serializable,Comparable<Employee>{

	/**
	 * This Serial version UID will change once any new version of class has been created
	 */
	private static final long serialVersionUID = 1L;

    private int id;
	private String name;
    private LocalDate birthday;
    /**
     * Transient Variable not supposed to be Serialized
     * cannot add Transient modifier due to JAXB constraint
     */
//    @XmlTransient
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public Employee setBirthday(LocalDate birthday) {
        this.birthday = birthday;

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
                ", birthday=" + birthday +
                ", age=" + age +
                ", role='" + role + '\'' +
                ", gender=" + gender +
                '}';
    }

    @Override
    public int compareTo(Employee compareWith) {
        /**
         * Not using Birthday as of now to compare
         */
        if(this.id == compareWith.getId()
                && this.name.equals(compareWith.getName())
                && this.role.equals(compareWith.getRole())
                && this.gender.equals(compareWith.getGender())
                && this.age == compareWith.getAge()
                ){
            return 0;
        }
        return 1;
    }
}
