package com.shashi.protoc.bean;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by SBhushan on 12/25/15.
 */
@XmlRootElement(name="employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employees<T extends Serializable> {

    @XmlElement(name="employee")
    private List<T> employees = null;

    public List<T> getEmployees(){
        return employees;
    }

    public void setEmployees(List<T> employees){
        this.employees = employees;
    }
}
