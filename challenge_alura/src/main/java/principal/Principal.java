package principal;

import Models.ApiResult;
import Models.AutorDato;
import Models.Libro;
import Models.LibroDato;
import services.ConsumoApi;
import services.ConvierteDatos;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private final String first_url = "https://gutendex.com/books/";
    private Scanner teclado_int = new Scanner(System.in);
    private Scanner teclado_line = new Scanner(System.in);
    private ConsumoApi Api = new ConsumoApi();
    private ConvierteDatos conversor = new ConvierteDatos();
    public void muestraElMenu() {
        while (true) {
            System.out.println("""
                    1. Buscar libro por titulo
                    2. Listar libros registrados
                    3. Listar autores registrados
                    4. Listar autores vivos en un determinado year
                    5. Listar libros por idiomas
                    0. Salir""");
            var opcion = teclado_int.nextInt();
            switch (opcion) {
                case 0:
                    System.out.println("******************");
                    System.out.println("Fin del sistema");
                    break;
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    System.out.println("******************");
                    break;
                case 3:
                    System.out.println("******************");
                    break;
                case 4:
                    System.out.println("******************");
                    break;
                case 5:
                    System.out.println("******************");
                    break;
            }
        }
    }

    public void buscarLibroPorTitulo() {
        System.out.println("Inserta el título del libro:");
        String titulo = teclado_line.nextLine();
        try {
            String urlGenerada = first_url + "?search=" + titulo.replace(" ","+");

            String libro = Api.obtenerDatos(urlGenerada);
            if (libro == null || libro.isEmpty()) {
                System.out.println("No se recibieron datos de la API.");
                return;
            }
            System.out.println("Respuesta de la API: " + libro);

            ApiResult resultado = conversor.obtenerDatos(libro, ApiResult.class);

            List<LibroDato> libros = resultado.results();
            LibroDato libro_bisqueda = libros.get(0);

            System.out.println("-----Book-----");
            System.out.println("Título: " + libro_bisqueda.titulo());
            System.out.println("Autores: ");
            for (AutorDato autor : libro_bisqueda.autor()) {
                System.out.println("  - Nombre: " + autor.nombre());
                if (autor.anoNacimiento() != null) {
                    System.out.println("    Año de nacimiento: " + autor.anoNacimiento());
                }
                if (autor.anoMuerte() != null) {
                    System.out.println("    Año de muerte: " + autor.anoMuerte());
                }
            }
            System.out.println("Idiomas: " + libro_bisqueda.idioma());
            System.out.println("Descargas: " + libro_bisqueda.numeroDeDescargas());
            System.out.println("----------");


        } catch (Exception e) {
            System.out.println("Error al buscar libro: " + e.getMessage());
        }
    }
}