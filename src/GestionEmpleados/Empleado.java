package GestionEmpleados;

// Clase abstracta Empleado
public abstract class Empleado {
    // Atributos
    protected String nombre;   // Nombre del empleado
    protected int id;          // Identificación del empleado
    protected double sueldoBase;  // Sueldo base del empleado

    // Constructor
    public Empleado(String nombre, int id, double sueldoBase) {
        this.nombre = nombre;
        this.id = id;
        this.sueldoBase = sueldoBase;
    }

    // Método abstracto para calcular el sueldo del empleado
    public abstract double calcularSueldo();

    public void setNombre(String nuevoNombre) {
    }

    public String getNombre() {
        return nombre;
    }
}


