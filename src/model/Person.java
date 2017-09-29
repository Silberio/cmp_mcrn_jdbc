package model;


public class Person {
	private String fname, lname, rank, division;
	
	/**
	 * Default constructor for Person object 
	 */
	public Person() {
		
	}
	
	/**
	 * Person object, overloaded constructor. Input first name, last name, rank and division
	 * 
	 */
	public Person(String fname, String lname, String rank, String division) {
		this.fname = fname;
		this.lname = lname;
		this.rank = rank;
		this.division = division;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}
	
	
}
