/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo2;

/**
 *
 * @author coxla
 */
public class Ejemplo2 {

    //AQUÍ SE DECLARÁN LAS VARIABLES GLOBALES
    public static int nombre_enteroGlobal = 10;
    //Una Variable global la podemos usar en cualquier parte del código (cualquier procedimiento o función)

    public static void main(String[] args) {
        // VARIABLE LOCAL: estás variables solo la podemos usar en el procedimiento o función donde lo declaramos
        int enteroLocal = 5;

        //Accediendo a variable global
        System.out.println("Imprimiendo variable: " + nombre_enteroGlobal);
        //---LLAMANDO PROCEDIMIENTOS----
        System.out.println("-------LLAMANDO PROCEDIMIENTOS----------------");
        //Para llamar el procedimiento simplemente lo llamamos por su indentificador
        //Podemos llamarlo las veces que deseemos
        NombreProcedimiento();
        System.out.println("---------------------------");
        NombreProcedimiento();
        System.out.println("---------------------------");
        NombreProcedimiento();
        System.out.println("");
        System.out.println("-------LLAMANDO PROCEDIMIENTOS CON PARAMETROS------");
        //Un parametro es un valor que si o si debemos mandarle al procedimiento, estos parametros se solicitan 
        //cuando se crea el procedimiento. En este caso en este procedimiento se solicitaron 3 parametros: dos enteros (int) y un texto (String)
        ProcedimientoParametros(3, 5, "Juan");
        System.out.println("");
        System.out.println("-------LLAMANDO FUNCION------");
        //Para llamar una función simplemente lo llamamos por su indentificador
        //Podemos llamarlo las veces que deseemos
        //La diferencia entre un procedimiento y una función, es que el procedimiento no retorna nada, mientras que la función si nos retorna algo,
        // el tipo de dato que nos retorna dependerá de con que tipo de dato lo creamos.
        double respuestaFuncion = dividir(); //Lo que nos retorna lo podemos guardar en una variable, en este caso retorna 1 (ver la función)
        System.out.println("Respuesta de division en funcion: " + respuestaFuncion);

        System.out.println("");
        System.out.println("-------LLAMANDO FUNCION CON PARAMETROS------");
        //Al igual que los procedimientos, en las funciones podemos enviar parametros
        int resultadoFactorial = calcularFactorial(5); //Retorna el valor del factorial
        System.out.println("El resultado del factorial es: " + resultadoFactorial);
       
        //----------------------------------RECURSIVIDAD----------------------------
        System.out.println();
        System.out.println("----------Recursividad simple calcularFactorialRecursiva(5)------------");

        int factorialSimple = calcularFactorialRecursiva(5);
        System.out.println("El factorial de 5 es: " + factorialSimple);
        System.out.println();
        
        System.out.println("----------Recursividad Indirecta------------");
       
        System.out.println("El factorial de 5 es en recursividad indirecta: " + calcularFactorialA(5));
        
        System.out.println("----------Recursividad Indirecta (Ejemplo 2)------------");
        funcionA(6);

    }

    //Procedimiento sin parametros (notar que al crear un procedimiento usamos "void ")
    //Un procedimiento básicamente es un bloque de código que solo se ejecuta cuando lo mandamos a llamar
    public static void NombreProcedimiento() {
        //Accediendo a variable global y modificando su valor
        nombre_enteroGlobal = nombre_enteroGlobal + 5;
        System.out.println("Imprimiendo variable: " + nombre_enteroGlobal);
        System.out.println("Este es mi procedimiento, hola desde aqui");

    }

    //Procedimiento con parametros (notar que al crear un procedimiento usamos "void ")
    //Como se mencinó anterimente, los parametros son datos que solicita el procedimiento para poder usarlos
    //Para solicitar dichos parametros debemos solicitarlo dento de los parentisis al momento de crear el procedimiento
    //Cabe aclarar que teemos que colocar de que tipo será el parametro que solicitamos
    //(Tipo Identificador, Tipo Identificado2)
    public static void ProcedimientoParametros(int numero1, int numero2, String nombre) {

        //Realizamos las operaciones que deseemos con los parametros que nos mandan desde el llamado
        System.out.println("Suma de los numeros: " + (numero1 + numero2));
        System.out.println("Tu nombre es: " + nombre);

        //También podemos llamar procedimientos y funciones desde los procedimientos
        NombreProcedimiento();
    }

