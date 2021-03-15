/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import dao.ActividadDAO;
import dao.ActividadIDAO;
import dao.ActividadVO;
import dao.CategoriaDAO;
import dao.CategoriaIDAO;
import dao.CategoriaVO;
import dao.UsuarioDAO;
import dao.UsuarioIDAO;
import dao.UsuarioVO;

/**
 *
 * @author edusandovall
 */
public class Controlador {
    
    ActividadIDAO actividadIDAO = new ActividadDAO();
    CategoriaIDAO categoriaIDAO = new CategoriaDAO();
    UsuarioIDAO usuariosIDAO = new UsuarioDAO();
    ActividadVO actividadVO = new ActividadVO();
    CategoriaVO categoriaVO = new CategoriaVO();
    UsuarioVO usuarioVO = new UsuarioVO();
    
    public ArrayList<ActividadVO>enviarFecha(String date)
    {
        ArrayList<ActividadVO> listaActividades= new ArrayList();
        
        try
        {
            listaActividades = actividadIDAO.consultarGastosFecha(date);
        } 
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaActividades;
    }
    
    public ArrayList<ActividadVO>enviarFechaAcumulado(String date) throws SQLException, ClassNotFoundException
    {
        ArrayList<ActividadVO> listaActividades = new ArrayList();
        
        try
        {
            listaActividades = actividadIDAO.listaAcumulado(date);
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaActividades;
    }
    
    public ArrayList<ActividadVO>enviarFechaMensual(String date)
    {
        ArrayList<ActividadVO> listaActividades = new ArrayList();
        
        try
        {
            listaActividades = actividadIDAO.listaMensual(date);
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaActividades;
    }
    
    public int enviarFechaInt(String date)
    {
        int gastoTotal=0;
        
        try 
        {
            gastoTotal= actividadIDAO.consultarGastoTotal(date);
        } 
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gastoTotal;
    }
    
    public int enviarFechaIntGT(String date)
    {
        int gastoTotalFecha=0;
         
        try 
        {
            gastoTotalFecha= actividadIDAO.consultarGastoTotalFecha(date);
        } 
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gastoTotalFecha;
    }
    
    public int enviarFechaIntAcum(String date)
    {
        int gastoAcumulado=0;

        try 
        {
            gastoAcumulado = actividadIDAO.consultarGastoAcumulado(date);
        } 
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gastoAcumulado;
    }
    
    public ArrayList<ActividadVO>listarGasto()
    {
        ArrayList<ActividadVO> listaActividades= new ArrayList();
        
        try 
        {
            listaActividades = actividadIDAO.consultarGastos();
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaActividades;
    }
    
    public boolean enviarDatos(String nombre, int valor, String fecha, int categoria)
    {
        actividadVO.setNombreGasto(nombre);
        actividadVO.setValorGasto(valor);
        actividadVO.setFechaGasto(fecha);
        actividadVO.setIdCategoria(categoria);
        try 
        {  
            if(actividadIDAO.ingresarGasto(actividadVO)==true)
            {
                return true;
            }
            else
            {
                return false;
            }
            
        } 
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean actualizarDatos(int id, String nombre, int valor, String fecha, int categoria)
    {
        actividadVO.setIdGasto(id);
        actividadVO.setNombreGasto(nombre);
        actividadVO.setValorGasto(valor);
        actividadVO.setFechaGasto(fecha);
        actividadVO.setIdCategoria(categoria);
        try 
        {  
            if(actividadIDAO.actualizarGasto(actividadVO)==true)
            {
                return true;
            }
            else
            {
                return false;
            }
            
        } 
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean eliminarGasto(int id)
    {
        actividadVO.setIdGasto(id);
        
        try
        {
            if(actividadIDAO.borrarGasto(actividadVO)==true);
            {
                return true;
            }
        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean actualizarCategoria(String nombre, int id)
    {
        categoriaVO.setCategoriaName(nombre);
        categoriaVO.setIdCategoria(id);
        
        try
        {
            if(categoriaIDAO.actualizarCategoria(categoriaVO)==true)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean enviarCategoria(String categoria)
    {
        categoriaVO.setCategoriaName(categoria);
        try
        {
            if(categoriaIDAO.ingresarCategoria(categoriaVO)==true)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public ArrayList<CategoriaVO>listarCategorias() throws ClassNotFoundException, SQLException
    {
        ArrayList<CategoriaVO>listaCategoria = new ArrayList();
        
        try
        {
            listaCategoria = categoriaIDAO.consultarCategoria();
        } 
        catch (SQLException | ClassNotFoundException ex)
        {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCategoria;
    }
    
    public ArrayList<ActividadVO>gastoPorID(int id)
    {
        ArrayList<ActividadVO>listaActividad = new ArrayList();
        
        try
        {
            listaActividad = actividadIDAO.gastoID(id);
        }
        catch (SQLException | ClassNotFoundException ex)
        {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaActividad;
    }
    
    public boolean verificar(String login, String pass)
    {
        usuarioVO.setLogin(login);
        usuarioVO.setPassword(pass);
        
        if(usuariosIDAO.verficar(login, pass)==true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
