package com.shashi.jaxb.Constants;

import com.shashi.files.FileUtility.EmployeeFile;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

import static org.junit.Assert.assertTrue;

/**
 * Created by shashi on 26/12/15.
 */
public class EmployeeFileTest {

    @Test
    public void serializeFilePathExists(){
        Path path = EmployeeFile.SERIALIZE_FILE.getPath();

        assertTrue(Files.exists(path, LinkOption.NOFOLLOW_LINKS));
    }

    @Test
    public void marshallFilePathExists(){
        Path path = EmployeeFile.MARSHALL_FILE.getPath();

        assertTrue(Files.exists(path, LinkOption.NOFOLLOW_LINKS));
    }


}
