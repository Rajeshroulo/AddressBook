package addressbook;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    @Test
    public void givenPersonDetails_ShouldReturnFirstName( ){
       Person person = new Person("Rajesh","Roulo","Ichapuram","Srikakulam",
               "AndhraPradesh","532312","9542048044"  );
        String firstName = person.getFirstName();
        Assert.assertEquals("Rajesh",firstName);
    }

    @Test
    public void givenPersonDetails_ShouldReturnState( ){
      Person person = new Person("Mahesh","Kumar","AnandMarg","Berhampur","Odisha",
            "760002","7788008818");
      String state = person.getState();
      Assert.assertEquals("Odisha",state);
    }

    @Test
    public void givenPersonDeatails_ShouldReturnZip( ){
        Person person = new Person("Devendra","Roulo","Ichapuram","Srikakulam",
                "AndhraPradesh","532312","9346160655"  );
        String zip = person.getZip();
        Assert.assertEquals("532312",zip);
    }

}
