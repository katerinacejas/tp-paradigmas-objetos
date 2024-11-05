import java.time.LocalDate;
public class BonoPresentismo extends Bono {
    @Override
    public int calcularBono(Empleado empleado) {
        Calendario anioActual = new Calendario();
        return (empleado.getDiasTrabajadosMes() * 100)/anioActual.diasHabilesMesActual(LocalDate.now().getMonthValue()) >= 90 ?
                (int) (empleado.calcularSueldo() * 0.05) : 0; //si tiene más del 90% de presentismo
                                                              //el bono es del 5%.
    }
}
