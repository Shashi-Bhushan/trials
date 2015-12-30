package com.shashi.jaxb.Constants;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Enumeration for valid Serialized and Marshalled File Paths
 * Respectively. Finds which file path is valid for the current
 * OS and assings it to {@code path}
 *
 * @author  Shashi Bhushan
 *          created on 12/25/15.
 */
public enum EmployeeFile {
    /**
     * Serialized File Path Enumeration
     */
    SERIALIZE_FILE(com.shashi.jaxb.Constants.EmployeeConstants.SERIALIZE_FILE_PATHS),
    /**
     * Marshalled File Path Enumeration
     */
    MARSHALL_FILE(EmployeeConstants.MARSHALL_FILE_PATHS);

    Path path;

    /**
     * Constructor which takes an array of {@code paths} and
     * iterate over it to find which one of them is the valid
     * file path for the current OS.
     * @param paths
     *          Array of paths from which one should be valid
     *          for Current OS
     */
    EmployeeFile(String[] paths){
        for(String path: paths){
            Path filePath = Paths.get(path);

            if(Files.exists(filePath, LinkOption.NOFOLLOW_LINKS)){
                this.path = filePath;
                break;
            }
        }
    }

    /**
     * Getter for {@code path} i.e. valid path for the Current
     * Enumeration
     * @return
     *          {@link Path} Specific to current Serialized or
     *          Marshaled File
     */
    public Path getPath(){
        return this.path;
    }
}
