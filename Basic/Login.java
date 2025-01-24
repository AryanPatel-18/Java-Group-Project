package Basic;

// All the imports
import java.io.*;
import java.util.Scanner;


public class Login {

    // All the objects for this class
    Scanner sc = new Scanner(System.in);
    Access a = new Access();
    Reminders r = new Reminders();
    

    public void login(){
        System.out.print("Please enter your login id : ");
        String id = sc.next();
        int option = a.checkPermission(id);
        String designation = "";

        if(option == 1){designation = "Admin";};
        if(option == 2){designation = "Student";};
        if(option == 3){designation = "Staff";};
        if(option == 4){designation = "Professor";};

        if(checkPassword(id, designation)){
            System.out.println("The password you have entered is incorrect please try again later");
            System.exit(0);
        }


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

    final private void normalMenu(String id){

        System.out.println("\n\n\n");
        System.out.println("Welcome " + id + "!");

        System.out.println("----- REMINDER -------\n\n");
        r.displayReminders(id, "public");
        System.out.println("\n\n\n");
        // Main menu for the student database
        System.out.println("-------------------------------\n");
        System.out.println("1) View Attendence");
        System.out.println("2) View Time Table");
        System.out.println("3) Send Private Message");
        System.out.println("4) Clear Reminders");
        System.out.println("5) View Reminders");
        System.out.println("--------------------------------\n\n");
    }

    final private void adminMenu(String id){

    }

    final private void proffessorMenu(String id){

    }

    final private void superMenu(String id){

    }
    
    final private void staffMenu(String id){

    }

    public boolean checkPassword(String id, String path){
        System.out.print("Please enter the password for the id : ");
        String inputPsw = sc.next();
        

        try (BufferedReader reader = new BufferedReader(new FileReader("Passwords/" + path + "/" + id + ".txt" ))){
            String actualPsw = reader.readLine();
            if(actualPsw.equals(inputPsw)){
                return true;
            }
        } catch (Exception e) {
            System.out.println("There was a problem while verifying the password");
        }
        return false;
    }
    

}
