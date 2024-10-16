import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BonoAntiguedad extends Bono{
    @Override
    public int calcularBono(Empleado empleado) {
        long diasEntreFechaIngresoYHoy = ChronoUnit.DAYS.between(empleado.getFechaDeIngreso(), LocalDate.now());

        if(diasEntreFechaIngresoYHoy >= 180) { //significa que el empleado ya tiene al menos 6 meses de antiguedad
            int sueldo = empleado.getCargo().getSueldoBasico();
            int horasQueTrabaja = empleado.getContrato().getCantidadDeHoras();

            // falta definir el algoritmo para el calculo del bono de antiguedad teniendo en cuenta lo de arriba
            // return
        }
        else { //no tiene 6 meses de antiguedad, entonces no cobra el bono
            return 0;
        }

        return 0;
    }
}