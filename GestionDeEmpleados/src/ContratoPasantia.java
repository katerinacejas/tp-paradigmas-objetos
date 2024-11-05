public class ContratoPasantia extends Contrato{
    private int cantidadDeHoras;
    private int sueldo;

    public int getCantidadDeHoras() {
        return this.cantidadDeHoras;
    }

    @Override
    public int calcularSueldo(Empleado empleado) {
        return this.sueldo;

    }
}
