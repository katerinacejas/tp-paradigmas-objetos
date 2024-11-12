public class ExcepcionLicenciaDenegada extends Exception {
    public ExcepcionLicenciaDenegada(String nombreEmpleado) {
        super("[LICENCIA DENEGADA] El empleado " + nombreEmpleado + " no puede tomar la licencia porque ya no le quedan días disponibles para la misma");
    }
}