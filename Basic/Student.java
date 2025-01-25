package Basic;

// All the imports
import java.util.*;
import java.io.*;

public class Student extends Main {
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
        Main.createReminderFiles("Student", id);
        
        

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

    public static void Menu(String id){

        // All the objects for this static method
        Reminders r = new Reminders();
        Scanner sc = new Scanner(System.in);

        System.out.println("\n\n\n");
        System.out.println("Welcome " + id + "!");

        System.out.println("----- REMINDER -------\n\n");
        r.displayReminders(id, "public");
        System.out.println("\n\n\n");


        // Main menu for the student database
        while(true){
            System.out.println("-------------------------------\n");
            System.out.println("1) View Attendence");
            System.out.println("2) View Time Table");
            System.out.println("3) Send Private Message");
            System.out.println("4) Clear Reminders");
            System.out.println("5) View Reminders");
            System.out.println("6) Exit");
            System.out.println("--------------------------------\n\n");

            System.out.print("What do you want to do? : ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    // For Attendence
                    break;
                case 2:
                    // For viewing time table
                case 3:
                    // For sending private messages
                case 4:
                    // To clear private reminders
                case 5:
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
