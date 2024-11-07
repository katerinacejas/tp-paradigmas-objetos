import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BonoAntiguedad implements BonoCalculable {

    @Override
    public int calcularBono(Empleado empleado) {
        double aniosAntiguedad = ChronoUnit.DAYS.between(empleado.getFechaDeIngreso(), LocalDate.now()) / 365.0;
        return aniosAntiguedad * 365 >= 180 ? // Tiene al menos 6 meses de antigüedad
                        // Ajuste proporcional según las horas del contrato (0.5 si es medio tiempo, 1 si es tiempo completo)
                (int) ( (empleado.getContrato().getSueldoBasico() * (empleado.getContrato().getCantidadDeHoras() / 8.0)) +
                        // 10% del sueldo básico por cada año, hasta un máximo del 100% (un sueldo completo)
                        (empleado.getContrato().getSueldoBasico() * Math.min(aniosAntiguedad * 0.10, 1.0)) )

                : 0; // No tiene 6 meses de antigüedad, no recibe bono
    }
}
