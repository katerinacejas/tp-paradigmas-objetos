public abstract class Contrato {
    protected int cantidadDeHoras;
    protected int sueldo;

    public int getCantidadDeHoras() {
        return this.cantidadDeHoras;
    }
    public int calcularSueldo(Empleado empleado) {return this.sueldo; }

}
