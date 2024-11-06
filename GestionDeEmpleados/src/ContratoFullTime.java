public class ContratoFullTime extends Contrato{
    private Bono bonoRendimiento;
    private Bono bonoPresentismo;
    private Bono bonoAntiguedad;
    private Bono bonoPorTitulosDeEstudio;

    public ContratoFullTime(int unSueldoBasico) {
        super(unSueldoBasico);
        this.cantidadDeHoras = 8;
        this.bonoAntiguedad = new BonoAntiguedad();
        this.bonoRendimiento = new BonoRendimiento();
        this.bonoPresentismo = new BonoPresentismo();
        this.bonoPorTitulosDeEstudio = new BonoPorTitulosDeEstudios();
    }

    @Override
    public int calcularSueldo(Empleado empleado) {
        return this.sueldoBasico
                + bonoRendimiento.calcularBono(empleado)
                + bonoPresentismo.calcularBono(empleado)
                + bonoAntiguedad.calcularBono(empleado)
                + bonoPorTitulosDeEstudio.calcularBono(empleado)
                + empleado.calcularPlusPorLicenciasDeEstudio();
    }
}
