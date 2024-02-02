/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo1;

/**
 *
 * @author coxla
 * 
 */

import java.util.ArrayList;
public class Ejemplo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Arreglos:
            Es un objeto que almacena una colección de elementos del mismo tipo. Estos elementos pueden ser variables 
            primitivas o no primitivos.
        */
        
        /* Arreglos ARREGLOS UNIDIMENSIONALES: 
            Podemos decir que es una variable que almacena en una lista varios valores (del mismo tipo), cada vez que agregamos
            un nuevo elemento al arreglo  lo guardará en un indíce diferete.
        */

        //-------------------DECLARACIÓN DE ARREGLOS UNIDIMENSIONALES------------
        
        /*
        Para declarar un arreglo es:
        TipoDato NombreArreglo = new TipoDato[ tamaño ];
        */
        //Declarando un arreglo de tipo int, con tamaño 8
        int[] notas = new int[8];

        // Declarando arreglo de tipo double, con tamaño 10
        double[] decimales = new double[10];

        //Declarando un arreglo de tipo String, con tamaño 5
        String[] nombres = new String[5];
        /*        
        La ventaja de usar un arreglo es que podemos tener una variable para guardar varios datos, en vez de hacer lo siguiente:
            String nombre1;
            String nombre2;
            String nombre3;
            String nombre4;
            String nombre5;
        */

        //-------------------GUARDAR VALORES EN ARREGLOS UNIDIMENSIONALES------------
        /*
            Cabe mencionar que los arreglos tienen índices, los cuales inician desde el 0.
            Es decir, cuando declarammos el arreglo "notas" con tamaño 8, sus índices serían de:
            0, 1, 2, 3, 4, 5, 6, 7. 
            
            Entonces  la posicion y el indice son distinto.
                Indice: Numero con el que accedemos a la posicion.
                Posicion: El elemento que queremos acceder
            valor de indice = posicion - 1;
            
            Por ejemplo, si queremos guardar un valor 12 en la posición 1 del arreglo "notas",
            entonces hacemos lo siguiente para ver cúal es el índice
            valor de indice = posicion - 1;
            valor de indice = 1 - 1;
            valor de indice = 0;
        */
         /*
        Para guardar una posicion en especifico es: NombreArreglo[indice] = valor;
        */
        //Guardando el valor de 12 en el arreglo "notas" en la posición 1 e índice 0 (El valor debe de ser del mismo tipo que el tipo del arreglo.)
        notas[0] = 12;
        
        //Guardando el valor de 30 en el arreglo "notas" en la posición 8 e índice 7
        notas[7] = 30;
        
        //Guardando el valor de "Cristian" en el arreglo "nombres" en la posición 2 e índice 1
        nombres[1] = "Cristian";

        // "--------VER VALORES GUARDADOS EN UN ARREGLO-------"
        System.out.println("----------VER VALORES GUARDADOS EN EL ARREGLO-------");
        //Obtenemos el tamaño del arreglos, usaremos el método "length" que tienen los arreglos
        System.out.println("El tamanio del arreglo notas es: " + notas.length);

        //Accediendo a un índice en específico del arreglo "notas"
        System.out.println("Imprimiendo índice 0 de notas:" + notas[0]);
        
        //Accediento a toodos los índices del arreglo "notas"
        System.out.println(" -Imprimiendo arreglo notas: ");
        //Podemos acceder a todos los índices del arreglo usando un for
        //Indícamos que el interador "i" del ciclo for ínicie en 0, ya que recordemos que los índices de los arreglos inician en 0
        //Ponemos la condición de que el ciclo terminé cuando el intereador "i" sea menor que el tamaño del arreglo.
        // La anterior condición la colocamos porqué recordemos que aúnque notas tenga un tamaño de 8, su índice llega hasta 7.
        for (int i = 0; i < notas.length; i++) {
            System.out.print("[" + notas[i] + "]"); // Lo que sucede aquí es esto: notas[0], pero al "i" ir aumentando, irá accediento a cada índice.
        }

        //-----------------ARREGLOS DIBIMENCIONALES (MATRICES-----------------
        /*
        Los arreglos Dibimencionale cuentan con dos dimenciones, es decir, tiene filas y columnas,
        lo podemos imaginar como una matriz.
        
        Cabe destacar que en java hay matrices de varias dimensiones, pero para el curso solo usaremos de
        dos dimensiones (dibimencionales).
        
        Para declarar un arreglo dibimencionales podemos hacer:
        TipoDato[][] NombreArreglo = new TipoDato[filas ] [ columnas ];
        */
        
        //Declarando un arreglo dibimencional, con 3 filas y 4 columnas
        int[][] matriz = new int[3][4]; // [filas][columnas]
        //GUARDANDO VALORES EN EL ARREGLO DIBIMENCIONAL
        
        /* Aquí también se usan los índices, y siempre se inicia el conteo desde 0, es decir:
            - Declaramos un arreglo dibimencional llamado "matriz"
            - Se declaró con un tamanio de 3 filas, por lo cual sus indices serían:
                    0, 1, 2
            - Se declaró con un tamanio de 4 columnas, por lo cual sus indices serían:
                    0, 1, 2, 3
        
           Por lo cual,  recordemos que si queremos guardar algo en una determinada posición
           debemos restarle -1 como se hizo en los arreglos unidimencionales.
        */
        /* Por ejemplo, si deseamos guardar en la matriz el valor 5, en la posición de la matriz [1,4]=[fila, columna]
           Entonces debemos restar a cada posición -1, para obtener el índice, por lo cual lo que usaremos será [0, 3]
        */
        
        //Llenando la matriz
        //Declarando el valor 0 en índice (0, 0)
        matriz[0][0] = 0;
        //Declarando el valor 1 en índice (0, 1)
        matriz[0][1] = 1;
        matriz[0][2] = 2;
        matriz[0][3] = 3;
        matriz[1][0] = 4;
        matriz[1][1] = 5;
        matriz[1][2] = 6;
        matriz[1][3] = 7;
        matriz[2][0] = 8;
        matriz[2][1] = 9;
        matriz[2][2] = 10;
        matriz[2][3] = 11;
        System.out.println("");
        
        // "--------VER VALORES GUARDADOS EN LA MATRIZ-------"
        System.out.println("------------VER VALORES GUARDADOS EN LA MATRIZ---------------");
        
        //Accediendo a un índice en específico de la matriz
        System.out.println("Imprimiendo indice [1][2]: " + matriz[1][2]);
        System.out.println("Imprimiendo matriz: ");
        
        //Podemos acceder a todos los índices del arreglo usando dos for, el uno para recorrer las filas y otro para recorrer las columnas
        //El primer for servirá en este caso para imprimir las filas
        //Cuando usamos "matriz.length" estamos obteniendo el tamaño de las filas, en este caso el tamaño es de 3
        for (int i = 0; i < matriz.length; i++) {
            //El segundo for servirá en este caso para imprimir las columnas
            //Cuando usamos "matriz[i].length" estamos obteniendo el tamaño de las columnas en la fila que nos encontramos
            //En este caso el tamaño de las columnas es de 4
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "]");
                //Lo que sucede aquí es, por ejemplo: matriz[0][2], donde "i" es la fila y "j" la columna
                //Cabe destacar que "i" no aumenta hasta que termine este for.
                //Mientras que "j" si irá aumentando, ya que es el encargado de ir recorriendo las columnas
                //Al momento de que "i" aumente y se ingrese a este for de nuevo, "j" volverá a valer 0.
            }
            //Un salto de línea para ir ordenando cada fila
            System.out.println("");
        }
        
        System.out.println("-------------RECORRIDO VERTICAL-----------------------");
        //Anteriormente se imprimió la matriz recorriendo primero cada fila (qué es lo más común)
        //Pero tambien podemos ir recorriendo por columnas, lo único que tenemos que hacer es invertir el for anidado que hicimos anteriomente
        //En este caso ponemos "matriz[0].length" para obtener el tamaño de las columnas, que en este caso es de 4, cabe destacar que usamos el índice
        //0 para obtener el tamaño, ya que el tamaño de las columnas para los otros índices es el mismo.
        for (int i = 0; i < matriz[0].length ; i++) {
            //Aquí al usar "matriz.length" obtenemos el tamaño de las filas
            for (int j = 0; j < matriz.length; j++) {
                System.out.print("["+matriz[j][i]+"]");
            }
            System.out.println("");
        }
        
        
        System.out.println("----------LISTAS DINAMICAS (NO SE PUEDEN USAR EN ESTE CURSO :c)----------");
        //CABE ACLARRAR QUE ESTAS LITAS DINAMICAS DE JAVA NO ESTAN PERMITIDAS PARA ESTE CURSO
        //-----------LISTAS DINAMICAS----------
        // Crear una lista dinámica de int
        //ArrayList<Integer> listaDinamicaEnteros= new ArrayList();
        
       
        // Crear una lista dinámica de String
        ArrayList<String> listaDinamica= new ArrayList();
        
        //Agregar elementos a la lista dinamica
        //Estos se iran agregando uno tras otro y el índice irá aumentando, es decir:
        //Lo agregar en el índice 0
        listaDinamica.add("Valor 1");
        //Lo agregar en el índice 1
        listaDinamica.add("Valor 2");
        //Lo agregar en el índice 2
        listaDinamica.add("Valor 3");
        
        //Accediento al valor agregado en el índice 1 : listaDinamica.get("Colocamos el índice al que queremos acceder")
        System.out.println("Imprimiendo índice 0: "+listaDinamica.get(1));
        System.out.println("Imprimiendo lista completa: "+listaDinamica);
        
        //Eliminando  al valor agregado en el índice 0 : listaDinamica.get("Colocamos el índice al que queremos eliminar")
        listaDinamica.remove(0);
        //Imprimiendo lista luego de eliminar un valor
        System.out.println("Imprimiendo lista completa: "+listaDinamica);
    }

}
