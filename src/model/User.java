package model;

/**
 * The class is a model for the database table 'user'
 * 
 * @author Akshai Prabhu
 * @author Ketki Trimukhe
 * @author Vishal Dsouza
 */
public class User {

	/**
	 * Data members
	 */
	private int userid;
	private String firstName;
	private String lastName;

	/**
	 * Member methods
	 * 
	 */
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
