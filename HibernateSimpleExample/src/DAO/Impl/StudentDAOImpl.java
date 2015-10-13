package DAO.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import util.HibernateUtil;
import DAO.StudentDAO;
import logic.Student;

public class StudentDAOImpl implements StudentDAO {

	public void addStudent(Student stud) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(stud);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e.getMessage(), "������ I/O", JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public void updateStudent(Student stud) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(stud);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e.getMessage(), "������ I/O", JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public Student getStudentById(int id) throws SQLException {
		Session session = null;
		Student stud = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			stud = (Student) session.load(Student.class, id);
			System.out.println("In UPDATE! id = " + stud.getId() + " name = " + stud.getName());
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e.getMessage(), "������ I/O", JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return stud;
	}

	public List<Student> getAllStudents() throws SQLException {
		Session session = null;
		List<Student> studs = new ArrayList<Student>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			studs = session.createCriteria(Student.class).list();
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e.getMessage(), "������ I/O", JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return studs;
	}

	public void deleteStudent(Student stud) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(stud);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e.getMessage(), "������ I/O", JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@SuppressWarnings("deprecation")
	public List<Student> selectUserByAge(int _age) throws SQLException {
		Session session = null;
		List studs = new ArrayList<Student>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria crit = session.createCriteria(Student.class); // �������
																	// ��������
																	// �������
			//studs = session.createCriteria(Student.class).add(Expression.like("name", "Ivanov%"))
				//	.add(Expression.between("age", 18, 25)).list();

			studs = session.createCriteria(Student.class).add(Expression.eq("age", _age)).list();
			
			//studs = session.createCriteria(Student.class).add(Expression.like("name", "_van%"))
			//		.add(Expression.or(Expression.eq("age", new Integer(20)), Expression.isNull("age"))).list();
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e.getMessage(), "������ I/O", JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return studs;
	}
}