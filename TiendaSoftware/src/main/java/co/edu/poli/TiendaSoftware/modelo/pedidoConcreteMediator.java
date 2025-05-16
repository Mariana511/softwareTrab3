package co.edu.poli.TiendaSoftware.modelo;

public class pedidoConcreteMediator implements PedidoMediator {

    private Pedido pedido;

    @Override
    public void seleccionarCliente(String nombre) {
        Cliente cliente = new Cliente(nombre);
        pedido = new Pedido(cliente);
    }

    @Override
    public void agregarProducto(String nombre) {
        if (pedido != null) {
            Producto producto = new Producto(nombre);
            pedido.agregarProducto(producto);
        }
    }

    @Override
    public void procesarPedido() {
        if (pedido != null) {
            pedido.procesar();
        }
    }

    @Override
    public void enviarPedido() {
        if (pedido != null) {
            pedido.enviar();
        }
    }

    @Override
    public void entregarPedido() {
        if (pedido != null) {
            pedido.entregar();
        }
    }

    @Override
    public String resumenPedido() {
        if (pedido != null) {
            return pedido.getResumen();
        } else {
            return "No hay pedido creado.";
        }
    }
}