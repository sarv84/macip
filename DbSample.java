package com.test.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

public class DbSample {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	// Insert Database

	public void insertDataBase() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/tld?"
					+ "user=root&password=root");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query

			StringBuffer sb = new StringBuffer();
			sb.append("INSERT INTO tutorials_tbl");
			sb.append("(");
			sb.append("tutorial_title");
			sb.append(",");
			sb.append("tutorial_author");
			sb.append(",");
			sb.append("submission_date");
			sb.append(")");
			sb.append("VALUES");
			sb.append("(");
			sb.append("Learn PHP in 25 minutes");
			sb.append(",");
			sb.append("C D SARAVANAN");
			sb.append(",");
			sb.append("26/8/2016");
			sb.append(";");

			boolean resultSet = statement.execute((sb.toString()));

			System.out.println("Inserted" + resultSet);

			// System.out.println("ROWSUPDATED" + rowsUpdated);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Update Database
	public void updateDataBase() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/tld?"
					+ "user=root&password=root");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			int rowsUpdated = statement
					.executeUpdate("UPDATE  tutorials_tbl SET  tutorial_author= 'CDSaravanan' where tutorial_title='Learn PHP';");

			System.out.println("ROWSUPDATED" + rowsUpdated);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Read

	public void readDataBase() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/tld?"
					+ "user=root&password=root");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select * from tutorials_tbl");

			while (resultSet.next()) {
				String tutorial_tile = resultSet.getString(1);
				String tutorial_author = resultSet.getString(2);
				Timestamp ts = resultSet.getTimestamp(3);

				System.out.println("Tutorial Title" + tutorial_tile);

				System.out.println("Tutorial Author" + tutorial_author);

				System.out.println("TimeStamp" + ts);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteDataBase() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			boolean resultSet;
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/tld?"
					+ "user=root&password=root");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement.execute("delete from tutorials_tbl;");

			System.out.println("Table Deleted" + resultSet);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) throws Exception {
		DbSample ds = new DbSample();
		ds.updateDataBase();
		ds.readDataBase();
		// ds.insertDataBase();
		ds.deleteDataBase();

	}
}
