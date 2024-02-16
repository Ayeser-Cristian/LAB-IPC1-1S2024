/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo1;

//Para heredar los atributos y métodos de una clase usamos la palabra "extends"
//En este caso nuestra clase padre será "Persona" y nuestra clase hijo será "Estudiante".
//Al hacer la herencia, obtenemos todos los atributos y métodos que tiene la clase "Persona", en la clase "Estudiante". 
public class Estudiante extends Persona {

    //Atributos propios de la clase "Estudiante"
    private int carnet;
    private String carrera;

    //Constructor
    /*Al ser una clase que hereda atributos de la clase "Persona"
    en el constructor debemos solicitar los mismos parametros que en la clase "Persona" más los atributos propios de esta clase.
     */
    public Estudiante(String nombreEnviado, String apellido, int edad, char genero, double altura, int mi_carnet, String carrera) {
        //Esto hace referencia a que los atributos heredados de la clase "Persona" se están inicializando con los parametros solicitados.
        super(nombreEnviado, apellido, edad, genero, altura);
        //Estos son los atributos propos de esta clase, que se estan inicializando con los parametros solicitados.
        this.carnet = mi_carnet;
        this.carrera = carrera;
    }

    //----------------------INICIO DE MÉTODOS CREADOS PARA EL ENCAPSULAMIENTO--------------------------
    /**
     * @return the carnet
     */
    public int getCarnet() {
        return carnet;
    }

    /**
     * @param carnet the carnet to set
     */
    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    /**
     * @return the carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    //----------------------FIN DE MÉTODOS CREADOS PARA EL ENCAPSULAMIENTO--------------------------
    //Metodo
    /*
    Los métodos son acciones que puede realizar nuestra clase, básicamente, son procedimientos y funciones dentro de una clase.
     */
    
    //Método para ver que el estudiante diga si gano o perdió el curso, dependiendo de la nota que le manda como parametro.
    public void VerMiNota(int nota) {
        if (nota >= 61) {
            System.out.println("Yo: " + this.getNombre() + " gane el lab de IPC1, con: " + nota);
        } else {
            System.out.println("Yo: " + this.getNombre() + " perdí el lab de IPC1 :c, con: " + nota);
        }
    }

}
