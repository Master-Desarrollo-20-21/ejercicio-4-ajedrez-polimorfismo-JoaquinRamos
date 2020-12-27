package chess;

public class Casilla {
	private int x;
	private int y;
	private String letraY;
	private Pieza pieza;
	
	public Casilla(int x, int y) {
		this.x = x;
		this.y = y;
		this.setLetraY(LetraColumna.obtenerLetra(x));
	}
	
	public void colocarPieza(String tipo, String color) {
		switch (tipo) {
			case "Rey":
				pieza = new Rey(color);
				break;	
			case "Peon":
				pieza = new Peon(color);
				break;
			case "Caballo":
				pieza = new Caballo(color);
				break;
			case "Torre":
				pieza = new Torre(color);
				break;
			case "Alfil":
				pieza = new Alfil(color);
				break;
		}	
	}

	public String toString(){
		if (pieza == null) {
			if (((x+y) % 2) == 0 )
				return "     ";
			else
				return "  �  ";
		}	
		else {
			
			return " " + pieza.getTipo().substring(0, 1) + " "  + pieza.getColor().substring(0, 1) + " ";
		}
	}
	
	public String getLetraY() {
		return letraY;
	}

	public void setLetraY(String letraY) {
		this.letraY = letraY;
	}

	public Pieza getPieza() {
		return pieza;
	}

	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}
}
