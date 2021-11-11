package Boxeadores;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Cuadrilatero {

    private static final int NUM_ACCESO_SIMULTANEOS = 2;
    static Semaphore semaphore = new Semaphore(NUM_ACCESO_SIMULTANEOS, true);

    public static Luchador luchador1;
    public static Luchador luchador2;

    public static void addParticipante(Luchador luchador) {
        try {
            System.out.println("Ha entrado al cuadrilatero el boxeador "+luchador.getName());
            luchador1 = luchador;
            semaphore.acquire();
            if (luchador1 != null && luchador2 != null)
                luchar(luchador1,luchador2);
            semaphore.release();
            System.out.println("Ha salido del cuadrilatero el boxeador "+luchador.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void luchar(Luchador luchador1,Luchador luchador2){
        try {
            luchador1.sleep(2000);
            luchador2.sleep(2000);
            if (luchador1.getId() > luchador2.getId()) {
                System.out.println("El luchador " + luchador1.getName() + " ha ganado");
            }
            else
                System.out.println("El luchador "+luchador2.getName()+" ha ganado");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
