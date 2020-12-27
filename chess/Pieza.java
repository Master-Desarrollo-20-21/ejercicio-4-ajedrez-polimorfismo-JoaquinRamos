package chess;

public abstract class Pieza {
	protected String tipo;
	protected String color;
	
	public Pieza() {
		tipo ="";
		color = "";
	}
	public Pieza(String tipo, String color) {
		this.tipo = tipo;
		this.color = color;
	}	
	
	public abstract RequisitosMovimiento esMovimientoPosible(Coordenada origen, Coordenada destino);
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
