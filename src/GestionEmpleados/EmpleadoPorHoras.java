package GestionEmpleados;

public class EmpleadoPorHoras extends Empleado implements Impuesto {
    private int horasTrabajadas;  // Horas trabajadas por el empleado

    // Constructor
    public EmpleadoPorHoras(String nombre, int id, double sueldoBase, int horasTrabajadas) {
        super(nombre, id, sueldoBase);
        this.horasTrabajadas = horasTrabajadas;
    }

    // Implementación del método abstracto calcularSueldo() para EmpleadoPorHoras
    @Override
    public double calcularSueldo() {
        // Supongamos que el sueldo se calcula multiplicando las horas trabajadas por una tarifa por hora
        double tarifaPorHora = 10.0;  // Tarifa por hora ficticia
        return sueldoBase + (horasTrabajadas * tarifaPorHora);
    }

    public double calcularImpuesto() {
        double sueldo = calcularSueldo(); // Calcula el sueldo total del empleado
        return sueldo * 0.10; // Impuesto del 10%
    }
}


