package model;

import java.util.concurrent.Semaphore;

public class Buffer {
    private int[] b;
    private int i = 0, j = 0;
    private Semaphore mutex = new Semaphore(1, true);
    private Semaphore hayDatos = new Semaphore(0, true);
    private Semaphore hayEspacio;

    public Buffer(int tam) {
        b = new int[tam];
        hayEspacio = new Semaphore(tam, true);

    }

    public void poner(int dato) throws InterruptedException {
        hayEspacio.acquire();
        mutex.acquire();
        b[i] = dato;
        i = (i + 1) % b.length;
        mutex.release();
        hayDatos.release();
    }

    public int extraer() throws InterruptedException {
        hayDatos.acquire();
        mutex.acquire();
        int actual = j;
        j = (j + 1) % b.length;
        mutex.release();
        hayEspacio.release();
        return b[actual];
    }
}
