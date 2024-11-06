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
    private Set<Licencia> licencias;
    private int diasTrabajadosMes;
    private Set<Titulo> titulosDeEstudio;

    // constructor para empleados sin titulos de estudio inicialmente
    public Empleado (String unNombreCompleto, int unDni, Cargo unCargo, Contrato unContrato, LocalDate unaFechaDeIngreso, Sexo unSexo) {
        this.nombreCompleto = unNombreCompleto;
        this.dni = unDni;
        this.cargo = unCargo;
        this.contrato = unContrato;
        this.licencias = new HashSet<>();
        this.fechaDeIngreso = unaFechaDeIngreso;
        this.nivelDeRendimiento = 3; //por default al inicio por ser valor intermedio
        this.sexo = unSexo;
        this.titulosDeEstudio = new HashSet<>();
    }

    // constructor para empleados que ya tienen titulo/titulos de estudio desde el inicio.
    public Empleado (String unNombreCompleto, int unDni, Cargo unCargo, Contrato unContrato, LocalDate unaFechaDeIngreso, Sexo unSexo, Set<Titulo> unosTitulosDeEstudio) {
        this.nombreCompleto = unNombreCompleto;
        this.dni = unDni;
        this.cargo = unCargo;
        this.contrato = unContrato;
        this.licencias = new HashSet<>();
        this.fechaDeIngreso = unaFechaDeIngreso;
        this.nivelDeRendimiento = 3; //por default al inicio por ser valor intermedio
        this.sexo = unSexo;
        this.titulosDeEstudio = unosTitulosDeEstudio;
    }

    public int calcularSueldo() {
        return this.contrato.calcularSueldo(this);
    }

    public void hacerHorasExtra(int unasHorasExtra) {
        this.horasExtra += unasHorasExtra;
    }

    public void setDiasTrabajadosMes(int diasTrabajadosMes) {
        this.diasTrabajadosMes = diasTrabajadosMes;
        // aca deberia ser un calculo de:
        // la cantidad de dias habiles en el mes menos la cantidad de dias de licencia que se tomo en ese mes
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

    public int calcularPlusPorLicenciasDeEstudio() {
        return this.licencias.stream()
                .filter(licencia -> licencia.fechaInicio.getYear() == LocalDate.now().getYear() &&
                        licencia.fechaInicio.getMonth() == LocalDate.now().getMonth() )
                .mapToInt(licencia -> licencia.plusPorLosDiasTomados())
                .sum();
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

    public Set<Licencia> getLicencias() {
        return this.licencias;
    }

    public int getDiasTrabajadosMes() {
        return diasTrabajadosMes;
    }

    public Set<Titulo> getTitulosDeEstudio() {
        return this.titulosDeEstudio;
    }
}
