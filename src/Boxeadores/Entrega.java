package Boxeadores;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Entrega {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            LuchadorEntrega t = new LuchadorEntrega();
            t.setName("Luchador " + i);
            t.start();
        }
    }
}

class LuchadorEntrega extends Thread {

    @Override
    public void run() {
        CuadrilateroEntrega.addParticipante(this);
    }
}

class CuadrilateroEntrega {

    private static final int NUM_ACCESO_SIMULTANEOS = 2;
    static Semaphore semaphore = new Semaphore(NUM_ACCESO_SIMULTANEOS, true);

    private static LuchadorEntrega luchadorEntrega1 = null;
    private static LuchadorEntrega luchadorEntrega2 = null;

    public static void addParticipante(LuchadorEntrega luchadorEntrega) {
        try {
            semaphore.acquire();

            if(luchadorEntrega1 == null)
                luchadorEntrega1 = luchadorEntrega;
            else
                luchadorEntrega2 = luchadorEntrega;

            if (luchadorEntrega1 != null && luchadorEntrega2 != null)
                luchar(luchadorEntrega1, luchadorEntrega2);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public static void luchar(LuchadorEntrega luch1, LuchadorEntrega luch2){
        System.out.println("Han entrado al cuadrilátero: "+luch1.getName()+" y "+luch2.getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Random r = new Random();

        if(r.nextBoolean()) {
            System.out.println("El " + luch1.getName() + " ha perdido");
            luchadorEntrega1 =null;
        }
        else {
            System.out.println("El " + luch2.getName() + " ha perdido");
            luchadorEntrega2 =null;
        }
        semaphore.release(1);
    }
}