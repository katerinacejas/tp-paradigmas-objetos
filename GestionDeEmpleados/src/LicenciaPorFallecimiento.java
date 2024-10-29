import java.time.LocalDate;

public class LicenciaPorFallecimiento extends Licencia {
    public PoliticaDiasPorLicencia parienteFallecido;

    public LicenciaPorFallecimiento(LocalDate unaFechaInicio, LocalDate unaFechaFin, PoliticaDiasPorLicencia unParienteFallecido) {
        super(unaFechaInicio, unaFechaFin);
        this.parienteFallecido = unParienteFallecido;
        System.out.println("la cantidad de dias duracion es = " + diasDuracion);
    }

    public boolean puedeSerTomadaPor(Empleado unEmpleado) {
        return this.diasDuracion <= this.parienteFallecido.getDiasPermitidosPorLicencia();
    }
}