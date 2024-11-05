public abstract class Contrato {
    protected int cantidadDeHoras;
    protected int sueldoBasico;

    public int getSueldoBasico(){return this.sueldoBasico;}
    public int getCantidadDeHoras() {
        return this.cantidadDeHoras;
    }
    public int calcularSueldo(Empleado empleado) {return this.sueldoBasico; }

}
