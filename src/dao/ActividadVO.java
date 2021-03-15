/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author edusandovall
 */
public class ActividadVO {
  
    private String nombreGasto;
    private String categoriaGasto;
    private int idCategoria;
    private String fechaGasto;
    private int valorGasto;
    private int idGasto;
    private int gastoDia;

    public String getNombreGasto() {
        return nombreGasto;
    }

    public void setNombreGasto(String nombreGasto) {
        this.nombreGasto = nombreGasto;
    }

    public String getCategoriaGasto() {
        return categoriaGasto;
    }

    public void setCategoriaGasto(String categoriaGasto) {
        this.categoriaGasto = categoriaGasto;
    }

    public String getFechaGasto() {
        return fechaGasto;
    }

    public void setFechaGasto(String fechaGasto) {
        this.fechaGasto = fechaGasto;
    }

    public int getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(int valorGasto) {
        this.valorGasto = valorGasto;
    }

    public int getIdGasto() {
        return idGasto;
    }
    public void setIdGasto(int idGasto) {
        this.idGasto = idGasto;
    }

    /**
     * @return the gastoDia
     */
    public int getGastoDia() {
        return gastoDia;
    }

    /**
     * @param gastoDia the gastoDia to set
     */
    public void setGastoDia(int gastoDia) {
        this.gastoDia = gastoDia;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    
}
