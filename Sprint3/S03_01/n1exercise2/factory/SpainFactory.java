package n1exercise2.factory;

import n1exercise2.address.SpainAddress;
import n1exercise2.entity.Address;
import n1exercise2.entity.PhoneNumber;
import n1exercise2.phone.SpainPhoneNumber;

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