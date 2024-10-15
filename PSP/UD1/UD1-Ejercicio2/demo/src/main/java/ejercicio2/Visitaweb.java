package ejercicio2;

import java.io.*;

public class Visitaweb {
    public static void main(String[] arg) throws IOException{
    	File directorio = new File("/home/juasanlop2/Escriptori/DAM2/DAM_2/PSP/UD1/UD1-Ejercicio2/demo/target/classes/ejercicio2");
    	ProcessBuilder pb = new ProcessBuilder("java", "Leerweb", "firefox");
    	pb.directory(directorio);
    	Process p = pb.start();
    	
    	OutputStream os = p.getOutputStream();
    	os.flush();
    }
}
