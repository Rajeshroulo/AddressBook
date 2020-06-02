package addressbook;

import  org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class AddressBookTest {
    AddressBook addressBook = new AddressBook();

    @Test
    public void givenPersonDetails_WhenAddedToAddressBook_ShouldReturnCorrectSize(){
        addressBook.add("AddressBook1","Rajeshkumar","Roulo","Ichapuram","Srikakulam","A.P",
                "532312","9542048044");
        int size = addressBook.personsList.size();
        Assert.assertEquals(4,size);
    }

    @Test
    public void givenPersonDetails_WhenRemovedFromAddressBook_ShouldReturnCorrectSize( ){
        try {
            addressBook.delete("AddressBook1", "9542048056");
        }catch (AddressBookException e){
            Assert.assertEquals(AddressBookException.ExceptionType.NOT_EXISTING,e.type);
        } }

    @Test
    public void givenPersonsDetailsSearchedByNumber_whenFound_shouldReturnTrue() {
         boolean result = addressBook.search("AddressBook1","9542048044");
        Assert.assertTrue(result);
    }

    @Test
    public void givenPersonsDetailsSearchedByName_whenNotFound_shouldReturnFalse() {
         boolean result = addressBook.search("AddressBook1","9363675348");
        Assert.assertFalse(result);
    }

    @Test
    public void givenPersonDetailsWithOneEmptyField_shouldReturnException() {
        try {
            addressBook.add("AddressBook1","Rajesh", " ", "ichapuram", "Sklm", "A.P",
                    "532312", "9542048044");
        } catch (AddressBookException e){
            Assert.assertEquals(AddressBookException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }

    @Test
    public void givenPersonDetailsWithAllEmptyFields_shouldReturnException() {
        try {
            addressBook.add("AddressBook1","", "", "", "", "",
                    "", "");
        } catch (AddressBookException e){
            Assert.assertEquals(AddressBookException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }

    @Test
    public void givenPersonDetails_whenTwoPersonsHaveSameNumber_shouldThrowAnException() {
        try {
        addressBook.add("AddressBook1","Rajesh", "raval", "Begumpet ", "Hyderabad", "Telangana",
                "560007", "9542048044");
        addressBook.add("AddressBook1","Harish", "Roulo", "Medchal", "Hyderabad", "Telangana ",
                "560006", "9542048044");

        } catch (AddressBookException e) {
            Assert.assertEquals(AddressBookException.ExceptionType.EXISTING, e.type);
        }
    }

    @Test
    public void givenPersonsDetails_whenSortedByFirstName_shouldReturnDataInSortedOrder() {
        List<Person> sortPersonDataAccordingToFirstName = addressBook.sortPersonData(new Comparators()
                .getComparator(AddressBook.CompareBy.FIRST_NAME),"AddressBook1");
        Assert.assertEquals("Harish", sortPersonDataAccordingToFirstName.get(0).firstName);
    }

    @Test
    public void givenPersonsDetails_whenSortedByZip_shouldReturnDataInSortedOrder() {
         List<Person> sortPersonDataAccordingToZip = addressBook.sortPersonData(new Comparators()
                .getComparator(AddressBook.CompareBy.ZIP),"AddressBook1");
        Assert.assertEquals("760002", sortPersonDataAccordingToZip.get(2).zip);
    }

    @Test
    public void givenPersonsDetails_whenPrintMethodCalled_shouldPrintPersonDetails(){
        addressBook.print("AddressBook1");
    }

    @Test
    public void editedPersonDetails_whenEdited_shouldReturnModifiedPersonDetails() {
        try {
            addressBook.edit("AddressBook1","5555555555","ram nagar" ,"hyderabad", "Telangana",
                    "536872", "9999999999");
        } catch (AddressBookException e){
            Assert.assertEquals(AddressBookException.ExceptionType.NOT_EXISTING,e.type);
        }
    }

}
