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
public interface ActividadIDAO {
    
    public boolean ingresarGasto(ActividadVO actividadVO) throws ClassNotFoundException, SQLException;
    public boolean actualizarGasto(ActividadVO actividadVO) throws ClassNotFoundException, SQLException;
    public boolean borrarGasto(ActividadVO actividadVO) throws ClassNotFoundException, SQLException;
   public ArrayList<ActividadVO>consultarGastosFecha(String fecha) throws ClassNotFoundException, SQLException;
    public ArrayList<ActividadVO>consultarGastos() throws SQLException;
    public int consultarGastoTotal(String fecha) throws SQLException, ClassNotFoundException;
    public int consultarGastoTotalFecha(String fecha) throws SQLException, ClassNotFoundException;
    public int consultarGastoAcumulado(String fecha) throws SQLException, ClassNotFoundException;
    public ArrayList<ActividadVO>listaAcumulado(String fecha) throws SQLException, ClassNotFoundException;
    public ArrayList<ActividadVO>listaMensual(String fecha) throws SQLException, ClassNotFoundException;
    public ArrayList<ActividadVO>gastoID(int id) throws SQLException, ClassNotFoundException;
}
