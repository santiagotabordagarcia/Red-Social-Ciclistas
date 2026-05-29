public class Ruta {

    // Atributos

    private String nombreRuta;
    private String tipoRuta;
    private float distancia;
    private String dificultad;
    private float tiempo;

    // Metodo

    //Constructor

    public Ruta(String nombreRuta, String tipoRuta, float distancia, String dificultad, float tiempo) {
        this.nombreRuta = nombreRuta;
        this.tipoRuta = tipoRuta;
        this.distancia = distancia;
        this.dificultad = dificultad;
        this.tiempo = tiempo;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public String getTipoRuta() {
        return tipoRuta;
    }

    public float getDistancia() {
        return distancia;
    }

    public String getDificultad() {
        return dificultad;
    }

    public float getTiempo() {
        return tiempo;
    }

    @Override
    public String toString() {
        return "Nombre de la Ruta: " + nombreRuta +
            "\nTipo de Ruta: " + tipoRuta +
            "\nDistancia: " + distancia + " km" +
            "\nDificultad: " + dificultad +
            "\nTiempo: " + tiempo + " horas";
    }


}