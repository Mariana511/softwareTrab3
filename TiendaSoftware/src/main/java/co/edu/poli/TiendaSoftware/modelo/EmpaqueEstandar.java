package co.edu.poli.TiendaSoftware.modelo;

public class EmpaqueEstandar implements EmpaqueStrategy {
	@Override
    public String empaquetar(String nombreProducto) {
        return nombreProducto + " empacado en bolsa plástica estándar.";
    }

}
