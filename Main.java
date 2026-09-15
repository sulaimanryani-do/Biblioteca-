import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe principal del programa de gestió de biblioteca.
 * Conté el menú principal i la interacció amb l’usuari.
 * 
 * @author TuNombre
 * @version 1.0
 */
public class Main {

    /** Scanner global per llegir dades del teclat */
    public static Scanner sc = new Scanner(System.in);

    /** Objecte biblioteca que conté els llibres */
    public static Biblioteca biblioteca = new Biblioteca();

    /** Gestor de préstecs i estadístiques */
    public static GestorBiblioteca gestor = new GestorBiblioteca();

    /** Llista d’usuaris registrats */
    public static List<Usuari> llistaUsuaris = new ArrayList<>();

    /**
     * Mètode principal del programa.
     * Inicialitza dades de prova i executa el menú.
     * 
     * @param args Arguments de línia de comandes
     */
    public static void main(String[] args) {

        // Dades inicials de prova
        biblioteca.afegirLlibre(new Llibre("1984", "George Orwell", "Novel·la"));
        biblioteca.afegirLlibre(new Llibre("El petit príncep", "Antoine de Saint-Exupéry", "Infantil"));

        menu();
    }

    /**
     * Mostra el menú principal de la biblioteca
     * i gestiona les opcions escollides per l’usuari.
     */
    public static void menu() {

        int opcio = -1;

        while (opcio != 0) {

            System.out.println("\n--- GESTIÓ BIBLIOTECA ---");
            System.out.println("1. Afegir Usuari");
            System.out.println("2. Afegir Llibre");
            System.out.println("3. Llistar Llibres");
            System.out.println("4. Prestar Llibre");
            System.out.println("5. Consultar Historial Usuari");
            System.out.println("6. Veure Estadístiques");
            System.out.println("0. Sortir");
            System.out.print("Tria una opció: ");

            opcio = sc.nextInt();
            sc.nextLine();

            switch (opcio) {

                case 1:

                    // Crear nou usuari
                    System.out.print("ID de l'usuari: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nom: ");
                    String nom = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    llistaUsuaris.add(new Usuari(id, nom, email));

                    System.out.println("Usuari creat correctament.");
                    break;

                case 2:

                    // Afegir llibre
                    System.out.print("Títol del llibre: ");
                    String titol = sc.nextLine();

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    System.out.print("Categoria: ");
                    String cat = sc.nextLine();

                    biblioteca.afegirLlibre(new Llibre(titol, autor, cat));

                    System.out.println("Llibre afegit.");
                    break;

                case 3:

                    // Mostrar llibres disponibles
                    System.out.println("\nLlibres a la biblioteca:");

                    for (Llibre l : biblioteca.getLlibres()) {
                        System.out.println(l);
                    }

                    break;

                case 4:

                    // Fer préstec d’un llibre
                    System.out.print("ID de l'usuari que demana: ");
                    int idU = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Títol del llibre a buscar: ");
                    String tBuscat = sc.nextLine();

                    // Buscar usuari
                    Usuari userTrobat = null;

                    for (Usuari u : llistaUsuaris) {
                        if (u.getId() == idU) {
                            userTrobat = u;
                        }
                    }

                    // Buscar llibre
                    Llibre llibreTrobat = biblioteca.buscarLlibre(tBuscat);

                    // Validar dades
                    if (userTrobat != null && llibreTrobat != null) {

                        gestor.prestarLlibre(userTrobat, llibreTrobat);

                    } else {

                        System.out.println("Usuari o Llibre no trobat.");
                    }

                    break;

                case 5:

                    // Consultar historial de préstecs
                    System.out.print("ID de l'usuari: ");

                    int idH = sc.nextInt();
                    sc.nextLine();

                    for (Usuari u : llistaUsuaris) {

                        if (u.getId() == idH) {
                            gestor.consultarHistorial(u);
                        }
                    }

                    break;

                case 6:

                    // Mostrar estadístiques
                    gestor.mostrarEstadistiques(biblioteca.getLlibres());

                    break;

                case 0:

                    // Sortir del programa
                    System.out.println("Adeu!");

                    break;

                default:

                    System.out.println("Opció no vàlida.");
            }
        }
    }
}