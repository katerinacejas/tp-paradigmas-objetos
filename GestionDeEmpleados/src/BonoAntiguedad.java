import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BonoAntiguedad extends Bono {
    @Override
    public int calcularBono(Empleado empleado) {
        long diasEntreFechaIngresoYHoy = ChronoUnit.DAYS.between(empleado.getFechaDeIngreso(), LocalDate.now());

        if (diasEntreFechaIngresoYHoy >= 180) { // Al menos 6 meses de antigüedad
            int sueldo = empleado.getCargo().getSueldoBasico();
            int horasContrato = empleado.getContrato().getCantidadDeHoras();

            // Cálculo del bono: proporcional en relacion a las horas según contrato +  proporcional en relación al tope de años en cuenta respecto a años de trabajo (10 años)
            double bono = sueldo * (horasContrato / 8.0) + sueldo * ((diasEntreFechaIngresoYHoy / 365.0) / 10.0);
            // Es decir, se agrega 0,5 de un sueldo basico a parttimers y 1 a fulltimets + un bono de 1 sueldo a quien lleve 10 años o más en la empresa, o el proporcional a un sueldo segun cantidad de años.

            // Retornar el bono como entero
            return (int) bono;
        } else {
            return 0; // No tiene 6 meses de antigüedad, no recibe bono
        }
    }
}
