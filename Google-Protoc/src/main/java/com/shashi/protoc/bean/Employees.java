package com.shashi.protoc.bean;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Class provides a wrapper for List of {@link Employee} via
 * composition. Also, provides access to some handy methods
 * of accessijng List of {@link Employee} viz {@link #size()}
 * and {@link #get(int)}
 *
 * @author  Shashi Bhushan
 *          created on 12/25/15.
 */
@XmlRootElement(name="employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employees {

    @XmlElement(name="employee")
    private List<Employee> employees = null;

    /**
     * Getter for List of {@link Employee}
     * @return
     *          List of {@link Employee}
     */
    public List<Employee> getEmployees(){
        return employees;
    }

    /**
     * Setter for List of {@link Employee}
     * @param employees
     *          List to set with
     */
    public void setEmployees(List<Employee> employees){
        this.employees = employees;
    }

    /**
     * Composition and Forwarding of Positional Access Operation
     * Returns the {@link Employee} at the position {@code index}
     * in List of {@link Employee}
     * @param index
     *          position or index of the employee to return
     * @return
     *          the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     *          if the index is out of range
     */
    public Employee get(int index){
        return employees.get(index);
    }

    /**
     * Composition and Forwarding of Size Query Operation
     * Returns the number of elements in this list.
     * @return
     *          the number of elements in the List of
     *          {@link Employee}
     */
    public int size(){
        return employees.size();
    }
}
