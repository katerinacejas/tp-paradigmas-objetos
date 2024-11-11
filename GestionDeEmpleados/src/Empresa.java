import java.util.Set;

public class Empresa {
    private Set<Empleado> empleados;

    public Empresa(Set<Empleado> unosEmpleados) {
        this.empleados = unosEmpleados;
    }

    public void contratarOtroEmpleado(Empleado unEmpleado){
        this.empleados.add(unEmpleado);
    }

    public void despedirEmpleado(Empleado unEmpleado) {
        this.empleados.remove(unEmpleado);
    }

    public Set<Empleado> getEmpleados() {
        return this.empleados;
    }

    public long porcentajeEmpleadosConMasDe10AniosAntiguedad() {
        return this.empleados.stream().filter(empleado -> empleado.getAntiguedadEnAnios() >= 10).count()
                * 100 / this.empleados.size();
    }

    public long cantEmpleadosConBuenRendimiento () {
        return this.empleados.stream().filter(empleado -> empleado.getNivelDeRendimiento() >= 4).count();
    }

    public boolean cumpleParidadDeGenero() {
        return this.empleados.stream().filter(empleado -> empleado.getSexo() == Sexo.FEMENINO).count()
                == this.empleados.stream().filter(empleado -> empleado.getSexo() == Sexo.MASCULINO).count();
    }

    public double promedioNivelRendimientoDeEmpleados() {
        return (double) (this.empleados.stream().mapToInt(empleado -> empleado.getNivelDeRendimiento()).sum()) / (this.empleados.size());
    }

    public int cantEmpleadosSinLicenciasEnEsteMes() {
        return (int) this.empleados.stream().filter(empleado -> empleado.tuveLicenciasEnElMesActual()).count();
    }

    public int cantEmpleadosConMasDeUnEstudio() {
        return (int) this.empleados.stream().filter(empleado -> empleado.getTitulosDeEstudio().size() > 1).count();
    }

    public double costoTotalDeEmpleados() {
        return this.empleados.stream().mapToDouble(empleado -> empleado.calcularSueldo()).sum();
    }

}
