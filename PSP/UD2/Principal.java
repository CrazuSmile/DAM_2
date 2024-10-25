public class Principal {
    public static void main(String[] args) {
        Hilo hilo1 = new Hilo("Hilo1");
        Hilo hilo2 = new Hilo("Hilo2");
        Hilo hilo3 = new Hilo("Hilo3");

        hilo1.start();
        hilo2.start();
        hilo3.start();

        System.out.println("3 hilos iniciados... ");
    }
}
