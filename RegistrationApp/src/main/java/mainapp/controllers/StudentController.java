package mainapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mainapp.entities.StudentRecord;
import mainapp.services.StudentServiceImpl;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentServiceObj;
	
	@RequestMapping("/list")
	public String getAllStudents(Model model) {
		List<StudentRecord> students = studentServiceObj.getAllStudents();
		model.addAttribute("list", students);
		return "list-students";
	}
	
	
	@RequestMapping("/add")
	public String getAddForm(Model model) {
		StudentRecord studentRecord = new StudentRecord();
		model.addAttribute("student", studentRecord);
		return "addupdate-student-form";
	}
	
	
	@RequestMapping("/update")
	public String getUpdateForm(@RequestParam(name = "id") int id, Model model) {
		StudentRecord studentRecord = studentServiceObj.getStudentById(id);
		model.addAttribute("student", studentRecord);
		return "addupdate-student-form";
	}
	
	
	@RequestMapping("/save")
	public String saveStudentForm(@RequestParam(name = "name") String name, @RequestParam(name = "department") 
	String department, @RequestParam(name = "country") String country, @RequestParam(name="id") int id, Model model) {
		
		if(id==0) {
			StudentRecord student = new StudentRecord(name,department,country);
			studentServiceObj.saveStudent(student);
		}else{
			StudentRecord student = studentServiceObj.getStudentById(id);
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);
			studentServiceObj.saveStudent(student);
		}
		
		return "redirect:list";
	}
	
	
	@RequestMapping("/delete")
	public String deleteStudentById(@RequestParam(name="id") int id) {
		
		studentServiceObj.deleteStudentById(id);
		
		return "redirect:list";
	}
	
	
}
