package Basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Proffessor extends Main {
    // All the objects
    static Scanner sc = new Scanner(System.in);
    Student s = new Student();
    Reminders r = new Reminders();

    // For setting the daily attendence
    void setDailyAttendence(String division){
        String students[] =  getStudentsofDiv(division);

        for(int i = 0 ; i < students.length; i++){
            boolean present = false;
            while(true){
                System.out.print("Was the student present : ");
                String ans = sc.next();
                if(ans.equalsIgnoreCase("yes")){
                    present = true;
                    break;
                }else if(ans.equalsIgnoreCase("no")){
                    break;
                }else{
                    System.out.println("You may only answer in yes or no");
                }
            }
            s.updateAttendence(present, students[i]);
        }
    }

    String[] getStudents(){
        StringBuilder students = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(new FileReader("Ids/Student/registered.txt"))) {
            String line;
            while((line = reader.readLine()) != null){
                if(line.equals("registered") ||line.equals("IdNumber") ||line.equals("EnrollmentNumber")){
                    continue;
                }else{
                    students.append(line + " ");
                }
            }
        } catch (Exception e) {
            System.out.println("There was a problem while getting student ids");
        }
        return students.toString().split(" ");
    }

    String[] getStudentsofDiv( String division){
        String students[] = getStudents();
        StringBuilder studentsOfDiv = new StringBuilder();
        
        for(int i = 0 ; i < students.length ; i++){
            if(division.equals(Main.readLine(7, students[i], "Student"))){
                studentsOfDiv.append(students[i] + " ");
            }    
        }

        return studentsOfDiv.toString().split(" ");
    }

    boolean checkDiv(String division){
        try(BufferedReader reader = new BufferedReader(new FileReader("TimeTables/list.txt"))) {
            String line;
            while((line = reader.readLine()) != null){
                if(line.equals(division)){
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("There was a problem while checking the divisiosn");
        }
        return false;
    }
    
    public void Menu(String id) {
        
        
        while(true){
            System.out.println("-------------------------------\n");
            System.out.println("1) Daily Attendence");
            System.out.println("2) Send Public Message");
            System.out.println("3) Send Private Message");
            System.out.println("4) Clear Reminders");
            System.out.println("5) View Reminders");
            System.out.println("6) Exit");
            System.out.println("--------------------------------\n\n");
            System.out.print("What do you want to do? : ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter the division : ");
                    String division = sc.next();
                    if(checkDiv(division)){
                        setDailyAttendence(division);
                    }else{
                        System.out.println("This division does not exist");
                    }
                    break;
                case 2:
                    r.sendPublicReminder();
                    break;
                case 3:
                    r.sendReminder(id);
                    break;
                case 4:
                    r.clearReminders(id, "Proffessor"); 
                    break;
                case 5:
                    r.displayReminders(id, "Private", "Proffessor");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid input");
                    break;
            }
        }
    }
}
