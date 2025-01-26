package Basic;

// All the imports for this file
import java.nio.file.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Clear {
    public void clearDataBase(){
        // For clearing the entire database
        String toBeCleared[] = {"Admin","Proffessor","Staff","Student"};

        for(int i = 0 ; i < toBeCleared.length;i++){
            try(BufferedReader reader = new BufferedReader(new FileReader("Ids/" + toBeCleared[i] + "/registered.txt"))) {
                String line;
                while((line = reader.readLine()) != null){
                    if(line.equalsIgnoreCase("registered") || line.equalsIgnoreCase("IdNumber")){
                        continue;
                    }
                    Path filePath = Paths.get("Ids/" + toBeCleared[i] + "/" + line + ".txt");
                    try {
                        Files.delete(filePath);
                    } catch (Exception e) {
                        System.out.println("There was a problem while deleting " + line + ".txt");
                    }
                }
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("Ids/" + toBeCleared[i] + "/registered.txt"))){
                    writer.write("registered" + System.lineSeparator());
                    writer.write("IdNumber" + System.lineSeparator());
                    if(toBeCleared[i].equals("Student")){
                        writer.write("EnrollmentNumber" + System.lineSeparator());
                    }
                } catch (Exception e) {
                    System.out.println("There was a problem while creating the new registered file");
                }
            } catch (IOException e) {
                System.out.println("There was a problem while reading decrypted register");
            }
        }
    }

    public void deleteUserFiles(String id, String path){
        String paths[] = getPath(id, path);
        
        for(int i = 0 ; i< paths.length ;i++){
            Path filePath = Paths.get(paths[i] + "/" + id + ".txt");
            System.out.println(paths[i] + "/" + id + ".txt");
            try {
                Files.delete(filePath);
            } catch (Exception e) {
                System.out.println("There was a problem while deleting " + id + ".txt file");
            }
        }
    }

    String[] getPath(String id, String path){
        if(path.equals("Student")){
            String paths[] = {"Ids/" + path , "Passwords/" + path,"Reminders/" + path + "/public","Reminders/" + path + "/Private"};
            return paths;
        }else{
            String paths[] = {"Ids/" + path , "Passwords/" + path,"Reminders/" + path + "/public","Reminders/" + path + "/Private", "Attendence/"};
            return paths;
        } 
    }

}
