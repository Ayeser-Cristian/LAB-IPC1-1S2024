/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase8;

import java.io.Serializable;

/**
 *
 * @author coxla
 */

/**
 * La clase Animal implementa la interfaz Serializable para que los objetos de esta clase
 * puedan ser serializados, es decir, convertidos en una secuencia de bytes para ser
 * almacenados en un archivo.
 * 
 * Si o si debemos colocar "implements Serializable" si deseamos serealizar un objeto
 */

public class Animal implements Serializable{
    private String raza;
    private String nombre;
    private int edad;

    public Animal(String raza, String nombre, int edad) {
        this.raza = raza;
        this.nombre = nombre;
        this.edad = edad;
    }

    /**
     * @return the raza
     */
    public String getRaza() {
        return raza;
    }

    /**
     * @param raza the raza to set
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    
    public void preserme(){
        System.out.println("Nombre: "+this.nombre+" Raza: "+ this.raza+ " Edad: "+this.edad);
    }
}
