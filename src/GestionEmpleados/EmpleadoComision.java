package GestionEmpleados;

// Clase concreta EmpleadoComision

public class EmpleadoComision extends Empleado implements Impuesto {
    private double ventasRealizadas;  // Ventas realizadas por el empleado

    // Constructor
    public EmpleadoComision(String nombre, int id, double sueldoBase, double ventasRealizadas) {
        super(nombre, id, sueldoBase);
        this.ventasRealizadas = ventasRealizadas;
    }

    // Implementación del método abstracto calcularSueldo() para EmpleadoComision
    @Override
    public double calcularSueldo() {
        // Supongamos que el sueldo se calcula sumando un porcentaje de las ventas realizadas
        double porcentajeComision = 0.05;  // Porcentaje de comisión ficticio
        return sueldoBase + (ventasRealizadas * porcentajeComision);
    }

    public double calcularImpuesto() {
        double sueldo = calcularSueldo(); // Calcula el sueldo total del empleado
        return sueldo * 0.05; // Impuesto del 5%
    }
}

