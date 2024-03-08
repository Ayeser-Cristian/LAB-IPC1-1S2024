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
// Clase Hilo2 que extiende de Thread
public class Hilo2 extends Thread {
    
    // Variable booleana para controlar la ejecución del hilo
    private volatile boolean correr = true;
    
    // Método para detener el hilo
    public void detener() {
        correr = false;
    }

    public void run() {
        while (correr) {
            try {
                // El hilo se duerme por 1 segundo
                Thread.sleep(1000);
                for (int i = 0; i < 5; i++) {
                    System.out.println(i + " Este es el hilo 2");
                }

                System.out.println("");
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
