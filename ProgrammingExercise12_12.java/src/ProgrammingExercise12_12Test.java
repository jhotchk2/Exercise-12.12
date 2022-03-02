import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class ProgrammingExercise12_12Test {

  @SuppressWarnings("static-access")
  @Test
  void testMain() throws Exception {
    ProgrammingExercise12_12 myTest = new ProgrammingExercise12_12();
    File test = new File("Test.java");
    File test2 = new File("Test2.java");
    
    StringBuilder buffer = new StringBuilder();
    Scanner input = new Scanner(test);
    
    buffer = myTest.reformatCode(buffer, input);
    myTest.printCode(buffer, test);
    
    assertEquals(test2, test);
  }

}
