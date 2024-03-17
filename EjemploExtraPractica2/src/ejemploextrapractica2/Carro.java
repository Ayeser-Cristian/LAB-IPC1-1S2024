/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemploextrapractica2;

/**
 *
 * @author coxla
 */
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Carro extends Thread {

    private volatile boolean running = true;
    Ventana vtn;
    Rectangle rec_muro, rec_carro;
    int posicionXCarro;

    public Carro(Ventana my_vtn, int posX) {
        this.vtn = my_vtn;
        this.posicionXCarro = posX;
        this.rec_carro = this.vtn.lblCarro.getBounds();
        this.rec_muro = this.vtn.lblMuro.getBounds();
    }

    public void run() {
        try {
            while (running) {

                sleep(250);
                if (this.rec_muro.intersects(this.rec_carro)) {
                    JOptionPane.showMessageDialog(null, "Llegue al tope ");
                    stopThead();
                } else {
                    this.posicionXCarro += 20;

                    this.vtn.lblCarro.setLocation(this.posicionXCarro, this.vtn.lblCarro.getY());
                    this.rec_carro=this.vtn.lblCarro.getBounds();
                    
                    this.vtn.repaint();
                }
                System.out.println("Posicion del Carro en X: " + this.posicionXCarro);

            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Carro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void stopThead() {
        this.running = false;
    }
}
