package npc;

import java.util.ArrayList;

public class Ladron extends Personaje {
    private int itemMax;
    private double precioAdd;
    private double nivelDegradacion;
    private double nivelReparacion;

    public Ladron(String nombre, String ciudad, Categoria categoria, ArrayList<Item> inventario) {
        super(nombre, ciudad, categoria, inventario);
        int itemMax = 3;
        double precioAdd =  0;
        double nivelDegradacion = 0.25;
        double nivelReparacion = 0.1;
    }
}