package n1exercise2.controller;

import n1exercise2.service.AgendaService;
import n1exercise2.entity.Address;
import n1exercise2.entity.Contact;
import n1exercise2.factory.AbstractFactory;
import n1exercise2.factory.SpainFactory;
import n1exercise2.entity.PhoneNumber;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private int option = 0;
    private AgendaService agendaService = new AgendaService();

    public void run() {
        String menuBlock =  """
               \nAgenda Menu
                1. Add spanish contact
                2. Add portuguese contact
                3. List contacts
                4. Exit
               Select an option:
               """;

        do {
            System.out.println(menuBlock);
            try {
                option = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (option) {
                    case 1:
                        addSpanishContact();
                        break;
                    case 2:
                        addPortugueseContact();
                        break;
                    case 3:
                        listContacts();
                        break;
                    case 4:
                        System.out.println("Bye!");
                        scanner.close();
                        break;
                    default:
                        System.out.println("Invalid number code. Please, try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        } while (option != 4);
    }

    private void addSpanishContact() {
        Contact contact = createContact();
        System.out.println("Addres:");
        String street = scanner.nextLine();
        System.out.println("City:");
        String city = scanner.nextLine();
        System.out.println("Postal Code:");
        String postalCode = scanner.nextLine();
        System.out.println("Phone Number:");
        String phone = scanner.nextLine();
        AbstractFactory spainFactory = new SpainFactory();
        Address address = spainFactory.createAddress(street, city, postalCode);
        PhoneNumber phoneNumber = spainFactory.createPhoneNumber(phone);
        agendaService.addContact(contact);
        agendaService.addAddress(address);
        agendaService.addPhoneNumber(phoneNumber);
        System.out.println("Contact added.");
    }

    private void addPortugueseContact() {
        Contact contact = createContact();
        System.out.println("Address:");
        String street = scanner.nextLine();
        System.out.println("City:");
        String city = scanner.nextLine();
        System.out.println("Postal Code:");
        String postalCode = scanner.nextLine();
        System.out.println("Phone Number:");
        String phone = scanner.nextLine();
        AbstractFactory portugalFactory = new AbstractFactory.PortugalFactory();
        Address address = portugalFactory.createAddress(street, city, postalCode);
        PhoneNumber phoneNumber = portugalFactory.createPhoneNumber(phone);
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

    private void listContacts() {
        agendaService.listContacts();
    }
}