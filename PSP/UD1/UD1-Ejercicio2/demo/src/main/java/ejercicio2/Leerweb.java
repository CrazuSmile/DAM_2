package ejercicio2;

import java.io.*;

public class Leerweb {
    public static void main(String[] args) {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String webs;
        try {
            System.out.println("Introduzca cadena a enviar:");
            webs = br.readLine();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
