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
    private Properties.Role role;
    private Properties.Gender gender;
    private Properties.Version version;

    /**
     *
     * @param id
     * @param name
     * @param birthday
     * @param role
     * @param gender
     * @param version
     */
    private Employee(final int id, final String name,
                     final LocalDate birthday,
                     final Properties.Role role,
                     final Properties.Gender gender,
                     final Properties.Version version){
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.role = role;
        this.gender = gender;
        this.version = version;
    }

    /**
     *
     */
    public static final class Builder{
        private int _id;
        private String _name;
        private LocalDate _birthday;
        private transient  int _age;
        private Properties.Role _role;
        private Properties.Gender _gender;
        private Properties.Version _version;

        /**
         * 
         * @param _id
         * @param _name
         */
        public Builder(int _id, String _name) {
            this._id = _id;
            this._name = _name;
        }

        public Builder setId(int _id) {
            this._id = _id;
            return this;
        }

        public Builder setName(String _name) {
            this._name = _name;
            return this;
        }

        public Builder setBirthday(LocalDate _birthday) {
            this._birthday = _birthday;
            /**
             * Set {@code age} now
             */
            LocalDate today = LocalDate.now();
            Period period = Period.between(this._birthday, today);
            this._age = period.getYears();

            return this;
        }

        public Builder setRole(Properties.Role _role) {
            this._role = _role;
            return this;
        }

        public Builder setGender(Properties.Gender _gender) {
            this._gender = _gender;
            return this;
        }

        public Builder setVersion(Properties.Version _version) {
            this._version = _version;
            return this;
        }

        /**
         * @return
         */
        public final Employee createEmployee(){
            return new Employee(_id, _name,_birthday, _role, _gender, _version);
        }
    }

    public int getId() {
        return id;
    }

    public String getName(){
		return name;
	}

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getAge() {
        return age;
    }

    public Properties.Role getRole() {
        return role;
    }

    public Properties.Gender getGender() {
        return gender;
    }

    public Properties.Version getVersion() {
        return version;
    }

    public interface Properties{
        /**
         * Gender of the {@link Employee}
         */
        enum Gender{
            MALE,
            FEMALE
        }

        /**
         * Position of the {@link Employee}
         */
        enum Role{
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
        enum Version{
            /**
             * Represents the initial version of {@link Employee}
             * with instance fields as ID, Name, Birthday, Age(Transient),
             * Role and Gender
             */
            ONE,
            TWO,
            THREE
        }
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
