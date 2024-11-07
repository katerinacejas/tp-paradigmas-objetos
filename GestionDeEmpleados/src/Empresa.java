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

    /*
        hacer metodos para estadisticas (idea del profe):
        1) cantidad de empleados con buen rendimiento (rendimiendo = 4 o 5)
        2) cumple con paridad de genero? devolver true o false si hay la misma cantidad de empleados hombres que mujeres
        3) promedio de nivel de rendimiento de los empleados
        4) cantidad de empleados que no se tomaron licencias en el mes actual
        5) cantidad de empleados con mas de 1 titulo de estudio
        6) total de costo de empleados para la empresa (es la sumatoria de los sueldos finales de cada empleado)

        alguna otra idea que se les ocurra es bienvenida. esto es para jugar con las colecciones que pidió


     */


}
