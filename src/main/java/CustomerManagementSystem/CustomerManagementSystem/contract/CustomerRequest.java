package CustomerManagementSystem.CustomerManagementSystem.contract;

public class CustomerRequest {

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String firstName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String lastName;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String city;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    private String mobileNumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    public CustomerRequest(String firstName,String lastName,String city, String mobileNumber, String email) {
        this.firstName = firstName;
        this.lastName=lastName;
        this.city = city;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

}
