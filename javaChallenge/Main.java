package javaChallenge;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Contact> contacts;
    private static Scanner scanner;
    private static int id = 0;

    public static void main(String[] args) {
        contacts = new ArrayList<>();
        System.out.println("Welome");
        showInitialOptions();
    }

    public static void showInitialOptions() {
        System.out.println("Please select one:" +
                "\n\t1. Manage Contacts" +
                "\n\t2. Messages" +
                "\n\t3. Quit");
        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                manageContacts();
                break;
            case 2:
                manageMessages();
                break;
            default:
                break;
        }
    }

    private static void manageMessages() {
        System.out.println("Please select one:" +
                "\n\t1. Show all messages" +
                "\n\t2. Send a new message" +
                "\n\t3. Go Back");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showAllMessages();
                break;
            case 2:
                sendNewMessage();
                break;
            default:
                showInitialOptions();
                break;
        }
    }

    private static void sendNewMessage() {
        System.out.println("Who are you going to send a message");
        String name = scanner.next();
        if (name.equals("")) {
            System.out.println("Pleaase enter the name of the contact");
            sendNewMessage();
        } else {
            boolean doesExist = false;
            for (Contact c: contacts) {
                if (c.getName().equals(name)) {
                    doesExist = true;
                }
            }
            if (doesExist) {
                System.out.println("WHat are you going to say?");
                String text = scanner.next();
                if (text.equals("")) {
                    System.out.println("Please enter some message");
                    sendNewMessage();
                } else {
                    id++;
                }
            } else {
                System.out.println("Theres no such contact");
            }
        }
    }

    private static void showAllMessages() {
        ArrayList<Message> allMessages = new ArrayList<>();
        for (Contact c: contacts) {
            allMessages.addAll(c.getMessages());
        }
        if (allMessages.size() > 0) {
            for (Message m: allMessages) {
                m.getDetails();
                System.out.println("***********");
            }
        } else {
            System.out.println("You don't have any message");
        }
        showInitialOptions();
    }

    private static void manageContacts() {
        System.out.println("Pleas select one:" +
                "\n\t1. Show all contacts:" +
                "\n\t2. Add a new contact" +
                "\n\t3. Search for a contact" +
                "\n\t4. Delete a contact" +
                "\n\t5. Go back");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showAllContacts();
                break;
            case 2:
                addNewContact();
                break;
            case 3:
                searchForContact();
                break;
            case 4:
                deleteContact();
                break;
            default:
                showInitialOptions();
                break;
        }
    }

    private static void deleteContact() {
        System.out.println("Please enter the contacts name:");
        String name  = scanner.next();
        if (name.equals("")) {
            System.out.println("Please enter the name");
            deleteContact();
        } else {
            boolean doesExist = false;
            for (Contact c: contacts) {
                if (c.getName().equals(name)) {
                    doesExist = true;
                    contacts.remove(c);
                }
            }
            if(!doesExist) {
                System.out.println("There is no such contact");
            }
        }
        showInitialOptions();
    }

    private static void searchForContact() {
        System.out.println("Please enter the contact name: ");
        String name = scanner.next();
        if (name.equals("")) {
            System.out.println("Please enter the name");
            searchForContact();
        } else {
            boolean doesExist = false;
            for (Contact c: contacts) {
                if (c.getName().equals(name)) {
                    doesExist = true;
                    c.getDetails();
                }
            }

            if (!doesExist) {
                System.out.println("There is no such contact in ur phone");
            }
        }
        showInitialOptions();
    }

    private static void addNewContact() {
        System.out.println("Adding a new contact..." +
                "\nPlease enter the contact's name");
        String name = scanner.next();
        System.out.println("Please enter contact's number:");
        String number = scanner.next();
        System.out.println("Pease enter the contact's email:");
        String email = scanner.next();

        if (name.equals("") || number.equals("") || email.equals("")) {
            System.out.println("Please enter all of the information");
            addNewContact();
        } else {
            boolean doesExist = false;
            for (Contact c: contacts) {
                if (c.getName().equals(name)) {
                    doesExist = true;
                }
            }
            if (doesExist) {
                System.out.println("We have a contact with this name");
                addNewContact();
            } else {
                Contact contact = new Contact(name, number, email);
                contacts.add(contact);
                System.out.println(name + " added successfully");
            }
        }
        showInitialOptions();
    }

    private static void showAllContacts() {
        for (Contact c: contacts) {
            c.getDetails();
            System.out.println("*************");
        }
        showInitialOptions();
    }


}

