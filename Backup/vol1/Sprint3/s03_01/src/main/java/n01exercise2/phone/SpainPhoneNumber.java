package n01exercise2.phone;

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

