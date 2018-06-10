package dao;

import java.util.List;

import javax.servlet.ServletContext;

import model.Student;

public interface StudentDao {
	
	public List<Student> getTopStudents(Student theStudent, ServletContext context);
	

}
