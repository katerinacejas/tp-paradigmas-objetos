import java.time.LocalDate;
import java.util.*;

public class Empleado {
    private String nombreCompleto;
    private int dni;
    private Cargo cargo;
    private int horasExtra = 0;
    private Contrato contrato;
    private LocalDate fechaDeIngreso;
    private int nivelDeRendimiento; //del 1 al 5
    private int horasTrabajadas = 0; // conteo de horas totales en 0


    //puse set porque no puede haber repetidos los bonos
    private Set<Bono> bonos;


    //list porque puede tener varias licencias del mismo tipo en la coleccion
    private List<Licencia> licencias;

    //constructor
    public Empleado (String unNombreCompleto, int unDni, Cargo unCargo, Contrato unContrato, LocalDate unaFechaDeIngreso) {
        this.nombreCompleto = unNombreCompleto;
        this.dni = unDni;
        this.cargo = unCargo;
        this.contrato = unContrato;
        this.licencias = new ArrayList<>(); //acá la lista de licencias que corresponda.
        this.bonos = new HashSet<>();

        //si queremos que la fecha de ingreso sea en este instante, se debería iniciar así
        this.fechaDeIngreso = LocalDate.now();

        //sino, se le pasa la fecha por parámetro.
        this.fechaDeIngreso = unaFechaDeIngreso;

        //por default al inicio por ser valor intermedio
        this.nivelDeRendimiento = 3;


    }
    // incrementa horas trabajadas
    public void incrementarHorasTrabajadas(int horas) {
        this.horasTrabajadas += horas;
    }
    //getter de horasTrabajadas
    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }
    //getter de nivelDeRendimiento
    public int getNivelDeRendimiento()
        return nivelDeRendimiento;

    public void agregarLicenciaEstudio(int horas) {
        LicenciaPorDiaDeEstudio licencia = new LicenciaPorDiaDeEstudio(horas);
        licencias.add(licencia);
    }

    public void agregarLicenciaEnfermedad(int horas) {
        LicenciaPorEnfermedad licencia = new LicenciaPorEnfermedad(horas);
        licencias.add(licencia);
    }

    public void agregarLicenciaFallecimiento(int horas) {
        LicenciaPorFallecimiento licencia = new LicenciaPorFallecimiento(horas);
        licencias.add(licencia);
    }

    public void agregarLicenciaNacimiento(int horas) {
        LicenciaPorNacimiento licencia = new LicenciaPorNacimiento(horas);
        licencias.add(licencia);
    }

    public void agregarLicenciaVacaciones(int horas) {
        LicenciaPorVacaciones licencia = new LicenciaPorVacaciones(horas);
        licencias.add(licencia);
    }

    public int calcularHorasTotalesLicencia() {
        int totalHoras = 0;
        for (Licencia licencia : licencias) {
            totalHoras += licencia.getHoras(); // Sumar horas de cada licencia
        }
        return totalHoras;
    }

    public void hacerHorasExtra(int unasHorasExtra) {
        this.horasExtra += unasHorasExtra;
    }

    public int calcularSueldo() {
        // esto no debería ser empleado.getCargo().getSueldoBasico(); ?
        return 0;
    }

    public int calcularBonoRendimiento() {
        return this.bonos.getFirst().calcularBono(this);
    }

    public int calcularBonoPresentismo() {
        BonoPresentismo bonoPresentismo = new BonoPresentismo();
        return bonoPresentismo.calcularBono(this)
    }

    public int calcularBonoAntiguedad() {
        BonoAntiguedad bonoAntiguedad = new BonoAntiguedad();
        return bonoAntiguedad.calcularBono(this);
    }

    public void mejorarRendimiento() {
        // Método vacío
    }

    public void cambiarDeCargo(Cargo cargo) {
        // Método vacío
    }

    public void tomarLicencia(Licencia licencia) {
        //
    }

    //getters
    public LocalDate getFechaDeIngreso() {
        return this.fechaDeIngreso;
    }

    public Contrato getContrato() {
        return this.contrato;
    }

    public Cargo getCargo(){
        return this.cargo;
    }
}
