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
		
	/**
	 * Getter Stid
	 * @return stid - ID from table Statistics
	 */
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="stid")
	public int getStid(){
		return stid;
	}
	
	/**Get id
	 * @return id - fk student from table Statistics
	 */
	@Column(name="id")
	public int getId(){
		return id;
	}
	
	/**Get Tid
	 * @return tid - fk Test from table Statistics 
	 */
	@Column(name="tid")
	public int getTid(){
		return tid;
	}
}
