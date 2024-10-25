package com.example;

import java.io.*;
import java.util.Scanner;

public class Leerweb {
    public static void main(String[] args) throws IOException {
        File directorio = new File(
                "/home/juasanlop2/Escriptori/DAM2/DAM_2/PSP/UD1/UD1-Ejercicio2/ejercicio2/src/main/java/com/example");
        Scanner s = new Scanner(System.in);
        System.out.println("Introduzca cadena a enviar: ");
        String cadena = s.nextLine();
        cadena = cadena + "\n";
        ProcessBuilder pb = new ProcessBuilder("java", "Visitaweb.java");
        pb.directory(directorio);
        Process p = pb.start();

        OutputStream os = p.getOutputStream();
        os.write(cadena.getBytes());
        os.flush();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
