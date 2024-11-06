import java.time.LocalDate;

public class LicenciaPorNacimiento extends Licencia {

    public LicenciaPorNacimiento(LocalDate unaFechaInicio, LocalDate unaFechaFin) {
        super(unaFechaInicio, unaFechaFin);
        System.out.println("la cantidad de dias duracion es = " + diasDuracion);
    }

    public boolean puedeSerTomadaPor(Empleado unEmpleado){
        return this.diasDuracion <= this.getDiasPermitidosPorSexo(unEmpleado);
    }

    public int getDiasPermitidosPorSexo(Empleado unEmpleado) {
        return unEmpleado.getSexo() == Sexo.FEMENINO ? 90 : 2;
    }

    public int plusPorLosDiasTomados() {
        return 0; //no se da ningun plus por tomarse dias por nacimiento
    }
}