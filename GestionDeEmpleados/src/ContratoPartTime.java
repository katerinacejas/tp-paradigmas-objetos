public class ContratoPartTime extends Contrato{

    private int cantidadDeHoras;
    private int sueldo;

    public int getCantidadDeHoras() {
        return this.cantidadDeHoras;
    }

    public int calcularBonoPresentismo(Empleado empleado) {

        BonoPresentismo bonoPresentismo = new BonoPresentismo();
        return bonoPresentismo.calcularBono(empleado);
    }

    @Override
    public int calcularSueldo(Empleado empleado) {
        return this.sueldo;

    }

}
