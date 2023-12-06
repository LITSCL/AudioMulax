package cl.inacap.audiomulaxmodelo.dto;

public abstract class InstrumentoMusical {
	protected int valor;
	protected String marca;
	
	public int getValor() {
		return this.valor;
	}
	public void setValor(int Valor) {
		this.valor = Valor;
	}
	public String getMarca() {
		return this.marca;
	}
	public void setMarca(String Marca) {
		this.marca = Marca;
	}
}
