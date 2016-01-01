package com.shashi.protoc;

import com.shashi.files.FileUtility;
import org.apache.log4j.BasicConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Shashi Bhushan
 *         Created on 30/12/15.
 *         For Google-Protoc
 */
public class ProtoUtilTest {
    /**
     * Setting up Log4j Framework properly
     */
    @BeforeClass
    public static void setUp() {
        BasicConfigurator.configure();
    }

    /**
     * Reads user inputs from CommandLineInput.txt file
     * and passes to {@link ProtoUtil#addPersonToFile(Path, BufferedReader, PrintStream)}
     *
     * @throws IOException
     *          if CommandLineInput.txt is not found in specified path or
     *          if could not add Person to Proto File
     */
    @Test
    public void addPersonFromFile_ShouldNotThrowException() throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader("src/test/java/com/shashi/protoc/file/CommandLineInput.txt"));

        ProtoUtil.addPersonToFile(FileUtility.Files.PROTOC_FILE.getPath(),
                reader, System.out);
    }

    /**
     * Reads from PROTOC_FILE and List the Persons
     * Should print to System.out PrintStream
     */
    @Test
    public void listPerson() {
        Path path = Paths.get(FileUtility.Files.PROTOC_FILE
                .getPath().toString());

        ProtoUtil.listPersonsFromFile(path, System.out);
    }
}
