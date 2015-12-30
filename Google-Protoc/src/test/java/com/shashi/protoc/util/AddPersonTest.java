package com.shashi.protoc.util;

import com.shashi.files.FileUtility;
import org.apache.log4j.BasicConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Shashi Bhushan
 *         Created on 30/12/15.
 *         For Google-Protoc
 */
public class AddPersonTest {

    @BeforeClass
    public static void setUp() {
        BasicConfigurator.configure();
    }

    @Test
    public void addPersonFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader("src/test/java/com/shashi/protoc/util/CommandLineInput.txt"));

        AddPerson.addPersonToFile(FileUtility.Files.PROTOC_FILE.getPath(),
                reader, System.out);
    }
}
