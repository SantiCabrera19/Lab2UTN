package GestionEmpleados;

// Clase concreta EmpleadoAsalariado

public class EmpleadoAsalariado extends Empleado implements Impuesto {

    // Constructor
    public EmpleadoAsalariado(String nombre, int id, double sueldoBase) {
        super(nombre, id, sueldoBase);
    }

    // Implementación del método abstracto calcularSueldo() para EmpleadoAsalariado
    @Override
    public double calcularSueldo() {
        // El sueldo de un empleado asalariado es el sueldo base sin cambios
        return sueldoBase;
    }

    public double calcularImpuesto() {
        double sueldo = calcularSueldo(); // Calcula el sueldo total del empleado
        return sueldo * 0.15; // Impuesto del 15%
    }
}

