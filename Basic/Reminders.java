package Basic;

// All the imports
import java.io.*;

public class Reminders {
    public void sendReminder(String id){
        // To send private reminders
    }

    public void sendPublicReminder(String id, boolean isAdmin){
        // To send public reminders
    }

    public void clearReminders(String id){
        // To clear All reminders
    }

    public void displayReminders(String id, String type){
        try (BufferedReader reader = new BufferedReader(new FileReader("Reminders/Students/" + type + "/" + id + ".txt"))){
            String line;
            while((line = reader.readLine())!= null){
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("There was a problem while reading the " + type + " reminders");
        }
    }

    // public void displayPriReminder(String id){
    //     try (BufferedReader reader = new BufferedReader(new FileReader("Reminders/Students/Private/" + id + ".txt"))){
    //         String line;
    //         while((line = reader.readLine())!= null){
    //             System.out.println(line);
    //         }
    //     } catch (Exception e) {
    //         System.out.println("There was a problem while reading the public reminders");
    //     }
    // }

    public boolean checkReminders(){
        
        return false;
    }
}
