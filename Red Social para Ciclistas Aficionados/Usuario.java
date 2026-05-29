import java.util.ArrayList;

public class Usuario {

    // Atributos

    private String nombre;
    private String apellido;
    private int edad;
    private String tipoCiclismo;
    private String ciudad;
    private float kilometrosTotales;
    private float mejorTiempo;
    private int ftp;

    // Metodos

    public Usuario(String nombre, String apellido, int edad, String tipoCiclismo, String ciudad, float kilometrosTotales, float mejorTiempo, int ftp) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.tipoCiclismo = tipoCiclismo;
        this.ciudad = ciudad;
        this.kilometrosTotales = kilometrosTotales;
        this.mejorTiempo = mejorTiempo;
        this.ftp = ftp;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getTipoCiclismo() {
        return tipoCiclismo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public float getKilometrosTotales() {
        return kilometrosTotales;
    }

    public float getMejorTiempo() {
        return mejorTiempo;
    }

    public int getFtp() {
        return ftp;
    }

    @Override
    public String toString() {

        return "Nombre: " + nombre +
            "\nApellido: " + apellido +
            "\nEdad: " + edad +
            "\nTipo de Ciclismo: " + tipoCiclismo +
            "\nCiudad: " + ciudad +
            "\nKilómetros Totales: " + kilometrosTotales +
            "\nMejor Tiempo: " + mejorTiempo +
            "\nFTP: " + ftp;

    }

    private ArrayList<Ruta> rutas = new ArrayList<>();
    private ArrayList<Usuario> amigos = new ArrayList<>();
    private ArrayList<Actividad> actividades = new ArrayList<>();

    public ArrayList<Ruta> getRutas() {
        return rutas;
    }

    public void agregarAmigo(Usuario amigo) {
        amigos.add(amigo);
    }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public ArrayList<Usuario> getAmigos() {
        return amigos;
    }

    

}