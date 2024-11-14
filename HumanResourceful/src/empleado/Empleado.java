package empleado;

import licencia.Licencia;
import contrato.Contrato;
import licencia.ExcepcionLicenciaDenegada;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Empleado {
    private String nombreCompleto;
    private int dni;
    private Sexo sexo;
    private int horasExtra = 0;
    private Contrato contrato;
    private LocalDate fechaDeIngreso;
    private int nivelDeRendimiento; //del 1 al 5
    private Set<Licencia> licencias = new HashSet<>();
    private Set<Titulo> titulosDeEstudio = new HashSet<>();

    // constructor para empleados sin titulos de estudio inicialmente
    public Empleado (String unNombreCompleto, int unDni, Contrato unContrato, LocalDate unaFechaDeIngreso, Sexo unSexo) {
        this.nombreCompleto = unNombreCompleto;
        this.dni = unDni;
        this.contrato = unContrato;
        this.fechaDeIngreso = unaFechaDeIngreso;
        this.nivelDeRendimiento = 3; //por default al inicio por ser valor intermedio
        this.sexo = unSexo;
    }

    // constructor para empleados que ya tienen titulo/titulos de estudio desde el inicio.
    public Empleado (String unNombreCompleto, int unDni, Contrato unContrato, LocalDate unaFechaDeIngreso, Sexo unSexo, Set<Titulo> unosTitulosDeEstudio) {
        this.nombreCompleto = unNombreCompleto;
        this.dni = unDni;
        this.contrato = unContrato;
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

    public void mejorarRendimiento() {
        // esto es para que nunca sea el rendimiento mayor a 5. Ese es el tope
        this.nivelDeRendimiento = Math.min(this.nivelDeRendimiento + 1, 5);
    }

    public void empeorarRendimiento() {
        // esto es para que nunca sea el rendimiento menor a 0. Ese es el piso
        this.nivelDeRendimiento = Math.max(this.nivelDeRendimiento - 1, 0);
    }


    public String tomarLicencia(Licencia unaLicencia) {
        try {
            if (!unaLicencia.puedeSerTomadaPor(this)) {
                throw new ExcepcionLicenciaDenegada(this.getNombreCompleto());
            }
            licencias.add(unaLicencia);
            return "El empleado se tomó la licencia";

        } catch (ExcepcionLicenciaDenegada excepcion) {
            return "Error: " + excepcion.getMessage();
        }
    }

    public Set<Licencia> licenciasTranscurridasEnElMesActual() {
        return this.licencias.stream()
                .filter(licencia -> licencia.getFechaInicio().getYear() == LocalDate.now().getYear() &&
                                    licencia.getFechaInicio().getMonth() == LocalDate.now().getMonth() )
                .collect(Collectors.toSet());
    }

    public boolean tuveLicenciasEnElMesActual () {
        return ! this.licenciasTranscurridasEnElMesActual().isEmpty();
    }

    public int getDiasTrabajadosMes() {
        Calendario anioActual = new Calendario();
        int cantDiasHabiles = anioActual.diasHabilesMesActual(LocalDate.now().getMonthValue());
        int cantDiasTomadosDeLicenciaEnElMes = this.licenciasTranscurridasEnElMesActual().stream()
                                                .mapToInt(licencia -> licencia.getDiasDuracion())
                                                .sum();
        return cantDiasHabiles - cantDiasTomadosDeLicenciaEnElMes;
    }

    public int calcularPlusPorLicenciasDeEstudio() {
        return this.licenciasTranscurridasEnElMesActual().stream()
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

    public Set<Titulo> getTitulosDeEstudio() {
        return this.titulosDeEstudio;
    }

    public String getNombreCompleto() {
        return this.nombreCompleto;
    }
}
