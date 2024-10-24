package n01exercise2.factory;

import n01exercise2.address.Address;
import n01exercise2.phone.PhoneNumber;
import n01exercise2.address.SpainAddress;
import n01exercise2.phone.PortugalPhoneNumber;
import n01exercise2.phone.SpainPhoneNumber;

public class SpainFactory implements AbstractFactory {
    @Override
    public Address createAddress(String street, String city, String postalCode) {
        return new SpainAddress(street, city, postalCode);
    }

    @Override
    public PhoneNumber createPhoneNumber(String phoneNumber) {
        return new SpainPhoneNumber(phoneNumber);
    }
}