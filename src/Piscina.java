import java.util.Random;
import java.util.concurrent.Semaphore;

public class Piscina {

    private static final int NUM_ACCESO_SIMULTANEOS = 4;
    static Semaphore semaphore = new Semaphore(NUM_ACCESO_SIMULTANEOS, true);

    static void solicitarAcceso(Banista banista){
        System.out.println("El "+banista.nombre+" quiere entrar");
        try {
            semaphore.acquire();
            banarse(banista);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static private void banarse(Banista banista){
        System.out.println("Comienza a bañaser "+banista.nombre);
        try {
            Thread.sleep((new Random().nextInt(4)+1)*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        banista.sucio = false;
        System.out.println("Finaliza el baño de " + banista.nombre);
    }
}
