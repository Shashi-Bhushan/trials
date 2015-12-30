package com.shashi.protoc.util;

import com.shashi.protoc.generated.AddressBookProtos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Path;

/**
 * @author Shashi Bhushan
 *         Created on 29/12/15.
 *         For Google-Protoc
 */
public class AddPerson {

    private static final Logger LOG =
            LoggerFactory.getLogger(AddPerson.class);

    /**
     * Fills in a Person Message based on User Input
     * @return
     *          {@link com.shashi.protoc.generated.AddressBookProtos.Person}
     *          object with the User entered properties
     */
    private static AddressBookProtos.Person promptForAddress(BufferedReader stdin,
                                                            PrintStream stdout) throws IOException{

        AddressBookProtos.Person.Builder personBuilder = AddressBookProtos.Person.newBuilder();

        stdout.print("Enter Person ID:"
                + System.getProperty("line.separator"));
        personBuilder.setId(Integer.valueOf(stdin.readLine()));

        stdout.print("Enter Name:"
                + System.getProperty("line.separator"));
        personBuilder.setName(stdin.readLine());

        stdout.print("Enter Email Address (blank for none):"
                + System.getProperty("line.separator"));
        String email = stdin.readLine();

        if(email.length() > 0){
            personBuilder.setEmail(email);
        }

        while(true){
            stdout.print("Enter a Phone Number (or leave blank to finish):"
                    + System.getProperty("line.separator"));

            String number = stdin.readLine();

            if(number == null || number.length() == 0){
                break;
            }

            AddressBookProtos.Person.PhoneNumber.Builder phoneNumberBuilder =
                    AddressBookProtos.Person.PhoneNumber.newBuilder().setNumber(number);

            stdout.print("is this a mobile, home or work phone?"
                    + System.getProperty("line.separator"));

            String type = stdin.readLine();

            switch(type){
                case "mobile":
                    phoneNumberBuilder.setType(
                            AddressBookProtos.Person.PhoneType.MOBILE);
                    break;
                case "home":
                    phoneNumberBuilder.setType(
                            AddressBookProtos.Person.PhoneType.HOME);
                    break;
                case "work":
                    phoneNumberBuilder.setType(
                            AddressBookProtos.Person.PhoneType.WORK);
                    break;
                default:
                    stdout.print("Unknown Phone Type. Using Default."
                            + System.getProperty("line.separator"));
            }

            personBuilder.addNumber(phoneNumberBuilder);
        }

        return personBuilder.build();
    }

    /**
     * Adds the {@link com.shashi.protoc.generated.AddressBookProtos.Person}
     * object to {@code protoFile}, taking input from {@code input} and
     * sending output to {@code output}
     *
     * @param protoFile
     *          Proto File to save compiled Data to
     * @param input
     *          Take input from this {@link BufferedReader} object
     * @param output
     *          Sends output to this {@link PrintStream} object
     *
     * @throws IOException
     *          When prompting for user input
     */
    public static void addPersonToFile(Path protoFile, BufferedReader input,
                                PrintStream output) throws IOException {
        AddressBookProtos.AddressBook.Builder addressBookBuilder =
                AddressBookProtos.AddressBook.newBuilder();

        // Read an Existing Address Book if it exists
        try {
            addressBookBuilder.mergeFrom(new FileInputStream(protoFile.toFile()));
        } catch (IOException cause) {
            // create one if Doesn't exists
            LOG.error("{} : path does not exists. Creating File.",
                    protoFile.toString());
        }

        // Write to File now
        addressBookBuilder.addPerson(promptForAddress(input, output));

        FileOutputStream outputStream = new FileOutputStream(protoFile.toFile());
        addressBookBuilder.build().writeTo(outputStream);

        LOG.info("Printed to File" + System.getProperty("line.separator"));
        outputStream.close();
    }
}
