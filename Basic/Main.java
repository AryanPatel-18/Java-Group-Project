package Basic;

import java.io.File;

class Main {

    static void createReminderFiles(String path, String id)
    {
        try{
            File privateReminders = new File("Reminders/" + path + "/Private/" + id + ".txt");
            privateReminders.createNewFile();
            File publicReminders = new File("Reminders/" + path + "/public/" + id + ".txt");
            publicReminders.createNewFile();
        }catch(Exception e){
            System.out.println("There was a problem while creatingt the requisite files for student");
        }
    }
}
