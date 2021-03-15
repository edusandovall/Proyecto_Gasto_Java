/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author edusandovall
 */
public interface CategoriaIDAO {
    
    public boolean ingresarCategoria(CategoriaVO categoriaVO) throws SQLException, ClassNotFoundException;
    public ArrayList<CategoriaVO>consultarCategoria() throws SQLException, ClassNotFoundException;
    public boolean actualizarCategoria(CategoriaVO categoriaVO) throws ClassNotFoundException, SQLException;
    
}
