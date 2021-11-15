package Boxeadores;

public class Luchador extends Thread {
    @Override
    public void run() {
        Cuadrilatero.addParticipante(this);
    }
}
