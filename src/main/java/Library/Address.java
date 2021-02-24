package Library;

public class Address {

    private String street;
    private int postcode;
    private String city;

    public Address(String street, int postcode, String city) {
        this.setStreet(street);
        this.setPostcode(postcode);
        this.setCity(city);

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

}
