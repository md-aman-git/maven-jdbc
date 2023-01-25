package com.epam;
import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException ex) {
			System.out.println(ex);
		}
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demodb", "root", "root");
			Statement statement = connection.createStatement();
			ResultSet rset = statement.executeQuery("select * from demotable");
			System.out.println("Person names : ");
			while(rset.next()) {
				System.out.println(rset.getInt(1) + " - " + rset.getString(2));
			}
			rset = statement.executeQuery("select * from city_table");
			System.out.println("----------------------------------");
			System.out.println("City names : ");
			System.out.println("----------------------------------");
			while(rset.next()) {
				System.out.println(rset.getInt(1) + " - " + rset.getString(2));
			}
			connection.close();
		} catch(SQLException ex) {
			System.out.println(ex);
		}
		
    }
}
