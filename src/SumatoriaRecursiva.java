public class SumatoriaRecursiva {

    public static void main(String[] args) {
        int n = 10;

        System.out.println("Enfoque recursivo: La sumatoria de los números del 1 al " + n + " es: " + calcularSumatoriaRecursiva(n));
        System.out.println("Enfoque iterativo: La sumatoria de los números del 1 al " + n + " es: " + calcularSumatoriaIterativa(n));
    }

    // Funcion Sumatorio pero con recursividad
    private static int calcularSumatoriaRecursiva(int n) {
        if (n <= 0) {
            return 0;
        } else {
            return n + calcularSumatoriaRecursiva(n - 1); //aplicamos recursividad
        }
    }

    // Aqui la funcion pero desde un enfoque iterativo
    private static int calcularSumatoriaIterativa(int n) {
        int sumatoria = 0;
        for (int i = 1; i <= n; i++) {
            sumatoria += i;
        }
        return sumatoria;
    }
}
