package co.edu.poli.TiendaSoftware.modelo;

public interface PedidoMediator {
	 void seleccionarCliente(String nombre);
	    void agregarProducto(String nombre);
	    void procesarPedido();
	    void enviarPedido();
	    void entregarPedido();
	    String resumenPedido();
	}
 	