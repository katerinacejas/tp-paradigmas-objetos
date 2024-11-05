public class ContratoFullTime extends Contrato{
    private int cantidadDeHoras;
    private int sueldo;

    public int getCantidadDeHoras() {
        return this.cantidadDeHoras;
    }

    public int calcularBonoRendimiento(Empleado empleado) {
        return 0;
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
        return this.sueldo;

    }


}
