package com.shashi.protoc.util;

import com.shashi.protoc.generated.AddressBookProtos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author Shashi Bhushan
 *         Created on 29/12/15.
 *         For Google-Protoc
 */
public class AddPerson {

    /**
     * Fills in a Person Message based on User Input
     * @return
     *          {@link com.shashi.protoc.generated.AddressBookProtos.Person}
     *          object with the User entered properties
     */
    public static AddressBookProtos.Person promptForAddress(BufferedReader stdin,
                                                            PrintStream stdout) throws IOException{

        AddressBookProtos.Person.Builder personBuilder = AddressBookProtos.Person.newBuilder();

        stdout.print("Enter Person ID:");
        personBuilder.setId(Integer.valueOf(stdin.readLine()));

        stdout.print("Enter Name:");
        personBuilder.setName(stdin.readLine());

        stdout.print("Enter Email Address (blank for none):");
        String email = stdin.readLine();

        if(email.length() > 0){
            personBuilder.setEmail(email);
        }

        while(true){
            stdout.print("Enter a Phone Number (or leave blank to finish):");

            String number = stdin.readLine();

            if(number.length() == 0){
                break;
            }

            AddressBookProtos.Person.PhoneNumber.Builder phoneNumberBuilder =
                    AddressBookProtos.Person.PhoneNumber.newBuilder().setNumber(number);

            stdout.print("is this a mobile, home or work phone?");

            String type = stdin.readLine();

            switch(type){
                case "mobile":
                    phoneNumberBuilder.setType(AddressBookProtos.Person.PhoneType.MOBILE);
                    break;
                case "home":
                    phoneNumberBuilder.setType(AddressBookProtos.Person.PhoneType.HOME);
                    break;
                case "work":
                    phoneNumberBuilder.setType(AddressBookProtos.Person.PhoneType.WORK);
                    break;
                default:
                    stdout.print("Unknown Phone Type. Using Default.");
            }

            personBuilder.addNumber(phoneNumberBuilder);
        }

        return personBuilder.build();
    }
}
