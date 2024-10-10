/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author juasanlop2
 */
public class Articulo {
    private int idArticulo;
    private String descripcion;

    public Articulo(int idArticulo, String descripcion) {
        this.idArticulo = idArticulo;
        this.descripcion = descripcion;
    }

    public Articulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Articulo(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Articulo:\n" + "idArticulo=" + idArticulo + ", descripcion=" + descripcion;
    }
    
    
}
