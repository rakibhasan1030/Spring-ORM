package com.spring.jdbc.springorm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/spring/jdbc/springorm/orm-config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
		
		Student student = new Student(001, "RAKIB HASAN", "SHYAMOLI, DHAKA");
		System.out.println("Row inserted : " + studentDao.insert(student));
	}
}
