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

    @Test
    public void serializeFilePathExists(){
        Path path = Files.SERIALIZE_FILE.getPath();

        assertTrue(java.nio.file.Files.exists(path, LinkOption.NOFOLLOW_LINKS));
    }

    @Test
    public void marshallFilePathExists(){
        Path path = Files.JAXB_FILE.getPath();

        assertTrue(java.nio.file.Files.exists(path, LinkOption.NOFOLLOW_LINKS));
    }


}
