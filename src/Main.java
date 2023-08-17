import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // creamos el scanner
        Scanner input = new Scanner(System.in);
        // las variables del programa
        int a,b,c;
        // solicitamos los numeros al usuario y les asignamos su valor a las variables
        System.out.println("Bienvenido, a continuacion ingrese 3 numeros para ordenarlos: ");
        a = input.nextInt();
        b= input.nextInt();
        c = input.nextInt();

        System.out.println("Los numeros ordenados de mayor a menor: ");
        // funcion para ordenar los numeros y mostramos
        ordenarNumeros(a,b,c);
        }

    private static void ordenarNumeros(int num1, int num2, int num3) {
        int min, med, max;

        // usamos la biblioteca de Math

        if (num1 <= num2 && num1 <= num3) {
            min = num1;
            med = Math.min(num2, num3);
            max = Math.max(num2, num3);
        } else if (num2 <= num1 && num2 <= num3) {
            min = num2;
            med = Math.min(num1, num3);
            max = Math.max(num1, num3);
        } else {
            min = num3;
            med = Math.min(num1, num2);
            max = Math.max(num1, num2);
        }
        System.out.println(max + " " + med + " " + min);
    }
}
