package n01exercise2.factory;

import n01exercise2.address.*;
import n01exercise2.phone.*;

public class PortugalFactory implements AbstractFactory {
    @Override
    public Address createAddress(String street, String city, String postalCode) {
        return new PortugalAddress(street, city, postalCode);
    }

    @Override
    public PhoneNumber createPhoneNumber(String phoneNumber) {
        return new PortugalPhoneNumber(phoneNumber);
    }
}