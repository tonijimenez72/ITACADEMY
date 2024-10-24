package npc;

import java.util.ArrayList;

public class Personaje {
    private String nombre;
    private Categoria categoria;
    private String ciudad;
    private ArrayList<Item> inventario = new ArrayList<>();

    public Personaje(String nombre, String ciudad, Categoria categoria, ArrayList<Item> inventario) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.categoria = categoria;
        this.inventario = inventario;
    }

    public String getNombre() {
        return nombre;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public String getCiudad() {
        return ciudad;
    }
    public ArrayList<Item> getInventario() {
        return inventario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public void setInventario(ArrayList<Item> inventario) {
        this.inventario = inventario;
    }

    @Override
    public String toString() {
        return "Personaje: " + nombre + ", " + categoria + " en la ciudad " + ciudad + ". Inventario: " + inventario;
    }
}

