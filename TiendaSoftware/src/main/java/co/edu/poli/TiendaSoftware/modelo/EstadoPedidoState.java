package co.edu.poli.TiendaSoftware.modelo;

public interface EstadoPedidoState {
	void agregarProducto(Pedido pedido, Producto producto);
    void quitarProducto(Pedido pedido, Producto producto);
    void procesar(Pedido pedido);
    void enviar(Pedido pedido);
    void entregar(Pedido pedido);
    String obtenerEstado();
}
