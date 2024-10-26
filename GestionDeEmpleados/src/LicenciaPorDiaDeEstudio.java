import java.time.LocalDate;

public class LicenciaPorDiaDeEstudio extends Licencia {
    private String materiaARendir;

    public LicenciaPorDiaDeEstudio(LocalDate unaFechaInicio, int unosDiasDuracion) {
        super(unaFechaInicio);

        this.fechaFin = unaFechaInicio.plusDays(((long) unosDiasDuracion));
        this.diasDuracion = unosDiasDuracion;

        //atributos comunes de esta

    }

    public boolean puedeSerTomadaPor(Empleado unEmpleado){
        return true;
    }

    public void serTomadaPor(Empleado unEmpleado){

    }

    //setters
    public void setMateriaARendir(String unaMateria) {
        this.materiaARendir = unaMateria;
    }
}
