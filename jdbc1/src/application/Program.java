package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {

		
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

}
