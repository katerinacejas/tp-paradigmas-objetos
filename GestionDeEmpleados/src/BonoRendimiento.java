public class BonoRendimiento extends Bono {
    @Override
    public int calcularBono(Empleado empleado) {
        //misma idea que en los otros. siendo rendimientoMax=5 ; bonoRendimiento= sueldo* (rendimiento/rendimientoMax)
        int nivelDeRendimiento = empleado.getNivelDeRendimiento() ;
        int sueldo = empleado.getContrato().getSueldoBasico();

        return (int) (sueldo * (nivelDeRendimiento/5));
    }
}
