package co.edu.poli.TiendaSoftware.modelo;


public class Producto {	

	private String nombre;
	private EmpaqueStrategy estrategiaEmpaque;


    public Producto(String nombre) {
        this.nombre = nombre;
        this.estrategiaEmpaque = new EmpaqueEstandar();
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
    public void setEstrategiaEmpaque(EmpaqueStrategy estrategia) {
        this.estrategiaEmpaque = estrategia;
    }

    public String obtenerEmpaque() {
        return estrategiaEmpaque.empaquetar(nombre);
    }
}