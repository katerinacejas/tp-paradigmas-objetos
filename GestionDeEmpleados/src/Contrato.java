public abstract class Contrato {
    protected int cantidadDeHoras;
    protected int sueldoBasico;

    public Contrato (int unSueldoBasico){
        this.sueldoBasico = unSueldoBasico;
    }

    public int getSueldoBasico() {
        return this.sueldoBasico;
    }

    public int getCantidadDeHoras() {
        return this.cantidadDeHoras;
    }

    public abstract int calcularSueldo(Empleado empleado);

}
