package co.edu.poli.TiendaSoftware.modelo;

public class EmpaqueEcologico implements EmpaqueStrategy {
	@Override
    public String empaquetar(String nombreProducto) {
        return nombreProducto + " empacado en materiales reciclables ♻️.";
    }

}
