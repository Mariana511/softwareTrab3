package co.edu.poli.TiendaSoftware.modelo;

public class EstadoProcesado implements EstadoPedidoState {
	@Override
    public void agregarProducto(Pedido pedido, Producto producto) {
        System.out.println("No se puede agregar productos a un pedido procesado.");
    }

    @Override
    public void quitarProducto(Pedido pedido, Producto producto) {
        System.out.println("No se puede quitar productos de un pedido procesado.");
    }

    @Override
    public void procesar(Pedido pedido) {
        System.out.println("El pedido ya está procesado.");
    }

    @Override
    public void enviar(Pedido pedido) {
        pedido.setEstado(new EstadoEnviado());
    }

    @Override
    public void entregar(Pedido pedido) {
        System.out.println("El pedido debe ser enviado antes de entregarlo.");
    }

    @Override
    public String obtenerEstado() {
        return "Procesado";
    }
}
