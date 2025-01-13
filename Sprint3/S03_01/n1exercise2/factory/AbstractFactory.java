package n1exercise2.factory;

import n1exercise2.address.PortugalAddress;
import n1exercise2.entity.Address;
import n1exercise2.entity.PhoneNumber;
import n1exercise2.phone.PortugalPhoneNumber;

public interface AbstractFactory {
    Address createAddress(String street, String city, String postalCode);
    PhoneNumber createPhoneNumber(String phoneNumber);

    class PortugalFactory implements AbstractFactory {
        @Override
        public Address createAddress(String street, String city, String postalCode) {
            return new PortugalAddress(street, city, postalCode);
        }

        @Override
        public PhoneNumber createPhoneNumber(String phoneNumber) {
            return new PortugalPhoneNumber(phoneNumber);
        }
    }
}