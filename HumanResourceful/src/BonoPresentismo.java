import java.time.LocalDate;
public class BonoPresentismo implements BonoCalculable {
    @Override
    public int calcularBono(Empleado empleado) {
        Calendario anioActual = new Calendario();
        return (empleado.getDiasTrabajadosMes() * 100)/anioActual.diasHabilesMesActual(LocalDate.now().getMonthValue()) >= 90 ?
                (int) (empleado.getContrato().getSueldoBasico() * 0.05) //si tiene más del 90% de presentismo el bono es del 5%
                : 0; //sino, no cobra bono
    }
}
