/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author juasanlop2
 */
public class Direccion {

    private int idDircciones;
    private int idCliente;
    private int numero;
    private String calle;
    private String comuna;
    private String ciudad;

    public Direccion(int idDircciones, int idCliente, int numero, String calle, String comuna, String ciudad) {
        this.idDircciones = idDircciones;
        this.idCliente = idCliente;
        this.numero = numero;
        this.calle = calle;
        this.comuna = comuna;
        this.ciudad = ciudad;
    }

    public Direccion(int numero, String calle, String comuna, String ciudad) {
        this.numero = numero;
        this.calle = calle;
        this.comuna = comuna;
        this.ciudad = ciudad;
    }

    public Direccion(int idDircciones) {
        this.idDircciones = idDircciones;
    }

    public Direccion(int idDircciones, int idCliente) {
        this.idDircciones = idDircciones;
        this.idCliente = idCliente;
    }

    public Direccion() {
    }
    

    public int getIdDircciones() {
        return idDircciones;
    }

    public int getIdCliente() {
        return idCliente;
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

    public void setIdDircciones(int idDircciones) {
        this.idDircciones = idDircciones;
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
        return "Direccion: \n" + " idDircciones = " + idDircciones + "\n idCliente = " + idCliente + "\n numero = " + numero + ", calle = " + calle + "\n comuna = " + comuna + ", ciudad = " + ciudad + "\n";
    }

}
