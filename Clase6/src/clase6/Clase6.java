/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase6;

/**
 *
 * @author coxla
 */
import java.util.ArrayList;
import javax.swing.JFrame;

//Librería de LookAndFeel
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Clase6 {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<Ingeniero> listaInges = new ArrayList<>();

    public static void main(String[] args) {
        // TODO code application logic here

        listaInges.add(new Ingeniero("Juan Perez", "Civil"));
        listaInges.add(new Ingeniero("Pedro Perez", "Civil"));
        listaInges.add(new Ingeniero("Luis Gomez", "Sistemas"));
        listaInges.add(new Ingeniero("Luis Gomez 2", "Sistemas"));
        listaInges.add(new Ingeniero("Luis Gomez 3", "Sistemas"));
        listaInges.add(new Ingeniero("Pamela Lopez 1", "Industrial"));
        listaInges.add(new Ingeniero("Pamela Lopez 2", "Industrial"));
        listaInges.add(new Ingeniero("Daniel 1", "Quimica"));
        listaInges.add(new Ingeniero("Daniel 2", "Quimica"));
        listaInges.add(new Ingeniero("Chistopher 1", "Mecanica"));
        listaInges.add(new Ingeniero("Chistopher 2", "Mecanica"));
        listaInges.add(new Ingeniero("Messi", "Ambiental"));

        
        //Aplicando LookAndFeel (con colocarlo en el main lo aplica para todas las demas ventanas, sin necesidad de poner el try catch)
        JFrame.setDefaultLookAndFeelDecorated(true);

        try {

            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            Administrador vtn= new Administrador();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
