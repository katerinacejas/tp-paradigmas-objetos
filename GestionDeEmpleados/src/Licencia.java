public abstract class Licencia {
    
    protected int horas;

    public Licencia() {
        this.horas = 0; // default en 0
    }

    public int getHoras() {
        return horas;
    }

    public void agregarHoras(int horas) {
        this.horas += horas; // Suma horas
    }
}
