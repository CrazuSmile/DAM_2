import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;

public class GrupoHilos extends Thread {
    public void run() {
        File menu = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            menu = new File("menu.txt");
            fr = new FileReader(menu);
            br = new BufferedReader(fr);

            String linea;
            String regex = "-";
            String[] array;

            while ((linea = br.readLine()) != null) {
                array = linea.split(regex);
            }
        } catch (Exception e) {
            e.getLocalizedMessage();
        }

    }
}
