package DAO;

import java.sql.SQLException;
import java.util.List;

import logic.Student;

/**
 * @author Lena Korsak
 *
 */
public interface StudentDAO {
    public void addStudent(Student student) throws SQLException;   //add student
    public void updateStudent(Student student) throws SQLException;//update student
    public Student getStudentById(int id) throws SQLException;    //get student by id
    public List<Student> getAllStudents() throws SQLException;              //get all student
    public void deleteStudent(Student student) throws SQLException;//delete student
	public List<Student> selectUserByAge(int _age)throws SQLException;
}