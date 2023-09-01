package GestionEmpleados;

import java.util.ArrayList;

// Clase GestorEmpleados
public class GestorEmpleados {
    ArrayList<Empleado> empleados;  // ArrayList para almacenar empleados

    // Constructor
    public GestorEmpleados() {
        empleados = new ArrayList<>();
    }

    // Método para agregar un empleado al ArrayList
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    // Método para modificar los detalles de un empleado existente
    public void modificarEmpleado(int index, Empleado nuevoEmpleado) {
        if (index >= 0 && index < empleados.size()) {
            empleados.set(index, nuevoEmpleado);
        }
    }

    // Método para eliminar un empleado del ArrayList
    public void eliminarEmpleado(int index) {
        if (index >= 0 && index < empleados.size()) {
            empleados.remove(index);
        }
    }

    // Método para calcular e imprimir el sueldo e impuesto de todos los empleados
    public void calcularSueldosEImpuestos() {
        for (Empleado empleado : empleados) {
            double sueldo = empleado.calcularSueldo();
            double impuesto = 0.0;

            if (empleado instanceof Impuesto) {
                impuesto = ((Impuesto) empleado).calcularImpuesto();
            }

            System.out.println("Nombre: " + empleado.getNombre());
            System.out.println("Sueldo: " + sueldo);
            System.out.println("Impuesto: " + impuesto);
            System.out.println("---------------");
        }
    }


}

