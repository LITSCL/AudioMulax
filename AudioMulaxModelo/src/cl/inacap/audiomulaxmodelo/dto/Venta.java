package cl.inacap.audiomulaxmodelo.dto;

import java.util.ArrayList;
import java.util.List;

public class Venta {
	private String nombreComprador;
	private String rutComprador;
	private int total;
	private int iva;
	private int totalConIVA;
	private List<InstrumentoMusical> instrumentos=new ArrayList<InstrumentoMusical>(); //Esta instrucción también se puede escribir así: "private List<InstrumentoMusical> Instrumentos=new ArrayList<>();", Ésta es la lista de instrumentos a vender.
	
	public List<InstrumentoMusical> getInstrumentos() {
		return instrumentos;
	}

	public void setInstrumentos(List<InstrumentoMusical> Instrumentos) {
		this.instrumentos = Instrumentos;
	}

	public String getNombreComprador() {
		return nombreComprador;
	}

	public void setNombreComprador(String NombreComprador) {
		this.nombreComprador = NombreComprador;
	}

	public String getRutComprador() {
		return rutComprador;
	}

	public void setRutComprador(String RutComprador) {
		this.rutComprador = RutComprador;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int Total) {
		this.total = Total;
	}

	public int getIVA() {
		return iva;
	}

	public void setIVA(int IVA) {
		this.iva = IVA;
	}
	
	public int getTotalConIVA() {
		return totalConIVA;
	}

	public void setTotalConIVA(int TotalConIVA) {
		this.totalConIVA = TotalConIVA;
	}

	public String toString() {
		String texto = "Boleta de venta:\n";
		for (InstrumentoMusical im : instrumentos) {
			texto+=im.toString() + "\n"; //En esta instrucción no es necesario llamar al método toString.
		}
		texto+="Total de venta: " + this.getTotal() + "\n";
		texto+="IVA: " + this.getIVA() + "\n";
		texto+="Total con IVA: " + this.getTotalConIVA() + "\n";
		return texto;
	}
}
