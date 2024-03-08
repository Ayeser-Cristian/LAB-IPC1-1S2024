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
import java.util.Random;
import javax.swing.border.Border;

public class Gas extends Thread {

    private volatile boolean running = true;

    Ventana ventana;
    int posx, posy;
    Moto moto;

    public Gas(Ventana _vtn) {
        this.ventana = _vtn;

        // Genera posiciones aleatorias para el objeto Gas
        Random random = new Random();
        this.posx = random.nextInt(625) + 10;
        this.posy = random.nextInt(200) + 380;

        // Crea un nuevo JLabel para representar el objeto Gas
        this.ventana.lbl_gas = new JLabel();
        this.ventana.lbl_gas.setBounds(this.posx, this.posy, 50, 50);

        // Carga la imagen de la gasolina y la ajusta al tamaño del JLabel
        ImageIcon img = new ImageIcon(getClass().getResource("../imgs/gasolina.png"));
        Image nuevo = img.getImage().getScaledInstance(this.ventana.lbl_gas.getWidth(), this.ventana.lbl_gas.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon render = new ImageIcon(nuevo);

        this.ventana.lbl_gas.setIcon(render);

        // Crea un borde para el JLabel
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        // Asigna el borde al JLabel
        this.ventana.lbl_gas.setBorder(border);
        this.ventana.add(this.ventana.lbl_gas);

        // Actualiza los límites del objeto Gas en el juego
        this.ventana.gas_rect = this.ventana.lbl_gas.getBounds();

        // Repinta la ventana
        this.ventana.repaint();

    }

    public void run() {
        // Crear un nuevo objeto Moto e inicar el hilo
        moto = new Moto(this.ventana, this);
        moto.start();

        try {
            while (running) {

                // Mientras el hilo está en ejecución, deshabilita el botón "Give me Gas"
                this.ventana.btn_give.setEnabled(false);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Método para detener el hilo
    public void stopThread() {
        running = false;
    }
}
