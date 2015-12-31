package com.shashi.protoc.util;

import com.shashi.files.FileUtility;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Shashi Bhushan
 *         Created on 31/12/15.
 *         For Google-Protoc
 */
public class ListPersonTest {

    @Test
    public void ListPerson() throws IOException {
        Path path = Paths.get(FileUtility.Files.PROTOC_FILE
                .getPath().toString());

        ListPerson.printList(path , System.out);
    }
}
