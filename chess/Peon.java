package chess;

import java.util.ArrayList;

public final class Peon extends Pieza {

	public Peon(String color) {
		super("Peon", color);
		if (color.equalsIgnoreCase("Blancas")) {
			this.setSimbolo(new String(Character.toChars(9817)));
		}
		else {
			this.setSimbolo(new String(Character.toChars(9823)));
		}
	}

	@Override
	public RequisitosMovimiento esMovimientoPosible(Coordenada origen, Coordenada destino) {
		RequisitosMovimiento requisitos = new RequisitosMovimiento();
		int xOrigen = origen.getX();
		int yOrigen = origen.getY();
		int xDestino = destino.getX();
		int yDestino = destino.getY();
		ArrayList<Coordenada> aCoordenadasNecesariasVacias = new ArrayList<Coordenada>();
		requisitos.esMovimientoPosible(false);
		System.out.println("Peon.java:   Calculando Requisitos para el Movimiento de Pe�n de color:" + color);
		
		if (color.equalsIgnoreCase("Blancas")) {
			// Ver movimientos posibles de pe�n de las Blancas
			if (yDestino == yOrigen+1 && xDestino == xOrigen) {
				// El pe�n quiere avanzar 1
				requisitos.esMovimientoPosible(true);
				aCoordenadasNecesariasVacias.add(new Coordenada(xOrigen, yOrigen+1));
				
			}
			else if (yDestino == yOrigen+2 && xDestino == xOrigen && yOrigen == 1) {
				// El pe�n avanza 2 porque est� en la posici�n de inicio
				requisitos.esMovimientoPosible(true);
				aCoordenadasNecesariasVacias.add(new Coordenada(xOrigen, yOrigen+1));
				aCoordenadasNecesariasVacias.add(new Coordenada(xOrigen, yOrigen+2));
			}else if (yDestino == yOrigen+1 && (xDestino == xOrigen+1 || xDestino == xOrigen-1)) {
				// El pe�n avanza 1 en diagonal hacia adelante para comerse una pieza enemiga
				requisitos.esMovimientoPosible(true);
				requisitos.necesitaPiezaRivalEnDestino(true);
			}
		}
		else {
			// Ver movimientos posibles de pe�n de las Negras
			if (yDestino == yOrigen-1 && xDestino == xOrigen) {
				// El pe�n avanza 1
				requisitos.esMovimientoPosible(true);
				aCoordenadasNecesariasVacias.add(new Coordenada(xOrigen, yOrigen-1));
			}
			else if (yDestino == yOrigen-2 && xDestino == xOrigen && yOrigen == 6) {
				// El pe�n avanza 2 porque est� en la posici�n de inicio
				requisitos.esMovimientoPosible(true);
				aCoordenadasNecesariasVacias.add(new Coordenada(xOrigen, yOrigen-1));
				aCoordenadasNecesariasVacias.add(new Coordenada(xOrigen, yOrigen-2));
			}else if (yDestino == yOrigen-1 && (xDestino == xOrigen+1 || xDestino == xOrigen-1)) {
				// El pe�n avanza 1 en diagonal hacia adelante para comerse una pieza enemiga
				requisitos.esMovimientoPosible(true);
				requisitos.necesitaPiezaRivalEnDestino(true);
			}
		}
		requisitos.casillasLibresNecesariasParaMover(aCoordenadasNecesariasVacias);
		return requisitos;
	}

}
