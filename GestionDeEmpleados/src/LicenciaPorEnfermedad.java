import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LicenciaPorEnfermedad extends Licencia {

    public LicenciaPorEnfermedad(LocalDate unaFechaInicio, LocalDate unaFechaFin) {
        super(unaFechaInicio, unaFechaFin);
        System.out.println("la cantidad de dias duracion es = " + diasDuracion);
    }

    public boolean puedeSerTomadaPor(Empleado unEmpleado){
        return unEmpleado.getAntiguedadEnAnios() < 5 ?
                    this.diasTotalesTomadosMasEstaLicencia(unEmpleado, this.getClass()) <= 90
                    : this.diasTotalesTomadosMasEstaLicencia(unEmpleado, this.getClass()) <= 180;
    }

}