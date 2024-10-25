/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author juasanlop2
 */
public class Cliente {

    private int idCliente;
    private float saldo;
    private float limiteCredito;
    private float descuento;

    public Cliente(int idCliente, float saldo, float limiteCredito, float descuento) {
        this.idCliente = idCliente;
        this.saldo = saldo;
        this.limiteCredito = limiteCredito;
        this.descuento = descuento;
    }

    public Cliente() {
    }

    public Cliente(float saldo, float limiteCredito, float descuento) {
        this.saldo = saldo;
        this.limiteCredito = limiteCredito;
        this.descuento = descuento;
    }

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setLimiteCredito(float limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public float getSaldo() {
        return saldo;
    }

    public float getLimiteCredito() {
        return limiteCredito;
    }

    public float getDescuento() {
        return descuento;
    }

    @Override
    public String toString() {
        return "Cliente:\n" + "ID = " + idCliente + "\n Saldo = " + saldo + "\n Limite de credito = " + limiteCredito + "\n Descuento = " + descuento + "\n";
    }

}
