package Basic;


// All the imports
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class Admin {
    Scanner sc = new Scanner(System.in);
    Access a = new Access();
    Clear c = new Clear();
    Create ct = new Create();

    public void addInformation(String id){

        // Format for the information of the admin file
        System.out.print("Enter the full name : ");
        String name = sc.nextLine();
        System.out.print("Enter the post : ");
        String post = sc.next();
        System.out.print("Enter contact number : ");
        String number = sc.next();
        System.out.print("Enter the specialization : ");
        String specialization = sc.next();
        System.out.print("Enter the language spoken : ");
        String language = sc.next();
        System.out.print("Enter the gender : ");
        String gender = sc.next();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Ids/Admin/" + id + ".txt"))){
            writer.write(name + System.lineSeparator());
            writer.write(post + System.lineSeparator());
            writer.write(number + System.lineSeparator());
            writer.write(specialization + System.lineSeparator());
            writer.write(language + System.lineSeparator());
            writer.write(gender + System.lineSeparator());
        } catch (Exception e) {
            System.out.println("There was a problem while setting the admin info");
        }
    }

    private void updateUser(String id){
        System.out.println(id);
        int option = a.checkPermission(id);
        String designation = "";
        
        if (option == 2) {
            designation = "Student";
        }
        
        if (option == 3) {
            designation = "Staff";
        }
        
        if (option == 4) {
            designation = "Professor";
        }
        if(option > 4 || option < 2){
            System.out.println("You cannot update this id");
            return;
        }
        if(a.idExists(id,designation)){
            if (option == 2) {
                updateStudentInfo(id);
            }
            
            if (option == 3) {
                updateStaffInfo(id);
            }
            
            if (option == 4) {
                updateProffInfo(id);
            }
        }else{
            System.out.println("This id does not exists");
        }
    }

    private void updateStudentInfo(String id){
        // We can update all info or just any info
        System.out.println("--------------------------");
        System.out.println("1) First Name");
        System.out.println("2) Last Name");
        System.out.println("3) Mentor Name");
        System.out.println("4) Address");
        System.out.println("--------------------------");

        System.out.print("Please enter what you want to update : ");
        int option = sc.nextInt();

        // Checking for the validity of the option
        if(option > 4 || option < 0){
            System.out.println("Please enter a valid option");
            return;
        }
        // Creating an array out of the information of the user
        String infoArr[] = createInfoArray(id, "Student");
        
        // Updating the new info from the user using indexes
        System.out.print("Enter the new info : ");
        infoArr[option] = sc.next(); 

        // Adding the new info to the text file
        addNewInfo(infoArr, "Student", id);
    }

    private void updateStaffInfo(String id){

    }

    private void updateProffInfo(String id){

    }

    private String[] createInfoArray(String id, String path){
        StringBuilder infoString = new StringBuilder();

        // Just taking all the values from the text file then adding them to a string with space between them and then just using split
        try (BufferedReader reader = new BufferedReader(new FileReader("Ids/" + path + "/" + id + ".txt"))){
            String line;
            while((line = reader.readLine()) != null){
                infoString.append(line + " ");
            }   
        } catch (Exception e) {
            System.out.println("There was a problem while accessing the information");
        }
        String infoArr[] = infoString.toString().split(" ");

        return infoArr;
    }

    private void addNewInfo(String[] arr, String path, String id){

        // Just travelling through the array and added all the new info back to the text file
        // In this case all the orignal data is deleted once and then new data is added
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Ids/" + path + "/" + id + ".txt"))){
            for(int i = 0 ; i < arr.length ; i++){
                writer.write(arr[i] + System.lineSeparator());
            }
        } catch (Exception e) {
            System.out.println("There was a problem while writing the new information");
        }
        
    }

    private void deleteUser(){
        System.out.print("Enter the id you want to delete");
        String inputId = sc.next();
        int option = a.checkPermission(inputId);
        String designation = " ";
        if (option == 2) {
            designation = "Student";
        }
        
        if (option == 3) {
            designation = "Staff";
        }
        
        if (option == 4) {
            designation = "Professor";
        }
        if(option > 4 || option < 2){
            System.out.println("You cannot delete this id");
            return;
        }

        StringBuilder data = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("Ids/" + designation + "/registered.txt"))){
            String line;
            while((line =reader.readLine())!= null){
                if(line.equals(inputId)){
                    continue;
                }else{
                    data.append(line + " ");
                }
            }
            addNewInfo(data.toString().split(" "), designation, "registered");
            c.deleteUserFiles(inputId, designation);
        } catch (Exception e) {
            System.out.println("There was a problem while updating the registered file");
        }

    }

    String generateStaffid(){
        Random random = new Random();
        int min = 100000; 
        int max = 999999;
        int randomSixDigit = random.nextInt(max - min + 1) + min;
        String id = "" + randomSixDigit;

        if(!checkStaffId(id)){
            updateStaffId(id);
            return id;
        }
        return generateStaffid();
    }

    boolean checkStaffId( String id){
        try (BufferedReader reader = new BufferedReader(new FileReader("Ids/StaffId.txt"))){
            String line;
            if((line = reader.readLine()) != null){
                if(line.equals(id)){
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("There was a problem while checking the staff ids");
        }
        return false;
    }

    void updateStaffId(String id){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Ids/StaffId.txt",true))){
            writer.write(id);
        } catch (Exception e) {
            System.out.println("There was a problem while updating the staff id");
        }
    }
    public void Menu(String id) {
            // All the objects for the static class
            Scanner sc = new Scanner(System.in);
            Access a = new Access();
            Student s = new Student();
            Reminders r = new Reminders();
            Timetable t = new Timetable();

            // Main menu for the student database
            while (true) {
                System.out.println("-------------------------------\n");
                System.out.println("1) Set Attendence");
                System.out.println("2) Send Public Message");
                System.out.println("3) Send Private Message");
                System.out.println("4) Clear Reminders");
                System.out.println("5) View Reminders");
                System.out.println("6) Set Time Table");
                System.out.println("7) Update Information");
                System.out.println("8) Delete User");
                System.out.println("9) Create Proffessor id");
                System.out.println("10) Create Staff id");
                System.out.println("11) Exit");
                System.out.println("--------------------------------\n\n");

                System.out.print("What do you want to do? : ");
                int option = sc.nextInt();

                switch (option) {
                    case 1:
                        String inputId = "";

                        // Just checking if the input user actually exists or not
                        while(true){
                            System.out.print("Please enter the id of the student : ");
                            inputId = sc.next();
                            if(!a.idExists(inputId, "Student")){
                                break;
                            }else{
                                System.out.println("This id does not exist please try another id!");
                            }
                        }
                        System.out.print("Enter the number of attended days : ");
                        double attendedDays = sc.nextDouble();
                        System.out.print("Enter The total number of days : ");
                        double totalDays = sc.nextDouble();

                        s.setAttendence(inputId, attendedDays, totalDays);
                        break;
                    case 2:
                        // For sending public messages
                            r.sendPublicReminder();
                            break;
                    case 3:
                        r.sendReminder(id);
                        break;
                    case 4:
                        r.clearReminders(id, "Admin");
                        break;
                    // To clear private reminders
                    case 5:
                        r.displayReminders(id, "Private", "Admin");
                        break;
                    case 6:
                        // To update the time table
                        System.out.println("Enter the division : ");
                        String division = sc.next();
                        if(t.checkDivision(division)){
                            t.setTimetable(division);
                        }else{
                            System.out.print("Please enter a valid division");
                        }
                        break;
                    case 7:
                        // Update Information
                        System.out.print("Enter the id you want to update : ");
                        String updateId = sc.next();
                        updateUser(updateId);
                        break;
                    case 8:
                        // To delete User
                        deleteUser();
                        break;
                    case 9:
                        // For creating proffessor id
                        ct.proffUser(generateStaffid());
                        break;
                    case 10:    
                    // For creating staff id 
                    case 11:
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
