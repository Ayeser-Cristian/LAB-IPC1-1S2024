/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplopractica1;

import java.util.Scanner;

import java.util.Random;

public class EjemploPractica1 {

    //Tablero
    public static String[][] tablero = new String[8][8];
    public static String[][] penalizaciones = new String[8][8];
    //Scanner global para numeros
    public static Scanner inputData = new Scanner(System.in);
    //Scanner global para letras
    public static Scanner inputString = new Scanner(System.in);
    //Jugador
    public static String simbolo = " @";
    //Posicion del jugador
    public static int position = 1;

    // NivelPenalizacion
    public static int nivelPenalizacion = -99;

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("==============Menú Principal============");
            System.out.println("1. Iniciar Juego");
            System.out.println("2. Retomar Juego");
            System.out.println("3. Mostrar información del estudiante");
            System.out.println("4. Salir");
            System.out.println("=======================================");
            System.out.print("Elige una opción: ");
            opcion = inputData.nextInt();
            menu_opciones(opcion);
        } while (opcion != 4);

    }

    public static void menu_opciones(int _opcion) {
        switch (_opcion) {
            case 1:
                System.out.println(" Partida Iniciada");
                llenarMatriz();
                llenrPenalizaciones();

                elegirOpcion();

                break;
            case 2:
                System.out.println("Retornar juego");
                break;
            case 3:
                System.out.println("Info: EL AUX");
                break;
            case 4:
                System.out.println("Gracias por usar el juego");
                break;
            default:
                System.out.println("Opción no valida");
        }
    }

    public static void llenarMatriz() {
        int contador = 1;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = String.valueOf(contador);
                contador++; //contador=contador+1
            }
        }

        for (int i = 0; i < penalizaciones.length; i++) {
            for (int j = 0; j < penalizaciones[i].length; j++) {
                penalizaciones[i][j] = "";
            }
        }

    }

    public static void llenrPenalizaciones() {
        //Instancia de la librería random
        Random random = new Random();

        int cantidadPenalizaciones;
        int posicionAleatoria;
        for (int i = 0; i < penalizaciones.length; i++) {

            //0, 1, 2
            //+2
            cantidadPenalizaciones = random.nextInt(3) + 2;

            while (cantidadPenalizaciones != 0) {
                //0-7

                while (true) {
                    posicionAleatoria = random.nextInt(penalizaciones[i].length);
                    //hola#
                    if (!penalizaciones[i][posicionAleatoria].contains("#")) {
                        break;
                    }
                }
                penalizaciones[i][posicionAleatoria] = "#" + penalizaciones[i][posicionAleatoria];
                cantidadPenalizaciones--;
            }
        }

    }

    public static void imprimirInferiorDerecha() {
        System.out.println("=================================================");
        //Para imprimirlo en el otro sentido solo cambiar este booleano a true o false
        boolean bandera = false;
        String casilla;
        for (int i = tablero.length - 1; i >= 0; i--) {
            //Solo para mas estetica del tablero
            for (int j = 0; j < tablero.length; j++) {
                System.out.print("+------");
            }

            System.out.println("+");
            //---------------------------------------

            for (int j = tablero.length - 1; j >= 0; j--) {

                if (bandera == true) {
                    casilla = penalizaciones[i][j] + tablero[i][j];
                    // ""+64 = ""64

                    System.out.printf("| %4s ", casilla);
                } else {
                    casilla = penalizaciones[i][(tablero.length - 1) - j] + tablero[i][(tablero.length - 1) - j];
                    //8-1= 7 
                    System.out.printf("| %4s ", casilla);
                }

                //System.out.print("| "+tablero[i][j] );
            }
            System.out.println("|");

            for (int j = tablero.length - 1; j >= 0; j--) {
                if (bandera == true) {
                    if (position == Integer.parseInt(tablero[i][j])) {
                        System.out.printf("| %4s ", simbolo);

                        if (penalizaciones[i][j].contains("#")) {
                            nivelPenalizacion = i + 1;
                        }

                    } else {
                        System.out.printf("| %4s ", " ");
                    }
                } else {

                    if (position == Integer.parseInt(tablero[i][(tablero.length - 1) - j])) {
                        System.out.printf("| %4s ", simbolo);
                        if (penalizaciones[i][(tablero.length - 1) - j].contains("#")) {
                            nivelPenalizacion = i + 1;
                        }
                    } else {
                        System.out.printf("| %4s ", " ");
                    }

                }
            }

            System.out.println("|");
            bandera = !bandera;

        }
        //Solo para mas estetica del tablero
        for (int j = 0; j < 8; j++) {

            System.out.print("+------");
        }
        System.out.println("+");
        //-----------------------------------------------
    }

    public static void imprimirInferiorIzquierda() {
        System.out.println("=================================================");
        //Para imprimirlo en el otro sentido solo cambiar este booleano a true o false
        boolean bandera = true;
        String casilla;
        for (int i = tablero.length - 1; i >= 0; i--) {
            //Solo para mas estetica del tablero
            for (int j = 0; j < tablero.length; j++) {
                System.out.print("+------");
            }

            System.out.println("+");
            //---------------------------------------

            for (int j = tablero.length - 1; j >= 0; j--) {

                if (bandera == true) {
                    casilla = penalizaciones[i][j] + tablero[i][j];
                    // ""+64 = ""64

                    System.out.printf("| %4s ", casilla);
                } else {
                    casilla = penalizaciones[i][(tablero.length - 1) - j] + tablero[i][(tablero.length - 1) - j];
                    //8-1= 7 
                    System.out.printf("| %4s ", casilla);
                }

                //System.out.print("| "+tablero[i][j] );
            }
            System.out.println("|");

            for (int j = tablero.length - 1; j >= 0; j--) {
                if (bandera == true) {
                    if (position == Integer.parseInt(tablero[i][j])) {
                        System.out.printf("| %4s ", simbolo);

                        if (penalizaciones[i][j].contains("#")) {
                            nivelPenalizacion = i + 1;
                        }

                    } else {
                        System.out.printf("| %4s ", " ");
                    }
                } else {

                    if (position == Integer.parseInt(tablero[i][(tablero.length - 1) - j])) {
                        System.out.printf("| %4s ", simbolo);
                        if (penalizaciones[i][(tablero.length - 1) - j].contains("#")) {
                            nivelPenalizacion = i + 1;
                        }
                    } else {
                        System.out.printf("| %4s ", " ");
                    }

                }
            }

            System.out.println("|");
            bandera = !bandera;

        }
        //Solo para mas estetica del tablero
        for (int j = 0; j < 8; j++) {

            System.out.print("+------");
        }
        System.out.println("+");
        //-----------------------------------------------
    }
    public static void elegirOpcion() {
        String elegir;
        Random random = new Random();
        int dado;
        do {

            if (position > 64) {
                System.out.println(" Ganaste el juego");
                break;
            }
            //Para imprimirlo de la otra forma
            //imprimirInferiorIzquierda()
            imprimirInferiorDerecha();

            niveles_Penalizacion();
            System.out.println(" Lanzar dado (d)");
            System.out.println(" Pausar Juego (p)");
            elegir = inputString.nextLine();

            if (elegir.equals("d")) {
                //1-6
                dado = random.nextInt(6) + 1;
                System.out.println("El dado cayo en: " + dado);
                position += dado; //position=position+dado;

            } else if (elegir.equals("p")) {
                System.out.println("Juego pausado");
            } else {
                System.out.println("Opcion no valida");
            }
        } while (!elegir.equals("p"));
    }

    public static void niveles_Penalizacion() {

        if (nivelPenalizacion == 1 || nivelPenalizacion == 2) {

            //Logia de penalizaciones
            System.out.println("Estoy en nivel facil de penalizacion");
        } else if (nivelPenalizacion == 3 || nivelPenalizacion == 4 || nivelPenalizacion == 5) {
            System.out.println("Estoy en nivel intermedio de penalizacion");
        } else if (nivelPenalizacion == 6 || nivelPenalizacion == 7 || nivelPenalizacion == 8) {
            System.out.println("Estoy en nivel dificil de penalizacion");
        }

        nivelPenalizacion = -99;
    }
}
