public class Banista extends Thread{

    boolean sucio = true;
    String nombre="";

    public Banista(String nombre){
        this.nombre=nombre;
    }


    @Override
    public void run(){
        Piscina.solicitarAcceso(this);
        System.out.println("Ya me he bañado. Sucio: "+sucio);
    }

}
