/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import datos.Action;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edusandovall
 */
public class UsuarioDAO implements UsuarioIDAO{
    
    Action act = new Action();
    CrudSQL sql = new CrudSQL();
    
    @Override
    public boolean verficar(String login, String pass)
    {
        try {
            ResultSet result;
            result= act.listar(sql.verificacion(login));
            result.next();
            
            if(result.getString("USR_PASSWORD").equals(pass))
            {
                return true;
            }
            else 
            {
                return false;
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ActividadDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
