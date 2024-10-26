import java.time.LocalDate;

public abstract class Licencia {
    protected LocalDate fechaInicio;
    protected LocalDate fechaFin;
    protected int diasDuracion;
    protected int cantDiasMaximosATomarse;
    protected int diasRestantesDisponiblesATomar;

    public Licencia (LocalDate unaFechaInicio){
        this.fechaInicio = unaFechaInicio;
    }

    public abstract boolean puedeSerTomadaPor(Empleado unEmpleado);

    public abstract void serTomadaPor(Empleado unEmpleado);

}

/*
Licencia por fallecimiento:
3 días corridos por el fallecimiento de un cónyuge, padres, hijos, hermanos.
1 día en caso de fallecimiento de abuelos o nietos.

Licencia por nacimiento:
2 días corridos para el padre.
90 días para la madre (licencia por maternidad).

Licencia por estudio/examen:
2 días corridos por examen, hasta un máximo de 10 días al año.

Licencia por enfermedad:
Hasta 3 meses para empleados con menos de 5 años de antigüedad.
Hasta 6 meses para empleados con 5 o más años de antigüedad.
Si la enfermedad es prolongada, puede solicitarse licencia sin goce de sueldo tras agotar la licencia paga.

Licencia sin goce de sueldo:
No tiene un límite específico en la ley y se establece por acuerdo con el empleador.

Licencia por vacaciones:
Menos de 5 años de antigüedad: 14 días corridos.
Entre 5 y 10 años de antigüedad: 21 días corridos.
Entre 10 y 20 años de antigüedad: 28 días corridos.
Más de 20 años de antigüedad: 35 días corridos.
 */