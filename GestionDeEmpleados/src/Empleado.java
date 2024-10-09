import java.util.*;

public class Empleado {
    private String nombreCompleto;
    private int dni;
    private Cargo cargo;
    private int horasExtra = 0;
    private Contrato contrato;
    private List<Bono> bonos;
    private Date fechaDeIngreso;
    private int nivelDeRendimiento; //del 1 al 5
    private List<Licencia> licencias;

    public void hacerHorasExtra(int unasHorasExtra) {
        this.horasExtra += unasHorasExtra;
    }

    public int calcularSueldo() {
        // Método vacío
        return 0;
    }

    public int calcularBonoRendimiento() {
        return this.bonos.getFirst().calcularBono(this);
    }

    public int calcularBonoPresentismo() {
        // Método vacío
        return 0;
    }

    public int calcularBonoAntiguedad() {
        // Método vacío
        return 0;
    }

    public void mejorarRendimiento() {
        // Método vacío
    }

    public void cambiarDeCargo(Cargo cargo) {
        // Método vacío
    }

    public void tomarLicencia(Licencia licencia) {
        // Método vacío
    }
}
