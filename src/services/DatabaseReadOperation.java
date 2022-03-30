package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.Assignment;
import models.Course;
import models.Student;
import models.Trainer;

public class DatabaseReadOperation {
    
    public void selectAllFromAssignments(Connection connection, String sql) throws SQLException  {
        Statement statement = connection.createStatement(); 
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Assignment assignment = new Assignment(resultSet.getInt("id_assignments"), resultSet.getString("title"), resultSet.getString("description"), resultSet.getTimestamp("submition_date_time"));
            System.out.println(assignment);
        }
        resultSet.close();
        statement.close();
    }
    
    public void selectAllFromStudents(Connection connection, String sql) throws SQLException  {
        Statement statement = connection.createStatement(); 
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Student student = new Student(resultSet.getInt("id_students"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getTimestamp("date_of_birth"), resultSet.getDouble("tuition_fees"));
            System.out.println(student);
        }
        resultSet.close();
        statement.close();
    }
    
    public void selectAllFromCourses(Connection connection, String sql) throws SQLException  {
        Statement statement = connection.createStatement(); 
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Course course = new Course(resultSet.getInt("id_courses"), resultSet.getString("title"), resultSet.getString("stream"), resultSet.getString("type"), resultSet.getDate("start_date"), resultSet.getDate("end_date"));
            System.out.println(course);
        }
        resultSet.close();
        statement.close();
    }
    
    public void selectAllFromTrainers(Connection connection, String sql) throws SQLException  {
        Statement statement = connection.createStatement(); 
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Trainer trainer = new Trainer(resultSet.getInt("id_trainers"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("subject"));
            System.out.println(trainer);
        }
        resultSet.close();
        statement.close();
    }
    
    public void selectStudentsPerCourse(Connection connection, String sql) throws SQLException  {
        Statement statement = connection.createStatement(); 
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
        Course course = new Course(resultSet.getString("title"), resultSet.getString("type"));
        Student student = new Student(resultSet.getString("first_name"), resultSet.getString("last_name"));
        System.out.println(course.toStringForTitleType() + " " + student.toStringForFirstNameLastName());
        }
        resultSet.close();
        statement.close();
    }
    
    public void selectTrainersPerCourse(Connection connection, String sql) throws SQLException  {
        Statement statement = connection.createStatement(); 
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
        Course course = new Course(resultSet.getString("title"), resultSet.getString("type"));
        Trainer trainer = new Trainer(resultSet.getString("first_name"), resultSet.getString("last_name"));
        System.out.println(course.toStringForTitleType() + " " + trainer.toStringForFirstNameLastName());
        }
        resultSet.close();
        statement.close();
    }
    
    public void selectAssignmentsPerCourse(Connection connection, String sql) throws SQLException  {
        Statement statement = connection.createStatement(); 
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
        Course course = new Course(resultSet.getString("courses.title"), resultSet.getString("type"));
        Assignment assignment = new Assignment(resultSet.getString("assignments.title"));
        System.out.println(course.toStringForTitleType() + " " + assignment.toStringForTitle());
        }
        resultSet.close();
        statement.close();
    }
    
    public void selectAssignmentsPerCoursePerStudent(Connection connection, String sql) throws SQLException  {
        Statement statement = connection.createStatement(); 
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
        Course course = new Course(resultSet.getString("courses.title"), resultSet.getString("type"));
        Student student = new Student(resultSet.getString("first_name"), resultSet.getString("last_name"));
        Assignment assignment = new Assignment(resultSet.getString("assignments.title"));
        System.out.println(course.toStringForTitleType() + " " + student.toStringForFirstNameLastName()+ " " + assignment.toStringForTitle());
        }
        resultSet.close();
        statement.close();
    }
    
    public void selectStudentsWithMoreThanOneCourses(Connection connection, String sql) throws SQLException  {
        Statement statement = connection.createStatement(); 
        ResultSet resultSet = statement.executeQuery(sql);
        int numberOfCourses = 0;
        while (resultSet.next()) {
        numberOfCourses = resultSet.getInt("number_of_courses");
        Student student = new Student(resultSet.getString("first_name"), resultSet.getString("last_name"));
        
        System.out.println(student.toStringForFirstNameLastName()+ " Number of courses: " + numberOfCourses);
        }
        resultSet.close();
        statement.close();
    }
    
}
