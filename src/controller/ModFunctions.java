package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Division;
import model.Person;
import model.Station;

/**
 * Contains functions for modifying the tables. Adding, remove, modify and show
 * data
 */
public class ModFunctions {
	private Person person = new Person();
	private Division division = new Division();
	private Station station = new Station();
	private String query;

	public ModFunctions() {

	}

	/*** Add new person to database */
	public void addNewPerson(String fname, String lname, String rank, String division, Connection cn) {
		person.setFname(fname);
		person.setLname(lname);
		person.setRank(rank);
		person.setDivision(division);

		addPersonToTable(cn);
	}

	/**
	 * Takes in first name, last name, rank and division and sends a MySQL query
	 * into the database, updating the table with newly added values.
	 */
	private void addPersonToTable(Connection cn) {
		// Create statement
		PreparedStatement statement = null;
		query = "INSERT INTO enlisted (ppl_fname, ppl_lname, ppl_rank, ppl_division) VALUES (?, ?, ? , ?)";

		try {
			cn.setAutoCommit(false);
			// CREATE STATEMENT INSERT
			statement = cn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			// set query parameters
			statement.setString(1, person.getFname());
			statement.setString(2, person.getLname());
			statement.setString(3, person.getRank());
			statement.setString(4, person.getDivision());
			// execute query
			statement.executeUpdate();

			cn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Add a new division to the table 'divisions'. WARNING: check official NCR
	 * records to avoid duplicates, frauds or non existent records. Paper divisions
	 * may be added with proper clearance and official
	 */
	public void addNewDivision(String divisionName, String stationLocationName, Connection cn) {
		division.setDivisionName(divisionName);
		division.setStationLocationName(stationLocationName);

		addDivisionToTable(cn);
	}

	/** Add a new division to divisions table on DB */
	private void addDivisionToTable(Connection cn) {
		// create statement
		PreparedStatement statement = null;
		// create query
		query = "INSERT INTO divisions (div_name) VALUES (?)";

		try {
			cn.setAutoCommit(false);
			// Statement insert
			statement = cn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			// parameters
			statement.setString(1, division.getDivisionName());
			// exec query
			statement.executeUpdate();

			cn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Adds a new location in which divisions are stationed
	 */
	public void addNewStationLocation(String stationlocationName, String status, Connection cn) {
		station.setStation(stationlocationName);
		station.setStatus(Integer.parseInt(status));

		addStationToTable(cn);
	}

	private void addStationToTable(Connection cn) {
		// create statement
		PreparedStatement statement = null;
		// create query
		query = "INSERT INTO stations (stn_name, stn_status) VALUES (?, ?)";

		try {
			cn.setAutoCommit(false);
			// Statement insert
			statement = cn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			// parameters
			statement.setString(1, station.getStation());
			statement.setInt(2, station.getStatus());
			// exec query
			statement.executeUpdate();

			cn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Selects all elements from table 'enlisted' and displays them on console
	 */
	public void selectAllFromTable(Connection cn, String columnName) {
		// create statement and resultSet
		Statement statement = null;
		ResultSet rs = null;
		// crete query
		query = "SELECT * FROM enlisted";

		try {
			cn.setAutoCommit(false);

			statement = cn.createStatement();
			rs = statement.executeQuery(query);

			while (rs.next()) {
				System.out.println(rs.getString(columnName));
			}
			cn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Displays all elements from table enlisted in DB with attributes rank, lname
	 * and from divisions, div_name
	 */
	public void selectEnlistedFromTable(Connection cn) {
		// create statement and resultSet
		Statement statement = null;
		ResultSet rs = null;
		// crete query
		query = "SELECT enlisted.ppl_rank, enlisted.ppl_lname, divisions.div_name FROM enlisted INNER JOIN divisions ON enlisted.ppl_division=divisions.div_PK";

		try {
			cn.setAutoCommit(false);

			statement = cn.createStatement();
			rs = statement.executeQuery(query);

			while (rs.next()) {
				System.out.println(
						rs.getString("ppl_rank") + " " + rs.getString("ppl_lname") + ", " + rs.getString("div_name"));
				System.out.println("--------------------");
			}
			cn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public void selectDivisionsFromTable(Connection cn) {
		// create statement and resultSet
		Statement statement = null;
		ResultSet rs = null;
		// crete query
		query = "SELECT divisions.div_name, stations.stn_name, stations.stn_status FROM divisions, stations WHERE divisions.div_location = stations.stn_PK";

		try {
			cn.setAutoCommit(false);
			statement = cn.createStatement();
			rs = statement.executeQuery(query);

			while (rs.next()) {
				System.out.print(rs.getString("div_name") + " stationed in " + rs.getString("stn_name") + " - ");
				if(rs.getString("stn_status").equals("1")) {
					System.out.println("Active");
				}
				System.out.println("--------------------");
			}

			cn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteRowFromEnlisted(Connection cn, String id) {
		// statement
		PreparedStatement statement = null;
		query = "DELETE FROM enlisted WHERE ppl_PK=?";

		try {
			cn.setAutoCommit(false);

			// Statement insert
			statement = cn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			// parameters
			statement.setString(1, id);
			// exec query
			statement.executeUpdate();

			cn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void changeDivisionStation(Connection cn, String division, String location) {

		PreparedStatement statement = null;
		query = "UPDATE divisions SET div_location = ? WHERE div_PK = ?";

		try {
			cn.setAutoCommit(false);

			// statement insert
			statement = cn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			// param
			statement.setInt(1, Integer.parseInt(location)); // the new value we want to insert
			statement.setInt(2, Integer.parseInt(division)); // which row we want to change
			// exec query
			statement.executeUpdate();

			cn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
