

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;


public class Select {
	Vector<Person> list = new Vector<>();
	Person p;
	
	public Select() {
		Connection connection = null;

		try {
			//Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("select * from person");
			while(rs.next())
			{
				String name = rs.getString("name");
				int age = rs.getInt("age");
				p = new Person(name,age);
				
				System.out.println(p.toString());
				list.add(p);
			}
			rs.close();
			connection.close();	
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public Vector<Person> returnSelect(){
		return list;
	}
}











