public class ContratoPasantia extends Contrato{

    public ContratoPasantia (int unSueldoBasico) {
        super(unSueldoBasico);
        this.cantidadDeHoras = 4;
        this.valorPorHoraExtra = 2500;
    }

    @Override
    public int calcularSueldo(Empleado empleado) {
        return this.sueldoBasico
                + empleado.calcularPlusPorLicenciasDeEstudio()
                + this.valorPorHoraExtra * empleado.getHorasExtra() ;
    }
}
