package DAO;

import java.sql.SQLException;
import java.util.List;

import logic.Test;

public interface TestDAO {
	public void addTest(Test test) throws SQLException;		//�������� ����
	public void updateTest(Test test) throws SQLException;	//�������� ����
	public Test getTestById(int t_id) throws SQLException;	//�������� ���� �� id
	public List<Test> getAllTests() throws SQLException;			//�������� ��� �����
	public void deleteTest(Test test) throws SQLException;	//������� ����

}
