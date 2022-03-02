import java.io.*;
import java.util.*;

public class ProgrammingExercise12_12 {
  public static void main(String[] args) throws Exception {

    // Checks if file was called correctly
    if (args.length != 1) {
      System.out.println("Usage: java exercise12_12 filename");
      System.exit(1);
    }

    // Checks if file already exists
    File sourceFile = new File(args[0]);
    if (!sourceFile.exists()) {
      System.out.println("Source file does not exist");
      System.exit(2);
    }

    // Create necessary variables
    StringBuilder buffer = new StringBuilder();
    Scanner input = new Scanner(sourceFile);


    buffer = reformatCode(buffer, input);
    printCode(buffer, sourceFile);
  }

  /**
   * Takes the source file as a parameter
   * Returns a StringBuilder object with the reformatted code
   */
  public static StringBuilder reformatCode(StringBuilder buffer, Scanner input) throws Exception{
    while (input.hasNext()) {
      String s = input.nextLine();
      String s1 = s.trim();
      if (s1.charAt(0) == '{') {
        buffer.append(" {");
        if (s1.length() > 1) {
          buffer.append("\r\n" + s.replace('{', ' '));
        }
      }
      else {
        buffer.append("\r\n" + s);
      }
    }
    input.close();
    return buffer;
  }

  /**
   * Takes a StringBuilder object and the source file as parameters
   * Writes the StringBuilder object to the source file
   */
  public static void printCode(StringBuilder buffer, File sourceFile) throws Exception{
    PrintWriter output = new PrintWriter(sourceFile);
    output.print(buffer.toString());
    output.close();
  }
}

