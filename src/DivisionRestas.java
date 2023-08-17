public class DivisionRestas {

    public static void main(String[] args) {
        int dividend = 25;
        int divisor = 5;

        System.out.println("Resultado de la división recursiva: " + divisionRecursiva(dividend, divisor));
        System.out.println("Resultado de la división iterativa: " + divisionIterativa(dividend, divisor));
    }

    // Enfoque recursivo
    private static int divisionRecursiva(int dividendo, int divisor) {
        if (dividendo < divisor) {
            return 0;
        } else {
            return 1 + divisionRecursiva(dividendo - divisor, divisor);
        }
    }

    // Enfoque iterativo
    private static int divisionIterativa(int dividendo, int divisor) {
        int cociente = 0;
        while (dividendo >= divisor) {
            dividendo -= divisor;
            cociente++;
        }
        return cociente;
    }
}
