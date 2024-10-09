public abstract class Bono {
    protected int porcentajeSueldo;
    protected int importe;
    protected int frecuencia;

    public abstract int calcularBono(Empleado empleado);
}
