package npc;

import java.util.ArrayList;
import java.util.Scanner;

public class IOMethods {
    private static String nombre = "";
    private static String ciudad = "";
    private static String categoria = "JUGADOR";
    private static ArrayList<Personaje> personajes = new ArrayList<>();
    private static ArrayList<Item> inventario = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú: \n"
                    + " 1 - Crear un NPC. \n"
                    + " 2 - Crear Item. \n"
                    + " 3 - Añadir un item al inventario de un NPC. \n"
                    + " 4 - Crear un Jugador. \n"
                    + " 5 - Que un Jugador pueda comprar un item a un NPC.\n"
                    + " 6 - Mostrar el ítem más barato de todos los vendedores de una ciudad.\n"
                    + " 7 - Consultar los ítems de un NPC.\n"
                    + " 8 - Restaurar un item.\n"
                    + " 9 - Consultar los ítems de un Jugador.\n"
                    + " 10 - Consultar todos los vendedores que hay en una ciudad.\n"
                    + " 11- Mostrar todos los ítems de un determinado tipo ordenados por precio (asc).\n"
                    + "Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearPersonaje();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    crearJugador();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:

                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
    public static Personaje crearPersonaje() {
        Personaje personaje = new Personaje(nombre, ciudad, Categoria.valueOf(categoria), inventario);

        System.out.println("Indica nombre:");
        nombre = scanner.nextLine();
        System.out.println("Indica ciudad:");
        ciudad = scanner.nextLine();
        System.out.println("Indica tipo de NPC (Ladron, Mercader, Campesino):");
        String categoria = scanner.nextLine();
        categoria = categoria.toUpperCase();

        personajes.add(personaje);
        return personaje;
    }

    public static Personaje crearJugador() {
        String categoria = "JUGADOR";
        Personaje personaje = new Personaje(nombre, ciudad, categoria, inventario);

        System.out.println("Indica nombre:");
        nombre = scanner.nextLine();
        System.out.println("Indica ciudad:");
        ciudad = scanner.nextLine();
        categoria = categoria.toUpperCase();

        personajes.add(personaje);
        return personaje;
    }

    public static void mostrarPersonajes() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes");
        } else {
            for (int i = 0; i < personajes.size(); i++) {
                System.out.println((i + 1) + ". " + personajes.get(i).toString());
            }
        }
    }

    public static void crearItem() {

    }

    public static void moverItem() {
        //    if(isFull()){
        //        throw new IllegalStateException("queue full");
        //    }
    }
    public static void comprarItem() {

    }

    public static void mostrarItems() {

    }

    public static void mostrarItemsPorTipo() {

    }

    public static void mostrarItemMasBarato() {

    }

    public static void restaurarItems() {

    }
}
