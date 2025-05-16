package co.edu.poli.TiendaSoftware.modelo;

public interface pedidoMediator {
	 void seleccionarCliente(String nombre);
	    void agregarProducto(String nombre);
	    void procesarPedido();
	    void enviarPedido();
	    void entregarPedido();
	    String resumenPedido();
	}
 	