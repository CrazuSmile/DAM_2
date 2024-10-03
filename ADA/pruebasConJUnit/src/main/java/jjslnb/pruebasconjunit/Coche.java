/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jjslnb.pruebasconjunit;

/**
 *
 * @author juasanlop2
 */
public class Coche {

    public String modelo;
    public float precioBase;
    public static float impuesto;

    public Coche(String modelo, float precioBase) {
        this.modelo = modelo;
        this.precioBase = precioBase;
    }

    public float precioFinal(float descuento) throws Exception {
        float precioConDescuento = this.precioBase;
        if (descuento < 1 || descuento > 100) {
            throw new RuntimeException("Descuento erroneo");
        }

        if (precioBase >= 5000) {
            precioConDescuento = this.precioBase - (this.precioBase * descuento / 100);
        }
        return precioConDescuento + precioConDescuento * this.impuesto / 100f;
    }
}
