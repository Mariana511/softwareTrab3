package co.edu.poli.TiendaSoftware.controller;

import co.edu.poli.TiendaSoftware.modelo.AgregarProductoCommand;
import co.edu.poli.TiendaSoftware.modelo.Cliente;
import co.edu.poli.TiendaSoftware.modelo.Pedido;
import co.edu.poli.TiendaSoftware.modelo.Producto;
import co.edu.poli.TiendaSoftware.modelo.QuitarProductoCommand;
import co.edu.poli.TiendaSoftware.modelo.*;
import co.edu.poli.TiendaSoftware.servicio.EmpaqueServicio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {
	 	@FXML private TextField txtCliente;
	    @FXML private TextField txtProducto;
	    @FXML private ListView<Producto> listViewProductos;
	    @FXML private Label lblMensaje;
	    
	    @FXML private ComboBox<String> comboEmpaque;
	    @FXML private Label labelResultado;
	    
	    @FXML private Label labelEstado;
	    
	    private Pedido pedido;
	    private ObservableList<Producto> productosObservable = FXCollections.observableArrayList();
	    private EmpaqueServicio empaqueServicio = new EmpaqueServicio();

	    @FXML
	    public void initialize() {
	        listViewProductos.setItems(productosObservable);
	        comboEmpaque.getItems().addAll("Regalo", "Ecológico", "Estandar");
	    }

	    @FXML
	    private void crearPedido() {
	    	String nombreCliente = txtCliente.getText().trim();
	        if (nombreCliente.isEmpty()) {
	            lblMensaje.setText("Nombre de cliente vacío.");
	            return;
	        }

	        pedido = new Pedido(new Cliente(nombreCliente));
	        productosObservable.clear();
	        actualizarEstado();
	        lblMensaje.setText("Pedido creado para " + nombreCliente);
	    }

	    @FXML
	    private void agregarProducto() {
	    	if (pedido == null) {
	            lblMensaje.setText("Primero crea un pedido.");
	            return;
	        }

	        String nombreProducto = txtProducto.getText().trim();
	        if (nombreProducto.isEmpty()) {
	            lblMensaje.setText("Nombre de producto vacío.");
	            return;
	        }

	        Producto producto = new Producto(nombreProducto);
	        new AgregarProductoCommand(pedido, producto).ejecutar();
	        productosObservable.add(producto);
	        lblMensaje.setText("Producto agregado.");
	    }

	    @FXML
	    private void quitarProducto() {
	    	if (pedido == null) {
	            lblMensaje.setText("Primero crea un pedido.");
	            return;
	        }

	        Producto productoSeleccionado = listViewProductos.getSelectionModel().getSelectedItem();
	        if (productoSeleccionado == null) {
	            lblMensaje.setText("Selecciona un producto para quitar.");
	            return;
	        }

	        new QuitarProductoCommand(pedido, productoSeleccionado).ejecutar();
	        productosObservable.remove(productoSeleccionado);
	        lblMensaje.setText("Producto quitado.");
	    }  	    
	    
	    @FXML
	    private void empacarProducto() {
	    	Producto productoSeleccionado = listViewProductos.getSelectionModel().getSelectedItem();
	        if (productoSeleccionado == null) {
	            labelResultado.setText("Selecciona un producto para empacar.");
	            return;
	        }

	        String tipo = comboEmpaque.getValue();
	        if (tipo == null) {
	            labelResultado.setText("Selecciona un tipo de empaque.");
	            return;
	        }

	        String resultado = empaqueServicio.procesarEmpaque(productoSeleccionado, tipo);
	        labelResultado.setText(resultado);
	    }
	    
	    private void actualizarEstado() {
	        if (pedido != null && labelEstado != null) {
	            labelEstado.setText("Estado actual: " + pedido.getEstadoNombre());
	        }
	    }
	    
	    @FXML
	    private void procesarPedido() {
	        if (pedido == null) {
	            lblMensaje.setText("Primero crea un pedido.");
	            return;
	        }
	        pedido.procesar();
	        actualizarEstado();
	        lblMensaje.setText("Pedido procesado.");
	    }

	    @FXML
	    private void enviarPedido() {
	        if (pedido == null) {
	            lblMensaje.setText("Primero crea un pedido.");
	            return;
	        }
	        pedido.enviar();
	        actualizarEstado();
	        lblMensaje.setText("Pedido enviado.");
	    }

	    @FXML
	    private void entregarPedido() {
	        if (pedido == null) {
	            lblMensaje.setText("Primero crea un pedido.");
	            return;
	        }
	        pedido.entregar();
	        actualizarEstado();
	        lblMensaje.setText("Pedido entregado.");
	    }
	    
}


