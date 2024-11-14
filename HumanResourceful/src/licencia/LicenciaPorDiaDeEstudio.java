package licencia;

import java.time.LocalDate;
import empleado.Empleado;

public class LicenciaPorDiaDeEstudio extends Licencia {
    public LicenciaPorDiaDeEstudio(LocalDate unaFechaInicio, LocalDate unaFechaFin) {
        super(unaFechaInicio, unaFechaFin);
        System.out.println("la cantidad de dias duracion es = " + diasDuracion);
    }

    public boolean puedeSerTomadaPor(Empleado unEmpleado){
        return this.diasTotalesTomadosMasEstaLicencia(unEmpleado, this.getClass()) <= 10;
    }

    public int plusPorLosDiasTomados() {
        return this.diasDuracion * 13000; // $13000 es lo que vale 1 dia de estudio.
    }

}
