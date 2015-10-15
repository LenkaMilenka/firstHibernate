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
@Table(name = "Test")
public class Test {

	private int tid;
	private String tname;
	private Student stud;

	/**
	 * Constructor test
	 * Setting null to column tname
	 */
	public Test() {
		tname = null;
	}

	/**
	 * Constructor test
	 * Setting test to column tname in the table Test
	 * @param s - test's name
	 */
	public Test(Test s) {
		tname = s.getTName();
	}

	/**
	 * Getter test's ID
	 * @return tid - rest's id
	 */
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "tid")
	public int getTid() {
		return tid;
	}

	/**Getter test's name
	 * @return tname - test's name
	 */
	@Column(name = "tname")
	public String getTName() {
		return tname;
	}

	/**Getter student from test
	 * @return stud - student
	 */
	@ManyToOne
	@JoinTable(name = "Statistics", joinColumns = @JoinColumn(name = "tid") , inverseJoinColumns = @JoinColumn(name = "id") )
	public Student getStud() {
		return stud;
	}

	/**Setter test's id
	 * @param i set to column tid in the table Test
	 */
	public void setId(int i) {
		tid = i;
	}

	/**Setter test's name
	 * @param s set to column tname in the table Test
	 */
	public void setTName(String s) {
		tname = s;
	}

}
