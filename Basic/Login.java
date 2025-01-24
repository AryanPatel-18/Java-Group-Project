package Basic;

// All the imports
import java.io.*;
import Basic.*;
import java.util.Scanner;

public class Login {

    // All the objects for this class
    Scanner sc = new Scanner(System.in);
    Access a = new Access();

    public void login(){
        System.out.print("Please enter your login id : ");
        String id = sc.next();
        int option = a.checkPermission(id);
        String user = "";

        switch (option) {
            case 0:
                System.out.println("Please enter a valid id");
                break;
            case 1:
                adminMenu();
            case 2:
                normalMenu();
            case 3:
                staffMenu();
            case 4:
                proffessorMenu();
            case 5:
                superMenu();            
            default:
                break;
        }
    
    }

    public void checkUser(String userId){

    }
    final private static void normalMenu(){

    }

    final private static void adminMenu(){

    }

    final private static void proffessorMenu(){

    }

    final private static void superMenu(){

    }
    
    final private static void staffMenu(){

    }

}
