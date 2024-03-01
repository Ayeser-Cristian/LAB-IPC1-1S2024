package clase6;

/**
 *
 * @author coxla
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Librerías para usar ArrayListA, Map y hacer el ordenamiento
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

//Librerías para poder gráficar
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

public class Administrador extends JFrame implements ActionListener {

    public Administrador() {

        // Crear un objeto JTabbedPane para gestionar pestañas
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

        // Crear tres paneles para las pestañas
        JPanel pest1 = new JPanel(null); //Se coloca null para tener control en la posicion de los elemntos en la pestaña
        JPanel pest2 = new JPanel(null);
        JPanel pest3 = new JPanel(null);

        // Agregar los paneles a las pestañas del JTabbedPane
        tabbedPane.addTab("Estudiantes", pest1);
        tabbedPane.addTab("Doctor", pest2);
        tabbedPane.addTab("Pestaña 3", pest3);

        //============================Vista Estudiantes==================================0
        //============================Vista Doctor==================================
        //Elementos de la grafica especialidad
        DefaultCategoryDataset datos_Especialidad = new DefaultCategoryDataset();

        Map<String, Integer> especialidades = new HashMap();

        //for each
        // Contar la cantidad de especialidades
        for (Ingeniero inge_x : Clase6.listaInges) {

            String espec = inge_x.getEspecialidad();

            if (especialidades.containsKey(espec)) {
                // Incrementar el contador si la especialidad ya está en el mapa
                especialidades.put(espec, especialidades.get(espec) + 1);
            } else {
                // Agregar la especialidad al mapa con contador 1 si no existe
                especialidades.put(espec, 1);
            }

        }

        // Ordenar el mapa por valores (número de especialides)
        //Pasamos el anterior map a un ArrayList
        List<Map.Entry<String, Integer>> listaOrdenada = new ArrayList<>(especialidades.entrySet());
        //Ordenamos la lista del número mayor al menor
        //Collections.sort(lista que vamos a ordenar, Comparator.comparing(Que valor vamos a tomcar para ordenar, ordenarlo de mayor a menor) )
        Collections.sort(listaOrdenada, Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));

        // Agregar las primeras 5 especialidades al gráfico
        int contador = 0;
        for (Map.Entry<String, Integer> dato_mapa : listaOrdenada) {
            contador++;
            //                         (valor que va a tener en la grafica, especialidad, especialidad)
            datos_Especialidad.addValue(dato_mapa.getValue(), dato_mapa.getKey(), dato_mapa.getKey());

            if (contador == 5) {
                break;
            }

        }
        //Creando Grafica
        JFreeChart graficaEspecialidad = ChartFactory.createBarChart(
                "Top 5 de Ingenierías", //Titulo grafica
                "Especialidad", //Titulo eje X
                "Cantidad", //Titulo eje Y
                datos_Especialidad //datos utilizado para construir el gráfico
        );

        // Cambiar la orientación de las etiquetas en el eje X a vertical
        CategoryPlot plot_xd = graficaEspecialidad.getCategoryPlot();
        CategoryAxis xAxis = plot_xd.getDomainAxis();
        xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

        // Crear un panel para mostrar el gráfico
        ChartPanel chartPanel = new ChartPanel(graficaEspecialidad);
        chartPanel.setBounds(1000, 350, 400, 400);
        pest2.add(chartPanel);

        //==================================================================================0
        // Agregar el JTabbedPane al contenido del JFrame
        getContentPane().add(tabbedPane);
        this.setExtendedState(MAXIMIZED_BOTH);  // Hacer que la ventana se abra maximizada
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la aplicación al cerrar la ventana
        this.setResizable(false); // Deshabilitar la capacidad de cambiar el tamaño de la ventana
        this.setVisible(true); // Hacer la ventana visible

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
