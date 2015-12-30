package com.shashi.files;

import com.shashi.files.FileUtility.Files;
import org.junit.Test;

import java.nio.file.LinkOption;
import java.nio.file.Path;

import static org.junit.Assert.assertTrue;

/**
 * Created by shashi on 26/12/15.
 */
public class FilesTest {

    /**
     * Asserts that path for Serialized File exists for
     * the current OS.
     *
     * Path will exist if one of the paths of
     * {@link FileUtility#SERIALIZE_FILE_PATHS} is valid
     * or atleast the directory for the file exists on
     * the current OS.
     */
    @Test
    public void serializeFilePathExists(){
        Path path = Files.SERIALIZE_FILE.getPath();
        assertTrue(path != null);
    }

    /**
     * Asserts that path for Marshalled File exists for
     * the current OS.
     *
     * Path will exist if one of the paths of
     * {@link FileUtility#XML_FILE_PATHS} is valid
     * or atleast the directory for the file exists on
     * the current OS.
     */
    @Test
    public void marshallFilePathExists(){
        Path path = Files.JAXB_FILE.getPath();
        assertTrue(path != null);
    }

    /**
     * Asserts that path for Proto File exists for
     * the current OS.
     *
     * Path will exist if one of the paths of
     * {@link FileUtility#PROTOC_FILE_PATHS} is valid
     * or atleast the directory for the file exists on
     * the current OS.
     */
    @Test
    public void protocFilePathExists(){
        Path path = Files.PROTOC_FILE.getPath();
        assertTrue(path != null);
    }

}
