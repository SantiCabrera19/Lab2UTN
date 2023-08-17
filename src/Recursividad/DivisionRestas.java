package Recursividad;

public class DivisionRestas {

    public static void main(String[] args) {
        int dividend = 25;
        int divisor = 5;

        System.out.println("Resultado de la división recursiva: " + divisionRecursiva(dividend, divisor));
        System.out.println("Resultado de la división iterativa: " + divisionIterativa(dividend, divisor));
    }

    // Primero desde la recursividad
    private static int divisionRecursiva(int dividendo, int divisor) {
        if (dividendo < divisor) {
            return 0;
        } else {
            return 1 + divisionRecursiva(dividendo - divisor, divisor); // Aqui aplicamos la recursividad
        }
    }

    // Aqui desde un enfoque iterativo de ambas maneras se puede
    private static int divisionIterativa(int dividendo, int divisor) {
        int cociente = 0;
        while (dividendo >= divisor) {
            dividendo -= divisor; // con un while se puede lograr igualmente, evitamos la recursividad
            cociente++;
        }
        return cociente;
    }
}
