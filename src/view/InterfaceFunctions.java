package view;

import java.util.Scanner;

/**
 * Class containing user interface functions. ### menuSelection() = user input
 * decides what the program will do with the database. ||
 * 
 * emptyStringHandler() = Exception handler for empty user input strings ||
 * 
 * addNewPersonMessage() = Method with user interface for adding a new person to
 * the table people in DB
 */
public class InterfaceFunctions {

	Scanner scan = new Scanner(System.in);
	String fname, lname, rank, division, location, status, id;
	int userSelection = 0;
	boolean stringIsEmpty, rankCheckPass, divisionCheckPass;

	public InterfaceFunctions() {

	}

	/**
	 * Selection menu called in ConnectionFunctions. Allows user decide in which way
	 * to modify the database
	 */
	public void menuSelection() {
		/*
		 * to implement: separate menus for modifying (add/remove) and viewing
		 */
		System.out.println("What do you wish to do?\n 1) Add new personal file\n 2) Report new division\n "
				+ "3) Add new station/camp record");
		System.out.println(" 4) View enlisted (Rank, Last name and active division). \n 5) Show active divisions. \n "
				+ "6) Delete a person from the record.\n 7) Change location of a division posting.\n"
				+ " 8) Exit program.");
		userSelection = Integer.parseInt(scan.nextLine());

	}

	public void emptyStringHandler(String str) {
		if (str.equals("")) {
			stringIsEmpty = true;
			System.out.println("" + str + "Cannot Be Empty!!!");
		} else
			stringIsEmpty = false;
	}

	/**
	 * EXTRA
	 */

	public void correctRankCheck(String rank) {

		if (rank.equals("PVT") || rank.equals("PFC") || rank.equals("CPL") || rank.equals("SGT") || rank.equals("LT")
				|| rank.equals("CPT") || rank.equals("MAJ") || rank.equals("COL") || rank.equals("GEN")) {
			rankCheckPass = true;
		} else {
			rankCheckPass = false;
			System.out.println("Invalid rank!!!");
		}
	}

	/**
	 * Adds a new person to the record. Each field it asks for is nested in a
	 * do-while with a built in exception handler. It checks if the string is empty
	 * and sends a message if it is and repeats the method.
	 */
	public void addNewPersonMessage() {

		do {
			System.out.print("Please insert First Name: ");
			fname = scan.nextLine().trim();
			emptyStringHandler(fname);
		} while (stringIsEmpty == true);

		do {
			System.out.print("Please insert Last Name: ");
			lname = scan.nextLine().trim();
			emptyStringHandler(lname);
		} while (stringIsEmpty == true);

		do {
			System.out.print("Please enter Rank: ");
			rank = scan.nextLine().trim();
			emptyStringHandler(rank);
			correctRankCheck(rank);
		} while (stringIsEmpty == true || rankCheckPass == false);

		do {
			System.out.print("Please enter Division: ");
			division = scan.nextLine().trim();
			emptyStringHandler(division);
		} while (stringIsEmpty == true || divisionCheckPass == false);
	}

	/*
	 * Adds a new mil. division into the DB. Exact same function as
	 * addNewPersonMessage(), but information is stored into DB divisions instead
	 */
	public void addNewDivisionMessage() {
		// UI for adding new division to table
		do {
			System.out.print("Please insert name of NCRA Division name: ");
			division = scan.nextLine().trim();
			emptyStringHandler(division);
		} while (stringIsEmpty == true);

		do {
			System.out.print("Please enter location where division is stationed: ");
			location = scan.nextLine().trim();
			emptyStringHandler(location);
		} while (stringIsEmpty == true);
	}

	/**
	 * Adds a new location in which a division is stationed. Exact function as
	 * AddNewPersonMessage(), and information parsed is stored in DB stations.
	 */
	public void addNewStationMessage() {
		// UI for adding a new station
		do {
			System.out.print("Please enter name of station or camp: ");
			location = scan.nextLine().trim();
			emptyStringHandler(location);
		} while (stringIsEmpty == true);

		do {
			System.out.print("Enter status of station or camp (1 = Active/0 = Non-Active): ");
			status = scan.nextLine().trim();
			emptyStringHandler(status);
		} while (stringIsEmpty == true);
	}

	/**
	 * Deletes a row/enlisted person from the DB
	 * */
	public void deleteEnlistedPersonMessage() {
		do {
			System.out.print("Please enter unique ID of person to be deleted: ");
			id = scan.nextLine().trim();
			emptyStringHandler(id);
		} while (stringIsEmpty == true);
	}

	/**
	 * Change location of a division posting
	 * */
	public void changeDivisionStationMessage() {
		do {
			System.out.print("Enter ID of the division you wish to alter: ");
			division = scan.nextLine().trim();
			emptyStringHandler(division);
		} while (stringIsEmpty == true);

		do {
			System.out.print("Enter ID of new location where division is posted: ");
			location = scan.nextLine().trim();
			emptyStringHandler(location);
		} while (stringIsEmpty == true);
	}

	/*
	 * GETTERS AND SETTERS
	 */

	public int getUserSelection() {
		return userSelection;
	}

	public void setUserSelection(int userSelection) {
		this.userSelection = userSelection;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
