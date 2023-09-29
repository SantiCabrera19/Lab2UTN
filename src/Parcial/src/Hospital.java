import java.util.*;
import java.io.*;

public class Hospital {

    static List<Doctor> doctors;
    static List<Paciente> pacientes;
    static String hospitalContactInfo;

    public static void main(String[] args) {
        doctors = new ArrayList<>();
        pacientes = new ArrayList<>();
        cargarDoctores();
        cargarDatosdeContactoHospital();
        // Menu
        while (true) {
            opcionesMenu();
            Scanner scanner = new Scanner(System.in);
            int opc = scanner.nextInt();
            switch (opc) {
                case 1:
                    listarDoctores();
                    break;
                case 2:
                    AñadirPaciente();
                    break;
                case 3:
                    ActualizarinformacionPaciente();
                    break;
                case 4:
                    verHistorialdelPaciente();
                    break;
                case 5:
                    AñadirEventoalPaciente();
                    break;
                case 6:
                    GuardarDatosdelPaciente();
                    break;
                case 7:
                    CargarDatosdelPaciente();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    public static void opcionesMenu() {
        System.out.println(hospitalContactInfo);
        System.out.println("Hospital Julio C. Perrando - Av. 9 de Julio 1100 · 0362 444-2399");
        System.out.println("Menú:");
        System.out.println("1. Listar Doctores.");
        System.out.println("2. Registrar un nuevo paciente.");
        System.out.println("3. Actualizar información personal de un paciente.");
        System.out.println("4. Consultar el historial médico de un paciente.");
        System.out.println("5. Nuevo historial para un paciente.");
        System.out.println("6. Guardar Historial de pacientes en archivo.");
        System.out.println("7. Cargar Historial de pacientes desde archivo.");
        System.out.println("8. Salir.");
    }

    public static void cargarDoctores() {
        doctors.add(new Doctor("Carlos Pérez", "12345678", "12/06/1975", "Cardiólogo"));
        doctors.add(new Doctor("Maria García", "23456789", "23/09/1980", "Neuróloga"));
    }

    public static void cargarDatosdeContactoHospital() {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Santiago\\Desktop\\Facultad\\Programacion - Java\\Parcial\\src\\datos.txt"))) {
            hospitalContactInfo = br.readLine();
        } catch (IOException e) {
            hospitalContactInfo = "Datos de contacto no disponibles.";
            System.err.println("Error al leer el archivo de datos: " + e.getMessage());
        }
    }

    public static void listarDoctores() {
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    public static void AñadirPaciente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el nombre del paciente:");
        String name = scanner.nextLine();
        System.out.println("Introduzca el DNI:");
        String dni = scanner.nextLine();
        System.out.println("Introduzca la fecha de nacimiento (dd/MM/yyyy):");
        String dob = scanner.nextLine();
        System.out.println("Introduzca el número de teléfono:");
        String phone = scanner.nextLine();
        System.out.println("Introduzca el tipo de sangre:");
        String bloodType = scanner.nextLine();
        Paciente newPaciente = new Paciente(name, dni, dob, phone, bloodType);
        pacientes.add(newPaciente);
        System.out.println("Paciente registrado exitosamente.");
    }

    public static void ActualizarinformacionPaciente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el DNI del paciente a actualizar:");
        String dni = scanner.nextLine();
        for (Paciente paciente : pacientes) {
            if (paciente.getDni().equals(dni)) {
                System.out.println("Introduzca el nuevo nombre del paciente:");
                paciente.setNombre(scanner.nextLine());
                System.out.println("Introduzca la nueva fecha de nacimiento (dd/MM/yyyy):");
                paciente.setFechaNacimiento(scanner.nextLine());
                System.out.println("Introduzca el nuevo número de teléfono:");
                paciente.setTelefono(scanner.nextLine());
                System.out.println("Introduzca el nuevo tipo de sangre:");
                paciente.setTipoDeSangre(scanner.nextLine());
                System.out.println("Información actualizada exitosamente.");
                return;
            }
        }
        System.out.println("No se encontró al paciente con DNI " + dni);
    }

    public static void verHistorialdelPaciente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el DNI del paciente a consultar:");
        String dni = scanner.nextLine();
        for (Paciente paciente : pacientes) {
            if (paciente != null && paciente.getDni() != null && paciente.getDni().equals(dni)) {
                paciente.verHistorialDeEventos();
                return;
            }
        }
        System.out.println("No se encontró al paciente con DNI " + dni);
    }


    public static void AñadirEventoalPaciente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el DNI del paciente:");
        String dni = scanner.nextLine();
        for (Paciente paciente : pacientes) {
            if (paciente.getDni().equals(dni)) {
                System.out.println("Introduzca la fecha del evento (dd/MM/yyyy):");
                String fecha = scanner.nextLine();
                System.out.println("Introduzca las observaciones del evento:");
                String observaciones = scanner.nextLine();
                paciente.addHistorial(new HistorialMedico(fecha, observaciones));
                System.out.println("Evento agregado exitosamente.");
                return;
            }
        }
        System.out.println("No se encontró al paciente con DNI " + dni);
    }
    public static void GuardarDatosdelPaciente() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("pacientes.data"))) {
            oos.writeObject(pacientes);
            System.out.println("Pacientes guardados exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar los pacientes: " + e.getMessage());
        }
    }

    public static void CargarDatosdelPaciente() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("pacientes.data"))) {
            pacientes = (List<Paciente>) ois.readObject();
            System.out.println("Pacientes cargados exitosamente.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar los pacientes: " + e.getMessage());
        }
    }

}

class Persona {
    private String nombre;
    private String dni;
    private String fechaNacimiento;

    public Persona(String nombre, String dni, String fechaNacimiento) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Persona(){

    }

    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
    public String getFechaNacimiento() { return fechaNacimiento; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDni(String dni) { this.dni = dni; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", DNI: " + dni + ", Fecha de Nacimiento: " + fechaNacimiento;
    }
}

class Doctor extends Persona {
    private String especialidad;

    public Doctor(String nombre, String dni, String fechaNacimiento, String especialidad) {
        super(nombre, dni, fechaNacimiento);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() { return especialidad; }

    @Override
    public String toString() {
        return super.toString() + ", Especialidad: " + especialidad;
    }
}

interface Informacion {
    void verHistorialDeEventos();
}

class Paciente extends Persona implements Informacion, Serializable {
    private String telefono;
    private String tipoDeSangre;
    private List<HistorialMedico> historialMedico;


    public Paciente(String nombre, String dni, String fechaNacimiento, String telefono, String tipoDeSangre) {
        super(nombre, dni, fechaNacimiento);
        this.telefono = telefono;
        this.tipoDeSangre = tipoDeSangre;
        this.historialMedico = new ArrayList<>();

    }

    public Paciente (){

    }



    public String getTelefono() { return telefono; }
    public String getTipoDeSangre() { return tipoDeSangre; }
    public List<HistorialMedico> getHistorialMedico() { return historialMedico; }

    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setTipoDeSangre(String tipoDeSangre) { this.tipoDeSangre = tipoDeSangre; }

    public void addHistorial(HistorialMedico historial) {
        historialMedico.add(historial);
    }



    @Override
    public void verHistorialDeEventos() {
        System.out.println("HISTORIAL MÉDICO:");
        for (HistorialMedico evento : historialMedico) {
            System.out.println(evento);
        }
    }
}

class HistorialMedico implements Serializable {
    private String fecha;
    private String observaciones;

    public HistorialMedico(String fecha, String observaciones) {
        this.fecha = fecha;
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return fecha + " - " + observaciones;
    }
}