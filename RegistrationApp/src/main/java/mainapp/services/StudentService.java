package mainapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import mainapp.entities.StudentRecord;


@Service
public interface StudentService {

	//List all the customers
	public List<StudentRecord> getAllStudents();
	
	
	//Search by Id
	public StudentRecord getStudentById(int id);
	
	
	//Save or Update
	public Boolean saveStudent(StudentRecord student);
	
	
	//Delete
	public Boolean deleteStudentById(int id);
}
