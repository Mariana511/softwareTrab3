package co.edu.poli.TiendaSoftware.modelo;

public class EmpaqueRegalo implements EmpaqueStrategy {
	 @Override
	    public String empaquetar(String nombreProducto) {
	        return nombreProducto + " empacado como regalo 🎁.";
	    }

}
