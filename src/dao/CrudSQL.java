/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author edusandovall
 */
public class CrudSQL {
    
    public static final String Create = "INSERT INTO PROYECTOGASTO.GASTO (GST_NOMBRE, GST_VALOR, ID_CATEGORIA, GST_FECHA) " +
                                                            "VALUES(?, ? , ?, TO_DATE(? , 'dd/mm/yyyy'))";
    
    public static final String CreateCat = "INSERT INTO PROYECTOGASTO.CATEGORIA(CAT_NOMBRE) VALUES(?)";
    
    public static final String ReadCat = "SELECT DISTINCT * FROM PROYECTOGASTO.CATEGORIA\n"
            + "ORDER BY ID_CATEGORIA";
    
    public static final String Read = "SELECT GASTO.GST_ID, GASTO.GST_NOMBRE, GASTO.GST_VALOR, CATEGORIA.CAT_NOMBRE, GST_FECHA\n" +
                                       "FROM GASTO INNER JOIN CATEGORIA ON GASTO.ID_CATEGORIA = CATEGORIA.ID_CATEGORIA\n"
                                       + "ORDER BY GST_ID";

    public static final String Update = "UPDATE PROYECTOGASTO.GASTO SET GST_NOMBRE= ?, "
                                       + "GST_VALOR= ? , ID_CATEGORIA= ?, GST_FECHA= TO_DATE(?, 'dd/mm/yyyy') WHERE GST_ID = ?";
    
    public static final String UpdateCategoria = "UPDATE PROYECTOGASTO.CATEGORIA\n"
            + "SET CAT_NOMBRE=?\n"
            + "WHERE ID_CATEGORIA=?";
    
    public static final String Delete = "DELETE FROM PROYECTOGASTO.GASTO WHERE GST_ID =?";
    
    public static final String ConsultaDinero= "SELECT SUM(GST.VALOR) FROM PROYECTOGASTO.GASTO";
    
    public String consultaAcumulado(String fecha)
    {
       String date;
       date = fecha.substring(3, 10);
       String consultaAcumulado= "SELECT SUM(GST_VALOR)GASTOTOTALACUMULADO FROM GASTO WHERE GST_FECHA BETWEEN TO_DATE("+"'01/"+date+"'"+", 'dd/mm/yyyy') AND TO_DATE("+"'"+fecha+"'"+", 'dd/mm/yyyy')";
       
       return consultaAcumulado;
    }
    
    public String consultaGastoDia(String fecha)
    {
        String consultaGastoDia = "SELECT SUM(GST_VALOR)GASTOTOTAL FROM PROYECTOGASTO.GASTO WHERE (GST_FECHA = TO_DATE("+"'"+fecha+"'"+", 'dd/mm/yyyy'))";
        return consultaGastoDia;
    }
    
    public String consultaGastoTotalFecha(String fecha)
    {
        String consultaTotal = "SELECT SUM(GST_VALOR)GASTOTOTALFECHA FROM GASTO WHERE TO_CHAR(GST_FECHA,'MM') = TO_CHAR(TO_DATE("+"'"+fecha+"'"+", 'dd/mm/yyyy'), 'MM')";
        return consultaTotal;
    }
    
    public String consultarGastosFecha(String fecha)
    {
        String gastosFecha = "SELECT GASTO.GST_NOMBRE, GASTO.GST_VALOR, CATEGORIA.CAT_NOMBRE, GST_FECHA\n"
                + "FROM GASTO INNER JOIN CATEGORIA ON GASTO.ID_CATEGORIA = CATEGORIA.ID_CATEGORIA\n"
                + " WHERE (GST_FECHA = TO_DATE("+"'"+fecha+"'"+", 'dd/mm/yyyy'))";
        return gastosFecha;
    }
    
    public String consultaAcumuladoLista(String fecha)
    {
        String date;
        date = fecha.substring(3, 10);
        String listaAcumulado = "SELECT GASTO.GST_NOMBRE, GASTO.GST_VALOR, CATEGORIA.CAT_NOMBRE, GST_FECHA\n"
                + "FROM GASTO INNER JOIN CATEGORIA ON GASTO.ID_CATEGORIA = CATEGORIA.ID_CATEGORIA\n"
                + "WHERE GST_FECHA BETWEEN TO_DATE("+"'01/"+date+"'"+", 'dd/mm/yyyy') AND TO_DATE("+"'"+fecha+"'"+", 'dd/mm/yyyy')";
        return listaAcumulado;
    }
    
    public String consultaMensualLista(String fecha)
    {
        String gastoMes = "SELECT GASTO.GST_ID, GASTO.GST_NOMBRE, GASTO.GST_VALOR, CATEGORIA.CAT_NOMBRE, GST_FECHA\n"
                + "FROM GASTO INNER JOIN CATEGORIA ON GASTO.ID_CATEGORIA = CATEGORIA.ID_CATEGORIA\n"
                + "WHERE TO_CHAR(GST_FECHA,'MM') = TO_CHAR(TO_DATE("+"'"+fecha+"'"+", 'dd/mm/yyyy'), 'MM')\n"
                + "ORDER BY GST_ID";
        return gastoMes;
    }
    
    public String consultaGastoID(int id)
    {
        String gasto = "SELECT GASTO.GST_ID, GASTO.GST_NOMBRE, GASTO.GST_VALOR, CATEGORIA.CAT_NOMBRE, TO_CHAR(GASTO.GST_FECHA, 'DD/MM/YYYY') AS GST_FECHA\n"
                + "FROM GASTO INNER JOIN CATEGORIA ON GASTO.ID_CATEGORIA = CATEGORIA.ID_CATEGORIA\n"
                + "WHERE GASTO.GST_ID= "+id;
        return gasto;
    }
    
    public String verificacion(String login)
    {
        String verificar = "SELECT * FROM PROYECTOGASTO.USUARIO WHERE USR_LOGIN ="+"'"+login+"'";
        return verificar;
    }
    
}
