package DAO;

import DAO.Impl.StudentDAOImpl;

/**
 * @author Lena Korsak
 *
 */
public class Factory {
      
      private static StudentDAO studentDAO = null;
      private static TestDAO testDAO = null;
      private static Factory instance = null;

      /**Get instance
     * @return instance - Factory's object
     */
    public static synchronized Factory getInstance(){
            if (instance == null){
              instance = new Factory();
            }
            return instance;
      }

      /**Get SrudentDAO
     * @return studentDAO - StudentDAO's object
     */
    public StudentDAO getStudentDAO(){
            if (studentDAO == null){
              studentDAO = new StudentDAOImpl();
            }
            return studentDAO;
      }   
      
      /**Get TestDAO
     * @return testDAO - TestDAO's object
     */
    public TestDAO getTestDAO(){
		    if (studentDAO == null){
		      studentDAO = new StudentDAOImpl();
		    }
		    return testDAO;
	  }	  
}