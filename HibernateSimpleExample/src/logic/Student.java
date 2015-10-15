package logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Lena Korsak
 *
 */
@Entity
@Table(name="Student")
public class Student {
    
    private int id;    
    private String name;    
    private int age;
    
    /**
     * Setting null in the parameter name   
     */
    public Student(){
        name = null;
    }
    
    /**Constructor - Set s in the parameter name
     * @param s - student
     */
    public Student(Student s){
        name = s.getName();
    }   
    
    /**Constructor Student
     * @param _name - student's name
     * @param _age - age of student
     */
    public Student(String _name, int _age){
        name = _name;
        age = _age;
    }   
    
	/**Get Student's ID
	 * @return id - student's id
	 */
	@Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    public int getId() {
        return id;
    }
    
	/**Get student's name
	 * @return name - student's name
	 */
	@Column(name="name")
    public String getName(){
        return name;
    }
    
	/**Get age of student
	 * @return age - age of student
	 */
	@Column(name="age")
    public int getAge(){
        return age;
    }
    
    /**
     * Set i to column ID in the table Students
     * @param i - students ID
     */
    public void setId(int i){
        id = i;     
    }
    
    /**
     * Set s to column name in the table Students
     * @param s - student's name
     */
    public void setName(String s){
        name = s;
    }   
    
    /**Set l to column age in the table Students
     * @param l - age of student
     */
    public void setAge(int l){
        age = l;
    }       
    
}