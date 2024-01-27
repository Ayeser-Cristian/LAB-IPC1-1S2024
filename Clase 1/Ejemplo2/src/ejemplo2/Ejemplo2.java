/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo2;

//Es la librería que permite el ingreso de datos desde consola para el usuario(el Scanner)
import java.util.Scanner;

public class Ejemplo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Declaracion y los Tipos de variables
        //Primitimos, estos son los usados:

        //Declaras variables enteros negativas o positivas usamos int
        int valorEntero = 10;

        ////Declaras variables decimales negativas o positivas usamos double
        double valorDecimal = 5.58;

        //Declarar un booleano usamos boolean (guarda un valor true o  false)
        boolean valorBool = true;

        //No primitivos (por el momento solo vamos a usar String)
        //Declarar un String, se escribe una cadena de caracteres, es decir, texto.
        String valorString = "Hola, aqui puedo escribir texto";

        //Casteo: Convertir una variable de un tipo a otro tipo, el explicito es el que aplicaremos.
        // De double a int
        double casteoDecimal = 5.3;
        int casteoEntero;
        casteoEntero = (int) casteoDecimal; //5

        //De String a int
        String numeroTexto = "89";
        int numero = Integer.parseInt(numeroTexto);

        // De int a String
        int numero2 = 58;
        String numeroTexto2 = Integer.toString(numero2);

        //----------INPUT Y OUPUT--------------
        System.out.println("--------------OUTPUT---------");
        //OUTPOT
        //Mostrar mensaje al usuario
        System.out.println("Este es un mensaje del programa"); //cuando colacamos println al final, da un salto de línea
        System.out.print("Hola"); //cuando colamos print, no da un el salto de linea
        System.out.println("4");
        //Concatener valores al imprimir
        System.out.println("Este es un numero entero: " + valorEntero);
        System.out.println(valorDecimal + " Este es un decimal");

        System.out.println("Este es el booleano: " + valorBool + " - " + " Este es el string: " + valorString);

        //Input: Ingresar datos en la consola (Pedir que se ingresen datos)
        System.out.println("--------------INPUT---------");
        //Crear un objeto para solicitar los datos
        //Como recomendación creemos dos Scanner, uno para solicitar números (decimales o enteros) y uno para solicitar texto.
        //Scanner para solicitar valores númericos
        Scanner ingresoValor = new Scanner(System.in);
        //Scanner para solicitar texto
        Scanner ingresoTexto = new Scanner(System.in);

        //Creamos una variable en la cual usaremos para almacenar el dato que el usario ingresará
        int edad;
        //Solicitamos al usuario que ingrese su edad (tipo int)
        System.out.print("Ingresa tu edad: ");
        /* Para solicitar la edad y almacenarlo en la variable edad, hacemos lo siguiente:
            - Lllamos nuestro Scanner para numeros que anteriomente creamos (Scanner ingresoValor=new Scanner(System.in))
            - Lo igualamos con la variable donde queremos que se guarde el valor que se ingresará
         */
        edad = ingresoValor.nextInt(); //Notar que al guardarlo en una variable de tipo int, el comando que usamos es ".nextInt()"

        System.out.println("    * Tu edad es: " + edad);

        //Solicitamos al usuario que ingrese su peso (tipo double)
        double peso;
        System.out.print("Ingresa tu peso: ");
        /* Para solicitar el peso y almacenarlo en la variable peso, hacemos lo siguiente:
            - Lllamos nuestro Scanner para numeros que anteriomente creamos (Scanner ingresoValor=new Scanner(System.in))
            - Lo igualamos con la variable donde queremos que se guarde el valor que se ingresará
         */
        peso = ingresoValor.nextDouble(); //Notar que al guardarlo en una variable de tipo double, el comando que usamos es ".nextDouble()"
        System.out.println("    * Tu peso es: " + peso);

        //Solicitamos al usuario que ingrese su nombre (tipo String)
        String nombre;
        System.out.print("Ingresa tu nombre: ");
        /* Para solicitar el nombre y almacenarlo en la variable nombre, hacemos lo siguiente:
            - Llamos nuestro Scanner para texto que anteriomente creamos (Scanner ingresoTexto=new Scanner(System.in))
            - Lo igualamos con la variable donde queremos que se guarde el valor que se ingresará
         */
        nombre = ingresoTexto.nextLine(); //Notar que al guardarlo en una variable de tipo String, el comando que usamos es ".nextLine()"
        System.out.println("    * Tu nombre es: " + nombre);

        //Operadores Aritmeticos
        System.out.println("--------------Operadores Aritmeticos---------");
        int n1 = 50, n2 = -10;
        double val1 = 5.8;

        int resultado;
        //Podemos realizar operaciones aritmeticas y el compilador respetara la jerarquía de operaciones
        resultado = n1 - n2 * 8;

        System.out.println("Resultado de la operación: " + resultado);

        double resultado2;

        resultado2 = n1 - n2 * 8 * val1;

        System.out.println("Resultado de la operación: " + resultado2);
        //Podemos realizar operaciones directamente en un sout
        System.out.println(5 + 5);
        System.out.println("Resultado de 5%7 es: " + (5 % 7));

        System.out.println("--------------Operadores Compuestos---------");

        //Le suma a sí mismo un 1
        n1++; //Es igual a decir n1=n1+1;
        System.out.println("Resultado aumento n1: " + n1);

        n1 += 5; // Es igual a decir n1=n1+5;
        System.out.println("Resultado aumento n1: " + n1);

        System.out.println("--------------Operadores Relacionales---------");
        System.out.println(5 > 8);

        System.out.println(9 >= 8);
        System.out.println(8 == 9);
        System.out.println(8 != 8);
        //Cuando compareamos texto, solo podemos comparar con "==" y "!="
        System.out.println("hola" == "holA");

        System.out.println("hola" != "holA");

        System.out.println("--------------Operadores Logicas---------");

        // operador logico: and 
        //Recordar que solo es verdadero cuando ambas condiciones son verdaderas
        System.out.println(5 == 6 && 9 > 8);
        // operador logico: or
        //Recordar que es verdadero cuando una es verdadero o ambas son verdaderos
        System.out.println(5 == 6 || 9 > 8);
        //Operador logico: not = !
        System.out.println(!(5 == 6 || 9 > 8));
        //                     true   && true && false || true
        //                         true && true 
        System.out.println(5 < 7 || 6 > 7 && 67 <= 98 && !(6 < 8) || 8 == 8);

        //Si no se recuerdan de esto, puedo ver las tablas de verdad en google
        System.out.println("--------------ESTRUCTURA DE CONTROL IF---------");
        double notaLab = 100;
        // El bloque if evalúa si la variable notaLab está en el rango de 90 a 100 (inclusive)
        if (notaLab >= 90 && notaLab <= 100) {
            // Si la condición es verdadera, se ejecuta este bloque de código
            System.out.println("Tuviste una excelente nota: " + notaLab);

            // Si la condición del if no es verdadera, se pasa al bloque else if para realizar otra verificación
        } else if (notaLab >= 70 && notaLab < 90) {
            // Este bloque se ejecuta si la nota no está en el rango entre 70 y 89
            System.out.println("Tuviste una muy buena nota: " + notaLab);

            // Si la condición del primer else if no es verdadera, se pasa al siguiente bloque else if para otra verificación
        } else if (notaLab >= 61 && notaLab < 70) {
            // Este bloque se ejecuta si la nota no está en los rangos  entre 61 y 69
            System.out.println("Tuviste una regular nota: " + notaLab);

            // Si la nota no está en ninguno de los rangos anteriores, se pasa al siguiente bloque else if
        } else if (notaLab < 61 && notaLab >= 0) {
            // Este bloque se ejecuta si la nota  es menor que 61 y igual o mayor a 0
            System.out.println("Perdiste el lab :,v");

            // Si la nota no está en ninguno de los bloques anteriores, se ejecuta el bloque else
        } else {
            // Este bloque se ejecuta si la nota no cumple con ninguna de las condiciones anteriores
            System.out.println("Nota no válida");
        }

        System.out.println("--------------ESTRUCTURA DE CONTROL SWITCH---------");
        String elegirOpcion = "25";

        // La estructura switch evalúa la variable elegirOpcion
        switch (elegirOpcion) {
            // Case "100": Se verifica si elegirOpcion es igual a "100"
            case "100":
                // Si la condición es verdadera, se ejecuta este bloque
                System.out.println("Seleccionaste la opcion 1");
                // El break indica que se debe salir del switch después de ejecutar este bloque
                break;

            // Case "25": Se verifica si elegirOpcion es igual a "25"
            case "25":
                // Si la condición es verdadera, se ejecuta este bloque
                System.out.println("Seleccionaste la opcion 2");
                // El break indica que se debe salir del switch después de ejecutar este bloque
                break;

            // Case "30": Se verifica si elegirOpcion es igual a "30"
            case "30":
                // Si la condición es verdadera, se ejecuta este bloque
                System.out.println("Seleccionaste la opcion 3");
                // El break indica que se debe salir del switch después de ejecutar este bloque
                break;

            // Default: Este bloque se ejecuta si ninguna de las condiciones anteriores es verdadera
            default:
                // Se ejecuta este bloque si no se encuentra un caso coincidente
                System.out.println("Ningún valor coincide");
                // El break indica que se debe salir del switch después de ejecutar este bloque
                break;
        }

        System.out.println("--------------CICLO FOR---------");
        System.out.println("For incremental:");
        // Inicia un bucle for con la variable de control i inicializada en 0
        // La condición de continuación es que i sea menor que 10.
        // El bucle sigue ejecutándose mientras la condición i < 10 sea verdadera
        // Después de cada iteración, i se incrementa en 1
        for (int i = 0; i < 10; i++) {
            // En cada iteración, se ejecuta el siguiente bloque de código e i aumenta se suma así mismo 1

            // Imprime en la consola el valor actual de i seguido de la cadena " Hola"
            System.out.println(i + " Hola");
        }
        // Después de que el bucle ha completado todas las iteraciones, el programa continúa con el código siguiente
        System.out.println("For decremental:");

        // Inicia un bucle for con la variable de control i inicializada en 10
        // La condición de continuación es que i sea mayor o igual a 0
        // El bucle sigue ejecutándose mientras la condición i >= 0 sea verdadera
        // Después de cada iteración, i se decrementa en 1
        for (int i = 10; i >= 0; i--) {
            // En cada iteración, se ejecuta el siguiente bloque de código
            // Imprime en la consola el valor actual de i seguido de la cadena " Hola"
            System.out.println(i + " Hola");
        }

        // Después de que el bucle ha completado todas las iteraciones, el programa continúa con el código siguiente
        System.out.println("--------------CICLO WHILE---------");
        int contador = 0;

        // Este es el inicio del bucle while. La condición es que el valor de 'contador' sea menor que 10.
        /*El bucle se ejecutará mientras la condición contador < 10 sea verdadera. En cada iteración, se 
        imprimirá el valor actual de contador y se incrementará en 1. El bucle continuará hasta que la 
        condición sea falsa, es decir, cuando contador alcance o supere el valor de 10. */
        while (contador < 10) {
            // Imprime el valor actual de 'contador' en la consola.
            System.out.println(contador);

            // Incrementa el valor de 'contador' en 1 en cada iteración del bucle.
            contador++;
        }

        System.out.println("--------------CICLO DO WHILE---------");
        boolean bandera = true;
        int contador2 = 1;
        // Inicio de un bucle 'do-while'. Este bucle se ejecutará al menos una vez, ya que la condición se evalúa al final.
        do {
            // Imprime un mensaje indicando que se ha ingresado al ciclo
            System.out.println("Entro al ciclo");

            // Verifica si el valor de 'contador2' es igual a 3
            if (contador2 == 3) {
                // Si es igual a 3, se utiliza 'break' para salir del bucle
                // Esto significa que el bucle se interrumpirá antes de completar su ejecución normal
                break;
            }

            // Incrementa el valor de 'contador2' en 1 en cada iteración
            contador2++;

            // La condición del bucle 'do-while'. Se evalúa al final del bucle, por lo que se ejecutará al menos una vez.
        } while (bandera);
        //Mientras la codición sea verdadera el ciclo se seguirá ejecutando, cuando sea falso el ciclo se detiene.

    }

}
