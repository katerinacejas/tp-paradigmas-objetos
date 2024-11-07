import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BonoAntiguedad extends Bono {
    public int algoritmoDelBono(double aniosAntiguedad, int sueldoBasico, int horasContrato) {
                        // Ajuste proporcional según las horas del contrato (0.5 si es medio tiempo, 1 si es tiempo completo)
        return (int) ( (sueldoBasico * (horasContrato / 8.0)) +
                        // 10% del sueldo básico por cada año, hasta un máximo del 100% (un sueldo completo)
                        (sueldoBasico * Math.min(aniosAntiguedad * 0.10, 1.0)) );
    }

    @Override
    public int calcularBono(Empleado empleado) {
        long diasEntreFechaIngresoYHoy = ChronoUnit.DAYS.between(empleado.getFechaDeIngreso(), LocalDate.now());
        return diasEntreFechaIngresoYHoy >= 180 ?
                algoritmoDelBono(diasEntreFechaIngresoYHoy / 365.0 , empleado.getContrato().getSueldoBasico(), empleado.getContrato().getCantidadDeHoras())  // Al menos 6 meses de antigüedad
                : 0; // No tiene 6 meses de antigüedad, no recibe bono
    }
}
