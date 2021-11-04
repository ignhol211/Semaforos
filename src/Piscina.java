import java.util.Random;

public class Piscina {

    static void solicitarAcceso(Banista banista){
        banarse(banista);
    }

    static private void banarse(Banista banista){
        System.out.println("Comienza a bañaser "+banista.nombre);
        try {
            Thread.sleep((new Random().nextInt(4)+1)*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        banista.sucio = false;
        System.out.println("Finaliza el baño de "+banista.nombre);
    }


}
