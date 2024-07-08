package npc;

import java.util.ArrayList;

public class Campesino extends Personaje {
    private int itemMax;
    private double precioAdd;
    private double nivelDegradacion;
    private double nivelReparacion;

    public Campesino(String nombre, String ciudad, Categoria categoria, ArrayList<Item> inventario) {
        super(nombre, ciudad, categoria, inventario);
        int itemMax = 5;
        double precioAdd =  0.2;
        double nivelDegradacion = 0.15;
        double nivelReparacion = 0.15;
    }
}
