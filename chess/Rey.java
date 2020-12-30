package chess;

import java.util.ArrayList;
import java.util.Iterator;

public final class Rey extends Pieza {

	public Rey(String color) {
		super("Rey", color);
		if (color.equalsIgnoreCase("Blancas")) {
			this.setSimbolo(new String(Character.toChars(9812)));
		}
		else {
			this.setSimbolo(new String(Character.toChars(9818)));
		}
	}

	@Override
	public RequisitosMovimiento esMovimientoPosible(Coordenada origen, Coordenada destino) {
		//El Rey tiene sólo 8 movimientos posibles, pasando de Enroques
		RequisitosMovimiento requisitos = new RequisitosMovimiento();
		int xOrigen = origen.getX();
		int yOrigen = origen.getY();
		int xDestino = destino.getX();
		int yDestino = destino.getY();
		
		requisitos.esMovimientoPosible(false);
		Coordenada movimientoHecho = new Coordenada(xDestino-xOrigen, yDestino-yOrigen);
		ArrayList<Coordenada> aMovimientosPosibles = obtenerMovimientosPosibles();
		for (Iterator<Coordenada> iterator = aMovimientosPosibles.iterator(); iterator.hasNext();) {
			Coordenada coordenada = (Coordenada) iterator.next();
			if (coordenada.esIgualA(movimientoHecho)) {
				requisitos.esMovimientoPosible(true);
			}
		} 
		System.out.println("Intentando Movimiento de Rey de color:" + color);
		
		return requisitos;
	}

	private ArrayList<Coordenada> obtenerMovimientosPosibles() {
		ArrayList<Coordenada> aMovimientosPosibles = new ArrayList<Coordenada>();
		int[][] movimientos= new int[][] {{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
		for (int i = 0; i < movimientos.length; i++) {
				aMovimientosPosibles.add(new Coordenada(movimientos[i][0],movimientos[i][1]));
		}
		return aMovimientosPosibles;
	}
}
