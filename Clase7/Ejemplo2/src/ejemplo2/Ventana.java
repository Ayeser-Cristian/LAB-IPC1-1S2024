/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

/**
 *
 * @author coxla
 */
public class Ventana extends JFrame implements ActionListener {

    JLabel lbl_moto, lbl_gas;

    JButton btn_give, btn_exit;

    ImagenFondo fondo_frame = new ImagenFondo();
    
    
    Rectangle moto_rect, gas_rect;
    
    public Ventana() {
        //Establecer fondo al Jframe
        this.setContentPane(fondo_frame);

        //Boton para empezar el hilo
        btn_give = new JButton("Give me Gas");
        btn_give.setBounds(650, 580, 130, 30);
        btn_give.setFont(new Font("Agency FB", Font.BOLD, 20));
        btn_give.setVisible(true);
        btn_give.addActionListener(this);
        this.add(btn_give);

        // Boton para terminar el programa
        btn_exit = new JButton("Exit");
        btn_exit.setBounds(500, 580, 130, 30);
        btn_exit.setFont(new Font("Agency FB", Font.BOLD, 20));
        btn_exit.setVisible(true);
        btn_exit.addActionListener(this);
        this.add(btn_exit);

        //Agregando moto a la ventana
        lbl_moto = new JLabel();
        lbl_moto.setBounds(40, 400, 150, 150);

        ImageIcon img = new ImageIcon(getClass().getResource("../imgs/moto.gif"));
        Image nuevo = img.getImage().getScaledInstance(lbl_moto.getWidth(), lbl_moto.getHeight(), Image.SCALE_DEFAULT);
        ImageIcon render = new ImageIcon(nuevo);
        lbl_moto.setIcon(render);
        lbl_moto.setVisible(true);
        this.add(lbl_moto);
        
        
        moto_rect= lbl_moto.getBounds();
        
        
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        lbl_moto.setBorder(border);
        
        
        //Creación de ventana
        this.setTitle("Looking for gas");
        this.setLayout(null);
        this.setSize(800, 650);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_give) {
            
            Gas get_gas= new Gas(this);
            get_gas.start();
            
        } else if (e.getSource() == btn_exit) {
            // Si se hace clic en el botón de salida, se cierra la aplicación
            System.exit(0);
        }
    }

    class ImagenFondo extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {

            imagen = new ImageIcon(getClass().getResource("../imgs/fondo.gif")).getImage();

            // Dibuja la imagen en el panel en las coordenadas (0, 0) con el ancho y altura del panel
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            // Establece el panel como transparente para que la imagen de fondo sea visible
            setOpaque(false);
            // Llama al método paint de la clase padre para completar el proceso de pintado
            super.paint(g);
        }

    }
}
