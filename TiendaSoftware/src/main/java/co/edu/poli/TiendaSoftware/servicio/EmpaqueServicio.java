package co.edu.poli.TiendaSoftware.servicio;

import co.edu.poli.TiendaSoftware.modelo.*;

public class EmpaqueServicio {
	
	public String procesarEmpaque(Producto producto, String tipoEmpaque) {
        switch (tipoEmpaque) {
            case "Regalo":
                producto.setEstrategiaEmpaque(new EmpaqueRegalo());
                break;
            case "Ecológico":
                producto.setEstrategiaEmpaque(new EmpaqueEcologico());
                break;
            default:
                producto.setEstrategiaEmpaque(new EmpaqueEstandar());
                break;
        }
        return producto.obtenerEmpaque();
    }

}
