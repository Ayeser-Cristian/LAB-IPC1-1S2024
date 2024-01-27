/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo3;


import java.util.Scanner;

public class Ejemplo3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner ingresoNumeros = new Scanner(System.in);
        Scanner ingresoTexto = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("--------------Menu-------------");
            System.out.println(" 1. Ver si soy de mayor de edad");
            System.out.println(" 2. Imprimir números según rangos");
            System.out.println(" 3. Calcular modulo");
            System.out.println(" 4. Salir");
            System.out.println("-------------------------------");
            System.out.print("Elige una opcion:");
            opcion = ingresoNumeros.nextInt();

            if (opcion == 1) {
                int edad;
                String nombre;
                System.out.print("Ingresa tu nombre: ");
                nombre=ingresoTexto.nextLine();
                System.out.print("Ingresa tu edad: ");
                edad=ingresoNumeros.nextInt();
                
                if(edad>=18){
                    System.out.println("Te llamas "+nombre+" y ya eres mayor de edad, tines "+edad);
                }else{
                     System.out.println("Te llamas "+nombre+" y ya eres menor de edad, tines "+edad);
                }
                
            } else if (opcion == 2) {
                int inicio, fin;
                System.out.print("Ingresa el rango inicial:");
                inicio=ingresoNumeros.nextInt();
                System.out.println("");
                System.out.print("Ingresa el rango final:");
                fin=ingresoNumeros.nextInt();
                
                for (int i =inicio ; i <= fin; i++) {
                    System.out.println(i);
                }
                
                
            } else if (opcion == 3) {
                int n1, n2;
                System.out.print("Ingresa un numero:");
                n1=ingresoNumeros.nextInt();
                System.out.println("");
                System.out.print("Ingresa el segundo numero:");
                n2=ingresoNumeros.nextInt();
                
                System.out.println("Resultado: "+ (n1%n2));
                
            } else if (opcion == 4) {
                System.out.println("Gracias por usar el programa ");
                break;
            }else{
                System.out.println("Opción no valida");
            }

        } while (true);

    }

}
