import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

    public String tomarLicencia(Licencia unaLicencia) {
        if (unaLicencia.puedeSerTomadaPor(this)){
            licencias.add(unaLicencia);
            return "El empleado se tomó la licencia";
        }
        else {
            // aca se lanzaría una excepcion o error por no poder tomar la licencia.
            // por ahora un String xq no se como son las excepciones.
            return "El empleado ya no tiene dias disponibles para tomarse esa licencia";
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

    public int getAntiguedadEnAnios() {
        return (int) ChronoUnit.YEARS.between(this.fechaDeIngreso, LocalDate.now());
    }
    public HashSet<Bono> getBonos() {
        return this.bonos;
    }

    public HashSet<Licencia> getLicencias() {
        return this.licencias;
    }
}
