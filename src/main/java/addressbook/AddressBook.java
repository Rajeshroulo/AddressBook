package addressbook;

import java.util.*;

public class AddressBook {
    List<Person> addressBookList = new ArrayList<Person>();

    public void add(String firstName, String lastName, String address, String city, String state, String zip,
                    String phone) {
        Person person = new Person(firstName, lastName, address, city, state, zip, phone);
        addressBookList.add(person);
    }

}
