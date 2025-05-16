package co.edu.poli.TiendaSoftware.modelo;

public class EstadoNuevo implements EstadoPedidoState {
	
	@Override
    public void agregarProducto(Pedido pedido, Producto producto) {
        pedido.agregarProductoInterno(producto);
    }

    @Override
    public void quitarProducto(Pedido pedido, Producto producto) {
        pedido.quitarProductoInterno(producto);
    }

    @Override
    public void procesar(Pedido pedido) {
        pedido.setEstado(new EstadoProcesado());
    }

    @Override
    public void enviar(Pedido pedido) {
        System.out.println("El pedido debe ser procesado antes de enviarlo.");
    }

    @Override
    public void entregar(Pedido pedido) {
        System.out.println("El pedido debe ser enviado antes de entregarlo.");
    }

    @Override
    public String obtenerEstado() {
        return "Nuevo";
    }
}
