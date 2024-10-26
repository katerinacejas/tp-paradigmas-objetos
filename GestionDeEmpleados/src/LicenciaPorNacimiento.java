import java.time.LocalDate;

public class LicenciaPorNacimiento extends Licencia {

    public LicenciaPorNacimiento(LocalDate unaFechaInicio, LocalDate unaFechaFin, int unosDiasDuracion) {
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