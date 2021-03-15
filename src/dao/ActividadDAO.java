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
public class ActividadDAO implements ActividadIDAO{
    
    PreparedStatement stmt;
    Action act = new Action();
    CrudSQL sql = new CrudSQL();
    
    @Override
    public boolean ingresarGasto(ActividadVO actividadVO) throws ClassNotFoundException, SQLException
    {
        try
        {
            stmt = Conexion.getConnection().prepareStatement(CrudSQL.Create);
            
            stmt.setString(1, actividadVO.getNombreGasto());
            stmt.setInt(2, actividadVO.getValorGasto());
            stmt.setInt(3, actividadVO.getIdCategoria());
            stmt.setString(4, actividadVO.getFechaGasto());
            
            if(act.execute(stmt)==true);
            {
                return true;
            }
            
        }
        catch(ClassNotFoundException | SQLException ex)
        {
             Logger.getLogger(ActividadDAO.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
    }
    
    @Override
    public boolean actualizarGasto(ActividadVO actividadVO) throws ClassNotFoundException, SQLException
    {
        try
        {
            stmt = Conexion.getConnection().prepareStatement(CrudSQL.Update);
            
            stmt.setString(1, actividadVO.getNombreGasto());
            stmt.setInt(2, actividadVO.getValorGasto());
            stmt.setInt(3, actividadVO.getIdCategoria());
            stmt.setString(4, actividadVO.getFechaGasto());
            stmt.setInt(5, actividadVO.getIdGasto());
            
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
             Logger.getLogger(ActividadDAO.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Error ActividadDAO");
             return false;
        }
    }
    
    @Override
    public boolean borrarGasto(ActividadVO actividadVO) throws ClassNotFoundException, SQLException
    {
        try
        {
            stmt = Conexion.getConnection().prepareStatement(CrudSQL.Delete);
            
            stmt.setInt(1, actividadVO.getIdGasto());
            
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
             Logger.getLogger(ActividadDAO.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Error en borrar");
             return false;
        }
    }
     
    @Override
    public int consultarGastoTotal(String fecha) throws SQLException, ClassNotFoundException
    {
        int gastoTotal = 0;
        try
        {
            ResultSet result;
            result = act.listar(sql.consultaGastoDia(fecha));
            
            if(result.next())
            {    
                gastoTotal = result.getInt("GASTOTOTAL");
            }
            
        }
        catch(SQLException | ClassNotFoundException ex)
        {
            Logger.getLogger(ActividadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gastoTotal;
    }
    
    @Override
    public int consultarGastoTotalFecha(String fecha) throws SQLException, ClassNotFoundException
    {
        int gastoTotalFecha = 0;
        
        try
        {
            ResultSet result;
            result = act.listar(sql.consultaGastoTotalFecha(fecha));
            
            if(result.next())
            {
                gastoTotalFecha = result.getInt("GASTOTOTALFECHA");
            }
        }
        catch(SQLException | ClassNotFoundException ex)
        {
            Logger.getLogger(ActividadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gastoTotalFecha;
    }
    
    @Override
    public int consultarGastoAcumulado(String fecha) throws SQLException, ClassNotFoundException
    {
        int gastoAcumulado = 0;
        
        try
        { 
            ResultSet result;
            result = act.listar(sql.consultaAcumulado(fecha));
            
            if(result.next())
            {
                gastoAcumulado = result.getInt("GASTOTOTALACUMULADO");
            }
        }
        catch(SQLException | ClassNotFoundException ex)
        {
            Logger.getLogger(ActividadDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en consultarGastoAcumulado");
        }
        return gastoAcumulado;
    }
    
    @Override
    public ArrayList<ActividadVO>consultarGastosFecha(String fecha) throws ClassNotFoundException, SQLException
    {
        
        ArrayList listaActividades = new ArrayList();
        try
        {
            ResultSet result;
            result = act.listar(sql.consultarGastosFecha(fecha));
            ActividadVO actividadVO;
            
            while(result.next())
            {
                actividadVO= new ActividadVO();
                
                actividadVO.setNombreGasto(result.getString("GST_NOMBRE"));
                actividadVO.setValorGasto(result.getInt("GST_VALOR"));
                actividadVO.setCategoriaGasto(result.getString("CAT_NOMBRE"));
                actividadVO.setFechaGasto(result.getString("GST_FECHA"));
                
                listaActividades.add(actividadVO);
            }
            
        }
        catch(ClassNotFoundException | SQLException ex)
        {
             Logger.getLogger(ActividadDAO.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Error en consultarGastosFecha");
        }
        return listaActividades;
    }
    
    @Override
    public ArrayList<ActividadVO>listaAcumulado(String fecha) throws SQLException, ClassNotFoundException
    {
        ArrayList listaActividades = new ArrayList();
        
        try
        {
            ResultSet result;
            result = act.listar(sql.consultaAcumuladoLista(fecha));
            ActividadVO actividadVO;
            
            while(result.next())
            {
                actividadVO= new ActividadVO();
                
                actividadVO.setNombreGasto(result.getString("GST_NOMBRE"));
                actividadVO.setValorGasto(result.getInt("GST_VALOR"));
                actividadVO.setCategoriaGasto(result.getString("CAT_NOMBRE"));
                actividadVO.setFechaGasto(result.getString("GST_FECHA"));
                
                listaActividades.add(actividadVO);
            }
            
        }
        catch(ClassNotFoundException | SQLException ex)
        {
             Logger.getLogger(ActividadDAO.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Error en listaAcumulado");
        }
        return listaActividades;
    }
    
    @Override
    public ArrayList<ActividadVO>listaMensual(String fecha) throws SQLException, ClassNotFoundException
    {
        ArrayList listaActividades = new ArrayList();
        
        try
        {
            ResultSet result;
            result = act.listar(sql.consultaMensualLista(fecha));
            ActividadVO actividadVO;
            
            while(result.next())
            {
                actividadVO = new ActividadVO();
                
                actividadVO.setIdGasto(Integer.parseInt(result.getString("GST_ID")));
                actividadVO.setNombreGasto(result.getString("GST_NOMBRE"));
                actividadVO.setValorGasto(result.getInt("GST_VALOR"));
                actividadVO.setCategoriaGasto(result.getString("CAT_NOMBRE"));
                actividadVO.setFechaGasto(result.getString("GST_FECHA"));
                
                listaActividades.add(actividadVO);
            }
        }
        catch(ClassNotFoundException | SQLException ex)
        {
             Logger.getLogger(ActividadDAO.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Error en listaMensual");
        }
        return listaActividades;
    }
    
    @Override
    public ArrayList<ActividadVO>gastoID(int id) throws SQLException, ClassNotFoundException
    {
        ArrayList listaActividades = new ArrayList();
        
        try
        {
            ResultSet result;
            result = act.listar(sql.consultaGastoID(id));
            ActividadVO actividadVO;
            
            while(result.next())
            {
                actividadVO = new ActividadVO();
                
                actividadVO.setIdGasto(Integer.parseInt(result.getString("GST_ID")));
                actividadVO.setNombreGasto(result.getString("GST_NOMBRE"));
                actividadVO.setValorGasto(result.getInt("GST_VALOR"));
                actividadVO.setCategoriaGasto(result.getString("CAT_NOMBRE"));
                actividadVO.setFechaGasto(result.getString("GST_FECHA"));
                
                listaActividades.add(actividadVO);
            }
        }
        catch(ClassNotFoundException | SQLException ex)
        {
             Logger.getLogger(ActividadDAO.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Error en gastoID");
        }
        return listaActividades;
    }
    
    @Override
    public ArrayList<ActividadVO>consultarGastos() throws SQLException
    {
        ArrayList listaActividades = new ArrayList();
        try
        {
            ResultSet result;
            result = act.listar(CrudSQL.Read);
            ActividadVO actividadVO;
            
            while(result.next())
            {
                actividadVO= new ActividadVO();
                
                actividadVO.setIdGasto(Integer.parseInt(result.getString("GST_ID")));
                actividadVO.setNombreGasto(result.getString("GST_NOMBRE"));
                actividadVO.setValorGasto(result.getInt("GST_VALOR"));
                actividadVO.setCategoriaGasto(result.getString("CAT_NOMBRE"));
                actividadVO.setFechaGasto(result.getString("GST_FECHA"));
                
                listaActividades.add(actividadVO);
            }
        }
          catch(ClassNotFoundException | SQLException ex)
        {
             Logger.getLogger(ActividadDAO.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Error en consultarGastos");
        }
        return listaActividades;  
    }
    
    
}
