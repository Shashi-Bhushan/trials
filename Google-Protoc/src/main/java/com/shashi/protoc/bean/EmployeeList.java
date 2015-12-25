package com.shashi.protoc.bean;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SBhushan on 12/25/15.
 */
@XmlRootElement(name="employeesList")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeList<T extends Serializable> {

    @XmlElement(name="employee")
    private List<T> employeeList = null;

    public List<T> getEmployeeList(){
        return employeeList;
    }

    public void setEmployeeList(List<T> employeeList){
        this.employeeList = employeeList;
    }
}
