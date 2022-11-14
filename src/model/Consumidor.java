package model;

public class Consumidor extends Thread {

    private Buffer b;
    private int size;

    public Consumidor(Buffer b, int size) {
        this.b = b;
        this.size = size;
    }

    @Override
    public void run() {
        for (int i = 0; i<size; i++) {
            try {
                int aux = b.extraer();
                System.out.println("El consumidor extrajo: " + aux + " del buffer");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
