package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import view.InterfaceFunctions;

/**
 * Connection creation class. Singleton. Creates a connection object to be used
 * when manipulating database. It creates a single instance. Still haven't
 * decided
 */
public class ConnectionFunctions {

	private static ConnectionFunctions connections = new ConnectionFunctions();

	private ModFunctions modFunc = new ModFunctions();
	private InterfaceFunctions ui = new InterfaceFunctions();

	private ConnectionFunctions() {

	}

	public static ConnectionFunctions getInstance() {
		return connections;
	}

	public void connect(String url, String user, String password) {
		try {
			// Establish connection
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connection OK!");
			// create statement

			ui.menuSelection();
			switch (ui.getUserSelection()) {
			case 1:
				ui.addNewPersonMessage();
				modFunc.addNewPerson(ui.getFname(), ui.getLname(), ui.getRank(), ui.getDivision(), connection);
				break;
			case 2:
				ui.addNewDivisionMessage();
				modFunc.addNewDivision(ui.getDivision(), ui.getLocation(), connection);
				break;
			case 3:
				ui.addNewStationMessage();
				modFunc.addNewStationLocation(ui.getLocation(), ui.getStatus(), connection);
				break;
			case 4:
				modFunc.selectEnlistedFromTable(connection);
				break;
			case 5:
				modFunc.selectDivisionsFromTable(connection);
				break;
			case 6:
				ui.deleteEnlistedPersonMessage();
				modFunc.deleteRowFromEnlisted(connection, ui.getId());
				break;
			case 7:
				ui.changeDivisionStationMessage();
				modFunc.changeDivisionStation(connection, ui.getDivision(), ui.getLocation());
				break;
			case 8:
				System.exit(0);
				break;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}