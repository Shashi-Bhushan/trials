package com.shashi.protoc.bean;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by SBhushan on 12/25/15.
 */
@XmlRootElement(name="employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employees {

    @XmlElement(name="employee")
    private List<Employee> employees = null;

    public List<Employee> getEmployees(){
        return employees;
    }

    public void setEmployees(List<Employee> employees){
        this.employees = employees;
    }

    public Employee get(int index){
        return employees.get(index);
    }

    public int size(){
        return employees.size();
    }
}
