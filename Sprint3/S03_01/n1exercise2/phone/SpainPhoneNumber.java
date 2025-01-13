package n1exercise2.phone;

import n1exercise2.entity.PhoneNumber;

public class SpainPhoneNumber implements PhoneNumber {
    private String phoneNumber;

    public SpainPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getPhoneNumberDetails() {
        return "+34 " + phoneNumber;
    }
}

