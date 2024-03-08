/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author coxla
 */
// Clase Hilo1 implementando la interfaz Runnable
public class Hilo1 implements Runnable {

    // Variable booleana para controlar la ejecución del hilo
    private volatile boolean correr = true;
    // Objeto de tipo Thread para manejar el hilo
    private Thread mi_thread;

    // Constructor de la clase Hilo1
    public Hilo1() {
        mi_thread = new Thread(this);
    }

    // Método para iniciar el hilo
    public void start() {
        mi_thread.start();
    }
     // Método para detener el hilo
    public void detener() {
        correr = false;
    }

    // Método run, contiene la lógica del hilo
    @Override
    public void run() {
        while (correr) {

            try {
                // El hilo se duerme por 1 segundo
                Thread.sleep(1000);
                for (int i = 0; i < 5; i++) {
                    System.out.println(i + " Este es el hilo 1");
                }

                System.out.println("");
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo1.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
