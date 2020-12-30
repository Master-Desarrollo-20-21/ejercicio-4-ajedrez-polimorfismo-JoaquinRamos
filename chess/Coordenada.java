package chess;

import java.util.ArrayList;

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
	
	public boolean enDiagonal(Coordenada destino) {
		return this.x!=destino.x && (Math.abs(destino.x-this.x) == Math.abs(destino.y-this.y));
	}

	public boolean enMismaFila(Coordenada destino) {
		return this.y==destino.y;
	}
	public boolean enMismaColumna(Coordenada destino) {
		return this.x==destino.x;
	}
	
	public Coordenada diferenciaMovimiento(Coordenada destino) {
		return new Coordenada(destino.x-this.x, destino.y-this.y);
	}
	
	public ArrayList<Coordenada> coordenadasIntermedias(Coordenada destino) {
		
		ArrayList<Coordenada> aCoordenadasIntermedias = new ArrayList<Coordenada>();
		if (this.enMismaColumna(destino)) {
			if (destino.y>this.y) {
				for (int y = this.y+1; y < destino.y; y++) {
					aCoordenadasIntermedias.add(new Coordenada(this.x, y));
				}
			} else {
				for (int y = this.y-1; y > destino.y; y--) {
					aCoordenadasIntermedias.add(new Coordenada(this.x, y));
				}
			}
		} else if (this.enMismaFila(destino)) {
			if (destino.x>this.x) {
				for (int x = this.x+1; x < destino.x; x++) {
					aCoordenadasIntermedias.add(new Coordenada(x, this.y));
				}
			} else {
				for (int x = this.x-1; x > destino.x; x--) {
					aCoordenadasIntermedias.add(new Coordenada(x, this.y));
				}
			}
		}else if (this.enDiagonal(destino)) {
			Coordenada diferenciaMovimiento = diferenciaMovimiento(destino);
			if (diferenciaMovimiento.getX()>0) {
				if (diferenciaMovimiento.getY()>0) {
					for (int i = 1; i < diferenciaMovimiento.getX(); i++) {
						aCoordenadasIntermedias.add(new Coordenada(this.x+i, this.y+i));
					}
				} else {
					for (int i = 1; i < diferenciaMovimiento.getX(); i++) {
						aCoordenadasIntermedias.add(new Coordenada(this.x+i, this.y-i));
					}
				}
			} else {
				if (diferenciaMovimiento.getY()>0) {
					for (int i = -1; i > diferenciaMovimiento.getX(); i--) {
						aCoordenadasIntermedias.add(new Coordenada(this.x+i, this.y-i));
					}
				} else {
					for (int i = -1; i > diferenciaMovimiento.getX(); i--) {
						aCoordenadasIntermedias.add(new Coordenada(this.x+i, this.y+i));
					}
				}
			}
		}
		return aCoordenadasIntermedias;
	}
	
	public String toString() {
		return ("{" + x + "," + y + "}");
	}
}
