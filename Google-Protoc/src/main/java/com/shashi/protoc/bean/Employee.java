package com.shashi.protoc.bean;

import java.io.Serializable;

public class Employee implements Serializable{

	/**
	 * This Serial version UID will change once any new version of class has been created
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName(){
		return name;
	}

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
