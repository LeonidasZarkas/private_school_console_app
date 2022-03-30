package services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import models.DatabaseParameters;

public class ConsoleScreen {
    
    public void firstScreenOptions() throws SQLException {
        System.out.println("\nPlease chose between the options below:\n"
                + "1: View Data from Database Tables\n"
                + "2: Insert Data to Database Tables\n"
                + "3: Exit\n");
        
        Scanner reader = new Scanner(System.in);
        String firstOption = reader.nextLine();
        
        while (!firstOption.equals("1") && !firstOption.equals("2")&& !firstOption.equals("3")) {
            System.out.println("Type '1', '2' or '3'");
            firstOption = reader.nextLine();
        }
        
        switch(firstOption){
                case "1":
                    viewTableDataOptions();
                    break;
                case "2":
                    insertDataToTableOptions();
                    break;
                case "3":
                    System.out.println("Thank you for passing by!");
                    break;
            }
        
    }
    
    public void viewTableDataOptions() throws SQLException {
        System.out.println("\nWhat do you want to see?\n"
                + "1: All the Students\n"
                + "2: All the Trainers\n"
                + "3: All the Assignments\n"
                + "4: All the Courses\n"
                + "5: All the Students per Course\n"
                + "6: All the Trainers per Course\n"
                + "7: All the Assignments per Course\n"
                + "8: All the Assignments per Course per Student\n"
                + "9: A list of students that belong to more than one courses\n");
        
        Scanner reader = new Scanner(System.in);
        String choice = reader.nextLine();
        
        goToChosenTableForView(choice);
        
    }
    
    public void goToChosenTableForView(String choice) throws SQLException {
        DatabaseParameters dbParameters = new DatabaseParameters();
        DatabaseConnection dbConnection = new DatabaseConnection();
        Connection myConnection = dbConnection.getConnection(dbParameters);
        
        DatabaseSelectQueries dbSQ = new DatabaseSelectQueries();
        DatabaseReadOperation dbOp = new DatabaseReadOperation();
        
        switch(choice){
                case "1":
                    dbSQ.selectAllFromStudentsQuery(dbOp, myConnection);
                    break;
                case "2":
                    dbSQ.selectAllFromTrainersQuery(dbOp, myConnection);
                    break;
                case "3":
                    dbSQ.selectAllFromAssignmentsQuery(dbOp, myConnection);
                    break;
                case "4":
                    dbSQ.selectAllFromCoursesQuery(dbOp, myConnection);
                    break;
                case "5":
                    dbSQ.selectStudentsPerCourseQuery(dbOp, myConnection);
                    break;
                case "6":
                    dbSQ.selectTrainersPerCourseQuery(dbOp, myConnection);
                    break;
                case "7":
                    dbSQ.selectAssignmentsPerCourseQuery(dbOp, myConnection);
                    break;
                case "8":
                    dbSQ.selectAssignmentsPerCoursePerStudentQuery(dbOp, myConnection);
                    break;
                case "9":
                    dbSQ.selectStudentsWithMoreThanOneCoursesQuery(dbOp, myConnection);
                    break;
        }
        firstScreenOptions();
    }
    
    public void insertDataToTableOptions() throws SQLException {
        System.out.println("\nChose a table:\n"
                + "1: Students\n"
                + "2: Trainers\n"
                + "3: Assignments\n"
                + "4: Courses\n"
                + "5: Students per Course\n"
                + "6: Trainers per Course\n"
                + "7: Assignments per Course\n");
        
        Scanner reader = new Scanner(System.in);
        String choice = reader.nextLine();
        
        goToChosenTableForInsert(choice);
        
    }
    
    public void goToChosenTableForInsert(String choice) throws SQLException {
        DatabaseParameters dbParameters = new DatabaseParameters();
        DatabaseConnection dbConnection = new DatabaseConnection();
        Connection myConnection = dbConnection.getConnection(dbParameters);
        
        DatabaseInsertOperation dbInOp = new DatabaseInsertOperation();
        Scanner reader = new Scanner(System.in);
        
        switch(choice){
                
                case "1":
                    System.out.println("Give Student first name:");
                    String firstName = reader.nextLine();
                    System.out.println("Give Student last name:");
                    String lastName = reader.nextLine();
                    dbInOp.insertIntoStudents(firstName, lastName, myConnection);
                    break;
                case "2":
                    System.out.println("Give Trainer first name:");
                    String fName = reader.nextLine();
                    System.out.println("Give Trainer last name:");
                    String lName = reader.nextLine();
                    dbInOp.insertIntoTrainers(fName, lName, myConnection);
                    break;
                case "3":
                    System.out.println("Give Assignment title:");
                    String atitle = reader.nextLine();
                    dbInOp.insertIntoAssignments(atitle, myConnection);
                    break;
                case "4":
                    System.out.println("Give Course title:");
                    String ctitle = reader.nextLine();
                    dbInOp.insertIntoCourses(ctitle, myConnection);
                    break;
                case "5":
                    System.out.println("Give Course id:");
                    int cid = reader.nextInt();
                    System.out.println("Give Student id:");
                    int sid = reader.nextInt();
                    dbInOp.insertIntoStudentsPerCourse(cid, sid, myConnection);
                    break;
                case "6":
                    System.out.println("Give Trainer id:");
                    int trid = reader.nextInt();
                    System.out.println("Give Course id:");
                    int courid = reader.nextInt();
                    dbInOp.insertIntoTrainersPerCourse(trid, courid, myConnection);
                    break;
                case "7":
                    System.out.println("Give Course id:");
                    int courseid = reader.nextInt();
                    System.out.println("Give Assignment id:");
                    int aid = reader.nextInt();
                    dbInOp.insertIntoAssignmentsPerCourse(courseid, aid, myConnection);
                    break;
        }
        firstScreenOptions();
    }
        
}
