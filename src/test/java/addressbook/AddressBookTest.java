package addressbook;

import  org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class AddressBookTest {
    AddressBook addressBook = new AddressBook();

    @Test
    public void givenPersonDetails_WhenAddedToAddressBook_ShouldReturnCorrectSize(){
        addressBook.add("Rajeshkumar","Roulo","Ichapuram","Srikakulam","A.P",
                "532312","9542048044");
        int size = addressBook.addressBook.size();
        Assert.assertEquals(1,size);
    }

    @Test
    public void givenPersonDetails_WhenRemovedFromAddressBook_ShouldReturnCorrectSize( ){
        addressBook.add("Rajeshkumar","Roulo","Ichapuram","Srikakulam","A.P",
                "532312","9542048044");
        addressBook.add("Harish","Roulo","Ichapuram","Srikakulam","A.P",
                "532312","9000341456");
        addressBook.addressBook.remove(1);
        int size = addressBook.addressBook.size();
        Assert.assertEquals(1,size);
    }

    @Test
    public void givenPersonsDetailsSearchedByNumber_whenFound_shouldReturnTrue() {
        AddressBook addressBook = new AddressBook();
        addressBook.add("Raj","purohit","Jaipur","Jaipur","Rajasthan",
                "560008","9363675348");
        boolean result = addressBook.search("9363675348");
        Assert.assertTrue(result);
    }

    @Test
    public void givenPersonsDetailsSearchedByName_whenNotFound_shouldReturnFalse() {
        AddressBook addressBook = new AddressBook();
        addressBook.add("Raj","Raval","Musheerabad","Hyderabad","Telangana",
                "456132","9354675354");
          boolean result = addressBook.search("9363675348");
        Assert.assertFalse(result);
    }

    @Test
    public void givenPersonDetailsWithOneEmptyField_shouldReturnException() {
        try {
            addressBook.add("Rajesh", " ", "ichapuram", "Sklm", "A.P",
                    "532312", "9542048044");
        } catch (AddressBookException e){
            Assert.assertEquals(AddressBookException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }

    @Test
    public void givenPersonDetailsWithAllEmptyFields_shouldReturnException() {
        try {
            addressBook.add("", "", "", "", "",
                    "", "");
        } catch (AddressBookException e){
            Assert.assertEquals(AddressBookException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }

    @Test
    public void givenPersonDetails_whenTwoPersonsHaveSameNumber_shouldThrowAnException() {
        try {
        addressBook.add("Rajesh", "raval", "Begumpet ", "Hyderabad", "Telangana",
                "560007", "9542048044");
        addressBook.add("Harish", "Roulo", "Medchal", "Hyderabad", "Telangana ",
                "560006", "9542048044");

        } catch (AddressBookException e) {
            Assert.assertEquals(AddressBookException.ExceptionType.EXISTING, e.type);
        }
    }

    @Test
    public void givenPersonsDetails_whenReqiuredDataisNotFound_shouldReturnNegativeValue() {
        addressBook.add("rajesh","raval","ichapuram","sklm","a.p",
                "536872","9736327872");
        addressBook.add("mahesh","kumar","berhampur","berhampur","odisha",
                "513867","6325767347");
         int result = addressBook.getIndex("6325764352");
        Assert.assertEquals(-1,result);
    }

    @Test
    public void givenPersonsDetails_whenDetailsEdited_shouldReturnEditedValues() {
        addressBook.add("mahesh","kumar","berhampur","berhampur","odisha",
                "513867","6325767347");
        addressBook.add("rajesh","kumar","ichapuram","sklm","a.p",
                "513867","6325767345");
        addressBook.edit("6325767347","ichapuram","udayagiri","odisha","532313",
                "7788008818");
        String address = addressBook.addressBook.get(1).getAddress();
        Assert.assertEquals("ichapuram",address);
        int result = addressBook.getIndex("7788008818");
        Assert.assertEquals(0,result);
    }

    @Test
    public void givenPersonsDetails_whenDetailsEdited_shouldNotReturnPastValues() {
        addressBook.add("mahesh","raval","ram nagar","hyderabad","Telangana",
                "536872","983637289");
        addressBook.add("rajesh","roulo","subhash nagar","hyderabad","Telangana",
                "513867","6387283638");
        addressBook.edit("6387283638","Nizampet","Secunderabad","Telangana","523648",
                "7788008818");
        String city = addressBook.addressBook.get(1).getCity();
        Assert.assertNotEquals("hyderabad",city);
    }

    @Test
    public void givenPersonsDetails_whenDeleted_shouldReturnNegativeIndexValue() {
        addressBook.add("Rajesh","raval","gangaputra colony","hyderabad","Telangana",
                "536872","9542048044");
        addressBook.add("raj","roulo","Uppal","hyderabad","Telangana",
                "513867","8074453962");
        addressBook.delete("9542048044");
        boolean result = addressBook.search("9542048044");
        Assert.assertFalse(result);
    }

    @Test
    public void givenPersonsDetails_whenSortedByFirstName_shouldReturnDataInSortedOrder() {
        addressBook.add("rajesh","roulo","marthahalli","banagalore","karnataka",
                "560007","9542048044");
        addressBook.add("mahesh","roulo","adarsh nagar","berhampur","odisha",
                "760002","7788008818");
        addressBook.add("harish","roulo","medcah","hyderabad","Telangana",
                "500004","9000341456");
        List<Person> sortPersonDataAccordingToFirstName = addressBook.sortPersonData(new Comparators()
                .getComparator(AddressBook.CompareBy.FIRST_NAME));
        Assert.assertEquals("harish", sortPersonDataAccordingToFirstName.get(0).firstName);
    }

    @Test
    public void givenPersonsDetails_whenSortedByZip_shouldReturnDataInSortedOrder() {
        addressBook.add("rajesh","roulo","marthahalli","banagalore","karnataka",
                "560007","9542048044");
        addressBook.add("mahesh","roulo","adarsh nagar","berhampur","odisha",
                "760002","7788008818");
        addressBook.add("harish","roulo","medcah","hyderabad","Telangana",
                "500004","9000341456");
        List<Person> sortPersonDataAccordingToZip = addressBook.sortPersonData(new Comparators()
                .getComparator(AddressBook.CompareBy.ZIP));
        Assert.assertEquals("760002", sortPersonDataAccordingToZip.get(2).zip);
    }

}
