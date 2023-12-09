package cl.inacap.audiomulaxmodelo.dto;

public class Guitarra extends InstrumentoMusical { //Significa que esta clase hereda de la clase InstrumentoMusical.
	private int cantidadDeCuerdas;
	private boolean puenteFlotante;
	
	public int getCantidadDeCuerdas() {
		return this.cantidadDeCuerdas;
	}
	
	public void setCantidadDeCuerdas(int CantidadDeCuerdas) {
		this.cantidadDeCuerdas=CantidadDeCuerdas;
	}
	
	public boolean isPuenteFlotante() {
		return puenteFlotante;
	}
	
	public void setPuenteFlotante(boolean PuenteFlotante) {
		this.puenteFlotante=PuenteFlotante;
	}
	
	public String toString() {
		return "Guitarra: " + this.marca + " Valor: " + this.valor + " Cantidad de cuerdas: " + this.cantidadDeCuerdas;
	}
}
