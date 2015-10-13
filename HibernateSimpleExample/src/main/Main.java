package main;

import java.sql.SQLException;
import java.util.List;

import logic.Student;

import DAO.Factory;

public class Main {
    
    public static void main(String[] args) throws SQLException {
       
    	
    	 System.out.println("--------All srudents-----------");
    	 List<Student> students = Factory.getInstance().getStudentDAO().getAllStudents();
         for(int i = 0; i < students.size(); i++){
         	System.out.println("ID : " + students.get(i).getId() + ", Name : " + students.get(i).getName() + 
         			", age : " + students.get(i).getAge());
         }
         
         Student stud = new Student("Ololosha", 17);
        Factory.getInstance().getStudentDAO().addStudent(stud);
        
        System.out.println("\n--------AAfter ADD-----------");
   	 	students = Factory.getInstance().getStudentDAO().getAllStudents();
        for(int i = 0; i < students.size(); i++){
        	System.out.println("ID : " + students.get(i).getId() + ", Name : " + students.get(i).getName() + 
        			", age : " + students.get(i).getAge());
        }
    	
        Student sup = Factory.getInstance().getStudentDAO().getStudentById(4);
        sup.setAge(22);
        sup.setName("Test!");
        Factory.getInstance().getStudentDAO().updateStudent(sup);
        
        System.out.println("\n--------After update-----------");
        students = Factory.getInstance().getStudentDAO().getAllStudents();
        for(int i = 0; i < students.size(); i++){
        	System.out.println("ID : " + students.get(i).getId() + ", Name : " + students.get(i).getName() + 
        			", age : " + students.get(i).getAge());
        }
        
        
       /* Student sdel = Factory.getInstance().getStudentDAO().getStudentById(3);
       // System.out.println("DEL id = " + sdel.getId() + ", name = " + sdel.getName());
        Factory.getInstance().getStudentDAO().deleteStudent(sdel);
        
        System.out.println("\n--------After delete-----------");        
        students = Factory.getInstance().getStudentDAO().getAllStudents();
        for(int i = 0; i < students.size(); i++){
        	System.out.println("ID : " + students.get(i).getId() + ", Name : " + students.get(i).getName() + 
        			", age : " + students.get(i).getAge());
        }*/
        
        System.out.println("\n--------After SELECT by age-----------");  
        students = Factory.getInstance().getStudentDAO().selectUserByAge(17);
        for(int i = 0; i < students.size(); i++){
        	System.out.println("ID : " + students.get(i).getId() + ", Name : " + students.get(i).getName() + 
        			", age : " + students.get(i).getAge());
        }
        
        
        
                
        //Сохраним их в бд, id будут сгенерированы автоматически
       // Factory.getInstance().getStudentDAO().addStudent(s1);
      //  Factory.getInstance().getStudentDAO().addStudent(s2);       
        
        //Выведем всех студентов из бд
       /* List<Student> studs = Factory.getInstance().getStudentDAO().getAllStudents();
        System.out.println("========Все студенты=========");
        for(int i = 0; i < studs.size(); ++i) {
                System.out.println("Имя студента : " + studs.get(i).getName() + ", Возраст : " + studs.get(i).getAge() +",  id : " + studs.get(i).getId());
                System.out.println("=============================");              
        }    */   
        
        System.exit(1);
    }
}