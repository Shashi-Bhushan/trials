package com.shashi.files;

import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Shashi Bhushan
 *         Created on 30/12/15.
 *         For Google-Protoc
 */
public class FileUtility {
    /**
     * Valid Serialized File paths Array
     */
    private static final String[] SERIALIZE_FILE_PATHS = {
            "/home/shashi/Emp-File.serialize",
            "/Users/SBhushan/IdeaProjects/Emp-File.serialize"
    };
    /**
     * Valid Marshalled File paths Array
     */
    private static final String[] XML_FILE_PATHS = {
            "/home/shashi/Emp-File.xml",
            "/Users/SBhushan/IdeaProjects/Emp-File.xml"
    };
    /**
     * Valid Marshalled File paths Array
     */
    private static final String[] PROTOC_FILE_PATHS = {
            "/home/shashi/Emp-File.protoc",
            "/Users/SBhushan/IdeaProjects/Emp-File.protoc"
    };

    /**
     * Enumeration for valid Serialized and Marshalled File Paths
     * Respectively. Finds which file path is valid for the current
     * OS and assigns it to {@code path}
     *
     * @author  Shashi Bhushan
     *          created on 12/25/15.
     */
    public enum Files {
        /**
         * Serialized File Path Enumeration
         */
        SERIALIZE_FILE(SERIALIZE_FILE_PATHS),
        /**
         * Marshalled File Path Enumeration
         */
        JAXB_FILE(XML_FILE_PATHS),
        /**
         * Protoc File Path Enumeration
         */
        PROTOC_FILE(PROTOC_FILE_PATHS);

        Path path;

        /**
         * Constructor which takes an array of {@code paths} and
         * iterate over it to find which one of them is the valid
         * file path for the current OS.
         * @param paths
         *          Array of paths from which one should be valid
         *          for Current OS
         */
        Files(String[] paths){
            for(String path: paths){
                Path filePath = Paths.get(path);

                String file = filePath.toString();
                Path directoryPath = Paths.get(file.substring(0, file.lastIndexOf('/')));

                if(java.nio.file.Files.exists(filePath, LinkOption.NOFOLLOW_LINKS)
                        || java.nio.file.Files.exists(directoryPath, LinkOption.NOFOLLOW_LINKS)){
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
}

