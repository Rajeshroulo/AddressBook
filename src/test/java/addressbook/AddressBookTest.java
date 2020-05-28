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

    @Test
    public void givenPersonsDetailsSearchedByName_whenFound_shouldReturnTrue() {
        AddressBook addressBook = new AddressBook();
        addressBook.add("Raj","purohit","Jaipur","Jaipur","Rajasthan",
                "560008","9363675348");
        boolean result = addressBook.search("Raj");
        Assert.assertTrue(result);
    }

    @Test
    public void givenPersonsDetailsSearchedName_whenNotFound_shouldReturnFalse() {
        AddressBook addressBook = new AddressBook();
        addressBook.add("Raj","Raval","Musheerabad","Hyderabad","Telangana",
                "456132","9354675354");
          boolean result = addressBook.search("Rajesh");
        Assert.assertFalse(result);
    }

}
