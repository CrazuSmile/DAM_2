public class Hilo extends Thread {
    public Hilo(String nombre) {
        super(nombre);
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName() + " con valor " + i);
            
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.getLocalizedMessage();
            }
        }

    }
}
