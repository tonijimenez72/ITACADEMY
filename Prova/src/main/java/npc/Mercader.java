package npc;

import java.util.ArrayList;

public class Mercader extends Personaje {
    private int itemMax;
    private double precioAdd;
    private double nivelDegradacion;
    private double nivelReparacion;

    public Mercader(String nombre, String ciudad, Categoria categoria, ArrayList<Item> inventario) {
        super(nombre, ciudad, categoria, inventario);
        int itemMax = 7;
        double precioAdd =  0.4;
        double nivelDegradacion = 0;
        double nivelReparacion = 0;
    }
}
