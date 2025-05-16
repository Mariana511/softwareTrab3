package co.edu.poli.TiendaSoftware.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private Cliente cliente;
    private List<Producto> productos;
    private EstadoPedidoState estado;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.estado = new EstadoNuevo(); // Estado inicial
    }

    // Acciones del patrón Command
    public void agregarProducto(Producto producto) {
        estado.agregarProducto(this, producto);
    }

    public void quitarProducto(Producto producto) {
        estado.quitarProducto(this, producto);
    }

    // Métodos para modificar productos internamente (desde el estado)
    public void agregarProductoInterno(Producto producto) {
        productos.add(producto);
    }

    public void quitarProductoInterno(Producto producto) {
        productos.remove(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setEstado(EstadoPedidoState estado) {
        this.estado = estado;
    }

    public EstadoPedidoState getEstado() {
        return estado;
    }

    public String obtenerEstado() {
        return estado.obtenerEstado();
    }

    // Acciones del patrón State (para llamar desde el controlador)
    public void procesar() {
        estado.procesar(this);
    }

    public void enviar() {
        estado.enviar(this);
    }

    public void entregar() {
        estado.entregar(this);
    }

    public String getEstadoNombre() {
        return estado.getClass().getSimpleName().replace("Estado", "");
    }
}