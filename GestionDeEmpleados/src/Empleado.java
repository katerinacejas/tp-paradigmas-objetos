import java.time.LocalDate;
import java.util.*;

public class Empleado {
    private String nombreCompleto;
    private int dni;
    private Sexo sexo;
    private Cargo cargo;
    private int horasExtra = 0;
    private Contrato contrato;
    private LocalDate fechaDeIngreso;
    private int nivelDeRendimiento; //del 1 al 5
    private HashSet<Bono> bonos;
    private HashSet<Licencia> licencias;

    //constructor
    public Empleado (String unNombreCompleto, int unDni, Cargo unCargo, Contrato unContrato, LocalDate unaFechaDeIngreso, Sexo unSexo) {
        this.nombreCompleto = unNombreCompleto;
        this.dni = unDni;
        this.cargo = unCargo;
        this.contrato = unContrato;
        this.licencias = new HashSet<>();
        this.bonos = new HashSet<>();
        this.fechaDeIngreso = unaFechaDeIngreso;
        this.nivelDeRendimiento = 3; //por default al inicio por ser valor intermedio
        this.sexo = unSexo;
    }

    public void hacerHorasExtra(int unasHorasExtra) {
        this.horasExtra += unasHorasExtra;
    }

    public int calcularSueldo() {
        // esto debería ser el calculo de la suma de
        /*
            sueldo basico +
            bonos que corresponda cobrar ese mes +
            valor de las horas extra +
            valor por los días de estudio que se haya pedido
            y se resta el valor de los dias de vacaciones que se haya pedido si se las pidio antes de cobrar el sueldo,
            porque las vacaciones se pagan adelantadas
            (las licencias por fallecimiento, enfermedad y nacimiendo no modifican el sueldo final del empleado)
         */
        return 0;
    }

    public int calcularBonoRendimiento() {
        return 0;
    }

    public int calcularBonoPresentismo() {
        BonoPresentismo bonoPresentismo = new BonoPresentismo();
        return bonoPresentismo.calcularBono(this);
    }

    public int calcularBonoAntiguedad() {
        BonoAntiguedad bonoAntiguedad = new BonoAntiguedad();
        return bonoAntiguedad.calcularBono(this);
    }

    public void mejorarRendimiento() {
        this.nivelDeRendimiento++;
    }

    public void empeorarRendimiento() {
        this.nivelDeRendimiento--;
    }

    public void cambiarDeCargo(Cargo otroCargo) {
        this.cargo = otroCargo;
    }

    public void tomarLicencia(Licencia unaLicencia) {
        if (unaLicencia.puedeSerTomadaPor(this)){
            unaLicencia.serTomadaPor(this);
            licencias.add(unaLicencia);
        }
        else {
            // aca se lanzaría una excepcion o error por no poder tomar la licencia.
        }
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

    public int getNivelDeRendimiento() {
        return this.nivelDeRendimiento;
    }

    public int getHorasExtra() {
        return this.horasExtra;
    }

    public Sexo getSexo() {
        return this.sexo;
    }

    public int calcularHorasTotalesLicencia() {
        int totalHoras = 0;
        for (Licencia licencia : licencias) {
    //        totalHoras += licencia.getHoras(); // Sumar horas de cada licencia
        }
        return totalHoras;
    }
}
