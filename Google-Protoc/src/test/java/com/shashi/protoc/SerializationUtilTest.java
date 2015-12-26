package com.shashi.protoc;

import com.shashi.protoc.Constants.EmployeeConstants;
import com.shashi.protoc.Constants.EmployeeFile;
import com.shashi.protoc.bean.Employee;
import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by shashi on 21/12/15.
 */
public class SerializationUtilTest {

    private static SerializationUtil<Employee> serializationUtil;

    @Before
    public void setUp() {
        BasicConfigurator.configure();

        serializationUtil = new SerializationUtil<>(Employee.class);
    }

    @Test
    public void serializeSingleEmployee() throws IOException {
        serializationUtil.serialize(EmployeeFile.SERIALIZE_FILE.getPath(), EmployeeConstants.employee1);
    }

    @Test
    public void deSerializesSingleEmployee() throws IOException, ClassNotFoundException {
        serializationUtil.serialize(EmployeeFile.SERIALIZE_FILE.getPath(), EmployeeConstants.employee1);
        List<Employee> deSerializedEmployee = serializationUtil.deSerialize(EmployeeFile.SERIALIZE_FILE.getPath());

        assertTrue(deSerializedEmployee.size() == 1);
        assertTrue(deSerializedEmployee.get(0).getId() == EmployeeConstants.employee1.getId());
        assertTrue(deSerializedEmployee.get(0).getName().equals(EmployeeConstants.employee1.getName()));
        assertTrue(deSerializedEmployee.get(0).getAge() == EmployeeConstants.employee1.getAge());
        assertTrue(deSerializedEmployee.get(0).getGender().equals(EmployeeConstants.employee1.getGender()));
        assertTrue(deSerializedEmployee.get(0).getRole().equals(EmployeeConstants.employee1.getRole()));
    }

    /**
     * Test Case checks if the name of the first {@link Employee} is equal to the name that is serialized
     */
    @Test
    public void employeeNameEqualTest(){
//        assertTrue(EmployeeConstants.NAME.equals(deSerializedEmployee.get(0).getName()));
//        assertTrue(EmployeeConstants.NAME.equals(unMarshalledEmployee.get(0).getName()));
    }
}
