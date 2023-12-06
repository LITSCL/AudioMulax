package cl.inacap.audiomulaxmodelo.dao;

import java.util.List;
import java.util.ArrayList;
import cl.inacap.audiomulaxmodelo.dto.Venta;

public class VentaDAO {
	private static List<Venta> ventas = new ArrayList<>();
	
	public void save(Venta v) {
		ventas.add(v);
	}
	
	public List<Venta> getAll() {
		return ventas;
	}
	
	public void delete(int Posicion) {
		ventas.remove(Posicion);
	}
}
