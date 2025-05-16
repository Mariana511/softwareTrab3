package co.edu.poli.TiendaSoftware.modelo;

public class EstadoEntregado implements EstadoPedidoState {
	@Override
    public void agregarProducto(Pedido pedido, Producto producto) {
        System.out.println("El pedido ya fue entregado. No se pueden modificar productos.");
    }

    @Override
    public void quitarProducto(Pedido pedido, Producto producto) {
        System.out.println("El pedido ya fue entregado. No se pueden modificar productos.");
    }

    @Override
    public void procesar(Pedido pedido) {
        System.out.println("El pedido ya fue entregado.");
    }

    @Override
    public void enviar(Pedido pedido) {
        System.out.println("El pedido ya fue entregado.");
    }

    @Override
    public void entregar(Pedido pedido) {
        System.out.println("El pedido ya fue entregado.");
    }

    @Override
    public String obtenerEstado() {
        return "Entregado";
    }
}
