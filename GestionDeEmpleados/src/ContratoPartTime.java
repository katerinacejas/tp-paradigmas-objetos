public class ContratoPartTime extends Contrato{

    public ContratoPartTime(int unSueldoBasico) {
        super(unSueldoBasico);
        this.cantidadDeHoras = 6;
    }

    public int calcularBonoPresentismo(Empleado empleado) {
        BonoPresentismo bonoPresentismo = new BonoPresentismo();
        return bonoPresentismo.calcularBono(empleado);
    }

    @Override
    public int calcularSueldo(Empleado empleado) {
        return 0;

    }

}
