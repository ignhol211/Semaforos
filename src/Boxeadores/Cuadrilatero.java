package Boxeadores;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Cuadrilatero {

    private static final int NUM_ACCESO_SIMULTANEOS = 2;
    static Semaphore semaphore = new Semaphore(NUM_ACCESO_SIMULTANEOS, true);

    private static Luchador luchador1 = null;
    private static Luchador luchador2 = null;

    public static void addParticipante(Luchador luchador) {
        try {
            semaphore.acquire();

            if(luchador1 == null)
                luchador1 = luchador;
            else
                luchador2 = luchador;

            if (luchador1 != null && luchador2 != null)
                luchar(luchador1,luchador2);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public static void luchar(Luchador luch1,Luchador luch2){
        System.out.println("Han entrado al cuadrilátero: "+luch1.getName()+" y "+luch2.getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Random r = new Random();

        if(r.nextBoolean()) {
            System.out.println("El " + luch1.getName() + " ha perdido");
            luchador1=null;
        }
        else {
            System.out.println("El " + luch2.getName() + " ha perdido");
            luchador2=null;
        }
        semaphore.release();
    }
}
