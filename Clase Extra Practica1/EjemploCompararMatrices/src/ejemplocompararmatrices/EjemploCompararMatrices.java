/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplocompararmatrices;

/**
 *
 * @author coxla
 */
import java.util.Scanner;

public class EjemploCompararMatrices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] matriz1 = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
        };

        
        int[][] matriz2 = new int[5][5];
        // Obtener la segunda matriz desde la entrada del usuario
        matriz2 = obtenerMatrizDesdeUsuario();
        
        // Verificar si las matrices son iguales
        if (compararMatrices(matriz1, matriz2)) {
            System.out.println("Las matrices son iguales.");
        } else {
            System.out.println("Las matrices son diferentes.");
        }
    }

    // Procedimiento para obtener la segunda matriz desde la entrada del usuario
    public static int[][] obtenerMatrizDesdeUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los valores para la segunda matriz:");

        // Crear una matriz vacía con las mismas dimensiones que la primera matriz
        int[][] matriz = new int[5][5];

        // Obtener los valores de la segunda matriz desde el usuario
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print("Ingrese el valor para el índice [" + (i) + "][" + (j) + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        return matriz;
    }

    // Procedimiento para verificar si dos matrices son iguales
    public static boolean compararMatrices(int[][] matriz1, int[][] matriz2) {

        // Comparar cada elemento de las matrices
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[0].length; j++) {
                if (matriz1[i][j] != matriz2[i][j]) {
                    return false; // Las matrices son diferentes
                }
            }
        }

        //La matriz es verdadera
        return true;
    }

}
