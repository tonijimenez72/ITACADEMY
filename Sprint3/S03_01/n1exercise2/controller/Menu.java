package n1exercise2.controller;

import n1exercise2.service.AgendaService;
import n1exercise2.model.Address;
import n1exercise2.model.Contact;
import n1exercise2.factory.AbstractFactory;
import n1exercise2.factory.PortugalFactory;
import n1exercise2.factory.SpainFactory;
import n1exercise2.model.PhoneNumber;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final AgendaService agendaService = new AgendaService();

    public void run() {
        int option;
        do {
            printMenu();
            option = getUserOption();
            handleOption(option);
        } while (option != 4);
    }

    private void printMenu() {
        System.out.println("""
               \nAgenda Menu
                1. Add Spanish contact
                2. Add Portuguese contact
                3. List contacts
                4. Exit
               Select an option:
               """);
    }

    private int getUserOption() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            return -1;
        } finally {
            scanner.nextLine(); // Clear the buffer
        }
    }

    private void handleOption(int option) {
        switch (option) {
            case 1 -> addContact(new SpainFactory());
            case 2 -> addContact(new PortugalFactory());
            case 3 -> listContacts();
            case 4 -> exitMenu();
            default -> System.out.println("Invalid number code. Please, try again.");
        }
    }

    private void addContact(AbstractFactory factory) {
        Contact contact = createContact();
        Address address = createAddress(factory);
        PhoneNumber phoneNumber = createPhoneNumber(factory);

        agendaService.addContact(contact);
        agendaService.addAddress(address);
        agendaService.addPhoneNumber(phoneNumber);

        System.out.println("Contact added.");
    }

    private Contact createContact() {
        System.out.println("Name:");
        String name = scanner.nextLine();
        System.out.println("Surname:");
        String surname = scanner.nextLine();
        return new Contact(name, surname);
    }

    private Address createAddress(AbstractFactory factory) {
        System.out.println("Address:");
        String street = scanner.nextLine();
        System.out.println("City:");
        String city = scanner.nextLine();
        System.out.println("Postal Code:");
        String postalCode = scanner.nextLine();
        return factory.createAddress(street, city, postalCode);
    }

    private PhoneNumber createPhoneNumber(AbstractFactory factory) {
        System.out.println("Phone Number:");
        String phone = scanner.nextLine();
        return factory.createPhoneNumber(phone);
    }

    private void listContacts() {
        agendaService.listContacts();
    }

    private void exitMenu() {
        System.out.println("Bye!");
        scanner.close();
    }
}