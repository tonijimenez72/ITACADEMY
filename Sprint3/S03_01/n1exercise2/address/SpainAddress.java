package n1exercise2.address;

import n1exercise2.entity.Address;

public class SpainAddress implements Address {
    private String street;
    private String city;
    private String postalCode;

    public SpainAddress(String street, String city, String postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    @Override
    public String getAddressDetails() {
        return street + "\n" + postalCode + " " + city + ", Spain";
    }
}
