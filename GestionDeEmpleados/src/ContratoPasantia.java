public class ContratoPasantia extends Contrato{

    public ContratoPasantia (int unSueldoBasico) {
        super(unSueldoBasico);
        this.cantidadDeHoras = 4;
    }

    @Override
    public int calcularSueldo(Empleado empleado) {
        return 0;

    }
}
