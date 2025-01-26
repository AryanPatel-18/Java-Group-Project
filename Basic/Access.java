package Basic;

import java.io.BufferedReader;
import java.io.FileReader;

// Changes can occur
// All the imports needed
// import java.io.*;
// import java.util.Scanner;

public class Access {

    public int checkPermission(String id){
        if(id.charAt(0) == 'A' && id.charAt(1) == 'D'){
            return 1;
        }
        if(id.charAt(0) == 'S' && id.charAt(1) == 'T'){
            return 2;
        }
        if(id.charAt(0) == 'S' && id.charAt(1) == 'F'){
            return 3;
        }
        if(id.charAt(0) == 'P' && id.charAt(1) == 'F'){
            return 4;
        }
        if(id.equals("SPmain")){
            return 5;
        }
        return 0;
    }

    public boolean idExists(String id , String path){
        try (BufferedReader reader = new BufferedReader(new FileReader("Ids/" + path + "/registered.txt"))){
            String line;
            while((line = reader.readLine()) != null){
                if(line.equals(id)){
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("There was a problem while reading the " + path + " registered file");
        }
        return false;
    }

}
