package co.edu.poli.TiendaSoftware.modelo;

public class EstadoEnviado implements EstadoPedidoState {
	@Override
    public void agregarProducto(Pedido pedido, Producto producto) {
        System.out.println("No se puede agregar productos a un pedido enviado.");
    }

    @Override
    public void quitarProducto(Pedido pedido, Producto producto) {
        System.out.println("No se puede quitar productos de un pedido enviado.");
    }

    @Override
    public void procesar(Pedido pedido) {
        System.out.println("El pedido ya ha sido enviado.");
    }

    @Override
    public void enviar(Pedido pedido) {
        System.out.println("El pedido ya fue enviado.");
    }

    @Override
    public void entregar(Pedido pedido) {
        pedido.setEstado(new EstadoEntregado());
    }

    @Override
    public String obtenerEstado() {
        return "Enviado";
    }
}
