/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edusandovall
 */
public class Conexion {

	private static Conexion conn;
	private static Connection connection;
	
	private Conexion()
	{
		super();
	}
	
	
	private static Conexion getInstance()
	{
		if(conn==null)
		{
			conn= new Conexion();
		}
		return conn;
	}
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			connection = DriverManager.getConnection(url, "proyectogasto", "proyectogastobd");
		}
		catch(ClassNotFoundException | SQLException ex)
		{
                                        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                                        System.out.println("Error Conexion");
		}
		return connection;
	}
        
}