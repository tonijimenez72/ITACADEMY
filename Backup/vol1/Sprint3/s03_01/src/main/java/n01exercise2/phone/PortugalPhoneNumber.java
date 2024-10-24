package n01exercise2.phone;

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