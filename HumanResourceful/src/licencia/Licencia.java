package licencia;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import empleado.Empleado;

public abstract class Licencia {
    protected LocalDate fechaInicio;
    protected LocalDate fechaFin;
    protected int diasDuracion;

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public Licencia (LocalDate unaFechaInicio, LocalDate unaFechaFin){
        this.fechaInicio = unaFechaInicio;
        this.fechaFin = unaFechaFin;
        this.diasDuracion = (int) ChronoUnit.DAYS.between(unaFechaInicio, unaFechaFin);
    }

    public abstract boolean puedeSerTomadaPor(Empleado unEmpleado);

    public abstract int plusPorLosDiasTomados();

    //metodo utilizazdo en las licencias por estudio, por enfermedad y por vacaciones
    public int diasTotalesTomadosMasEstaLicencia(Empleado unEmpleado, Class<? extends Licencia> claseLicencia) {
        /*
            paso 1: obtengo la coleccion de licencias del empleado
            paso 2: filtro de todas las licencias las que son del tipo del objeto que llama a este metodo y que fueron tomadas en este año laboral
            paso 3: me quedo con una coleccion de todos los días de duracion de cada licencia de ese tipo de este año laboral
            paso 4: hago una sumatoria de todos los dias que se tomo el empleado
            paso 5: a ese total le sumo los dias que se quiere tomar ahora
        */
        return unEmpleado.getLicencias().stream()
                .filter(licencia -> claseLicencia.isInstance(licencia) &&
                        licencia.fechaInicio.getYear() == this.fechaInicio.getYear())
                .mapToInt(licencia -> licencia.diasDuracion)
                .sum()
                + this.diasDuracion;
    }

    public int getDiasDuracion() {
        return this.diasDuracion;
    }
}