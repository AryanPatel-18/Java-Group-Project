package Basic;

// All the imports
import java.io.*;
import java.util.Scanner;


public class Login {

    // All the objects for this class
    Scanner sc = new Scanner(System.in);
    Access a = new Access();

    public void login(){
        System.out.print("Please enter your login id : ");
        String id = sc.next();
        int option = a.checkPermission(id);
        boolean exists = false;

        // Showing the appropriate menu according to the id
        switch (option) {
            case 0:
                System.out.println("Please enter a valid id");
                break;
            case 1:
                if(exists = isExist("Admin", id)){
                    exists = true;
                    adminMenu(id);
                }
                break;
            case 2:
                if(exists = isExist("Student", id)){
                    exists = true;
                    normalMenu(id);
                }
                break;
            case 3:
                if(exists = isExist("Staff", id)){
                    exists = true;
                    staffMenu(id);
                }
                break;
            case 4:
                if(exists = isExist("Proffessor", id)){
                    exists = true;
                    proffessorMenu(id);
                }
                break;
            case 5:
                superMenu(id);
                break;            
            default:
                break;
        }

        // error message if the account does not exist
        if(!exists){
            System.out.println("The file name you have entered does not exist");
        }
    
    }

    boolean isExist(String path, String fileName){
        
        // Checking the existence of the account in the database
        try (BufferedReader reader = new BufferedReader(new FileReader("Ids/" + path + "/registered.txt"))){
            String line;
            while((line = reader.readLine()) != null){
                if(line.equalsIgnoreCase(fileName)){
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("There was a problem while reading the file database");
        }
        return false;
    }

    final private static void normalMenu(String id){
        // Main menu for the student database
    }

    final private static void adminMenu(String id){

    }

    final private static void proffessorMenu(String id){

    }

    final private static void superMenu(String id){

    }
    
    final private static void staffMenu(String id){

    }

}
