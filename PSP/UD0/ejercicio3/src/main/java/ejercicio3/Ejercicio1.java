package ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Ejercicio1 {
    public static void main(String[] args) {
        File entrada = null;
        File salida = null;
        FileReader fr = null;
        BufferedReader br = null;
        BufferedWriter buffer = null;
        FileWriter escritor = null;

        try {
            // Apertura del fichero y creación de BufferedReader para poder
            // hacer una lectura cómoda (disponer del método readLine()).
            entrada = new File("/home/juasanlop2/Escriptori/DAM2/DAM_2/PSP/UD0/ejercicio3/files/entrada.txt");
            salida = new File("/home/juasanlop2/Escriptori/DAM2/DAM_2/PSP/UD0/ejercicio3/files/salida.txt");
            escritor = new FileWriter(salida);
            buffer = new BufferedWriter(escritor);
            fr = new FileReader(entrada);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            String regex = "[,\\s]";
            String[] myArray;

            while ((linea = br.readLine()) != null) {
                myArray = linea.split(regex);
                for (String s : myArray) {
                    System.out.println(s);
                }
                escritor.write("Numero de palabras de la entrada es " + myArray.length);
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra, tanto si todo va bién como si salta
            // una excepción.
            try {
                br.close();
                buffer.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

}