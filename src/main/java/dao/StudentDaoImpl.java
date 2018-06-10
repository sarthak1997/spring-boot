package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Repository;

import model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	private Connection connection;
	private String query;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public List<Student> getTopStudents(Student theStudent,ServletContext context)
	{
		connection=(Connection)context.getAttribute("datacon");
		query="select * from student where age between ? and ? and city= ? order by marks desc limit 5";
		
		List<Student> topStudentList=new ArrayList<Student>();
		Student student=null;
		
		try {
			preparedStatement=connection.prepareStatement(query);
			
			if(theStudent.getAge()<=20)
			{
				preparedStatement.setInt(1,10);
				preparedStatement.setInt(2,20);
			}
			else if(theStudent.getAge()<=30)
			{
				preparedStatement.setInt(1,21);
				preparedStatement.setInt(2,30);
			}
			else if(theStudent.getAge()<=60)
			{
				preparedStatement.setInt(1,31);
				preparedStatement.setInt(2,60);
			}
			
			preparedStatement.setString(3,theStudent.getCity());
			
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				student=new Student();
				student.setName(resultSet.getString(1));
				student.setAge(resultSet.getInt(2));
				student.setMarks(resultSet.getInt(3));
				student.setCity(resultSet.getString(4));
				
				topStudentList.add(student);
			}
			
			return topStudentList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
