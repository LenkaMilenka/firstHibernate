package DAO;

import java.sql.SQLException;
import java.util.List;

import logic.Test;

/**
 * @author Lena Korsak
 *
 */
public interface TestDAO {
	public void addTest(Test test) throws SQLException;		//addition test
	public void updateTest(Test test) throws SQLException;	//update test
	public Test getTestById(int t_id) throws SQLException;	//get test by id
	public List<Test> getAllTests() throws SQLException;			//get all test
	public void deleteTest(Test test) throws SQLException;	//delete test

}
