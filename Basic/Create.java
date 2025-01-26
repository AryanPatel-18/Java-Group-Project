package Basic;

// All the imports for the file
import java.io.*;
import java.util.Scanner;

public class Create {

    // All the objects needed for the class
    // Login l = new Login();
    Scanner sc = new Scanner(System.in);
    Student s = new Student();
    Admin a = new Admin();

    public void studentUser(){
        System.out.print("Please enter your first name : ");
        String firstName = sc.next();
        System.out.print("Please enter your last name : ");
        String lastName = sc.next();

        // Specific way to create user id
        String id = "ST" + firstName.toUpperCase().charAt(0) + lastName.toUpperCase().charAt(0) + getId("Student");
        registerUser(id, "Student");
        setPassword(id, "Student");
        s.addInformation(id, firstName, lastName); 
        Main.createReminderFiles("Students", id);
        Student.Menu(id);

    }

    public void proffUser(String id){
        // For creating proffessor ids
    }

    public void adminUser(){
        // For creating admin user which requires a super user
        String id = "";
        while(true){
            System.out.print("Enter the id : ");
            id = sc.next();
            if(!isExist("Admin",id)){
                break;
            }else{
                System.out.println("This id already exists please try another one");
            }
        }
        id = "AD" + id + getId("Admin");
        a.addInformation(id);
        setPassword(id, "Admin");
        registerUser(id, "Admin");
        Main.createReminderFiles("Admin", id);
        a.Menu(id);

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
            updateId(path);
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

    private void setPassword(String id, String path){
        System.out.print("Please enter the password you want for the id : ");
        String psw = sc.next();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Passwords/" + path + "/" + id + ".txt"))){
            writer.write(psw);
        } catch (Exception e) {
            System.out.println("There was a problem while saving the password");
        }
    }

    public boolean isExist(String path, String fileName) {

        // Checking the existence of the account in the database
        try (BufferedReader reader = new BufferedReader(new FileReader("Ids/" + path + "/registered.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equalsIgnoreCase(fileName)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("There was a problem while reading the file database");
        }
        return false;
    }


}
