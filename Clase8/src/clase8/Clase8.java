/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase8;

import java.io.File; // Proporciona la clase File que representa un archivo o directorio en el sistema de archivos.
import java.io.FileInputStream; // Proporciona la clase FileInputStream que se utiliza para leer datos de un archivo como una secuencia de bytes.
import java.io.FileNotFoundException; // Proporciona la excepción FileNotFoundException que se lanza cuando no se encuentra un archivo
import java.io.FileOutputStream; // Proporciona la clase FileOutputStream que se utiliza para escribir datos en un archivo como una secuencia de bytes.
import java.io.IOException; // Proporciona la excepción IOException que se lanza cuando ocurre un error durante la lectura o escritura de datos.
import java.io.ObjectInputStream; // Proporciona la clase ObjectInputStream que se utiliza para deserializar objetos desde un flujo de entrada.
import java.io.ObjectOutputStream; // Proporciona la clase ObjectOutputStream que se utiliza para serializar objetos a un flujo de salida.
import java.io.PrintWriter; // Proporciona la clase PrintWriter que se utiliza para escribir texto formateado a un flujo de salida.
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author coxla
 */
public class Clase8 {

    static ArrayList<Animal> animals = new ArrayList<Animal>();

    public static void main(String[] args) {

        /*
            Lo primero que debemos hacer al iniciar el programa es ver si hay datos serealizados previamente,
            si los hay, deserializamos y los cargamos a memoria (las listas) para simular que los datos permanecen.
         */
        // Se intenta deserializar los datos de animales desde un archivo
        animals = (ArrayList<Animal>) Deserealizar();

        // Si se logra deserializar, se muestran los datos obtenidos
        if (animals != null) {
            System.out.println("Existen datos para deserealizar");
            for (Animal animal_x : animals) {
                animal_x.preserme();
            }
        } else {
            // Si no se logra deserializar, se muestra un mensaje indicando que no hay datos
            System.out.println("Aun no existe un archivo para deserealizar");

            //Volvemos a inicar nuestra Lista de "animals", debido a que si entra a esta parte del código, se le asignó
            //un null por intentar deserializar, por lo cual es necesario iniciarla de nuevo
            animals = new ArrayList<Animal>();
        }

        Ventana vtn = new Ventana();
    }

    public static void lecturaCSV(File archivo_csv) {
        try {
            Scanner lector = new Scanner(archivo_csv); // Crear un objeto Scanner para leer el archivo CSV

            boolean encabezado = true; // Bandera para identificar si la línea actual es el encabezado
            while (lector.hasNextLine()) { // Iterar sobre cada línea del archivo

                String linea = lector.nextLine(); // Leer la próxima línea del archivo

                if (encabezado == false) { // Si no es el encabezado

                    // Separar los datos de la línea por comas y almacenarlos en un array
                    String[] datos = linea.split(","); // Ejemplo: ["id", "nombre", "raza", "edad"]

                    // Imprimir el contenido de la línea del archivo
                    for (String parte : datos) {
                        System.out.print(parte + "\t" + "| " + "\t"); // Imprimir cada parte separada por una barra vertical
                    }
                    System.out.println(""); // Imprimir una nueva línea

                    // Crear un nuevo objeto Animal con los datos de la línea y añadirlo a la lista de animales
                    Animal nuevo = new Animal(datos[2], datos[1], Integer.valueOf(datos[3])); // datos[2] es la raza, datos[1] es el nombre y datos[3] es la edad
                    animals.add(nuevo);
                }
                encabezado = false; // Después de procesar el encabezado, establecer la bandera en falso
            }
            lector.close(); // Cerrar el lector de archivos CSV

            System.out.println("------------------------------------------");
            System.out.println("Imprimiendo lista de animales: ");

            // Imprimir la lista de animales
            for (Animal x : animals) {
                x.preserme(); // Llamar al método "preserme" de cada objeto Animal para imprimir sus detalles
            }
        } catch (FileNotFoundException ex) { // Manejar la excepción si no se encuentra el archivo
            ex.printStackTrace(); // Imprimir el rastreo de la pila de la excepción
        }
    }

    public static void EscribirCSV() {
        String direccionFile = "./Archivos/ListaAnimales.csv"; // Ruta del archivo CSV a escribir
        try (PrintWriter writer = new PrintWriter(new File(direccionFile))) { // Crear un objeto PrintWriter para escribir en el archivo
            writer.println("id,nombre,raza,edad"); // Escribir la línea de encabezado en el archivo CSV

            int cont = 0; // Inicializar un contador para el identificador de cada animal

            for (Animal x : animals) { // Iterar sobre la lista de animales
                // Crear una cadena de datos para el animal actual en el formato "id,nombre,raza,edad"
                String dato = Integer.toString(cont) + "," + x.getNombre() + "," + x.getRaza() + "," + Integer.toString(x.getEdad());

                writer.println(dato); // Escribir la cadena de datos en una nueva línea del archivo CSV

                cont++; // Incrementar el contador para el siguiente animal
            }
            System.out.println("Archivo creado exitosamente");
        } catch (FileNotFoundException e) { // Manejar la excepción si no se puede encontrar o crear el archivo

            e.printStackTrace(); // Imprimir el rastreo de la pila de la excepción
        }
    }

    public static void Serealizar() {
        // Crear algunos objetos Animal para serializar
        Animal animal1 = new Animal("Labrador", "Mike", 12);
        Animal animal2 = new Animal("Pastor aleman", "Max", 5);
        Animal animal3 = new Animal("Chihuahua", "Jinx", 9);

        // Agregar los objetos a la lista de animales
        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);

        //Aquí iniciamos la serealizacion
        try {
            String direccionFile = "./Archivos/AnimalesSerial.bin"; // Ruta del archivo binario para guardar los datos serializados

            // Crear un objeto ObjectOutputStream para escribir los objetos en el archivo binario
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(direccionFile));

            // Escribir la lista de animales en el archivo binario, notese que es la lista que contiene objetos 
            //de la clase "Animal", la cual se le implemento "implements Serializable"
            salida.writeObject(animals);

            salida.close(); // Cerrar el ObjectOutputStream

            System.out.println("Serialización exitosa");
        } catch (IOException e) { // Manejar la excepción si hay algún error de E/S
            e.printStackTrace(); // Imprimir el rastreo de la pila de la excepción
        }
    }

    public static Object Deserealizar() {
        try {
            String direccionGet = "./Archivos/AnimalesSerial.bin"; // Ruta del archivo binario que contiene los datos serializados

            // Crear un objeto ObjectInputStream para leer los objetos del archivo binario
            ObjectInputStream getAnimals = new ObjectInputStream(new FileInputStream(direccionGet));

            // Leer la lista de animales del archivo binario y convertirla en un objeto ArrayList de Tipo "Animal"
            ArrayList<Animal> lista_momentanea = (ArrayList<Animal>) getAnimals.readObject();

            getAnimals.close(); // Cerrar el ObjectInputStream
            System.out.println("Lista de animales obtenida de deserialización"); 
            return lista_momentanea; // Devolver la lista de animales deserializados

        } catch (Exception e) { // Capturar cualquier excepción que ocurra durante el proceso de deserialización
            System.out.println(e.getMessage()); // Imprimir el mensaje de error
        }

        return null; // Devolver null si no se logro hacer la deserialización
    }
}
