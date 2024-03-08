/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo2;

/**
 *
 * @author coxla
 */
import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Moto extends Thread {

    Ventana ventana;
    Gas gas;
    int posx_moto, posy_moto;
    private volatile boolean running = true;

    public Moto(Ventana vtn, Gas _gas) {
        this.ventana = vtn;
        this.gas = _gas;
        this.posx_moto = this.ventana.lbl_moto.getX();
        this.posy_moto = this.ventana.lbl_moto.getY();
        this.ventana.moto_rect = this.ventana.lbl_moto.getBounds();
    }

    public void run() {
        try {
            while (running) {

                sleep(250);
                if (this.gas.posx > posx_moto) {
                    posx_moto += 8;
                } else if (this.gas.posx < posx_moto) {
                    posx_moto -= 8;
                }

                if (this.gas.posy + 50 > posy_moto + 150) {
                    posy_moto += 8;
                } else if (this.gas.posy + 50 < posy_moto + 150) {
                    posy_moto -= 8;
                }

                this.ventana.lbl_moto.setLocation(posx_moto, posy_moto);

                this.ventana.moto_rect = this.ventana.lbl_moto.getBounds();

                if (this.ventana.moto_rect.intersects(this.ventana.gas_rect)) {

                    sleep(250);
                    this.ventana.lbl_gas.setBounds(this.gas.posx - 25, this.gas.posy - 25, 100, 100);

                    ImageIcon img = new ImageIcon(getClass().getResource("../imgs/eat.gif"));
                    Image nuevo = img.getImage().getScaledInstance(this.ventana.lbl_gas.getWidth(), this.ventana.lbl_gas.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon render = new ImageIcon(nuevo);

                    this.ventana.lbl_gas.setIcon(render);

                    this.ventana.repaint();
                    sleep(800);

                    // Realizar cambios en la interfaz de usuario dentro del hilo de eventos de Swing
                    SwingUtilities.invokeLater(() -> {
                        // Eliminar el componente del gas
                        this.ventana.remove(this.ventana.lbl_gas);
                        // Repintar la interfaz gráfica
                        this.ventana.repaint();
                        // Habilitar un botón en la interfaz gráfica
                        this.ventana.btn_give.setEnabled(true);
                    });

                    this.gas.stopThread();
                    stopThread();

                }

                this.ventana.repaint();

            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Moto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void stopThread() {
        running = false;
    }
}
