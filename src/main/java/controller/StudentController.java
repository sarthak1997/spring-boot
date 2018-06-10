package controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletContextAware;

import model.Student;
import service.StudentService;

@Controller
public class StudentController implements ServletContextAware {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ServletContext context;

	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel)
	{
		System.out.println("inside show form");
		Student theStudent=new Student();
		theModel.addAttribute("student",theStudent);
		return "studentForm";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent,Model theModel)
	{
		List<Student> topStudentList=studentService.getTopStudents(theStudent,context);
		theModel.addAttribute("topStudents",topStudentList);
		theModel.addAttribute("city",theStudent.getCity());
		//theModel.addAttribute("agegroup", theStudent.getAge());
		
		return "showStudents";
	}

	public void setServletContext(ServletContext arg0) {
		this.context=arg0;
	}
}
