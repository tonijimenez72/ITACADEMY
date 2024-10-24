package n01exercise2.factory;

import n01exercise2.address.Address;
import n01exercise2.phone.PhoneNumber;

public interface AbstractFactory {
    Address createAddress(String street, String city, String postalCode);
    PhoneNumber createPhoneNumber(String phoneNumber);
}