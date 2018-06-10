package service;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.StudentDao;
import model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	public List<Student> getTopStudents(Student theStudent,ServletContext context) {
		return studentDao.getTopStudents(theStudent,context);
	}

}
