import java.time.LocalDate;

public class LicenciaPorVacaciones extends Licencia {

    public LicenciaPorVacaciones(LocalDate unaFechaInicio, LocalDate unaFechaFin, int unosDiasDuracion) {
        super(unaFechaInicio);

        this.fechaFin = unaFechaInicio.plusDays(((long) unosDiasDuracion));
        this.diasDuracion = unosDiasDuracion;

    }

    public boolean puedeSerTomadaPor(Empleado unEmpleado){
        return true;
    }

    public void serTomadaPor(Empleado unEmpleado){

    }

}