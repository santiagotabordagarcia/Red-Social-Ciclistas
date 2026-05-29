import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Main {

    static ArrayList<Usuario> usuarios = new ArrayList<>();

    public static void main(String[] args) {
        Scanner bici = new Scanner(System.in);
        cargarUsuarios();
        cargarRutas();
        cargarAmigos();
        cargarActividades();
        int opcion = 0;

        while (opcion != 11) {

            System.out.println("_______________________________\n");
            System.out.println("           Menú\n");
            System.out.println("1. Registrar nuevo usuario");
            System.out.println("2. Añadir ruta a usuario");
            System.out.println("3. Conectar con otro ciclista");
            System.out.println("4. Visualizar datos");
            System.out.println("5. Buscar ciclista");
            System.out.println("6. Listar ciclistas");
            System.out.println("7. Lista rutas");
            System.out.println("8. Comparar rutas");
            System.out.println("9. Registrar actividad");
            System.out.println("10. Listado de actividades");
            System.out.println("11. Salir");
            System.out.println("_______________________________\n");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero(bici);

            System.out.println("");

            switch (opcion) {
                case 1:
                    System.out.println("Registro de nuevo usuario.\n");
                    registrarUsuario(bici);
                    break;
                case 2:
                    System.out.println("Añadir ruta a clista.\n");
                    añadirRuta(bici);
                    break;
                case 3:
                    System.out.println("Añadir amigos.\n");
                    conectarCiclistas(bici);
                    break;
                case 4:
                    System.out.println("Visualizar datos de ciclistas.\n");
                    visualizarDatos(bici);
                    break;
                case 5:
                    System.out.println("Busqueda de ciclistas.\n");
                    buscarCiclista(bici);
                    break;
                case 6:
                    System.out.println("Lista de usuarios.\n");
                    listarUsuarios(bici);
                    break;
                case 7:
                    System.out.println("Rutas de ciclistas.\n");
                    listarRutas(bici);
                    break;
                case 8:
                    System.out.println("Comparar rutas.\n");
                    compararRutas(bici);
                    break;
                case 9:
                    System.out.println("Registrar actividad.\n");
                    registrarActividad(bici);
                    break;
                case 10:
                    System.out.println("Listado de actividades.\n");
                    listarActividades(bici);
                    break;
                case 11:
                    System.out.println("Has salido de la aplicacion.\n");
                    guardarUsuarios();
                    guardarRutas();
                    guardarAmigos();
                    guardarActividades();
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.\n");
            }

        }
        bici.close();

    }

    // Metodo para registrar usuarios

    public static void registrarUsuario(Scanner bici) {

        System.out.print("Nombre del usuario: ");
        String nombre = leerTexto(bici);

        System.out.print("Apellido del usuario: ");
        String apellido = leerTexto(bici);

        System.out.print("Edad del usuario: ");
        int edad = leerEntero(bici);

        System.out.print("Tipo de ciclismo que practica el usuario: ");
        String tipo = leerTexto(bici);

        System.out.print("Ciudad del usuario: ");
        String ciudad = leerTexto(bici);

        System.out.print("Kilómetros totales del usuario: ");
        float kilometrosTotales = leerFloat(bici);

        System.out.print("Mejor tiempo del usuario: ");
        float mejorTiempo = leerFloat(bici);

        System.out.print("FTP del usuario: ");
        int ftp = leerEntero(bici);

        // Crear un nuevo usuario

        Usuario nuevoUsuario = new Usuario(nombre, apellido, edad, tipo, ciudad, kilometrosTotales, mejorTiempo, ftp);

        // Gurdar en la lista de usuarios
        usuarios.add(nuevoUsuario);

        System.out.println("\nUsuario registrado exitosamente.\n");
    }

    // Listar usuarios

    public static void listarUsuarios(Scanner bici) {

        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.\n");
            return;
        }

        System.out.println("¿Cómo desea listar los ciclistas?\n");

        System.out.println("1. Edad");
        System.out.println("2. Nombre");
        System.out.println("3. Tipo de ciclismo");

        System.out.print("\nSeleccione una opción: ");

        int opcion = leerEntero(bici);

        switch (opcion) {

            case 1:

                ordenarEdad();

                System.out.println(
                        "\nCiclistas ordenados por edad:\n");

                for (int i = usuarios.size() - 1; i >= 0; i--) {

                    System.out.println(usuarios.get(i));
                    System.out.println("");
                }

                break;

            case 2:

                ordenarNombre();

                System.out.println(
                        "\nCiclistas ordenados por nombre:\n");

                for (Usuario usuario : usuarios) {

                    System.out.println(usuario);
                    System.out.println("");
                }

                break;

            case 3:

                System.out.println("\nTipo de ciclismo");

                System.out.println("1. Ruta");
                System.out.println("2. MTB");
                System.out.println("3. Gravel");
                System.out.println("4. Urbano");

                System.out.print(
                        "\nSeleccione una opción: ");

                int tipo = leerEntero(bici);

                String modalidad = "";

                switch (tipo) {

                    case 1:
                        modalidad = "Ruta";
                        break;

                    case 2:
                        modalidad = "MTB";
                        break;

                    case 3:
                        modalidad = "Gravel";
                        break;

                    case 4:
                        modalidad = "Urbano";
                        break;

                    default:
                        System.out.println(
                                "Opción inválida.");
                        return;
                }

                System.out.println(
                        "\nCiclistas de modalidad "
                                + modalidad + ":\n");

                boolean encontrado = false;

                for (Usuario usuario : usuarios) {

                    if (usuario.getTipoCiclismo()
                            .equalsIgnoreCase(modalidad)) {

                        System.out.println(usuario);
                        System.out.println("");

                        encontrado = true;
                    }
                }

                if (!encontrado) {

                    System.out.println(
                            "No hay ciclistas de esta modalidad.\n");
                }

                break;

            default:

                System.out.println(
                        "Opción inválida.\n");
        }
    }

    // Buscar ciclista

    public static void buscarCiclista(Scanner bici) {

        // Buscar ciclista por nombre, ciudad o tipo de ciclismo

        System.out.println("Buscar ciclista por:\n");
        System.out.println("1. Nombre");
        System.out.println("2. Ciudad");
        System.out.println("3. Tipo de ciclismo\n");
        System.out.print("Seleccione una opción: ");

        int opcion = leerEntero(bici);
        System.out.println("");

        // Busca el ciclista segun la opcion seleccionada

        switch (opcion) {

            case 1:

                System.out.print("Ingrese el nombre del ciclista: ");
                String nombre = leerTexto(bici);
                boolean encontradoN = false;
                System.out.println("");

                // Recorre la lista de usuarios verificando si el nombre es el mismo que el
                // ingresado

                for (Usuario usuario : usuarios) {
                    if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                        System.out.println("Ciclista encontrado:\n");
                        System.out.println(usuario);
                        System.out.println("");
                        encontradoN = true;
                        break;
                    }
                }

                if (!encontradoN) {
                    System.out.println("Ciclista no encontrado\n");
                }
                break;

            case 2:

                System.out.print("Ingrese la ciudad del ciclista: ");
                String ciudad = bici.nextLine();
                boolean encontradoC = false;
                System.out.println("");

                for (Usuario usuario : usuarios) {
                    if (usuario.getCiudad().equalsIgnoreCase(ciudad)) {
                        System.out.println("Ciclista encontrado:\n");
                        System.out.println(usuario);
                        System.out.println("");
                        encontradoC = true;
                        break;
                    }
                }

                if (!encontradoC) {
                    System.out.println("Ciclista no encontrado\n");
                }
                break;

            case 3:

                System.out.print("Ingrese el tipo de ciclismo: ");
                String tipo = bici.nextLine();
                boolean encontradoT = false;
                System.out.println("");

                for (Usuario usuario : usuarios) {
                    if (usuario.getTipoCiclismo().equalsIgnoreCase(tipo)) {
                        System.out.println("Ciclista encontrado:\n");
                        System.out.println(usuario);
                        System.out.println("");
                        encontradoT = true;
                        break;
                    }
                }

                if (!encontradoT) {
                    System.out.println("Ciclista no encontrado\n");
                }
                break;

            default:
                System.out.println("Opción no válida. Por favor, intente de nuevo.");
        }

    }

    // Añadir ruta al usuario

    public static void añadirRuta(Scanner bici) {

        // Verifica si los ciclistas estan registrados

        System.out.print("Ingrese el nombre del ciclista al que le desea añadir una ruta: ");
        String nombre = leerTexto(bici);
        System.out.println("");
        Usuario uEncontrado = null;

        // Busca el ciclista

        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                uEncontrado = usuario;
                break;
            }
        }

        // Verifica si el ciclista fue encontrado

        if (uEncontrado != null) {

            System.out.println("Ciclista encontrado");
            System.out.println("");
            System.out.print("Nombre de la ruta: ");
            String nombreRuta = leerTexto(bici);

            System.out.println("Tipo de ruta");
            System.out.println(" 1. Ruta");
            System.out.println(" 2. MTB");
            System.out.println(" 3. Gravel");
            System.out.println(" 4. Urbano");
            System.out.print("Ingrese el numero de opción: ");
            int opcionTipo = leerEntero(bici);
            String tipoRuta = "";

            switch (opcionTipo) {
                case 1:
                    tipoRuta = "Ruta";
                    break;
                case 2:
                    tipoRuta = "MTB";
                    break;
                case 3:
                    tipoRuta = "Gravel";
                    break;
                case 4:
                    tipoRuta = "Urbano";
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }

            System.out.print("Distancia: ");
            float distancia = leerFloat(bici);

            System.out.print("Tiempo en horas: ");
            float tiempo = leerFloat(bici);

            System.out.println("Dificultad");
            System.out.println(" 1. Fácil");
            System.out.println(" 2. Media");
            System.out.println(" 3. Difícil");
            System.out.print("Ingrese el numero de opción: ");

            int opcionDificultad = leerEntero(bici);
            String dificultad = "";

            switch (opcionDificultad) {
                case 1:
                    dificultad = "Facil";
                    break;
                case 2:
                    dificultad = "Media";
                    break;
                case 3:
                    dificultad = "Dificil";
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }

            // Crea una nueva ruta con los datos ingresados

            Ruta nuevaRuta = new Ruta(nombreRuta, tipoRuta, distancia, dificultad, tiempo);

            uEncontrado.getRutas().add(nuevaRuta);

            System.out.println("\nRuta añadida exitosamente\n");

        } else {
            System.out.println("Usuario no encontrado.\n");
        }

    }

    // Listar rutas

    public static void listarRutas(Scanner bici) {

        // Verifica si hay usuarios registrados

        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        // Recorre la lista de usuarios y muestrar sus rutas

        for (Usuario usuario : usuarios) {
            System.out.println("Rutas del ciclista: " + usuario.getNombre());

            // Verifica si el ciclista tiene rutas

            if (usuario.getRutas().isEmpty()) {
                System.out.println("El ciclista no tiene rutas.\n");
            } else {
                for (Ruta ruta : usuario.getRutas()) {
                    System.out.println(ruta);
                    System.out.println("");
                }

            }
        }
    }

    // Agregar amigos

    public static void conectarCiclistas(Scanner bici) {

        // Nombre de los ciclistas que quiere conectar

        System.out.print("Ingrese el nombre del primer ciclista: ");
        String nombre1 = leerTexto(bici);
        System.out.print("Ingrese el nombre del segundo ciclista: ");
        String nombre2 = leerTexto(bici);

        Usuario ciclista1 = null;
        Usuario ciclista2 = null;

        // Busca los ciclistas por su nombre en la lista de los usuarios

        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombre1)) {
                ciclista1 = usuario;
            }
            if (usuario.getNombre().equalsIgnoreCase(nombre2)) {
                ciclista2 = usuario;
            }
        }

        // Verifica si existen los ciclistas

        if (ciclista1 == null || ciclista2 == null) {
            System.out.println("Uno o ambos ciclistas no fueron encontrados.\n");
            return;
        }

        // Verifica que no sean el mismo ciclista

        if (ciclista1 == ciclista2) {
            System.out.println("No puedes agregarte a ti mismo como amigo.\n");
            return;
        }

        // Verifica si ya son amigos

        if (ciclista1.getAmigos().contains(ciclista2)) {
            System.out.println("Estos ciclistas ya son amigos.\n");
            return;
        }

        // Agrega a los ciclista como amgios

        ciclista1.agregarAmigo(ciclista2);
        ciclista2.agregarAmigo(ciclista1);

        System.out.println("EL ciclista " + ciclista1.getNombre() + " ha añadido al ciclista " + ciclista2.getNombre()
                + " exitosamente.\n");
    }

    // Visualizar datos del ciclista

    public static void visualizarDatos(Scanner bici) {

        System.out.print("Ingrese el nombre del ciclista para visualizar sus datos:");
        String nombre = leerTexto(bici);
        Usuario ciclista = null;

        // Busca el ciclista por su nombre en la lista de usuarios

        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                ciclista = usuario;
                break;
            }
        }

        // Verifica si el ciclista fue encontrado

        if (ciclista != null) {

            // Muestra los datos del ciclista

            System.out.println("Datos del ciclista:\n");
            System.out.println(ciclista);

            System.out.println("Las rutas del ciclista:\n");

            // Verifica si el ciclista tiene rutas

            if (ciclista.getRutas().isEmpty()) {
                System.out.println("El ciclista no tiene rutas.\n");

            } else {

                for (Ruta ruta : ciclista.getRutas()) {
                    System.out.println(ruta);
                    System.out.println("");
                }

            }

            // Verifica si el ciclista tiene amigos

            System.out.println("Amigos del ciclista:\n");

            if (ciclista.getAmigos().isEmpty()) {
                System.out.println("El ciclista no tiene amigos.\n");

            } else {

                for (Usuario amigo : ciclista.getAmigos()) {
                    System.out.println(amigo);
                    System.out.println("");
                }
            }

        }
    }

    // Guardar los datos del usuario

    public static void guardarUsuarios() {

        try {
            PrintWriter escribir = new PrintWriter("CSV/usuarios.csv");

            for (Usuario usuario : usuarios) {
                escribir.println(usuario.getNombre() + "," + usuario.getApellido() + "," + usuario.getEdad() + ","
                        + usuario.getTipoCiclismo() + "," + usuario.getCiudad() + "," + usuario.getKilometrosTotales()
                        + "," + usuario.getMejorTiempo() + "," + usuario.getFtp());
            }
            escribir.close();
            System.out.println("Los datos del usuario fueron guardados correctamente");

        } catch (Exception e) {
            System.out.println("El sistema falló al guardar los datos");

        }

    }

    // Cargar los datos del usuario

    public static void cargarUsuarios() {

        try {
            File archivo = new File("CSV/usuarios.csv");
            if (!archivo.exists()) {
                return;
            }

            Scanner leer = new Scanner(archivo);

            // Lee cada linea del archivo y crea un nuevo usuario

            while (leer.hasNextLine()) {
                String linea = leer.nextLine();
                String datos[] = linea.split(",");

                String nombre = datos[0];
                String apellido = datos[1];
                int edad = Integer.parseInt(datos[2]);
                String tipo = datos[3];
                String ciudad = datos[4];
                float kilometrosTotales = Float.parseFloat(datos[5]);
                float mejorTiempo = Float.parseFloat(datos[6]);
                int ftp = Integer.parseInt(datos[7]);

                Usuario usuario = new Usuario(nombre, apellido, edad, tipo, ciudad, kilometrosTotales, mejorTiempo,
                        ftp);
                usuarios.add(usuario);
            }

            leer.close();
            System.out.println("\nLos datos del ciclista han sido cargados correctamente");

        } catch (Exception e) {
            System.out.println("\nEl sistema falló al cargar los datos del ciclista");

        }

    }

    // Guardar las rutas del usuario

    public static void guardarRutas() {
        try {

            // Crea un nuevo archivo y lo sobreescribe si ya existe

            PrintWriter escribir = new PrintWriter("CSV/rutas.csv");

            for (Usuario usuario : usuarios) {
                for (Ruta ruta : usuario.getRutas()) {
                    escribir.println(usuario.getNombre() + "," + ruta.getNombreRuta() + "," + ruta.getTipoRuta() + ","
                            + ruta.getDistancia() + "," + ruta.getDificultad() + "," + ruta.getTiempo());
                }
            }

            escribir.close();
            System.out.println("Las rutas del ciclista fueron guardados correctamente");

        } catch (Exception e) {
            System.out.println("El sistema fallo al gurdar las rutas del ciclista");

        }

    }

    // Cargar las rutas del usuario

    public static void cargarRutas() {

        try {

            // Verifica si el archivo existe

            File archivo = new File("CSV/rutas.csv");
            if (!archivo.exists()) {
                return;
            }

            Scanner leer = new Scanner(archivo);

            // Lee cada linea del archivo y crea una nueva ruta para el usuario

            while (leer.hasNextLine()) {

                String linea = leer.nextLine();
                String datos[] = linea.split(",");

                String nombreUsuario = datos[0];
                String nombreRuta = datos[1];
                String tipoRuta = datos[2];
                float distancia = Float.parseFloat(datos[3]);
                String dificultad = datos[4];
                float tiempo = Float.parseFloat(datos[5]);

                for (Usuario usuario : usuarios) {
                    if (usuario.getNombre().equalsIgnoreCase(nombreUsuario)) {

                        Ruta ruta = new Ruta(nombreRuta, tipoRuta, distancia, dificultad, tiempo);
                        usuario.getRutas().add(ruta);
                        break;
                    }
                }
            }

            leer.close();
            System.out.println("Las rutas del ciclista han sido cargados correctamente");

        } catch (Exception e) {
            System.out.println("El sistema falló al cargar las rutas del ciclista");

        }
    }

    // Guardar los amigos del usuario

    public static void guardarAmigos() {
        try {

            PrintWriter escribir = new PrintWriter("CSV/amigos.csv");

            for (Usuario usuario : usuarios) {
                for (Usuario amigo : usuario.getAmigos()) {
                    escribir.println(usuario.getNombre() + "," + amigo.getNombre());
                }
            }

            escribir.close();
            System.out.println("Los amigos del ciclista fueron guardados correctamente\n");

        } catch (Exception e) {
            System.out.println("El sistema fallo al gurdar los amigos del ciclista\n");

        }
    }

    // Cargar los amigos del usuario

    public static void cargarAmigos() {
        try {

            File archivo = new File("CSV/amigos.csv");

            if (!archivo.exists()) {
                return;
            }

            Scanner leer = new Scanner(archivo);

            // Lee cada linea del archivo y añade los cilicstas correspondientes como amigos

            while (leer.hasNextLine()) {

                String linea = leer.nextLine();

                String datos[] = linea.split(",");

                String ciclistaUs = datos[0];
                String ciclistaAm = datos[1];

                Usuario ciclista1 = null;
                Usuario ciclista2 = null;

                for (Usuario usuario : usuarios) {
                    if (usuario.getNombre().equalsIgnoreCase(ciclistaUs)) {
                        ciclista1 = usuario;
                    }
                    if (usuario.getNombre().equalsIgnoreCase(ciclistaAm)) {
                        ciclista2 = usuario;
                    }
                }

                if (ciclista1 != null && ciclista2 != null) {
                    if (!ciclista1.getAmigos().contains(ciclista2)) {
                        ciclista1.agregarAmigo(ciclista2);
                    }
                }
            }

            leer.close();
            System.out.println("Los amigos del ciclista han sido cargados correctamente\n");

        } catch (Exception e) {
            System.out.println("El sistema falló al cargar los amigos del ciclista\n");
        }
    }

    public static void guardarActividades() {
        try {
            PrintWriter escribir = new PrintWriter("CSV/actividades.csv");
            for (Usuario usuario : usuarios) {
                for (Actividad actividad : usuario.getActividades()) {
                    escribir.println(usuario.getNombre() + "," + actividad.getNombreActividad() + ","
                            + actividad.getFecha() + ","
                            + actividad.getDuracion() + "," + actividad.getCalorias());
                }
            }
            escribir.close();
            System.out.println("Las actividades del ciclista fueron guardados correctamente\n");
        } catch (Exception e) {
            System.out.println("El sistema fallo al gurdar las actividades del ciclista\n");
        }
    }

    public static void cargarActividades() {
        try {

            File archivo = new File("CSV/actividades.csv");

            if (!archivo.exists()) {
                return;
            }
            Scanner leer = new Scanner(archivo);

            while (leer.hasNextLine()) {

                String linea = leer.nextLine();

                String datos[] = linea.split(",");

                String nombreUsuario = datos[0];
                String nombreActividad = datos[1];
                String fecha = datos[2];
                float duracion = Float.parseFloat(datos[3]);
                int calorias = Integer.parseInt(datos[4]);

                for (Usuario usuario : usuarios) {
                    if (usuario.getNombre().equalsIgnoreCase(nombreUsuario)) {
                        Actividad actividad = new Actividad(nombreActividad, fecha, duracion, calorias);
                        usuario.getActividades().add(actividad);
                        break;
                    }
                }
            }
            leer.close();
        } catch (Exception e) {
            System.out.println("El sistema fallo al cargar las actividades del ciclista\n");
        }
    }

    // Comparar rutas

    public static void compararRutas(Scanner bici) {
        System.out.print("Ingrese el nombre de la ruta: ");
        String nombreRuta = leerTexto(bici);

        ArrayList<String> resultados = new ArrayList<>();
        ArrayList<Float> tiempos = new ArrayList<>();

        // Recorre la lista de usuarios y las rutas y busca cuales coinciden

        for (Usuario usuario : usuarios) {
            for (Ruta ruta : usuario.getRutas()) {
                if (ruta.getNombreRuta().equalsIgnoreCase(nombreRuta)) {
                    resultados.add("Ciclista: " + usuario.getNombre() + " - Tiempo: " + ruta.getTiempo() + " horas");
                    tiempos.add(ruta.getTiempo());
                }
            }
        }

        // Ordenar los resultados por tiempo con el metodo de burbuja

        for (int i = 0; i < tiempos.size(); i++) {
            for (int j = 0; j < tiempos.size() - 1; j++) {
                if (tiempos.get(j) > tiempos.get(j + 1)) {
                    float auxTiempo = tiempos.get(j);
                    tiempos.set(j, tiempos.get(j + 1));
                    tiempos.set(j + 1, auxTiempo);

                    String auxNombre = resultados.get(j);
                    resultados.set(j, resultados.get(j + 1));
                    resultados.set(j + 1, auxNombre);
                }
            }
        }
        System.out.println("\nRuta: " + nombreRuta);
        for (int i = 0; i < resultados.size(); i++) {
            System.out.println(i + 1 + ". " + resultados.get(i) + " - " + tiempos.get(i) + " horas");
        }
    }

    // Ordenar los ciclistas por nombre

    public static void ordenarNombre() {

        // Ordena a los ciclistas por nombre con el metodo burbuja

        for (int i = 0; i < usuarios.size(); i++) {
            for (int j = 0; j < usuarios.size() - 1; j++) {
                if (usuarios.get(j).getNombre().compareToIgnoreCase(usuarios.get(j + 1).getNombre()) > 0) {
                    Usuario aux = usuarios.get(j);
                    usuarios.set(j, usuarios.get(j + 1));
                    usuarios.set(j + 1, aux);
                }
            }
        }
    }

    // Ordenar los ciclistas por edad

    public static void ordenarEdad() {

        // Ordena a los ciclistas por edad con el metodo burbuja

        for (int i = 0; i < usuarios.size(); i++) {
            for (int j = 0; j < usuarios.size() - 1; j++) {
                if (usuarios.get(j).getEdad() > usuarios.get(j + 1).getEdad()) {
                    Usuario aux = usuarios.get(j);
                    usuarios.set(j, usuarios.get(j + 1));
                    usuarios.set(j + 1, aux);
                }
            }
        }
    }

    // Ordenar los ciclistas por tipo de ciclismo

    public static void ordenarTipo() {

        // Ordena a los ciclistas por edad con el metodo burbuja

        for (int i = 0; i < usuarios.size(); i++) {
            for (int j = 0; j < usuarios.size() - 1; j++) {
                if (usuarios.get(j).getTipoCiclismo().compareToIgnoreCase(usuarios.get(j + 1).getTipoCiclismo()) > 0) {
                    Usuario aux = usuarios.get(j);
                    usuarios.set(j, usuarios.get(j + 1));
                    usuarios.set(j + 1, aux);
                }
            }
        }
    }

    // Registrar actividad

    public static void registrarActividad(Scanner bici) {

        System.out.print("Ingrese el nombre del ciclista: ");
        String nombre = leerTexto(bici);

        Usuario encontrado = null;

        for (Usuario usuario : usuarios) {

            if (usuario.getNombre().equalsIgnoreCase(nombre)) {

                encontrado = usuario;
                break;
            }
        }

        // Si el ciclista fue encontrado, ingresa lo datos de la actividad y la añade

        if (encontrado != null) {

            System.out.print("Nombre de la actividad: ");
            String actividad = leerTexto(bici);

            System.out.print("Fecha: ");
            String fecha = bici.nextLine();

            System.out.print("Duración en horas: ");
            float duracion = leerFloat(bici);

            System.out.print("Calorías quemadas: ");
            int calorias = leerEntero(bici);

            Actividad nuevaActividad = new Actividad(actividad, fecha, duracion, calorias);

            encontrado.getActividades().add(nuevaActividad);

            System.out.println("\nActividad registrada correctamente.\n");

        } else {

            System.out.println("Ciclista no encontrado.\n");
        }
    }

    // Listar actividades

    public static void listarActividades(Scanner bici) {

        System.out.print("Ingrese el nombre del ciclista: ");
        String nombre = leerTexto(bici);

        Usuario encontrado = null;

        for (Usuario usuario : usuarios) {

            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                encontrado = usuario;
                break;
            }
        }

        // Busca al cilicsta para mostrar sus acttividades

        if (encontrado != null) {

            if (encontrado.getActividades().isEmpty()) {

                System.out.println(
                        "\nEl ciclista no tiene actividades.\n");

            } else {

                System.out.println(
                        "\nActividades del ciclista:\n");

                for (Actividad actividad : encontrado.getActividades()) {

                    System.out.println(actividad);
                    System.out.println("");
                }
            }

        } else {

            System.out.println("Ciclista no encontrado.\n");
        }
    }

    // Verifica que si sea un numero entero

    public static int leerEntero(Scanner bici) {
        while (true) {
            try {
                int numero = bici.nextInt();
                bici.nextLine();

                return numero;

            } catch (Exception e) {

                System.out.print("Ingrese un numero valido: ");
                bici.nextLine();
            }
        }
    }

    // Verifica que si sea un numero decimal

    public static float leerFloat(Scanner bici) {
        while (true) {
            try {
                float numero = bici.nextFloat();
                bici.nextLine();
                return numero;
            } catch (Exception e) {
                System.out.print("Ingrese un numero decimal valido: ");
                bici.nextLine();
            }
        }
    }

    // Verifica que si sean solo letras

    public static String leerTexto(Scanner bici) {
        while (true) {
            String texto = bici.nextLine();

            if (texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                return texto;

            } else {
                System.out.print("Ingrese solo letras: ");

            }
        }
    }

}
