package model;

import java.util.Random;

public class Productor extends Thread {

    private Random r = new Random();
    private Buffer b;
    private int size;

    public Productor(Buffer b, int size) {
        this.b = b;
        this.size = size;
    }

    @Override
    public void run() {
        for (int i = 0; i<size; i++) {
            int aux = r.nextInt(10);
            try {
                b.poner(aux);
                System.out.println("El productor puso: " + aux + " en el buffer");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
