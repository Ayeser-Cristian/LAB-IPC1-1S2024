/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo1;

/**
 *
 * @author coxla
 */
public class Ejemplo1 {
//nfkjvf
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*DECLARACIÓN DE OBJETO
        La forma de declarar un objeto es de la siguiente forma:
            NombreClase variable = new NombreClase();
         */
        System.out.println("Holaaaaaaaaaaaaaaa");

        //Creando una instanacia de la clase "Persona", es decir, un objeto
        //Creando Objeto 1
        System.out.println("=============PERSONA 1=================");
        //Para crear el objeto llenamos los parametros que solicitamos en el costructor de la clase,
        //lo cual sirve para ponerle valores iniciales a sus atributos.
        Persona perso_1 = new Persona("Maria", "Morales", 20, 'F', 1.70);

        //Podemos acceder a sus métodos creados en la clase de la siguiente forma: 
        perso_1.hablar(" Hola, estoy hablando");

        //Podemos acceder a los atributos de la clase de la siguient forma:
        System.out.println("Nombre de Perso_1: " + perso_1.getNombre());
        /*
        Cabe mencionar que podemos acceder a sus atributos de la siguiente forma, si en dado caso los dejaramos publicos:
        System.out.println("Nombre de Perso_1: "+ perso_1.nombre);
        
        Pero se recomienda poner los atributos privados y hacer el encapsulamineto (métodos get y set)
         */

        //Podemos modificar los atributos de la clase de la siguient forma:
        perso_1.setNombre("Belen");

        /*
        Cabe mencionar que podemos modificar sus atributos de la siguiente forma, si en dado caso los dejaramos publicos:
        perso_1.nombre="Belen";
        
        Pero se recomienda poner los atributos privados y hacer el encapsulamineto (métodos get y set)
         */
        //Imprimos el nombre ya modificado
        System.out.println("Nombre de Perso_1: " + perso_1.getNombre());

        //Aquí estamos llamando otros de sus métodos
        perso_1.Presentarme();

        System.out.println("=============PERSONA 2=================");
        //Creando Objeto 2
        //De la misma clase vamos a crear otra instancia, pero ahora los atributos tendrán diferentes valores
        //Pensemos que ahora tenemos dos personas diferentes creados por el molde de la clase "Persona"

        //Para crear el objeto llenamos los parametros que solicitamos en el costructor de la clase,
        //lo cual sirve para ponerle valores iniciales a sus atributos.
        Persona perso_2 = new Persona("Luis", "Lopez", 25, 'M', 1.72);
        
        //Llamando método de la persona 2 para que se presnete
        perso_2.Presentarme();

        System.out.println("=============ESTUDIANTE 1=================");
        
        //Ahora tenemos otra clase, una clase llamada "Estudiante"
        //Recordemos que para fines de ejemplo esta clase hereda los atributos y métodos que tiene la clase "Persona"
        Estudiante student_1 = new Estudiante("Cristian", "Apellido", 23, 'M', 1.66, 202010025, "Sistemas");

        //A pesar de que este método "Presentarme()" no existe en la clase "Estudiante", podemos usarlo, ya que como se mencionó
        //la clase "Estudiante" hereda los atributos y métodos de la clase "Persona", en la cual se encuentra el método "Presentarme()".
        student_1.Presentarme();
        
        //Llamamos el método "VerMiNota()" de la clase Estudiante.
        student_1.VerMiNota(65);
    }

}
