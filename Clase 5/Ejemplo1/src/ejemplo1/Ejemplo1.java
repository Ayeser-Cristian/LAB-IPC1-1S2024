package ejemplo1;

/**
 *
 * @author coxla
 */
import java.util.ArrayList;

public class Ejemplo1 {

    public static ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
    public static int  contador=1;
    public static void main(String[] args) {

        
        Login vtn_login= new Login();
        
    }
    
    public static Object[][] convertirDatosEstudiantes_tabla(){
        int filas= listaEstudiantes.size();
        Object[][] arreglo = new Object[filas][5];
        
        for (int i = 0; i < filas; i++) {
                Estudiante temp_estudiante= listaEstudiantes.get(i);
                
                arreglo[i][0]=temp_estudiante.getCodigo();
                arreglo[i][1]=temp_estudiante.getNombre();
                arreglo[i][2]=temp_estudiante.getApellido();
                arreglo[i][3]=temp_estudiante.getCorreo();
                arreglo[i][4]=temp_estudiante.getGenero();
                
        }
        
        return arreglo;
    
    }
    
    
    public static void agregarEstudiante(int codigo, String nombre, String apellido, String correo, String genero){
        
      
        
        listaEstudiantes.add(new Estudiante(codigo, nombre, apellido, correo, genero));
    }
}
