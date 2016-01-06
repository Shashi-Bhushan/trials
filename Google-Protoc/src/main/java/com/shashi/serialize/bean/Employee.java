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
     * Private Constructor of {@link Employee}, shall be called only By
     * {@link com.shashi.serialize.bean.Employee.Builder}
     * @param id
     *          ID of the {@link Employee}. Required Field
     * @param name
     *          Full Name of the {@link Employee}. Required Field
     * @param birthday
     *          DOB of {@link Employee} as {@link LocalDate} object
     * @param role
     *          Role of {@link Employee} in the organization
     *          one of the values of {@link com.shashi.serialize.bean.Employee.Properties.Role}
     * @param gender
     *          Gender of the {@link Employee}
     *          one of the values of {@link com.shashi.serialize.bean.Employee.Properties.Gender}
     * @param version
     *          Version of the {@link Employee} object
     *          good for tracking while persisting State of the object and restoring object from that
     *          saved state.
     *          Basically, {@code serialVersionUID} does the same thing. but changing {@code serialVersionUID}
     *          will make state persistence and state restoring between different version impossible.
     *          Tracking state via {@code version} has an advantage that tracking of what changes break the
     *          state persistence and then restoring process pretty clear.
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
     * {@link com.shashi.serialize.bean.Employee.Builder}
     *          Builder of {@link Employee}. It takes all the required arguments in the constructor and provides
     *          setters for optional fields. {@link #build()} creates the {@link Employee} object from
     *          these properties.
     *          Note: Builder does not have any Getter for fields
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
         * Parameterized Constructor of {@link com.shashi.serialize.bean.Employee.Builder}
         * takes up ID and Name of {@link Employee} as these are required fields
         * @param _id
         *          ID of the {@link Employee}
         * @param _name
         *          Full name of {@link Employee}
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
         * creates {@link Employee} object based on the supplied field values
         * @return
         *          {@link Employee} object
         */
        public final Employee build(){
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

    /**
     * Properties associated with {@link Employee}
     */
    public interface Properties{
        /**
         * Gender of the {@link Employee}
         */
        enum Gender{
            MALE,
            FEMALE
        }

        /**
         * Position of the {@link Employee} in the organisation
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

    /**
     * @see
     *          {@link Object#equals(Object)}
     * @param obj
     *          Instance of {@link Employee} to compare with
     * @return
     *          true if {@code id} and {@code name} of the {@link Employee} are equal
     *          matches other properties as well if they are equal
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof  Employee)){
            return false;
        }else if(obj == this){
            return true;
        }else{
            Employee compareWith = (Employee)obj;

            if(this.id == compareWith.getId()
                    && this.name.equals(compareWith.getName()) ) {
                /**
                 * Assume at this point that both objects {@code this} and {@code obj} are equal
                 * because their Name and Id fields are equal
                 *
                 * if their are any other properties in {@code this}, match them with those of
                 * {@code compareWith}
                 */
                boolean isEqual = true;

                if(this.gender != null){
                    isEqual = this.gender.equals(compareWith.getGender());
                }
                if(this.role != null){
                    isEqual = this.role.equals(compareWith.getRole());
                }
                if(this.version != null){
                    isEqual = this.version.equals(compareWith.getVersion());
                }
                if(this.birthday != null){
                    isEqual = this.birthday.equals(compareWith.getBirthday());
                }

                return isEqual;
            }
            return false;
        }
    }

    public Builder newBuilder(int id, String name){
        return new Builder(id,name);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
