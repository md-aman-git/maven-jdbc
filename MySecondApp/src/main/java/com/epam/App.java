package com.epam;
import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
	static gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
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
			System.out.println("----------------------------------");
			System.out.println("Fruit names : ");
			System.out.println("----------------------------------");
			rset = statement.executeQuery("select * from fruit_table");
			while(rset.next()) {
				System.out.println(rset.getInt(1) + " - " + rset.getString(2));
			}
			System.out.println("----------------------------------");
			System.out.println("City names : ");
			System.out.println("----------------------------------");
			rset = statement.executeQuery("select * from city_table");
			while(rset.next()) {
				System.out.println(rset.getInt(1) + " - " + rset.getString(2));
			}
			System.out.println("GCD of 24 & 78 is = " + gcd(24, 78));
			connection.close();
		} catch(SQLException ex) {
			System.out.println(ex);
		}
		
    }
}
