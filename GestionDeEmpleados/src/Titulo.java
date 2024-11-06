public class Titulo {
    private String nombre;
    private int puntaje;

    public Titulo (String unNombreDelTitulo, int unPuntaje) {
        this.nombre = unNombreDelTitulo;
        this.puntaje = unPuntaje;
    }

    public int getPuntaje() {
        return this.puntaje;
    }
}
