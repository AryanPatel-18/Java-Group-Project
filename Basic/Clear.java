package Basic;

// All the imports for this file
import java.nio.file.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Clear {
    public void clearDataBase(String id){
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
                } catch (Exception e) {
                    System.out.println("There was a problem while creating the new registered file");
                }
            } catch (IOException e) {
                System.out.println("There was a problem while reading decrypted register");
            }
        }
    }

    public void deleteUser(String id){
        // For deleting users
        // if id is of admin we can run the admin delete function
    }

    private void deleteAdmin(){
        // For delete admin user
    }
}
