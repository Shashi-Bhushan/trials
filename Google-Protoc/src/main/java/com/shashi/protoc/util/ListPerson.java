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
            output.printf("%-30s : %5d" , "Person ID" , person.getId());
            output.printf("%-30s : %15s" , "Name" , person.getName());
            if(person.hasEmail()){
                output.printf("%-30s : %15s" , "Email" , person.getEmail());
            }

            for(AddressBookProtos.Person.PhoneNumber phoneType:
                    person.getNumberList()){
                output.printf("%-30s : %15s" , phoneType.getType()
                        + " Number #", phoneType.getNumber());
            }
        }
    }
}
