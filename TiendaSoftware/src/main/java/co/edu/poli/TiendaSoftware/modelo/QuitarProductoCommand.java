package co.edu.poli.TiendaSoftware.modelo;

public class QuitarProductoCommand implements Command {
    private Pedido pedido;
    private Producto producto;

    public QuitarProductoCommand(Pedido pedido, Producto producto) {
        this.pedido = pedido;
        this.producto = producto;
    }

    @Override
    public void ejecutar() {
        pedido.quitarProducto(producto);
    }
}
