package Basic;

// All the imports for the file
import java.io.*;
import java.util.Scanner;

public class Create {

    // All the objects needed for the class
    Login l = new Login();
    Scanner sc = new Scanner(System.in);

    public void studentUser(){
        System.out.print("Please enter your first name : ");
        String firstName = sc.next();
        System.out.print("Please enter your last name : ");
        String lastName = sc.next();

        // Specific way to create user id
        String id = "ST" + firstName.toUpperCase().charAt(0) + lastName.toUpperCase().charAt(0) + getId("Student");
        updateId("Student");
        registerUser(id, "Student"); 

    }

    public void proffUser(String id){
        // For creating proffessor ids
    }

    public void adminUser(String id){
        // For creating admin user which requires a super user
        // There can be only one super user
    }

    void registerUser(String id, String path){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Ids/" + path + "/registered.txt", true))){
            writer.write(id + System.lineSeparator());
        } catch (Exception e) {
            System.out.println("There was a problem while registering the student into the database;");
        }
    }

    int getId(String path){
        // For getting the id number from the database
        // Basically for checking how many ids we have created for each user category
        // All elminating any copies of ids dues to them having the same name

        String currentId = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("Ids/" + path + "/IdNumber.txt"))){
            currentId = reader.readLine();
            return Integer.parseInt(currentId);
        } catch (Exception e) {
            System.out.println("There was a problem while reading the id number file");
        }
        return 0;
    }

    void updateId(String path){
        int id = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("Ids/" + path + "/idNumber.txt"))) {
            String line = reader.readLine();
            id = Integer.parseInt(line);
        } catch (Exception e) {
            System.out.println("There was a problem while reading the id number");
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Ids/" + path + "/IdNumber.txt"))) {
            String anotherLine = "" + (++id);
            writer.write(anotherLine);
        } catch (Exception e) {
            System.out.println("There was a problem while updating the id number");
        }
    }
}
