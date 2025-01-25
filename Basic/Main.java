package Basic;

import java.io.BufferedWriter;
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
}
