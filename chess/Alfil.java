package chess;

import java.util.ArrayList;

public final class Alfil extends Pieza {

	public Alfil(String color) {
		super("Alfil", color);
	}

	@Override
	public RequisitosMovimiento esMovimientoPosible(Coordenada origen, Coordenada destino) {
		RequisitosMovimiento requisitos = new RequisitosMovimiento();
		int xOrigen = origen.getX();
		int yOrigen = origen.getY();
		int xDestino = destino.getX();
		int yDestino = destino.getY();
		ArrayList<Coordenada> aCoordenadasNecesariasVacias = new ArrayList<Coordenada>();

		requisitos.esMovimientoPosible(esMovimientoPosible(xOrigen, yOrigen, xDestino, yDestino));
		if (!esMovimientoPosible(xOrigen, yOrigen, xDestino, yDestino)) {
			return requisitos;
		}
		Coordenada diferenciaMovimiento = calcularDiferenciaMovimiento(xOrigen, yOrigen, xDestino, yDestino);
		if (diferenciaMovimiento.getX()>0) {
			if (diferenciaMovimiento.getY()>0) {
				for (int i = 1; i < diferenciaMovimiento.getX(); i++) {
					aCoordenadasNecesariasVacias.add(new Coordenada(xOrigen+i, yOrigen+i));
				}
			} else {
				for (int i = 1; i < diferenciaMovimiento.getX(); i++) {
					aCoordenadasNecesariasVacias.add(new Coordenada(xOrigen+i, yOrigen-i));
				}
			}
		} else {
			if (diferenciaMovimiento.getY()>0) {
				for (int i = -1; i > diferenciaMovimiento.getX(); i--) {
					aCoordenadasNecesariasVacias.add(new Coordenada(xOrigen+i, yOrigen-i));
				}
			} else {
				for (int i = -1; i > diferenciaMovimiento.getX(); i--) {
					aCoordenadasNecesariasVacias.add(new Coordenada(xOrigen+i, yOrigen+i));
				}
			}
		}
		requisitos.casillasLibresNecesariasParaMover(aCoordenadasNecesariasVacias);
		return requisitos;
	}

	private boolean esMovimientoPosible(int xOrigen, int yOrigen, int xDestino, int yDestino) {
		return xOrigen!=xDestino && (Math.abs(xDestino-xOrigen) == Math.abs(yDestino-yOrigen));
	}

	private Coordenada calcularDiferenciaMovimiento(int xOrigen, int yOrigen, int xDestino, int yDestino) {
		return new Coordenada(xDestino-xOrigen, yDestino-yOrigen);
	}
}
