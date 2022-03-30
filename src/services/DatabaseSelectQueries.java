package services;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseSelectQueries {
    private String sql;
    
    public void selectAllFromAssignmentsQuery(DatabaseReadOperation dbOp, Connection myConnection) throws SQLException {
        sql = "SELECT * FROM `assignments`;";
        dbOp.selectAllFromAssignments(myConnection, sql);
    }
    
    public void selectAllFromStudentsQuery(DatabaseReadOperation dbOp, Connection myConnection) throws SQLException {
        sql = "SELECT * FROM `students`;";
        dbOp.selectAllFromStudents(myConnection, sql);
    }
    
    public void selectAllFromCoursesQuery(DatabaseReadOperation dbOp, Connection myConnection) throws SQLException {
        sql = "SELECT * FROM `courses`;";
        dbOp.selectAllFromCourses(myConnection, sql);
    }
    
    public void selectAllFromTrainersQuery(DatabaseReadOperation dbOp, Connection myConnection) throws SQLException {
        sql = "SELECT * FROM `trainers`;";
        dbOp.selectAllFromTrainers(myConnection, sql);
    }
    
    public void selectStudentsPerCourseQuery(DatabaseReadOperation dbOp, Connection myConnection) throws SQLException {
        sql = "select title,type,first_name,last_name from courses "
            + "inner join students_per_course on courses.id_courses = students_per_course.id_courses "
            + "inner join students on students.id_students = students_per_course.id_students order by courses.id_courses;";

        dbOp.selectStudentsPerCourse(myConnection, sql);
    }
    
    public void selectTrainersPerCourseQuery(DatabaseReadOperation dbOp, Connection myConnection) throws SQLException {
        sql = "select title,type,first_name,last_name from courses "
            + "inner join trainers_per_course on courses.id_courses = trainers_per_course.id_courses inner join trainers "
            + "on trainers_per_course.id_trainers = trainers.id_trainers "
            + "order by courses.id_courses;";
        dbOp.selectTrainersPerCourse(myConnection, sql);
    }
    
    public void selectAssignmentsPerCourseQuery(DatabaseReadOperation dbOp, Connection myConnection) throws SQLException {
        sql = "select distinct courses.title,type,assignments.title from courses "
            + "inner join assignments_per_course using (id_courses) inner join assignments "
            + "using (id_assignments) order by courses.id_courses, assignments.id_assignments;";
        dbOp.selectAssignmentsPerCourse(myConnection, sql);
    }
    
    public void selectAssignmentsPerCoursePerStudentQuery(DatabaseReadOperation dbOp, Connection myConnection) throws SQLException {
       sql = "select courses.title,type,first_name,last_name,assignments.title from assignments "
            + "inner join assignments_per_course using(id_assignments) "
            + "inner join courses using(id_courses) "
            + "inner join students_per_course using(id_courses) "
            + "inner join students using(id_students) "
            + "order by courses.id_courses, students.id_students, assignments.id_assignments;";
        dbOp.selectAssignmentsPerCoursePerStudent(myConnection, sql); 
    }
    
    public void selectStudentsWithMoreThanOneCoursesQuery(DatabaseReadOperation dbOp, Connection myConnection) throws SQLException {
        sql = "select first_name,last_name,count(id_courses) as number_of_courses "
            + "from students inner join students_per_course using (id_students) "
            + "inner join courses using (id_courses) "
            + "group by students.id_students "
            + "having number_of_courses > 1 "
            + "order by number_of_courses;";
        dbOp.selectStudentsWithMoreThanOneCourses(myConnection, sql);
    }


    

    

    

    

    
    
}
