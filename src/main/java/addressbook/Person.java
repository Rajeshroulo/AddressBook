package addressbook;

public class Person {

        String firstName;
        String lastName;
        String address;
        String city;
        String state;
        String zip;
        String phoneNumber;

        public Person() {
        }

        public Person(String firstName, String lastName, String address, String city, String state, String zip,
                      String phoneNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.phoneNumber = phoneNumber;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public String getAddress() {
            return this.address;
        }

        public String getCity() {
            return this.city;
        }

        public String getState() {
            return this.state;
        }

        public String getZip() {
            return this.zip;
        }

        public String getPhoneNumber() {
            return this.phoneNumber;
        }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
