package com.shashi.protoc.util;

import com.shashi.protoc.generated.AddressBookProtos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;

/**
 * @author Shashi Bhushan
 *         Created on 31/12/15.
 *         For Google-Protoc
 */
public class ListPerson {

    public static void printList(Path path, PrintStream output)
            throws IOException {
        AddressBookProtos.AddressBook addressBook =
                AddressBookProtos.AddressBook.parseFrom(
                        new FileInputStream(path.toFile()));

        for(AddressBookProtos.Person person
                : addressBook.getPersonList()){
            output.printf("%-15s : %-5d%s" , "Person ID" , person.getId(),
                    System.getProperty("line.separator"));
            output.printf("%-15s : %-15s%s" , "Name" , person.getName(),
                    System.getProperty("line.separator"));
            if(person.hasEmail()){
                output.printf("%-15s : %-15s%s" , "Email" , person.getEmail(),
                        System.getProperty("line.separator"));
            }

            for(AddressBookProtos.Person.PhoneNumber phoneType:
                    person.getNumberList()){
                output.printf("#%-14s : %-15s%s", phoneType.getType(),
                        phoneType.getNumber(), System.getProperty("line.separator"));
            }

            output.println();
        }
    }
}
