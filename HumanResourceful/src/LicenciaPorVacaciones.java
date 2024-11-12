import java.time.LocalDate;

public class LicenciaPorVacaciones extends Licencia {

    public LicenciaPorVacaciones(LocalDate unaFechaInicio, LocalDate unaFechaFin) {
        super(unaFechaInicio, unaFechaFin);
        System.out.println("la cantidad de dias duracion es = " + diasDuracion);
    }

    public boolean puedeSerTomadaPor(Empleado unEmpleado){
        int diasPermitidos;
        if (unEmpleado.getAntiguedadEnAnios() < 5) {
            diasPermitidos = 14;
        }
        else if (unEmpleado.getAntiguedadEnAnios() >= 5 && unEmpleado.getAntiguedadEnAnios() < 10) {
            diasPermitidos = 21;
        }
        else if (unEmpleado.getAntiguedadEnAnios() >= 10 && unEmpleado.getAntiguedadEnAnios() < 20) {
            diasPermitidos = 28;
        }
        else {
            diasPermitidos = 35;
        }
        return this.diasTotalesTomadosMasEstaLicencia(unEmpleado, this.getClass()) <= diasPermitidos;
    }

    public int plusPorLosDiasTomados() {
        return 0; //no se da ningun plus por tomarse dias por vacaciones
    }

}