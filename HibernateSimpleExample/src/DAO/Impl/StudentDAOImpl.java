package DAO.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import util.HibernateUtil;
import DAO.StudentDAO;
import logic.Student;

/**
 * @author Lena Korsak
 *
 */
public class StudentDAOImpl implements StudentDAO {

	/**
	 * Addition student to database
	 * 
	 * @see DAO.StudentDAO#addStudent(logic.Student)
	 * @param stud - student
	 * @throws SQLException
	 */
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

	/**
	 * update student in the database
	 * 
	 * @see DAO.StudentDAO#updateStudent(logic.Student)
	 * @param stud - student
	 * @throws SQLException
	 */
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

	/**
	 * Get student by id
	 * 
	 * @see DAO.StudentDAO#getStudentById(int)
	 * @param id - student's id
	 * @return student by id
	 * @throws SQLException
	 */
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

	/**
	 * Get list all students
	 * 
	 * @see DAO.StudentDAO#getAllStudents()
	 * @throws SQLException
	 * @return studs - student's list
	 */
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

	/**
	 * delete student in the database
	 * 
	 * @see DAO.StudentDAO#deleteStudent(logic.Student)
	 * @param stud - student
	 * @throws SQLException
	 */
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

	/**
	 * Gel list students by age = @param age
	 * 
	 * @see DAO.StudentDAO#selectUserByAge(int)
	 * @param age - age of student
	 * @return student's list by age
	 * @throws SQLException
	 */
	@SuppressWarnings("deprecation")
	public List<Student> selectUserByAge(int _age) throws SQLException {
		Session session = null;
		List<Student> studs = new ArrayList<Student>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			studs = session.createCriteria(Student.class).add(Expression.eq("age", _age)).list();

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

	/** Get list students by name%
	 * @see DAO.StudentDAO#selectUSerByName(java.lang.String)
	 * @param _name - student's name
	 * @return student's list by name%
	 * @throws SQLException
	 */
	public List<Student> selectUSerByName(String _name) throws SQLException {
		Session session = null;
		List<Student> studs = new ArrayList<Student>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			studs = session.createCriteria(Student.class).add(Expression.like("name", "" + _name + "%")).list();
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
	
	/**
	 * Get student's list by name through SQLQuery
	 * @return list with students
	 * @param _name - student's name
	 */
	public List<Student> selectSQLExecute(String _name){
		List<Student> studs = new ArrayList<Student>();
		Session session = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();	
			Query query = session.createSQLQuery("select * from Student where name like ?").addEntity(Student.class);
			studs = query.setString(0, _name + "%").list();
		}catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e.getMessage(), "������ I/O", JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return studs;
	}
	
	 /**Probably, delete all students
	 * @see DAO.StudentDAO#testFunc()
	 * @return studs - student's list
	 */
	public List<Student> testFunc(){
		  Session session = null;
		    List<Student> studs = new ArrayList<Student>();
		    try {
		    	session = HibernateUtil.getSessionFactory().openSession();
		    	Criteria crit = session.createCriteria(Student.class);
		    	crit.setMaxResults(50);
		    	studs = crit.list();
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, e.getMessage(), "������ I/O", JOptionPane.OK_OPTION);
		    } finally {
		    	if (session != null && session.isOpen()) {
		    		session.close();
		    	}
		    }
		    return studs;		  
	  }
	
}