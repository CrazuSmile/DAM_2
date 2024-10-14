import java.io.*;

public class EntradaSalida {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("bash", "-c", "ls /home/juasanlop2");
        Process p = pb.start();

        InputStream is = p.getInputStream();
        int c;
        while ((c = is.read()) != -1) {
            System.out.print((char) c);
        }
        is.close();
    }
}
