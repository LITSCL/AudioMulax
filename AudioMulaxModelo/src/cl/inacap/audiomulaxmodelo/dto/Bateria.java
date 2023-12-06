package cl.inacap.audiomulaxmodelo.dto;

public class Bateria extends InstrumentoMusical { //Significa que esta clase hereda de la clase InstrumentoMusical.
	private boolean esElectrica;
	private int cantidadDeTambores;
	
	public boolean isEsElectrica() {
		return this.esElectrica;
	}
	public void setEsElectrica(boolean EsElectrica) {
		this.esElectrica = EsElectrica;
	}
	public int getCantidadDeTambores() {
		return this.cantidadDeTambores;
	}
	public void setCantidadDeTambores(int CantidadDeTambores) {
		this.cantidadDeTambores = CantidadDeTambores;
	}
	public String toString() {
		return "Bateria: "+this.marca+" Valor: "+this.valor+" Cantidad de tambores: "+this.cantidadDeTambores;
	}
}
