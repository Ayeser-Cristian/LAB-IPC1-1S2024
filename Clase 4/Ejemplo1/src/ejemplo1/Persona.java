/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo1;

/**
 *
 * @author coxla
 */
public class Persona {

    //ATRIBUTOS (Son las carácteristicas más importantes de nuestra clase)
    private String nombre;
    private String apellido;
    private int edad;
    private char genero;
    private double altura;

    //CONSTRUCTOR
    /*
    El constructor podemos decir que es un método que se ejecuta cuando nosotros creamos una nueva instancia/objeto,
    generalmente se usa para colocarle valores iniciales a los atributos que tiene la clase. Los valores iniciales son
    solicitados por medio de parametros al momento de crear la nueva instancia/objeto. 
     */
 /*
    HACK PARA CREAR CONSTRUCTOR EN NEATBEANS:
        - CTRL + Barra espaciadora
        - Nos desplegara varias opciones (ver cual es el constructor)
        - Seleccionamos el constructor (normalmente es la segunda opción) y damos click
     */
    public Persona(String nombre, String apellido, int edad, char genero, double altura) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.altura = altura;
    }

    //ENCAPSULAMINETO
    /*
        Se recomienda colocar los atributos de forma private, para que solo puedan ser accedidos 
        de forma directa en esta clase.
    
        Sim embargo, para poder acceder a los abributos desde otro lado que no sea esta clase, podemos
        utilizar el encapsulamiento, el cual creará métodos para cada atributo para que puedan ser accedidos 
        a los atributos a pesar de que estén privados.
   
        Para que NetBeans realice el encapsulamiento automaticamente, vamos a seleccionar
        nuestras variables.
    
        Click izquierdo -> Refactor -> Encapsulate Fields
    
        Esto nos hara el encapsulado de manera automatica y generara los metodos
        necesarios para acceder a la informacion por medio de metodos.
        
     */
    //----------------------INICIO DE MÉTODOS CREADOS PARA EL ENCAPSULAMIENTO--------------------------
    // Los metodos GET sirven para obtener el valor de la variable que tenemos como private.
    public String getNombre() {
        return nombre;
    }

    //Los metodos SET sirven para modificar un valor en la variable que tenemos como private.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the genero
     */
    public char getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(char genero) {
        this.genero = genero;
    }

    /**
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    //----------------------FIN DE MÉTODOS CREADOS PARA EL ENCAPSULAMIENTO--------------------------
    // METODOS
    /*
    Los métodos son acciones que puede realizar nuestra clase, básicamente, son procedimientos y funciones dentro de una clase.
     */
    
    //Método hablar(), recibe un String como parametro y lo imprime.
    public void hablar(String mensaje) {
        System.out.println("Estoy diciendo: " + mensaje);
    }

    //Método de la clase que imprime los atributos que tiene.
    public void Presentarme() {
        System.out.println("-------------------------------------------");
        System.out.println("Mi Nombre es: " + this.nombre);
        System.out.println("Mi edad Edad es: " + this.edad);
        System.out.println("Mido: " + this.altura + " (m)");
        System.out.println("-------------------------------------------");
    }

}
