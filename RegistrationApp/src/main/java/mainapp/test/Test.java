package mainapp.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import mainapp.config.SpringHibConfig;
import mainapp.entities.StudentRecord;
import mainapp.services.StudentService;
import mainapp.services.StudentServiceImpl;


public class Test {

	public static void main(String[] args) {
		
		
		// Check if hibernate working with MySQL DB. 
		// checked -> it is working fine
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringHibConfig.class);
		
		StudentService ss = ctx.getBean(StudentServiceImpl.class);

//		
//		List<StudentRecord> list = ss.getAllStudents();
//		if(list==null) {
//			System.out.println("No records in DB.");
//		}else {
//			for(StudentRecord sr: list) {
//				System.out.println(sr);
//			}
//		}
//		
//		
		
//		ss.saveStudent(new StudentRecord("xyx","test","abc"));
//		
//		StudentRecord student = ss.getStudentById(4);
//		System.out.println("\nGot the student by Id:\n"+student);
		
		
		
		
		
//		ss.deleteStudentById(1);
		

	}

}
