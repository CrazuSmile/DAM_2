public class Menu {
    public static void main(String[] args) {
        ThreadGroup grupo = new ThreadGroup("Menu");

        GrupoHilos g = new GrupoHilos();
        Thread h1 = new Thread(grupo, g, "Primeros");
        Thread h2 = new Thread(grupo, g, "Segundos");
        Thread h3 = new Thread(grupo, g, "Postres");

        h1.start();
        h2.start();
        h3.start();
    }
}
