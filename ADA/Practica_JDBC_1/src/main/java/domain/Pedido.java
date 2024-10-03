/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.time.LocalDate;

/**
 *
 * @author juasanlop2
 */
public class Pedido {
    private int idPedido;
    private int idCliente;
    private LocalDate fecha;
    private int numero;
    private String calle;
    private String comuna;
    private String ciudad;

    public Pedido(int idPedido, int idCliente, LocalDate fecha, int numero, String calle, String comuna, String ciudad) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.numero = numero;
        this.calle = calle;
        this.comuna = comuna;
        this.ciudad = ciudad;
    }

    public Pedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Pedido(int idCliente, LocalDate fecha, int numero, String calle, String comuna, String ciudad) {
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.numero = numero;
        this.calle = calle;
        this.comuna = comuna;
        this.ciudad = ciudad;
    }

    public Pedido() {
    }

    public int getIdPedido() {
        return idPedido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getNumero() {
        return numero;
    }

    public String getCalle() {
        return calle;
    }

    public String getComuna() {
        return comuna;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Pedido: \n" + "idPedido: " + idPedido + ", idCliente: " + idCliente + ", fecha: " + fecha + "\n numero: " + numero + ", calle: " + calle + ", comuna: " + comuna + ", ciudad: " + ciudad + '\n';
    }
}
