public class ContratoFullTime extends Contrato{
    private int cantidadDeHoras;
    private int sueldoBasico;

    public int getSueldoBasico() {
        return sueldoBasico;
    }

    public void setCantidadDeHoras(int cantidadDeHoras) {
        this.cantidadDeHoras = cantidadDeHoras;
    }


    public int getCantidadDeHoras() {
        return this.cantidadDeHoras;
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
