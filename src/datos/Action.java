/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edusandovall
 */
public class Action {
    
    public boolean execute(PreparedStatement stmt) throws SQLException, ClassNotFoundException
    {
        try
        {
            if(stmt.executeUpdate()>=1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error Action");
            return false;
        }
        
        finally
        {
            try
            {
                if(Conexion.getConnection()!=null)
                {
                    Conexion.getConnection().close();
                }
            }
            catch(ClassNotFoundException  ex)
            {
               Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Error Action");
            }
        }
    }
    
    public ResultSet listar(String con) throws SQLException, ClassNotFoundException
    {
        
        try
        {
          PreparedStatement stmt;
          stmt = Conexion.getConnection().prepareStatement(con);
          ResultSet result = stmt.executeQuery();
          return result;
          
        }
        catch(SQLException | ClassNotFoundException ex)
        {
            Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error Action");
            return null;
        }
        
        finally
        {
            try
            {
                if(Conexion.getConnection()!=null)
                {
                    Conexion.getConnection().close();
                }
            }
            catch(ClassNotFoundException  ex)
            {
               Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Error Action");
            }
        }
    }
}
