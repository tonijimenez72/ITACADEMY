package npc;

public class Item {
    private String nombre;
    private String tipo;
    private double precio;
    private double desgaste;

    public Item(String nombre,  String tipo, double precio, double desgaste) {
        this.nombre = nombre;
        this. tipo = tipo;
        this.precio = precio;
        this.desgaste = desgaste;
    }

    public String getNombre() {
                return nombre;
    }
    public String getTipo() {
        return tipo;
    }
    public double getPrecio() {
        return precio;
    }
    public double getDesgaste() {
        return desgaste;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setDesgaste(double desgaste) {
        this.desgaste = desgaste;
    }

    @Override
    public String toString() {
        return "Item: " + nombre + ", tipo: " + tipo + ", precio: " + precio + ", desgaste=" + desgaste;
    }
}
