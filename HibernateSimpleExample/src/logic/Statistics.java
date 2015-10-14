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
@Table(name="Statistics")
public class Statistics {	
	
	private int stid;	
	private int id;	
	private int tid;
		
	public Statistics(){		
	}
		
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="stid")
	public int getStid(){
		return stid;
	}
	
	@Column(name="id")
	public int getId(){
		return id;
	}
	
	@Column(name="tid")
	public int getTid(){
		return tid;
	}
}
