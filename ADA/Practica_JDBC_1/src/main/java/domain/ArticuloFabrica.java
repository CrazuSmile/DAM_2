/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author juasanlop2
 */
public class ArticuloFabrica {
    private int idArticulo;
    private int idFabrica;
    private int existencias;
    private float precio;

    public ArticuloFabrica(int idArticulo, int idFabrica, int existencias, float precio) {
        this.idArticulo = idArticulo;
        this.idFabrica = idFabrica;
        this.existencias = existencias;
        this.precio = precio;
    }

    public ArticuloFabrica(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public ArticuloFabrica(int existencias, float precio) {
        this.existencias = existencias;
        this.precio = precio;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public int getIdFabrica() {
        return idFabrica;
    }

    public int getExistencias() {
        return existencias;
    }

    public float getPrecio() {
        return precio;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public void setIdFabrica(int idFabrica) {
        this.idFabrica = idFabrica;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
    
}
