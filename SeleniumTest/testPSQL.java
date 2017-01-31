import org.junit.Before;
import org.junit.Test;

import  java.sql.Connection;
import  java.sql.Statement;
import  java.sql.ResultSet;
import  java.sql.DriverManager;
import  java.sql.SQLException;
import static org.junit.Assert.*;
/**
 * Created by Torak28 on 31.01.2017.
 */
public class testPSQL{
	String dbUrl, user, password, query;
	String id, pass, mail,port;
	@Before
	public void Funkc() throws ClassNotFoundException, SQLException{
		dbUrl = "jdbc:postgresql://127.0.0.1:5432/Projekt";
		user = "postgres";
		password = "admin1";
		query = "SELECT * FROM public.uzytkownik";

		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection(dbUrl,user,password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()){
			id = rs.getString(1);
			pass = rs.getString(2);
			mail = rs.getString(3);
			port = rs.getString(4);
			//System.out.println(id + " "+ pass + " "+mail+" "+" "+port);
		}
	}
	@Test
	public void testBaza() throws Exception{
		assertEquals(1, Integer.parseInt(id));
		assertEquals("admin123", pass);
		assertEquals("jan@kowalski.pl", mail);
		assertEquals(1, Integer.parseInt(port));
	}
}
