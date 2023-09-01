package GestionEmpleados;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorEmpleados gestor = new GestorEmpleados();

        while (true) {
            try {
                System.out.println("1. Agregar empleado");
                System.out.println("2. Modificar empleado");
                System.out.println("3. Eliminar empleado");
                System.out.println("4. Calcular sueldos e impuestos");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1 -> {
                        System.out.println("Seleccione el tipo de empleado:");
                        System.out.println("1. Empleado por Horas");
                        System.out.println("2. Empleado Asalariado");
                        System.out.println("3. Empleado por Comisión");
                        int tipoEmpleado = scanner.nextInt();
                        System.out.print("Ingrese el nombre del empleado: ");
                        String nombre = scanner.next();
                        System.out.print("Ingrese el ID del empleado: ");
                        int id = scanner.nextInt();
                        System.out.print("Ingrese el sueldo base: ");
                        double sueldoBase = scanner.nextDouble();
                        if (tipoEmpleado == 1) {
                            System.out.print("Ingrese las horas trabajadas: ");
                            int horasTrabajadas = scanner.nextInt();
                            gestor.agregarEmpleado(new EmpleadoPorHoras(nombre, id, sueldoBase, horasTrabajadas));
                        } else if (tipoEmpleado == 2) {
                            gestor.agregarEmpleado(new EmpleadoAsalariado(nombre, id, sueldoBase));
                        } else if (tipoEmpleado == 3) {
                            System.out.print("Ingrese las ventas realizadas: ");
                            double ventasRealizadas = scanner.nextDouble();
                            gestor.agregarEmpleado(new EmpleadoComision(nombre, id, sueldoBase, ventasRealizadas));
                        }
                    }
                    case 2 -> {
                        System.out.print("Ingrese el índice del empleado a modificar: ");
                        int indexModificar = scanner.nextInt();
                        if (indexModificar >= 0 && indexModificar < gestor.empleados.size()) {
                            Empleado empleadoModificar = gestor.empleados.get(indexModificar);

                            System.out.print("Ingrese el nuevo nombre del empleado: ");
                            String nuevoNombre = scanner.next();
                            empleadoModificar.setNombre(nuevoNombre);

                            // Similarmente, ajusta otros atributos según el tipo de empleado
                            // Ejemplo: empleadoModificar.setHorasTrabajadas(nuevasHorasTrabajadas);

                            gestor.modificarEmpleado(indexModificar, empleadoModificar);
                        } else {
                            System.out.println("Índice inválido.");
                        }
                    }
                    case 3 -> {
                        System.out.print("Ingrese el índice del empleado a eliminar: ");
                        int indexEliminar = scanner.nextInt();
                        if (indexEliminar >= 0 && indexEliminar < gestor.empleados.size()) {
                            gestor.eliminarEmpleado(indexEliminar);
                        } else {
                            System.out.println("Índice inválido.");
                        }
                    }
                    case 4 -> gestor.calcularSueldosEImpuestos();
                    case 5 -> {
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Opción inválida. Por favor, intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                scanner.nextLine(); // Limpiar el búfer del Scanner
                // Importante limpiarlo sino NO PARARÁ de ITERAR XD
            }
        }
    }
}

