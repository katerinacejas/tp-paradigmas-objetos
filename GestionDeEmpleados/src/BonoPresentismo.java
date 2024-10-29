public class BonoPresentismo extends Bono {
    @Override
    public int calcularBono(Empleado empleado) {
  /*      int horasTrabajadas = empleado.getHorasTrabajadas();
        int horasTotalesLicencia = empleado.calcularHorasTotalesLicencia(); // Aca debería sumar todas las horas de licencia de cada una de las licencias
        int horasContrato = empleado.getContrato().getCantidadDeHoras(); // Obtener horas por contrato
        int sueldo = empleado.getCargo().getSueldoBasico();

        // Cálculo del bono según porcentaje de (horas trabajadas)/(horas totales segun contrato)
        double porcentajeBono = (double) (horasTrabajadas + horasTotalesLicencia) / (horasContrato * 22);
        return (int) (porcentajeBono * sueldo); // Use sueldo como el monto total a cobrar porque hicimos eso con "BonoAntiguedad" pero podríamos definir un maxBono en cada uno para que no termine cobrando 4 sueldos.
  */
        return 0;
    }
}
