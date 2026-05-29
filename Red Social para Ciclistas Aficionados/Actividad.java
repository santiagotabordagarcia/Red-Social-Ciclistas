public class Actividad {

    // Atributos

    private String nombreActividad;
    private String fecha;
    private float duracion;
    private int calorias;

    // Constructor

    public Actividad(String nombreActividad, String fecha, float duracion, int calorias) {
        this.nombreActividad = nombreActividad;
        this.fecha = fecha;
        this.duracion = duracion;
        this.calorias = calorias;
    }

    // Getters

    public String getNombreActividad() {
        return nombreActividad;
    }

    public String getFecha() {
        return fecha;
    }

    public float getDuracion() {
        return duracion;
    }

    public int getCalorias() {
        return calorias;
    }

    // Setters

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    // Mostrar datos

    @Override

    public String toString() {

        return "Actividad: " + nombreActividad +
               "\nFecha: " + fecha +
               "\nDuración: " + duracion + " horas" +
               "\nCalorías quemadas: " + calorias;
    }


}