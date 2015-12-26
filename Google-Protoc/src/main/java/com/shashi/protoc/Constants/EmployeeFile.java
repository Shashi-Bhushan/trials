package com.shashi.protoc.Constants;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by shashi on 26/12/15.
 */
public enum EmployeeFile {
    SERIALIZE_FILE(EmployeeConstants.SERIALIZE_FILE_PATHS),MARSHALL_FILE(EmployeeConstants.MARSHALL_FILE_PATHS);

    Path path;

    EmployeeFile(String[] paths){
        for(String path: paths){
            Path filePath = Paths.get(path);
            if(Files.exists(filePath, LinkOption.NOFOLLOW_LINKS)){
                this.path = filePath;
                break;
            }
        }
    }

    public Path getPath(){
        return this.path;
    }
}
