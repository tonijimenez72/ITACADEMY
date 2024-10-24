package n01exercise2.address;

public class PortugalAddress implements Address {
    private String street;
    private String city;
    private String postalCode;

    public PortugalAddress(String street, String city, String postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    @Override
    public String getAddressDetails() {
        return street + "\n" + postalCode + " " + city + ", Portugal";
    }
}
