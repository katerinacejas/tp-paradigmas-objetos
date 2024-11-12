public class ContratoFullTime extends Contrato{
    private BonoCalculable bonoRendimiento;
    private BonoCalculable bonoPresentismo;
    private BonoCalculable bonoAntiguedad;
    private BonoCalculable bonoPorTitulosDeEstudio;

    public ContratoFullTime(int unSueldoBasico) {
        super(unSueldoBasico);
        this.bonoAntiguedad = new BonoAntiguedad();
        this.bonoRendimiento = new BonoRendimiento();
        this.bonoPresentismo = new BonoPresentismo();
        this.bonoPorTitulosDeEstudio = new BonoPorTitulosDeEstudios();
        this.cantidadDeHoras = 8;
        this.valorPorHoraExtra = 7500;
    }

    @Override
    public int calcularSueldo(Empleado empleado) {
        return this.sueldoBasico
                + bonoRendimiento.calcularBono(empleado)
                + bonoPresentismo.calcularBono(empleado)
                + bonoAntiguedad.calcularBono(empleado)
                + bonoPorTitulosDeEstudio.calcularBono(empleado)
                + empleado.calcularPlusPorLicenciasDeEstudio()
                + this.valorPorHoraExtra * empleado.getHorasExtra() ;
    }
}
