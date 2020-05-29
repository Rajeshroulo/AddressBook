package addressbook;

import java.util.*;

public class AddressBook {
    List<Person> addressBook = new ArrayList<Person>();

    public void add(String firstName, String lastName, String address, String city, String state, String zip,
                    String phone) {
        if(firstName == "" || lastName == "" || address == "" || city == "" || state == ""|| zip == "" ||
                phone == "")
            throw new AddressBookException(AddressBookException.ExceptionType.ENTERED_EMPTY,"Entered Empty");

        Person person = new Person(firstName, lastName, address, city, state, zip, phone);
        addressBook.add(person);
    }

    public boolean search(String firstName) {
        for (int i=0;i<addressBook.size();i++) {
            String name = addressBook.get(i).firstName;
            if (name.equals(firstName))
                return true;
        }
        return false;
    }

}
