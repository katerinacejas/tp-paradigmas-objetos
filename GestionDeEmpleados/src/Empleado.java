import java.util.Date;

public class Empleado {
    private String nombreCompleto;
    private int dni;
    private Cargo cargo;
    private int ausenciasNoLicencia;
    private int horasExtra;
    private Contrato contrato;
    private BonoRendimiento bonoRendimiento;
    private BonoPresentismo bonoPresentismo;
    private BonoAntiguedad bonoAntiguedad;
    private Date fechaDeIngreso;
    private int nivelDeRendimiento; //del 1 al 5
    private boolean estaDeLicencia;
}
