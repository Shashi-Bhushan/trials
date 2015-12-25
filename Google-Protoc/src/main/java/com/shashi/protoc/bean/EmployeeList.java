package com.shashi.protoc.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SBhushan on 12/25/15.
 */
@XmlRootElement(name="empList")
@XmlSeeAlso({Employee.class})
public class EmployeeList<T extends Serializable> extends ArrayList<T> {

    @Override
    public boolean add(T employee) {
        return super.add(employee);
    }

    @XmlElement(name="employee")
    public List<T> getEmployeeList(){
        return this;
    }
}
