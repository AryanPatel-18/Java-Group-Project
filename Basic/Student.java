package Basic;

// All the imports
import java.util.Scanner;
import java.io.*;

public class Student {
    // All the objects for this class
    Scanner sc = new Scanner(System.in);

    public void viewAttendence(){
        // For viewing attendence
    }

    public void addInformation(String id){
        System.out.print("Enter your name : ");
        String name = sc.next();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Ids/Student/" + id + ".txt"))){
            writer.write(name);
        } catch (Exception e) {
            System.out.println("There was problem while writing the student data");
        }
    }

}
