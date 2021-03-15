/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import datos.Action;
import datos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edusandovall
 */
public class CategoriaDAO implements CategoriaIDAO {
    
    PreparedStatement stmt;
    Action act = new Action();
    CrudSQL sql = new CrudSQL();
    
    @Override
    public boolean ingresarCategoria(CategoriaVO categoriaVO) throws SQLException, ClassNotFoundException
    {
        try
        {
            stmt = Conexion.getConnection().prepareStatement(CrudSQL.CreateCat);
            
            stmt.setString(1, categoriaVO.getCategoriaName());
            
            if(act.execute(stmt)==true)
            {
                return true;
            }
            else
            {
                return false;
            }
            
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    @Override
    public boolean actualizarCategoria(CategoriaVO categoriaVO) throws ClassNotFoundException, SQLException
    {
        try
        {
            stmt = Conexion.getConnection().prepareStatement(CrudSQL.UpdateCategoria);
            
            stmt.setString(1, categoriaVO.getCategoriaName());
            stmt.setInt(2, categoriaVO.getIdCategoria());
            
            if(act.execute(stmt))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    @Override
    public ArrayList<CategoriaVO>consultarCategoria() throws SQLException, ClassNotFoundException
    {
        ArrayList listaCategoria = new ArrayList();
        
        try
        {
            ResultSet result;
            result = act.listar(CrudSQL.ReadCat);
            CategoriaVO categoriaVO;
            
            while(result.next())
            {
                categoriaVO = new CategoriaVO();
                
                categoriaVO.setIdCategoria(Integer.parseInt(result.getString("ID_CATEGORIA")));
                categoriaVO.setCategoriaName(result.getString("CAT_NOMBRE"));
                listaCategoria.add(categoriaVO);
            }
        }
        
        catch(ClassNotFoundException | SQLException ex)
        {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCategoria;
    }
}
