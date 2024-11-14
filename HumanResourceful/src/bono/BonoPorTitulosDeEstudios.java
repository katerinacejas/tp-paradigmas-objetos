package bono;
import empleado.Empleado;

public class BonoPorTitulosDeEstudios implements BonoCalculable {
    private int valorPorTitulo = 5000;

    @Override
    public int calcularBono(Empleado empleado) {
        return empleado.getTitulosDeEstudio().size() >= 2 ?

                // si tiene mas de 2 titulos, entonces cobra el valor del titulo * el promedio de los puntajes que tenga el titulo
                ((int) (empleado.getTitulosDeEstudio().stream()
                        .mapToInt(titulo -> titulo.getPuntaje())
                        .sum() ) / empleado.getTitulosDeEstudio().size()
                        ) * this.valorPorTitulo

                // si tiene menos de 2 titulos, entonces no cobra bono
                : 0;
    }
}
