package co.edu.poli.TiendaSoftware.modelo;

public class Producto {
	private String nombre;

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}