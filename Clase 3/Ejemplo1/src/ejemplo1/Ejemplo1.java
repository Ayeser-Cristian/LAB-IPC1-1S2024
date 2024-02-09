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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("---------------ArithmeticException---------------");
        // ArithmeticException
        try {
            double division = 21 / 0;
        } catch (ArithmeticException ae) {
            System.out.println("Error: " + ae.getMessage());
        }
        
        
        System.out.println("");
        System.out.println("---------------Null Pointer Exception---------------");
        // Null Pointer Exception
        try {
            String str = null;
            int length = str.length();
        } catch (NullPointerException ne) {
            System.out.println("Error: " + ne.getMessage());
        }
        
        
        System.out.println("");
        System.out.println("---------------Array Index Out Of Bounds Exception---------------");
        // Array Index Out Of Bounds Exception
        try {
            int[] myNumbers = {1, 2, 3};
            System.out.println(myNumbers[10]);
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Something went wrong: " + aioobe.getMessage());
        }
        
        
        System.out.println("");
        System.out.println("---------------Class Cast Exception---------------");
        // Class Cast Exception
        try {
            Object obj = "Hola";
            Integer num = (Integer) obj;
        } catch (ClassCastException ce) {
            System.out.println("Error: " + ce.getMessage());
        }
        
        
        System.out.println("");
        System.out.println("---------------General (lo podemos usar para todos los tipos de errores---------------");
        //General (lo podemos usar para todos los tipos de errores
        try {
            double division1 = 21 / 0;
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("");
        System.out.println("Hola pase el error");
    }

}
