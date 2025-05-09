package co.edu.poli.TiendaSoftware.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private Cliente cliente;
    private List<Producto> productos = new ArrayList<>();

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void quitarProducto(Producto producto) {
        productos.remove(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public Cliente getCliente() {
        return cliente;
    }
}