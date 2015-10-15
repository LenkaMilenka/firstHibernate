package DAO.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;

import util.HibernateUtil;
import DAO.TestDAO;
import logic.Test;

/**
 * @author Lena Korsak
 *
 */
public class TestDAOImpl implements TestDAO {
		/** Addition test
		 * @see DAO.TestDAO#addTest(logic.Test)
		 * @param test - test
		 * @throws SQLException
		 */
		public void addTest(Test test) throws SQLException {
		    Session session = null;
		    try {
		    	session = HibernateUtil.getSessionFactory().openSession();
		    	session.beginTransaction();
		    	session.save(test);
		    	session.getTransaction().commit();
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
		    } finally {
		    	if (session != null && session.isOpen()) {
		    		session.close();
		    	}
		    }
	  }
	
	  /** Update test
	 * @see DAO.TestDAO#updateTest(logic.Test)
	 * @param test - test
	 * @throws SQLException
	 */
	public void updateTest(Test test) throws SQLException {
		    Session session = null;
		    try {
		    	session = HibernateUtil.getSessionFactory().openSession();
		    	session.beginTransaction();
		    	session.update(test);
		    	session.getTransaction().commit();
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
		    } finally {
		    	if (session != null && session.isOpen()) {
		    		session.close();
		    	}
		    }
	  }
	
	  /** Get test by id
	 * @see DAO.TestDAO#getTestById(int)
	 * @param id - test's id
	 * @throws SQLException
	 */
	public Test getTestById(int id) throws SQLException {
		    Session session = null;
		    Test test = null;
		    try {
		    	session = HibernateUtil.getSessionFactory().openSession();
		    	test = session.load(Test.class, id);
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
		    } finally {
		    	if (session != null && session.isOpen()) {
		    		session.close();
		    	}
		    }
		    return test;
	  }
	
	  /** Get All tests
	 * @see DAO.TestDAO#getAllTests()
	 * @return tests - list with test
	 * @throws SQLException
	 */
	public List<Test> getAllTests() throws SQLException {
		    Session session = null;
		    List<Test> tests = new ArrayList<Test>();
		    try {
		    	session = HibernateUtil.getSessionFactory().openSession();
		    	tests = session.createCriteria(Test.class).list();
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
		    } finally {
		    	if (session != null && session.isOpen()) {
		    		session.close();
		    	}
		    }
		    return tests;
	  }
	
	  /** Delete test
	 * @see DAO.TestDAO#deleteTest(logic.Test)
	 * @param test - deleted test
	 * @throws SQLException
	 */
	public void deleteTest(Test test) throws SQLException {
		    Session session = null;
		    try {
		    	session = HibernateUtil.getSessionFactory().openSession();
		    	session.beginTransaction();
		    	session.delete(test);
		    	session.getTransaction().commit();
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
		    } finally {
		    	if (session != null && session.isOpen()) {
		    		session.close();
		    	}
		    }
	  }  
}
