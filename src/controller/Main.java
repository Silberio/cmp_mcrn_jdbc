package controller;
import java.sql.*;

import view.InterfaceFunctions;


/**
 * 
 * */
public class Main {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/cmp_mccarran";
		String user = "root";
		String password = "";

		ConnectionFunctions connection = ConnectionFunctions.getInstance();
		
		connection.connect(url, user, password);
	}

}
