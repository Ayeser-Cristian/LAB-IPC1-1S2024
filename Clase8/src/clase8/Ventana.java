/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase8;

/**
 *
 * @author coxla
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Ventana extends JFrame implements ActionListener {

    public Ventana() {

        //Boton para cargar y leer archivos csv
        JButton btnAbrirArchivo = new JButton("Seleccionar CSV");
        btnAbrirArchivo.setBounds(60, 50, 200, 30);
        btnAbrirArchivo.addActionListener(this);
        this.add(btnAbrirArchivo);

        // Boton para serealizar
        JButton btnSerealizar = new JButton("Serealizar");
        btnSerealizar.setBounds(60, 100, 200, 30);
        btnSerealizar.addActionListener(this);
        this.add(btnSerealizar);

        //Boton parea escribir un archivo csv
        JButton btnCSV = new JButton("Escribir CSV");
        btnCSV.setBounds(60, 140, 200, 30);
        btnCSV.addActionListener(this);
        this.add(btnCSV);

        //Creacion de la ventana de inicio
        this.setTitle("Ventana");  // Título de la ventana
        this.setSize(500, 350);//Tamaño de la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        this.setLayout(null); // Diseño nulo (sin diseño predeterminado), para poder posicionar los componentes donde queramos
        this.setResizable(false);  // No permite redimensionar la ventana
        this.setLocationRelativeTo(null); //Despliega la ventana en el centro de la pantalla
        this.setVisible(true); // Hace visible la ventana

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Seleccionar CSV")) {
            // Se crea un objeto JFileChooser para permitir al usuario seleccionar un archivo.
            JFileChooser My_fileChooser = new JFileChooser();

            // Se crea un filtro de extensión de archivo para mostrar solo archivos CSV en el diálogo de selección de archivos.
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos CSV", "csv");

            // Se establece el filtro en el JFileChooser para que solo muestre archivos CSV.
            My_fileChooser.setFileFilter(filter);

            // Se muestra la ventana de diálogo para que el usuario seleccione un archivo.
            int seleccion = My_fileChooser.showOpenDialog(this);

            // Si el usuario selecciona un archivo y hace clic en "Aceptar" en el diálogo...
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                // Se obtiene el archivo seleccionado por el usuario.
                File archivoSeleccionado = My_fileChooser.getSelectedFile();

                // Se llama al método lecturaCSV de la clase Clase8 para leer y procesar el archivo CSV seleccionado.
                Clase8.lecturaCSV(archivoSeleccionado);
            }
            
        } else if (e.getActionCommand().equals("Escribir CSV")) {
            Clase8.EscribirCSV();
        } else if (e.getActionCommand().equals("Serealizar")) {
            Clase8.Serealizar();
        }
    }
}
