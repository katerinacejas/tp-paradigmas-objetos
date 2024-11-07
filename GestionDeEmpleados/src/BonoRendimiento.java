public class BonoRendimiento implements BonoCalculable {
    @Override
    public int calcularBono(Empleado empleado) {
        return empleado.getNivelDeRendimiento() >= 3 ?
                // si su rendimiendo es de 3 o superior, cobra bono.
                //el bono aumenta proporcionalmente al nivel del rendimiento que tenga. A mayor rendimiento, mayor bono
                // el maximo rendimiento genera un bono de 2 veces y media el valor del sueldo basico.
                (int) (empleado.getContrato().getSueldoBasico() * (empleado.getNivelDeRendimiento() * 0.5))
                // si tiene rendimiento de 1 o 3, significa que tuvo mal rendimiento y no cobra bono
                : 0;
    }
}
