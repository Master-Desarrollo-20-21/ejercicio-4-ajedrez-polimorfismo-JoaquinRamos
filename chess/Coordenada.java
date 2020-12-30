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
		// Movimiento Horizontal o Vertical, como el de la Torre
		if (this.enMismaColumna(destino)) {
			// Es un Movimiento Vertical
			if (destino.y>this.y) {
				// Vertical hacia arriba
				for (int y = this.y+1; y < destino.y; y++) {
					aCoordenadasIntermedias.add(new Coordenada(this.x, y));
				}
			} else {
				// Vertical hacia abajo
				for (int y = this.y-1; y > destino.y; y--) {
					aCoordenadasIntermedias.add(new Coordenada(this.x, y));
				}
			}
		} else if (this.enMismaFila(destino)) {
			// Es un Movimiento Horizontal
			if (destino.x>this.x) {
				// Horizontal hacia la Derecha
				for (int x = this.x+1; x < destino.x; x++) {
					aCoordenadasIntermedias.add(new Coordenada(x, this.y));
				}
			} else {
				// Horizontal hacia la Izquierda
				for (int x = this.x-1; x > destino.x; x--) {
					aCoordenadasIntermedias.add(new Coordenada(x, this.y));
				}
			}
		}else if (this.enDiagonal(destino)) {
			// Movimiento Diagonal, como el del Alfil
			Coordenada diferenciaMovimiento = diferenciaMovimiento(destino);
			if (diferenciaMovimiento.getX()>0) {
				// La X aumenta
				if (diferenciaMovimiento.getY()>0) {
					// La Y aumenta
					for (int i = 1; i < diferenciaMovimiento.getX(); i++) {
						aCoordenadasIntermedias.add(new Coordenada(this.x+i, this.y+i));
					}
				} else {
					// La Y disminuye
					for (int i = 1; i < diferenciaMovimiento.getX(); i++) {
						aCoordenadasIntermedias.add(new Coordenada(this.x+i, this.y-i));
					}
				}
			} else {
				// La X disminuye
				if (diferenciaMovimiento.getY()>0) {
					// La Y aumenta
					for (int i = -1; i > diferenciaMovimiento.getX(); i--) {
						aCoordenadasIntermedias.add(new Coordenada(this.x+i, this.y-i));
					}
				} else {
					// La Y disminuye
					for (int i = -1; i > diferenciaMovimiento.getX(); i--) {
						aCoordenadasIntermedias.add(new Coordenada(this.x+i, this.y+i));
					}
				}
			}
		}
		System.out.println("Necesito vacías las Coordenadas:" + aCoordenadasIntermedias);
		return aCoordenadasIntermedias;
	}
	
	public String toString() {
		return ("{" + x + "," + y + "}");
	}
}
