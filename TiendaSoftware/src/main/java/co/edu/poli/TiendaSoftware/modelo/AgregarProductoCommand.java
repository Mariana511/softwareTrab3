package co.edu.poli.TiendaSoftware.modelo;

public class AgregarProductoCommand implements Command {
    private Pedido pedido;
    private Producto producto;

    public AgregarProductoCommand(Pedido pedido, Producto producto) {
        this.pedido = pedido;
        this.producto = producto;
    }

    @Override
    public void ejecutar() {
        pedido.agregarProducto(producto);
    }
}