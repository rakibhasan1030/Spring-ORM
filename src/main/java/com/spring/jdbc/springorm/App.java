package com.spring.jdbc.springorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/spring/jdbc/springorm/orm-config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		// Student student = new Student(001, "RAKIB HASAN", "SHYAMOLI, DHAKA");
		// System.out.println("Row inserted : " + studentDao.insert(student));

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("\t\t\t - * - * - WELCOME TO SPRING ORM PROJECT - * - * - \t\t\t\n\n");

		boolean runLoop = true;
		while (runLoop) {
			System.out.println("\t\t\t\t1. Add a new student");
			System.out.println("\t\t\t\t2. See all students");
			System.out.println("\t\t\t\t3. See specific student details");
			System.out.println("\t\t\t\t4. Delete a student");
			System.out.println("\t\t\t\t5. Update a student");
			System.out.println("\t\t\t\t0. EXIT");

			try {
				System.out.println("\n\nPlease, enter your choice : ");
				int userInput = Integer.parseInt(bufferedReader.readLine());
				switch (userInput) {
				case 1:
					System.out.println("Insert sudent id:");
					int studentId = Integer.parseInt(bufferedReader.readLine());
					System.out.println("Insert sudent name:");
					String studentName = bufferedReader.readLine();
					System.out.println("Insert sudent address:");
					String studentAddress = bufferedReader.readLine();
					int res = studentDao.insert(new Student(studentId, studentName, studentAddress));
					if (res == studentId) {
						System.out.println("Student added successfully!\n\n");
					} else {
						System.out.println("Something is wrong, please try again!\n\n");
					}
					System.out.println("\n - - - - - - - - - - - - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - - \n");
					break;

				case 2:
					List<Student> students = studentDao.getAllStudent();
					System.out.println("\n\nHere is the information of all students:\n");
					for (Student student : students) {
						System.out.println("Student ID: " + student.getStudentId() + "\n" + "Student Name: "
								+ student.getStudentName() + "\n" + "Student Address: " + student.getStudentAddress()
								+ "\n");
					}
					System.out.println("\n - - - - - - - - - - - - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - - \n");
					break;

				case 3:
					System.out.println("Insert sudent id:");
					int id = Integer.parseInt(bufferedReader.readLine());
					Student student = studentDao.getStudent(id);
					System.out.println("\n\nThe information of the student with id = " + id + ":\n");
					System.out.println(
							"Student ID: " + student.getStudentId() + "\n" + "Student Name: " + student.getStudentName()
									+ "\n" + "Student Address: " + student.getStudentAddress() + "\n");
					System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n");
					break;

				case 4:
					System.out.println("Insert sudent id:");
					int deleteId = Integer.parseInt(bufferedReader.readLine());
					studentDao.deleteStudent(deleteId);
					System.out.println("\n\nThe student's information successtully deleted!\n");
					System.out.println("\n - - - - - - - - - - - - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - - \n");
					break;

				case 5:
					System.out.println("Insert sudent id:");
					int updateId = Integer.parseInt(bufferedReader.readLine());
					Student updateStudent = studentDao.getStudent(updateId);
					System.out.println(
							"\nChoose one -\n1. Change Name\n2. Change Address\n3. Change Both\nPlease, enter your choice - ");
					int choice = Integer.parseInt(bufferedReader.readLine());
					switch (choice) {
					case 1:
						System.out.println("Name? - ");
						String name = bufferedReader.readLine();
						studentDao.updateStudent(
								new Student(updateStudent.getStudentId(), name, updateStudent.getStudentAddress()));
						System.out.println("\n\nThe student's information successtully updated!\n");
						break;

					case 2:
						System.out.println("Address? - ");
						String address = bufferedReader.readLine();
						studentDao.updateStudent(
								new Student(updateStudent.getStudentId(), updateStudent.getStudentName(), address));
						System.out.println("\n\nThe student's information successtully updated!\n");
						break;

					case 3:
						System.out.println("Name? - ");
						String inputName = bufferedReader.readLine();
						System.out.println("Address? - ");
						String inputAddress = bufferedReader.readLine();
						studentDao.updateStudent(new Student(updateStudent.getStudentId(), inputName, inputAddress));
						System.out.println("\n\nThe student's information successtully updated!\n");
						break;
					default:
						break;
					}

					System.out.println("\n - - - - - - - - - - - - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - - \n");
					break;

				case 0:
					runLoop = false;
					break;

				default:
					break;
				}

			} catch (Exception e) {
				System.out.println("Invalid input, try another one!\\n\\n");
			}
		}

		System.out.println("\n\nThank you for using this application, See yaa!!!\n\n");

	}

}
