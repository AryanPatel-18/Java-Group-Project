package Basic;

import java.io.BufferedWriter;
import java.io.FileWriter;
// All the imports
import java.util.Scanner;


public class Admin {
    Scanner sc = new Scanner(System.in);

    public void addInformation(String id){

        // Format for the information of the admin file
        System.out.print("Enter the full name : ");
        String name = sc.nextLine();
        System.out.print("Enter the post : ");
        String post = sc.next();
        System.out.print("Enter contact number : ");
        String number = sc.next();
        System.out.print("Enter the specialization : ");
        String specialization = sc.next();
        System.out.print("Enter the language spoken : ");
        String language = sc.next();
        System.out.print("Enter the gender : ");
        String gender = sc.next();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Ids/Admin/" + id + ".txt"))){
            writer.write(name + System.lineSeparator());
            writer.write(post + System.lineSeparator());
            writer.write(number + System.lineSeparator());
            writer.write(specialization + System.lineSeparator());
            writer.write(language + System.lineSeparator());
            writer.write(gender + System.lineSeparator());
        } catch (Exception e) {
            System.out.println("There was a problem while setting the admin info");
        }
    }

    final public static void Menu(String id) {
            // All the objects for the static class
            Scanner sc = new Scanner(System.in);
            Access a = new Access();
            Student s = new Student();
            Reminders r = new Reminders();

            // Main menu for the student database
            while (true) {
                System.out.println("-------------------------------\n");
                System.out.println("1) Set Attendence");
                System.out.println("2) Send Public Message");
                System.out.println("3) Send Private Message");
                System.out.println("4) Clear Reminders");
                System.out.println("5) View Reminders");
                System.out.println("6) Exit");
                System.out.println("--------------------------------\n\n");

                System.out.print("What do you want to do? : ");
                int option = sc.nextInt();

                switch (option) {
                    case 1:
                        String inputId = "";

                        // Just checking if the input user actually exists or not
                        while(true){
                            System.out.print("Please enter the id of the student : ");
                            inputId = sc.next();
                            if(!a.idExists(inputId, "Student")){
                                break;
                            }else{
                                System.out.println("This id does not exist please try another id!");
                            }
                        }
                        System.out.print("Enter the number of attended days : ");
                        double attendedDays = sc.nextDouble();
                        System.out.print("Enter The total number of days : ");
                        double totalDays = sc.nextDouble();

                        s.setAttendence(inputId, attendedDays, totalDays);
                        break;
                    case 2:
                        // For sending public messages
                            r.sendPublicReminder();
                            break;
                    case 3:
                        
                        break;
                    case 4:
                        
                        break;
                    // To clear private reminders
                    case 5:
                        
                        break;
                    // To view private reminders
                    case 6:
                        System.out.println("Exiting...");
                        sc.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please enter a valid option");
                        break;
            }
        }
    }
}
