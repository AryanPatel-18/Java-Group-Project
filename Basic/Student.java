package Basic;

// All the imports
import java.util.*;
import java.io.*;

public class Student {
    // All the objects for this class
    Scanner sc = new Scanner(System.in);

    public void viewAttendence(){
        // For viewing attendence
    }

    public void addInformation(String id, String firstName, String lastName){

        // Taking all the inputs
        System.out.print("Enter your mentor name : ");
        String mentorName = sc.nextLine();
        System.out.print("Enter your Address : ");
        String address = sc.nextLine();
        String enrollmentNumber = "" + generateEnrollmentNumber();
        
        

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Ids/Student/" + id + ".txt"))){
            writer.write(id + System.lineSeparator());
            writer.write(firstName + System.lineSeparator());
            writer.write(lastName + System.lineSeparator());
            writer.write(mentorName + System.lineSeparator());
            writer.write(address + System.lineSeparator());
            writer.write(enrollmentNumber + System.lineSeparator());
        } catch (Exception e) {
            System.out.println("There was problem while writing the student data");
        }
        
        System.out.println("-------------------------------\n");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Mentor Name : " + mentorName);
        System.out.println("Address : " + address);
        System.out.println("Enrollment Number :" + enrollmentNumber + "\n");
        System.out.println("--------------------------------\n\n");
    }

    int generateEnrollmentNumber(){
        Random random = new Random();

        // Generate a random 9-digit number
        int randomNineDigitNumber = 100000000 + random.nextInt(900000000);
        if(!checkEnrollmentNumber(randomNineDigitNumber)){
            return randomNineDigitNumber;
        }
        return generateEnrollmentNumber();
    }

    boolean checkEnrollmentNumber(int number){
        try (BufferedReader reader = new BufferedReader(new FileReader("Ids/Student/EnrollmentNumber.txt"))){
            String line;
            while((line = reader.readLine()) != null){
                if((Integer.parseInt(line)) == number){
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("There was a problem while reading the enrollment number file");
        }
        return false;
    }


}
