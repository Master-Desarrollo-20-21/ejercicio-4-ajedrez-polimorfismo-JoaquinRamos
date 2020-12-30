package chess;

import java.util.ArrayList;
import java.util.Iterator;

public final class Caballo extends Pieza {

	public Caballo(String color) {
		super("Caballo", color);
		if (color.equalsIgnoreCase("Blancas")) {
			this.setSimbolo(new String(Character.toChars(9816)));
		}
		else {
			this.setSimbolo(new String(Character.toChars(9822)));
		}
	}

	public RequisitosMovimiento esMovimientoPosible(Coordenada origen, Coordenada destino) {
		RequisitosMovimiento requisitos = new RequisitosMovimiento();
		int xOrigen = origen.getX();
		int yOrigen = origen.getY();
		int xDestino = destino.getX();
		int yDestino = destino.getY();
		ArrayList<Coordenada> aMovimientosPosibles = obtenerMovimientosPosibles();
		
		requisitos.esMovimientoPosible(false);
		Coordenada movimientoHecho = new Coordenada(xDestino-xOrigen, yDestino-yOrigen);
		for (Iterator<Coordenada> iterator = aMovimientosPosibles.iterator(); iterator.hasNext();) {
			Coordenada coordenada = (Coordenada) iterator.next();
			if (coordenada.esIgualA(movimientoHecho)) {
				requisitos.esMovimientoPosible(true);
			}
		} 		
		return requisitos;
	}

	private ArrayList<Coordenada> obtenerMovimientosPosibles() {
		ArrayList<Coordenada> aMovimientosPosibles = new ArrayList<Coordenada>();
		int[][] movimientos= new int[][] {{1,2},{1,-2},{2,1},{2,-1},{-1,2},{-1,-2},{-2,1},{-2,-1}};
		for (int i = 0; i < movimientos.length; i++) {
				aMovimientosPosibles.add(new Coordenada(movimientos[i][0],movimientos[i][1]));
		}
		return aMovimientosPosibles;
	}
}
