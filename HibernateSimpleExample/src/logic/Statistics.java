package logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Statistics")
public class Statistics {	
	
	private int stid;	
	private int fk_id;	
	private int fk_tid;
		
	public Statistics(){		
	}
		
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="stid")
	public int getStid(){
		return stid;
	}
	
	@Column(name="fk_id")
	public int getId(){
		return fk_id;
	}
	
	@Column(name="fk_tid")
	public int getTid(){
		return fk_tid;
	}
}
