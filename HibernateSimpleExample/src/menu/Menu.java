package menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO.Factory;
import logic.Student;

/**
 * @author Lena Korsak
 *
 */
public class Menu {
	private static Scanner in = new Scanner(System.in);

	/**
	 * show menu
	 */
	public static void showMenu() {
		while (true) {
			try {
				System.out.println("Enter the command, please: ");
				System.out.println("1 - Add student");
				System.out.println("2 - Delete student");
				System.out.println("3 - Update student");
				System.out.println("4 - Show student by age");
				System.out.println("5 - Show all student");
				System.out.println("6 - Show student by name");
				System.out.println("7 - Show student by name through sql execute");
				System.out.println("8 - exit");
				int search = Integer.parseInt(in.next());
				switch (search) {
				case 1:
					addStudent();
					break;
				case 2:
					showAllStudent();
					delStudent();
					break;
				case 3:
					showAllStudent();
					updateStudent();
					break;
				case 4:
					selectByAge();
					break;
				case 5:
					showAllStudent();
					break;
				case 6:
					selectByName(6);
					break;
				case 7:
					selectByName(7);
					break;
				case 8:
					System.exit(0);
					break;
				}
			} catch (Exception e) {
				System.out.println("You entered not a number!\n Enter the command, please.");
			}
		}
	}

	/**
	 * addition student to database
	 */
	private static void addStudent() {
		System.out.print("Enter student's name: ");
		String name = in.next();
		System.out.print("Enter age of student: ");
		int age = Integer.parseInt(in.next());
		Student student = new Student(name, age);
		try {
			Factory.getInstance().getStudentDAO().addStudent(student);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	/**
	 * show all student
	 */
	private static void showAllStudent() {
		try {
			List<Student> students = Factory.getInstance().getStudentDAO().getAllStudents();
			System.out.println("--------All students-----------");
			for (int i = 0; i < students.size(); i++) {
				System.out.println("ID : " + students.get(i).getId() + ", Name : " + students.get(i).getName()
						+ ", age : " + students.get(i).getAge());
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	/**
	 * delete student in the database
	 */
	private static void delStudent() {
		try {
			System.out.println("Ender ID removed student");
			int id = Integer.parseInt(in.next());
			Student sdel = Factory.getInstance().getStudentDAO().getStudentById(id);
			Factory.getInstance().getStudentDAO().deleteStudent(sdel);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	/**
	 * edit student in the database
	 */
	private static void updateStudent() {
		try {
			System.out.println("Ender ID edited student");
			int id = Integer.parseInt(in.next());
			Student std = Factory.getInstance().getStudentDAO().getStudentById(id);
			System.out.print("Enter student's name: ");
			std.setName(in.next());
			System.out.print("Enter age of student: ");
			std.setAge(Integer.parseInt(in.next()));
			Factory.getInstance().getStudentDAO().updateStudent(std);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	/**
	 * get list student by age
	 */
	private static void selectByAge() {
		try {
			System.out.print("Enter age of student: ");
			List<Student> students = Factory.getInstance().getStudentDAO().selectUserByAge(Integer.parseInt(in.next()));
			for (int i = 0; i < students.size(); i++) {
				System.out.println("ID : " + students.get(i).getId() + ", Name : " + students.get(i).getName()
						+ ", age : " + students.get(i).getAge());
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	private static void selectByName(int val) {
		try {
			System.out.print("Enter name of student: ");
			String str = in.next();
			List<Student> students = new ArrayList<Student>();
			if (val == 6) {
				students = Factory.getInstance().getStudentDAO().selectUSerByName(str);
			} else if (val == 7) {
				students = Factory.getInstance().getStudentDAO().selectSQLExecute(str);
			}
			for (int i = 0; i < students.size(); i++) {
				System.out.println("ID : " + students.get(i).getId() + ", Name : " + students.get(i).getName()
						+ ", age : " + students.get(i).getAge());
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
