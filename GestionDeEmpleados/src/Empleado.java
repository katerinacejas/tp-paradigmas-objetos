import java.time.LocalDate;
import java.util.*;

public class Empleado {
    private String nombreCompleto;
    private int dni;
    private Cargo cargo;
    private int horasExtra = 0;
    private Contrato contrato;
    private LocalDate fechaDeIngreso;
    private int nivelDeRendimiento; //del 1 al 5

    //puse set porque no puede haber repetidos los bonos
    private Set<Bono> bonos;

    //list porque puede tener varias licencias del mismo tipo en la coleccion
    private List<Licencia> licencias;

    //constructor
    public Empleado (String unNombreCompleto, int unDni, Cargo unCargo, Contrato unContrato, LocalDate unaFechaDeIngreso) {
        this.nombreCompleto = unNombreCompleto;
        this.dni = unDni;
        this.cargo = unCargo;
        this.contrato = unContrato;

        //si queremos que la fecha de ingreso sea en este instante, se debería iniciar así
        this.fechaDeIngreso = LocalDate.now();

        //sino, se le pasa la fecha por parámetro.
        this.fechaDeIngreso = unaFechaDeIngreso;

        //por default al inicio por ser valor intermedio
        this.nivelDeRendimiento = 3;
    }

    public void hacerHorasExtra(int unasHorasExtra) {
        this.horasExtra += unasHorasExtra;
    }

    public int calcularSueldo() {
        // Método vacío
        return 0;
    }

    public int calcularBonoRendimiento() {
        return this.bonos.getFirst().calcularBono(this);
    }

    public int calcularBonoPresentismo() {
        // Método vacío
        return 0;
    }

    public int calcularBonoAntiguedad() {
        // Método vacío
        return 0;
    }

    public void mejorarRendimiento() {
        // Método vacío
    }

    public void cambiarDeCargo(Cargo cargo) {
        // Método vacío
    }

    public void tomarLicencia(Licencia licencia) {
        // Método vacío
    }

    //getters
    public LocalDate getFechaDeIngreso() {
        return this.fechaDeIngreso;
    }

    public Contrato getContrato() {
        return this.contrato;
    }

    public Cargo getCargo(){
        return this.cargo;
    }
}
