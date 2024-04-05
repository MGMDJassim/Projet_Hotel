import java.io.File;  
import java.io.IOException; 

public class CreateFile {
  public static void main(String[] args) {
    try {
      File myObj = new File("projet.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
        writer.write("test succes");
        writer.close();
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
