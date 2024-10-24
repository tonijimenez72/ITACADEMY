package npc;

import java.util.ArrayList;

public class Jugador extends Personaje {
    private int itemMax;
    private double precioAdd;
    private double nivelDegradacion;
    private double nivelReparacion;

    public Jugador(String nombre, String ciudad, Categoria categoria, ArrayList<Item> inventario) {
        super(nombre, ciudad, categoria, inventario);
        double precioAdd =  0;
        double nivelDegradacion = 0;
        double nivelReparacion = 0;
    }
}