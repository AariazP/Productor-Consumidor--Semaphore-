package application;

import model.Buffer;
import model.Consumidor;
import model.Productor;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Buffer b = new Buffer(10);
        Productor p = new Productor(b, 10);
        Consumidor c = new Consumidor(b, 10);
        p.start();
        c.start();
    }
}