    // Funcion sin parametros
    //Una función básicamente es un bloque de código que solo se ejecuta cuando lo mandamos a llamar, pero la función siempre retorna un valor cuando es llamado
    //Además, podemos notar que en una función al momento de crearlo no usamos "void", sino que en lugar de ello colocamos un Tipo de dato a la función.
    public static double dividir() {
        //Aquí al igual que el procedimiento podemos realizar las operaciones que deseemos
        double n1 = 8, n2 = 8;
        double resultado = n1 / n2;
        //La gran diferencia con los procedimientos, es que si o si debemos retorna un valor con el mismo tipo que creamos la función
        //En este caso creamos la función con un tipo "double", por lo cual debemos retornar un valor de tipo "double", si lo hacemos con otro tipo nos dará error.
        return resultado;
    }

    // Función con paramtros
    //Como se mencinó anterimente, los parametros son datos que solicita la función para poder usarlos
    //En este caso la función solicita que al momento de ser llamado se le envié un Tipo de dato Int
    public static int calcularFactorial(int numero) {
        //Realizamos el calculo del factorial según el número que nos índiquen por medio del parametro
        int factorial = 1;
        if (numero < 0) {
            System.out.println("El factorial no es valido para numeros negativos");
            factorial = numero;
        } else {

            for (int i = 1; i <= numero; i++) {
                factorial *= i;

            }
        }

        //Notar que lo que estamos retornando es un int, ya que la función fue creado como tipo int
        return factorial;
    }
    
    //--------------------------------------RECURSIVIDAD---------------------------
    
    // FUNCIÓN RECURSIVA DIRECTA PARA CALCULAR FACTORIAL
    // La recursividad directa  se refiere a la técnica en la que una función se llama a sí mismo durante su ejecución. 
    //En otras palabras, una funcion recursiva se llama así mismo varias veces. Para detener la recursividad en una función debemos
    //colocar una condición que detenga el llamado que se hace así mismo.
    
    public static int calcularFactorialRecursiva(int n) {
        // Paso 1: Verificar el caso base
        if (n == 0 || n == 1) {
            return 1; // Caso base: 0! y 1! son 1
        } else {
            /*
            En este paso, la función se llama a  sí misma con el argumento (n - 1). Esto es lo que hace que la función sea recursiva. 
            Cada vez que se llama recursivamente, el valor de n se reduce en 1.
            */
            return n * calcularFactorial(n - 1); // Llamada recursiva
            
            /*
            La expresión n * calcularFactorialRecursiva(n - 1) realiza la multiplicación de n con el resultado de la llamada recursiva. 
            La multiplicación se realiza después de que la llamada recursiva ha regresado con un valor. Finalmente, el resultado de esta 
            multiplicación se devuelve como el resultado de la función.
            */
        }
        
        /*
        La recursividad continúa hasta que se alcanza el caso base, momento en el cual la función comienza a devolver valores y las llamadas 
        recursivas se resuelven una a una en orden inverso. Cada llamada recursiva representa una parte del problema original, y la 
        combinación de los resultados de estas llamadas resuelve el problema completo.
        */
    }
    
    
    //FUNCIÓN RECURSIVA INDIRECTA
    //Ocurre cuando una función no se llama a sí misma directamente, pero en cambio, involucra la llamada de otras funciones.
    
    public static int calcularFactorialA(int n) {
        if (n == 0 || n == 1) {
            return 1; // Caso base: 0! y 1! son 1
        } else {
            // Llamada a la otra función
            return n * calcularFactorialB(n - 1);
        }
    }

    public static int calcularFactorialB(int n) {
        if (n == 0 || n == 1) {
            return 1; // Caso base: 0! y 1! son 1
        } else {
            // Llamada a la otra función
            return n * calcularFactorialA(n - 1);
        }
    }
    
    //Función indirecta otro ejemplo
    public static void funcionA(int n) {
        if (n > 0) {
            System.out.println("En funcionA, n = " + n);

            // Llamamos a la funciónB desde la funciónA
            funcionB(n - 1);
        }
    }

    public static void funcionB(int n) {
        if (n > 0) {
            System.out.println("En funcionB, n = " + n);

            // Llamamos a la funciónA desde la funciónB
            funcionA(n - 1);
        }
    }

}
