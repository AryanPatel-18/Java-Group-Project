package Basic;

// Changes can occur
// All the imports needed
// import java.io.*;
// import java.util.Scanner;

public class Access {
    public void readLine(int lineNumber){
        // to read a specific line from the code
    }

    public void studentData(String id){
        // for printing student data
    }

    public void proffData(String id){
        // for accessing proffessor data
    }

    public void adminData(String id){
        // For checking admin data which requires super user
    }

    boolean isSuperUser(String id){
        // For checking if the id is superUser

        return false;
    }

    boolean isAdmin(String id){
        // for checking if the user is admin
        return false;
    }
}
