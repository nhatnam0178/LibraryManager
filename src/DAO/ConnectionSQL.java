package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class ConnectionSQL {
	private String url = "jdbc:sqlserver://localhost:1435;databaseName=LibraryManager;user=sa;password=123456";;
	public Connection conn;

	public void Connect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet Query(String strQuery) {
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(strQuery);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public ResultSet Query(String str, String[] params) {
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(str);
			for (int i = 0; i < params.length; i++) {
				stmt.setString(i + 1, params[i]);

			}
			ResultSet rs = stmt.executeQuery();
			return rs;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
}
