package n1exercise2.phone;

import n1exercise2.entity.PhoneNumber;

public class PortugalPhoneNumber implements PhoneNumber {
    private String phoneNumber;

    public PortugalPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getPhoneNumberDetails() {
        return "+351 " + phoneNumber;
    }
}