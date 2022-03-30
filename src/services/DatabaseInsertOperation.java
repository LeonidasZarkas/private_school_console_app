package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInsertOperation {
    private String sql;
    
    public void insertIntoStudents(String firstName, String lastName, Connection myConnection) throws SQLException {
        sql = "INSERT INTO `students`(`first_name`, `last_name`) VALUES(?,?);";
        PreparedStatement stmt = myConnection.prepareStatement(sql);
        stmt.setString(1,firstName);
        stmt.setString(2,lastName);
        
        int result = stmt.executeUpdate();
        System.out.println("Records inserted: " + result);
    }
    
    public void insertIntoTrainers(String firstName, String lastName, Connection myConnection) throws SQLException {
        sql = "INSERT INTO `trainers`(`first_name`, `last_name`) VALUES(?,?);";
        PreparedStatement stmt = myConnection.prepareStatement(sql);
        stmt.setString(1,firstName);
        stmt.setString(2,lastName);
        
        int result = stmt.executeUpdate();
        System.out.println("Records inserted: " + result);
    }
    
    public void insertIntoAssignments(String title, Connection myConnection) throws SQLException {
        sql = "INSERT INTO `assignments`(`title`) VALUES(?);";
        PreparedStatement stmt = myConnection.prepareStatement(sql);
        stmt.setString(1,title);
        
        int result = stmt.executeUpdate();
        System.out.println("Records inserted: " + result);
    }
    
    public void insertIntoCourses(String title, Connection myConnection) throws SQLException {
        sql = "INSERT INTO `courses`(`title`) VALUES(?);";
        PreparedStatement stmt = myConnection.prepareStatement(sql);
        stmt.setString(1,title);
                
        int result = stmt.executeUpdate();
        System.out.println("Records inserted: " + result);
    }
    
    public void insertIntoStudentsPerCourse(int idCourses, int idStudents, Connection myConnection) throws SQLException {
        sql = "INSERT INTO `students_per_course`(`id_courses`, `id_students`) VALUES(?,?);";
        PreparedStatement stmt = myConnection.prepareStatement(sql);
        stmt.setInt(1,idCourses);
        stmt.setInt(2,idStudents);
        
        int result = stmt.executeUpdate();
        System.out.println("Records inserted: " + result);
    }
    
    public void insertIntoTrainersPerCourse(int idTrainers, int idCourses, Connection myConnection) throws SQLException {
        sql = "INSERT INTO `trainers_per_course`(`id_trainers`, `id_courses`) VALUES(?,?);";
        PreparedStatement stmt = myConnection.prepareStatement(sql);
        stmt.setInt(1,idTrainers);
        stmt.setInt(2,idCourses);
        
        int result = stmt.executeUpdate();
        System.out.println("Records inserted: " + result);
    }
    
    public void insertIntoAssignmentsPerCourse(int idCourses, int idAssignments, Connection myConnection) throws SQLException {
        sql = "INSERT INTO `assignments_per_course`(`id_courses`, `id_assignments`) VALUES(?,?);";
        PreparedStatement stmt = myConnection.prepareStatement(sql);
        stmt.setInt(1,idCourses);
        stmt.setInt(2,idAssignments);
        
        int result = stmt.executeUpdate();
        System.out.println("Records inserted: " + result);
    }
    
}
