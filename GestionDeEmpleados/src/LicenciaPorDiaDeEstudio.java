import java.time.LocalDate;

public class LicenciaPorDiaDeEstudio extends Licencia {
    public LicenciaPorDiaDeEstudio(LocalDate unaFechaInicio, LocalDate unaFechaFin) {
        super(unaFechaInicio, unaFechaFin);
        System.out.println("la cantidad de dias duracion es = " + diasDuracion);
    }

    public boolean puedeSerTomadaPor(Empleado unEmpleado){
        return this.diasTotalesTomadosMasEstaLicencia(unEmpleado, this.getClass()) <= 10;
    }

}
