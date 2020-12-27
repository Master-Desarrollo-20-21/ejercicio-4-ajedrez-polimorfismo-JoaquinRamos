package chess;

import java.util.ArrayList;

public final class Torre extends Pieza {

	public Torre(String color) {
		super("Torre", color);
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
		
		if (xOrigen==xDestino) {
			requisitos.esMovimientoPosible(true);
			if (yDestino>yOrigen) {
				for (int y = yOrigen+1; y < yDestino; y++) {
					aCoordenadasNecesariasVacias.add(new Coordenada(xOrigen, y));
				}
			} else {
				for (int y = yOrigen-1; y > yDestino; y--) {
					aCoordenadasNecesariasVacias.add(new Coordenada(xOrigen, y));
				}
			}
			
		} else if (yOrigen==yDestino) {
			requisitos.esMovimientoPosible(true);
			if (xDestino>xOrigen) {
				for (int x = xOrigen+1; x < xDestino; x++) {
					aCoordenadasNecesariasVacias.add(new Coordenada(x, yOrigen));
				}
			} else {
				for (int x = xOrigen-1; x > xDestino; x--) {
					aCoordenadasNecesariasVacias.add(new Coordenada(x, yOrigen));
				}
			}
		}
		requisitos.casillasLibresNecesariasParaMover(aCoordenadasNecesariasVacias);
		return requisitos;
	}
}
