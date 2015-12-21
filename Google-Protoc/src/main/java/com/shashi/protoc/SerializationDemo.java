package com.shashi.protoc;

import java.io.Serializable;

public class SerializationDemo implements Serializable{

	/**
	 * This Serial version UID will change once any new version of class has been created
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

}
