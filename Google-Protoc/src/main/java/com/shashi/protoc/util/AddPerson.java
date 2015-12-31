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
 *
 *         TODo: Merge this with ListPerson
 */
public class AddPerson {

    private static final Logger LOG =
            LoggerFactory.getLogger(AddPerson.class);

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
            LOG.error("{} : path does not exists. Creating File.",
                    protoFile.toString());
        }

        // Write to File now
        addressBookBuilder.addPerson(promptForPersonDetails(input, output));

        FileOutputStream outputStream = new FileOutputStream(protoFile.toFile());
        addressBookBuilder.build().writeTo(outputStream);

        LOG.info("Printed to File" + System.getProperty("line.separator"));
        outputStream.close();
    }

    /**
     * Fills in a Person Message based on User Input
     *
     * @param input
     *          Take Input from this object
     * @param output
     *          Prints output to this object
     * @return
     *          {@link com.shashi.protoc.generated.AddressBookProtos.Person}
     *          object with the User entered properties
     * @throws IOException
     *          When reading From {@code input}
     */
    private static AddressBookProtos.Person promptForPersonDetails(BufferedReader input,
                                                     PrintStream output) throws IOException{

        AddressBookProtos.Person.Builder personBuilder = AddressBookProtos.Person.newBuilder();

        output.print("Enter Person ID:"
                + System.getProperty("line.separator"));
        personBuilder.setId(Integer.valueOf(input.readLine()));

        output.print("Enter Name:"
                + System.getProperty("line.separator"));
        personBuilder.setName(input.readLine());

        output.print("Enter Email Address (blank for none):"
                + System.getProperty("line.separator"));
        String email = input.readLine();

        if(email.length() > 0){
            personBuilder.setEmail(email);
        }

        addNumberToBuilder(personBuilder, input, output);

        return personBuilder.build();
    }

    /**
     * Adds Numbers To {@link com.shashi.protoc.generated.AddressBookProtos.Person}
     * object's Builder
     * @param personBuilder
     *          Builder to which numbers to add
     * @param input
     * \        Input from which to read numbers and their type
     * @param output
     *          Prints output to
     * @throws IOException
     *          While reading from input
     */
    private static void addNumberToBuilder(AddressBookProtos.Person.Builder personBuilder,
                                           BufferedReader input, PrintStream output) throws IOException {
        while(true){
            output.print("Enter a Phone Number (or leave blank to finish):"
                    + System.getProperty("line.separator"));

            String number = input.readLine();

            if(number == null || number.length() == 0){
                break;
            }

            AddressBookProtos.Person.PhoneNumber.Builder phoneNumberBuilder =
                    AddressBookProtos.Person.PhoneNumber.newBuilder().setNumber(number);

            output.print("is this a mobile, home or work phone?"
                    + System.getProperty("line.separator"));

            String type = input.readLine();

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
                    output.print("Unknown Phone Type. Using Default."
                            + System.getProperty("line.separator"));
            }

            personBuilder.addNumber(phoneNumberBuilder);
        }
    }
}
