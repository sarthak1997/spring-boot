package service;
import java.util.List;

import javax.servlet.ServletContext;

import model.Student;

public interface StudentService {
	
	public List<Student> getTopStudents(Student theStudent,ServletContext context);

}
