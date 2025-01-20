package n1exercise2.service;

import n1exercise2.model.Address;
import n1exercise2.model.Contact;
import n1exercise2.model.PhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class AgendaService {
    private List<Contact> contacts = new ArrayList<>();
    private List<Address> addresses = new ArrayList<>();
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }

    public void addPhoneNumber(PhoneNumber phoneNumber) {
        phoneNumbers.add(phoneNumber);
    }

    public void listContacts() {
        if (contacts.isEmpty()) {
            System.out.println("The agenda is empty.");
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                Contact contact = contacts.get(i);
                Address address = addresses.get(i);
                PhoneNumber phoneNumber = phoneNumbers.get(i);
                System.out.println(contact);
                System.out.println(address.getAddressDetails());
                System.out.println(phoneNumber.getPhoneNumberDetails());
                System.out.println();
            }
        }
    }
}