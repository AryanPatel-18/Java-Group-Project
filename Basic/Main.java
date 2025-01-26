package Basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

class Main {

    static void createReminderFiles(String path, String id)
    {
        // For writing in the private file
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Reminders/" + path + "/Private/" + id + ".txt"))) {
            writer.write("No reminders");
        } catch (Exception e) {
            System.out.println("There was a problem while writing in the Private reminders file");
        }

        // For writing in the public reminder file
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Reminders/" + path + "/Public/" + id + ".txt"))) {
            writer.write("No reminders");
        } catch (Exception e) {
            System.out.println("There was a problem while writing in the Public reminder file");
        }
    }

    // Read particular line from the text file
    public static String readLine(int lineNumber, String id, String path){
        // to read a specific line from the code

        try(BufferedReader reader = new BufferedReader(new FileReader("Ids/" + path + "/" + id + ".txt"))) {
            String line;
            int count = 1;
            while((line = reader.readLine()) != null){
                if(count == lineNumber){
                    return line;
                }
                count ++;
            }
        } catch (Exception e) {
            System.out.println("There was a problem while reading the specific line");
        }
        return "No line at that point";
    }

    public static void createAttendenceFile(String id){
        String totalDays = "";
        try(BufferedReader reader = new BufferedReader(new FileReader("Attendence/TotalDays.txt"))) {
            totalDays = reader.readLine();
        } catch (Exception e) {
            System.out.println("There was a problem while checking the total attendence");
        }
        
        // For creating the total attendence file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Attendence/" + id + ".txt"))){
            writer.write("0");
            writer.write(totalDays);
            writer.write("0");
        } catch (Exception e) {
            System.out.println("There was a problem while creating the attendence file");
        }
    }
}
