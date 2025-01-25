package Basic;

// All the imports
import java.io.*;
import java.util.*;

public class Reminders {

    // All the imports for this class
    Scanner sc = new Scanner(System.in);
    Access a = new Access();

    public void sendReminder(String id) {
        System.out.print("Enter the id you want to send to message to : ");
        String sendId = sc.next();
        sc.nextLine();
        int option = a.checkPermission(sendId);
        String designation = "";

        // Finding the designation according to the id entered
        if (option == 1) {
            designation = "Admin";
        }

        if (option == 2) {
            designation = "Students";
        }

        if (option == 3) {
            designation = "Staff";
        }

        if (option == 4) {
            designation = "Professor";
        }

        if (option == 5) {
            System.out.println("You cannot send message to this id");
        }

        // Trying to write the message to the sendId file
        // Here the true allows so that the data is not replaced but we can simply add new data on top of it
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Reminders/" + designation + "/Private/" + sendId + ".txt", true))) {
            System.out.print("Please enter your message : ");
            String message = sc.nextLine();
            writer.write(message + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("The person you are trying to send the message to does not exist");
        }

    }

    public void sendPublicReminder(String id, boolean isAdmin) {
        // To send public reminders
    }

    // For clearing Private Reminders
    public void clearReminders(String id, String path) {
        // Just adding a null line so that all the data is deleted
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Reminders/" + path + "/Private/" + id + ".txt"))) {
            writer.write(System.lineSeparator());
            System.out.println("Cleared all the reminders!\n\n");
        } catch (Exception e) {
            System.out.println("There was a problem while clearing the reminders");
        }
    }

    // Displaying different reminders
    public void displayReminders(String id, String type) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Reminders/Students/" + type + "/" + id + ".txt"))) {
            String line;

            // Used line builder so that we can easily add or append values to the string, also supports \n which is to leave a line
            // String builder is the same as a string just using for append feature
            StringBuilder lineBuilder = new StringBuilder();
            
            while ((line = reader.readLine()) != null) {
                lineBuilder.append(line + System.lineSeparator());
            }

            String conversion = lineBuilder.toString().trim();
            
            // Checking if there are any reminders or not
            if(conversion.length() != 0){
                System.out.println("\n\n");
                System.out.println(conversion);
                System.out.println("\n\n");
            }else{
                System.out.println("No Reminders");
            }
        } catch (Exception e) {
            System.out.println("There was a problem while reading the " + type + " reminders");
        }
    }
}
