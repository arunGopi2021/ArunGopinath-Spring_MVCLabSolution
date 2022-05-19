package mainapp.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import mainapp.entities.StudentRecord;



@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = {"mainapp.services"})
public class SpringHibConfig {
	
	@Bean
	public SessionFactory getHibernateSessionFactory() {
		
		Configuration connection = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(StudentRecord.class);
		
		return connection.buildSessionFactory();
	}

}
