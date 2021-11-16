
package Boxeadores;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            Luchador t = new Luchador();
            t.setName("Luchador " + i);
            t.start();
        }
    }
}