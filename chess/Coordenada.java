package chess;

public class Coordenada {
	
	private int x;
	private int y;
	
	public Coordenada(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean esIgualA(Coordenada c) {
		return this.getX() == c.getX() && this.getY() == c.getY();
	}
	
	public String toString() {
		return ("{" + x + "," + y + "}");
	}
}
