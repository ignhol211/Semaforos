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

            if(luchador1 == null)
                luchador1 = luchador;
            else
                luchador2 = luchador;

            semaphore.acquire();
            if (luchador1 != null && luchador2 != null)
                luchar(luchador1,luchador2);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void luchar(Luchador luchador1,Luchador luchador2){
        System.out.println("Han entrado al cuadrilátero: "+luchador1.getName()+" y "+luchador2.getName());

        Random r = new Random();

        try {
            Thread.sleep(1);
            if(r.nextBoolean()){
                System.out.println("El "+luchador1.getName()+" ha perdido");
                luchador1 = null;
                semaphore.release();
            }
            else {
                System.out.println("El " + luchador2.getName() + " ha perdido");
                luchador2 = null;
                semaphore.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
