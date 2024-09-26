package proyecto_acronimos;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("ACRÓNIMO");
        Scanner teclado = new Scanner(System.in);
        String cadena;
        System.out.printf("OBTENER ACRÓNIMO DE UN TEXTO");
        System.out.printf("Teclee el texto :");
        cadena = teclado.nextLine();
        Acronimos x = new Acronimos();
        String resultado = x.obtenerAcronimo(cadena);
        System.out.printf("El acrónimo de %s es %s\n", cadena, resultado);
    }
}
