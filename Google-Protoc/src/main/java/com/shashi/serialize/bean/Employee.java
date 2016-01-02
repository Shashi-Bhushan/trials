package com.shashi.serialize.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Employee implements Serializable,Comparable<Employee>{

	/**
	 * This Serial version UID will change once any new version of class has been created
	 */
	private static final long serialVersionUID = 1L;

    private int id;
	private String name;
    private LocalDate birthday;
    private transient int age;
    private Role role;
    private Gender gender;
    private Version version;

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
         * Set {@code age} now
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

    public Version getVersion() {
        return version;
    }

    public Employee setVersion(Version version) {
        this.version = version;
        return this;
    }

    /**
     * Gender of the {@link Employee}
     */
    public enum Gender{
        MALE,
        FEMALE
    }

    /**
     * Position of the {@link Employee}
     */
    public enum Role{
        JUNIOR_SOFTWARE_ENGINEER,
        SOFTWARE_ENGINEER,
        SENIOR_SOFTWARE_ENGINEER,
        CONSULTANT,
        SENIOR_CONSULTANT,
        ARCHITECT
    }

    /**
     * Enumeration holding a version history of {@link Employee} class
     * Basically, {@code serialVersionUID} does the same
     * but with Deserialization process, it checks with the original
     * Serialized versionUID
     */
    public enum Version{
        /**
         * Represents the initial version of {@link Employee}
         * with instance fields as ID, Name, Birthday, Age(Transient),
         * Role and Gender
         */
        ONE,
        TWO,
        THREE
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
                ", Version=" + version +
                '}';
    }

    /**
     * compares the {@link Employee} object to the given object
     * on the basis of {@code id}, {@code name}, {@code Role},
     * {@code Gender} and {@code birthday}
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
                && this.birthday.equals(compareWith.getBirthday())
                ){
            return 0;
        }
        return 1;
    }
}
