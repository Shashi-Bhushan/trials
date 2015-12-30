package com.shashi.protoc.util;

import com.shashi.files.FileUtility;
import org.apache.log4j.BasicConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;

/**
 * @author Shashi Bhushan
 *         Created on 30/12/15.
 *         For Google-Protoc
 */
public class AddPersonTest {

    /**
     * Setting up Log4j Framework properly
     */
    @BeforeClass
    public static void setUp() {
        BasicConfigurator.configure();
    }

    /**
     * Reads user inputs from CommandLineInput.txt file
     * and passes to {@link AddPerson#addPersonToFile(Path, BufferedReader, PrintStream)}
     *
     * @throws IOException
     *          if CommandLineInput.txt is not found in specified path or
     *          if could not add Person to Proto File
     */
    @Test
    public void addPersonFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader("src/test/java/com/shashi/protoc/util/CommandLineInput.txt"));

        AddPerson.addPersonToFile(FileUtility.Files.PROTOC_FILE.getPath(),
                reader, System.out);
    }
}
