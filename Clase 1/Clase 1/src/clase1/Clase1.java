package clase1;

/*
    Importante:
        * Todas las instruciones finalizan con ";"
 */

 /*Esta es la clase (más adelante veremos qué es una clase en programación)principal,
la cual se crea con el nombre que le asigamos al proyecto al momento de iniciar.
 */
public class Clase1 {

    /*
    El método "main" es la principal. Este método es el primero que se ejecuta 
    al correr el programa.
     */
    public static void main(String[] args) {
        /*
            Este es un comentario de 
            muchas líneas.
         */

        //Este es un comentario de una línea
        /*
        - Una variable es un espacio de almacenamiento con un nombre 
        asociado que se utiliza para representar y manipular datos en un programa.
        - Un identificador es el nombre que le asignamos a una variable.
        - Importante:
            * Un identificador no puede llevar caracteres especiales
            * Un identificador debe iniciar siempre con una letra o un "_", no con números
            * Un identificador puede llevar letras, números y "_"
        - Ejemplos de identificadores CORRECTOS:
            * variable1
            * Variable_2
            * _Variable1_2
        
       - Ejemplos de identificadores INCORRECTOS:
            * 1variable -- No puede iniciar con un número
            * Variable_#2 -- No puede llevar caracteres especiales
 
         */
        //-------DECLARACIÓN DE VARIABLES SIN INICIALIZAR-------
        // Esta variable la declaramos, sin embargo, no le asignamos ni un valor.
        int variable_1;
        // Para asignarle un valor simplemente llavamos la variable y le asignamos un valor
        variable_1 = 8;
        //-------DECLARACIÓN DE VARIABLES INICIALIZADAS-------
        //Podemos asignarle un valor a la variable desde que la declaramos
        int variable_2 = 2;
        //De igual forma podemos ir modificando el valor de la variable aunque que inicializamos
        //siempre llamandolo por su identificador y asignandole el nuevo valor
        variable_2 = 10;

        //--------IMPRESIÓN DE DATOS EN CONSOLA---------------
        /*Hack: Para no tener que escribir la instrucción completa de imprimir, podemos hacer lo siguiente:
            - Escribir: sout
            - Precionar la tabla de tabulación
        Esto hará que se escriba la instrucción completa para imprimir
         */
        //Imprimimos una cadena de caracteres (texto), el cual siempre debemos colocarlo dentro de comillas. 
        System.out.println("--------Imprimiendo variables----------"); //Imprime el valor de expresion con un salto de linea al final 

        //Imprimimos el valor que tiene la variable "variable_1", el cual tiene un valor de 8
        System.out.println(variable_1); //Imprime el valor de expresion con un salto de linea al final 

        //Imprimimos el valor que tiene la variable "variable_2", el cual tiene un valor de 10, ya que fue el último que se le asigno.
        System.out.print(variable_2); //Imprime el valor, sin un salto de línea

        System.out.println("");//Solo da un salto de línea

        //-----------TIPOS DE DATOS EN JAVA------
        //-> Datos Primitivos:Se refiere a un tipo de dato básico que no es derivado de ningún otro tipo.
        //LOS SIGUIENTES TIPOS DE DATOS CASI NO LOS USAREMOS:
        // Almacena números enteros del -128 al 127
        byte valorByte = 127;

        // Alamacena números enteros del -32768 al 32767
        short valorShort = 5000;

        // Almacena valores enteros negativos y positivos.
        long ValorLong = 80000L; // La "L" indica que el valor es de tipo long.

        // Almacena números decimales negativos y positivos.
        float valorFloat = 42.551f; // La "f" indica que el valor es de tipo float.

        // LOS SIGUIENTES  TIPOS DE DATOS PRIMITIVOS SON LOS QUE USAREMOS USUALMENTE:
        // Almacena valores enteros negativos y positivos.
        int valorEnteroP = 1000;
        int valorEnteroN = -1000;

        // Almacena números decimales negativos y positivos.
        double valorDoubleP = 4725.58;
        double valorDoubleN = -4725.58;
        double valorDouble2N = 10;

        // Almacena  solo un  carácter.
        char valorChar = 't';

        // Almacena valores de verdadero o falso.
        boolean valorBoolFalso = false;
        boolean valorBoolTrue = true;

        //-> Datos No Primitivos: Se refiere a un tipo que no almacena directamente el valor, sino que almacena una referencia a un objeto en memoria.
        //El String almacena una cadena de carácteres, en otras palabras, almacena texto.
        String cadena = "El String es un tipo de Dato no primitivo";

        /*Una forma de indentificar un tipo de dato Primitivo y no Primitivo, es viendo si al declarar el tipo este inicia con mayúscula
        o minúscula. 
            - Si empieza con minúscula es Primitivo.
            - Si empieza con mayúscula es No Primitivo
        Otros datos no primitivos son: los arreglos, los objetos, las clases, etc. Estos los veremos en las siguientes clases.
         */
        //-----------CASTEOS EN JAVA------
        System.out.println("--------Casteo Implicito----------");
        //-> Casteo Implícito: Los hace el programa aútomaticamente
        int numeroEntero = 10;
        double numeroDecimal;

        /*Aquí se realiza un casteo Implícito, ya que el compilador 
       de forma automatica pasa el valor entero a un valor decimal, ya que no detecta
       que no hay riesgos de perder datos. Es decir:
          - La variable "numeroEntero" tiene almacenado un entero con valor = 10;
          - Luego le decimos al programa que en la variable "numeroDecimal" se guarde el valor de "numeroEntero", es decir 10.  (numeroDecimal = numeroEntero;)
          - La variable "numeroDecimal" almacena solo decimales, pero al recibir un número entero de la variable "numeroEntero", el programa detecta que no hay perdida
            de datos si se realiza esto, ya que para pasar a 10 a decimal solo debe agregar un punto, es decir 10.0
         */
        numeroDecimal = numeroEntero;
        System.out.println(numeroDecimal);

        /*
        Si intentemos hacerlo alrevés, es decir:
            int numeroEntero;
            double numeroDecimal=10.5;
            numeroEntero = numeroDecimal;
        Esto genera un error, ya que el compilador detecta que pueden haber riegos de perder datos
        al momento del parseo Implícito. Es decir, al ser "numeroDecimal" un decimal, he intentar
        asignarlo a un entero, hay una perdida de datos, ya que se perdería el valor decimal. Es decir:
            - La variable "numeroDecimal" tiene almacenado un decimal con valor = 10.5;
            - Luego le decimos al programa que en la variable "numeroEntero" se guarde el valor de "numeroDecimal", es decir 10.5 .  (numeroEntero = numeroDecimal;)
            - La variable "numeroEntero" almacena solo eneteros, pero al recibir un número decimal de la variable "numeroDecimal", el compilador detecta que hay una perdida
              de datos, ya que si se intenta alamcenar 10.5 en una variable de tipo entero (numeroEntero), se pierde la parte decimal, es decir, solo se podría almacenar la
              parte entera (10) y se perdería la parte decimal (0.5), por lo cual da error y no hace el casteo de forma automatica.
         */
        System.out.println("--------Casteos Explicitos----------");
        //-> Casteos Explícitos: Los hace el programador (nosotros).
        // De double a int
        double numeroDecimal2 = 10.5;
        int numeroEntero2;
        /*En este caso estamos realizando un casteo Explícito, ya que aunque haya perdidas de 
        dato obligamos a que el número decimal pase a ser un entero. En este caso la variable
        "numeroEntero2" tendrá un valor de 10 por el casteo realizado*/
        System.out.print("Casteo de double a int: ");
        numeroEntero2 = (int) numeroDecimal2;
        System.out.println(numeroEntero2);
        /* Si quereos parsear un decimal a un entero, pero aproximando a su valor mas cercano
         Podemos usar la librería "Math" para que realice el respectivo redondeo. */
        double doubleValue = 123.56;
        int intValue = (int) Math.round(doubleValue);
        System.out.print("Casteo de double a int pero aproximando a su valor mas cercano: ");
        System.out.println(intValue);

        //De entero a flotante 
        int enteroCasteo = 999;
        float flotanteCasteo = (float) enteroCasteo;
        System.out.print("Casteo de int  a float: ");
        System.out.println(flotanteCasteo);

        //De cadena (String) a int: básicamente es pasar un número que esta en texto a un nuevo que no es texto
        String texto = "123";

        int numeroCasteado = Integer.parseInt(texto);
        System.out.print("Casteo de String a int (texto a numero): ");
        System.out.println(numeroCasteado);

        //De int a cadena (String): básicamente es pasar un número a texto
        int numeroCasteado2 = 456;
        String texto2 = Integer.toString(numeroCasteado2);
        System.out.print("Casteo de int a string: ");
        System.out.println(texto2);

        //De char a int
        char caracter = 'a';
        int valorAscii = (int) caracter;

        /*El valor que nos da como resultado es el código ASCII del caracter.
          Para ver los valos ASCII de cada cáracter pueden visitar la siguiente 
          página: https://elcodigoascii.com.ar/
         */
        System.out.print("Casteo de char a int: ");
        System.out.println(valorAscii);

        // De int a char
        int codigoAscii = 65; // El código ASCII para 'A'
        char caracterObtenido = (char) codigoAscii;
        System.out.print("Casteo de int a char: ");
        System.out.println(caracterObtenido);
        /*
        Aquí al pasar de int a char, lo que obtenemos es el caracter según el número que hayamos ingresado, siguiente 
        el código ASCCI.
         */

    }

}
