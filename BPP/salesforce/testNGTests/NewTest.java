package salesforce.testNGTests;

import org.testng.annotations.Test;
import utils.DataGenerator;

public class NewTest {
  @Test
  public void f() {
	  System.out.println(DataGenerator.firstName() + " " + DataGenerator.lastName());
	  System.out.println(DataGenerator.intNumber(10));
	  System.out.println(DataGenerator.address());
  }
}
