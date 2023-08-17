package Recursividad;

public class Factorial {

    public static void main(String[] args) {
        int numero = 5;

        System.out.println("recursividad: El factorial de " + numero + " es igual a: " + calcularFactorialRecursivo(numero));
        System.out.println("iterativa: El factorial de " + numero + " es igual : " + calcularFactorialIterativo(numero));
    }

    // Calculo del factorial con recursividad (source: Chatgpt)
    private static int calcularFactorialRecursivo(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calcularFactorialRecursivo(n - 1); //Aqui se aplica la recursividad
        } // y retornamos para termina la recursividad y ahorrar memoria
    }

    // Un calculo al factorial pero con enfoque iterativo
    private static int calcularFactorialIterativo(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) { //Aqui la iteracion
            factorial *= i;
        }
        return factorial; //
    }

}
