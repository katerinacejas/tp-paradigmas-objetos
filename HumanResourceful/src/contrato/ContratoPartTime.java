package contrato;
import empleado.Empleado;
import bono.BonoCalculable;
import bono.BonoPresentismo;
import bono.BonoPorTitulosDeEstudios;

public class ContratoPartTime extends Contrato{
    private BonoCalculable bonoPorTitulosDeEstudio;
    private BonoCalculable bonoPresentismo;

    public ContratoPartTime(int unSueldoBasico) {
        super(unSueldoBasico);
        this.bonoPresentismo = new BonoPresentismo();
        this.bonoPorTitulosDeEstudio = new BonoPorTitulosDeEstudios();
        this.cantidadDeHoras = 6;
        this.valorPorHoraExtra = 5000;
    }

    @Override
    public int calcularSueldo(Empleado empleado) {
        return this.sueldoBasico
                + bonoPresentismo.calcularBono(empleado)
                + bonoPorTitulosDeEstudio.calcularBono(empleado)
                + empleado.calcularPlusPorLicenciasDeEstudio()
                + this.valorPorHoraExtra * empleado.getHorasExtra() ;
    }

}
