package addressbook;

import  org.junit.Assert;
import org.junit.Test;

public class AddressBookTest {

    @Test
    public void givenPersonDetails_WhenAddedToAddressBook_ShouldReturnCorrectSize(){
        AddressBook addressBook = new AddressBook();
        addressBook.add("Rajeshkumar","Roulo","Ichapuram","Srikakulam","A.P",
                "532312","9542048044");
        int size = addressBook.addressBookList.size();
        Assert.assertEquals(1,size);
    }

    @Test
    public void givenPersonDetails_WhenRemovedFromAddressBook_ShouldReturnCorrectSize( ){
        AddressBook addressBook = new AddressBook();
        addressBook.add("Rajeshkumar","Roulo","Ichapuram","Srikakulam","A.P",
                "532312","9542048044");
        addressBook.add("Harish","Roulo","Ichapuram","Srikakulam","A.P",
                "532312","9000341456");
        addressBook.addressBookList.remove(1);
        int size = addressBook.addressBookList.size();
        Assert.assertEquals(1,size);
    }

}
