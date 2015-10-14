package logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Lena Korsak
 *
 */
@Entity
@Table(name="Test")
public class Test {
	
	private int tid;	
	private String tname;	
	private Student stud;
	
	public Test(){
		tname = null;
	}
	
	public Test(Test s){
		tname = s.getTName();
	}
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
    @Column(name="tid")
	public int getTid() {
		return tid;
	}
	
	@Column(name="tname")
	public String getTName(){
		return tname;
	}
	
	@ManyToOne
	@JoinTable(name = "Statistics", joinColumns = @JoinColumn(name = "tid"), inverseJoinColumns = @JoinColumn(name = "id"))
	public Student getStud(){
		return stud;
	}
	
	public void setId(int i){
		tid = i;		
	}
	
	public void setTName(String s){
		tname = s;
	}		
	
	
}
