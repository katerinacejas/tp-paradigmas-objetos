import java.time.LocalDate;
import java.util.*;

public class Empleado {
    private String nombreCompleto;
    private int dni;
    private Cargo cargo;
    private int horasExtra = 0;
    private Contrato contrato;
    private List<Bono> bonos;
    private LocalDate fechaDeIngreso;
    private int nivelDeRendimiento; //del 1 al 5
    private List<Licencia> licencias;

    //constructor
    public Empleado (String unNombreCompleto, int unDni, Cargo unCargo, Contrato unContrato) {
        this.nombreCompleto = unNombreCompleto;
        this.dni = unDni;
        this.cargo = unCargo;
        this.contrato = unContrato;

        //esto podríamos ponerle una fecha vieja para que en el bono de antiguedad haya mas de 6 meses de diferencia y pueda cobrarlo
        this.fechaDeIngreso = LocalDate.now();

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
}
