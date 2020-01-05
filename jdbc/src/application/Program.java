package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbException;

public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		insert();
//		delete();
//		transaction();
//		insertEmployee();
	}
	
	
	private static void insertEmployee() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conn = DB.getConnection();
			st = conn.prepareStatement("INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentID) "
					+ "VALUES "
					+ "(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
									//este parametro faz o metodo execute retornar um ResultSet
			
			
			st.setString(1,"Carl Purple");
			st.setString(2, "carl@gmail.com");
			// Date example
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
			st.setDouble(4, 3000.0);
			st.setInt(5, 4);

			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				rs = st.getGeneratedKeys();
				
				while(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done!: Id = " + id);
				}
				
				
			} else {
				System.out.println("no rows affected");
			}

		} catch (SQLException e) {
			System.out.println(e);
		} catch(ParseException eParse){
			eParse.printStackTrace();
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

	private static void transaction() {

		Connection conn = null;
		Statement st = null;

		try {
			conn = DB.getConnection();
			st = conn.createStatement();

			conn.setAutoCommit(false);

			int rowsAffected1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
			int rowsAffected2 = st.executeUpdate("UPDATE seller SET BaseSalary = 2220 WHERE DepartmentId = 2");

//			if(true) {
//				throw new DbException("fake error!");
//			}
			
			conn.commit();
			
			System.out.println("Rows1: " + rowsAffected1);
			System.out.println("Rows2: " + rowsAffected2);

		} catch (SQLException e) {

			try {
				conn.rollback();
				throw new DbException("Transaction rolled back! Caused By: " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
			}

		} finally {
			DB.closeConnection();
			DB.closeStatement(st);
		}

	}

	private static void insert() {

		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DB.getConnection();
			st = conn.prepareStatement("INSERT INTO department(Name) " + " VALUES (?)");

			st.setString(1, "DP1");

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("rows affected: " + rowsAffected);

			} else {
				System.out.println("error");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeConnection();
			DB.closeStatement(st);
		}

	}

	private static void delete() {

		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DB.getConnection();
			st = conn.prepareStatement("DELETE FROM department " + "WHERE Id = ?");
			st.setInt(1, 5);

			int rowsAffected = st.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("rows affected: " + rowsAffected);

			} else {
				System.out.println("error");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeConnection();
			DB.closeStatement(st);
		}

	}

	private static void update() {
		Connection conn = null;
		PreparedStatement st = null;

		try {

			conn = DB.getConnection();

			st = conn.prepareStatement(
					"UPDATE seller " + "SET BaseSalary = BaseSalary + ? " + "WHERE (DepartmentId = ?)");

			st.setDouble(1, 200.00);
			st.setInt(2, 2);

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("rows affected: " + rowsAffected);
			} else {
				System.out.println("error");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.closeConnection();
			DB.closeStatement(st);
		}
	}

}
