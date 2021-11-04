public class Main {
    //Piscina con 10 personas de aforo
    //Los bañistas son hilos
    //Un bañista se queda un rato en la piscina (Tiempo random)
    //Cuando se va un bañista, puede entrar otro

    public static void main(String[]args){
        for (int i=0;i<10;i++){
            Banista b = new Banista(String.valueOf(i));
            b.start();

        }
    }

}
