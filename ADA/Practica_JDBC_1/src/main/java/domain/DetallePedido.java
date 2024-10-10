/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author juasanlop2
 */
public class DetallePedido {
    private int idPedido;
    private int idArticulo;
    private int cantidad;

    public DetallePedido(int idPedido, int idArticulo, int cantidad) {
        this.idPedido = idPedido;
        this.idArticulo = idArticulo;
        this.cantidad = cantidad;
    }

    public DetallePedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public DetallePedido(int idArticulo, int cantidad) {
        this.idArticulo = idArticulo;
        this.cantidad = cantidad;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "DetallePedido:\n" + "idPedido: " + idPedido + "\n idArticulo: " + idArticulo + ", cantidad: " + cantidad;
    }
    
}
