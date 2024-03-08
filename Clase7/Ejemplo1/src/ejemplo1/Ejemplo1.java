/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author coxla
 */
public class Ejemplo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /* Se puede usar Runnable o Thread para crear hilos en Java:
         - Runnable: Es una interfaz funcional que representa un objeto que puede ser ejecutado por un hilo.
           Se utiliza principalmente para mantener la flexibilidad en la implementación de otras interfaces o herencias de clase.
           Para ejecutar un Runnable, generalmente se pasa como argumento a un objeto Thread y se llama al método start() del objeto Thread.
         - Thread: Es una clase en Java que representa un hilo. Puede extender la clase Thread o implementar la interfaz Runnable.
           Cuando se extiende Thread, la clase debe sobrescribir el método run() para proporcionar la lógica de ejecución del hilo.
           Cuando se implementa Runnable, la clase solo necesita implementar el método run().
           La principal diferencia entre usar Runnable y extender Thread es que en el primer caso, se puede heredar de otra clase,
           mientras que en el segundo caso, se pierde la oportunidad de heredar de otra clase ya que Java no admite herencia múltiple.
        
           Yo prefiero usar Thread :)
        */

        
        // Creación de una instancia de Hilo1
        Hilo1 hilo1 = new Hilo1();
        // Creación de una instancia de Hilo2
        Hilo2 hilo2 = new Hilo2();

        // Inicio de los hilos
        hilo1.start();
        hilo2.start();

        try {
            // Espera 7 segundos antes de detener los hilos
            Thread.sleep(7000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ejemplo1.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Detiene los hilos
        hilo1.detener();
        hilo2.detener();

    }

}
