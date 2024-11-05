public class ContratoFullTime extends Contrato{

    public ContratoFullTime(int unSueldoBasico) {
        super(unSueldoBasico);
        this.cantidadDeHoras = 8;
    }

    public int calcularBonoRendimiento(Empleado empleado) {
        BonoPresentismo bonoRendimiento = new BonoPresentismo();
        return bonoRendimiento.calcularBono(empleado);
    }

    public int calcularBonoPresentismo(Empleado empleado) {

        BonoPresentismo bonoPresentismo = new BonoPresentismo();
        return bonoPresentismo.calcularBono(empleado);
    }

    public int calcularBonoAntiguedad(Empleado empleado) {
        BonoAntiguedad bonoAntiguedad = new BonoAntiguedad();
        return bonoAntiguedad.calcularBono(empleado);
    }

    @Override
    public int calcularSueldo(Empleado empleado) {
       return (int) (this.sueldoBasico + calcularBonoAntiguedad(empleado)
                + calcularBonoPresentismo(empleado)
                + calcularBonoRendimiento(empleado));

    }
}
