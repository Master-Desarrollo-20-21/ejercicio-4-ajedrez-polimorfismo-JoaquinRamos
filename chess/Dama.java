package chess;

public final class Dama extends Pieza {

	public Dama(String color) {
		super("Dama", color);
		if (color.equalsIgnoreCase("Blancas")) {
			this.setSimbolo(new String(Character.toChars(9813)));
		}
		else {
			this.setSimbolo(new String(Character.toChars(9819)));
		}
	}

	@Override
	public RequisitosMovimiento esMovimientoPosible(Coordenada origen, Coordenada destino) {
		RequisitosMovimiento requisitos = new RequisitosMovimiento();	
		requisitos.esMovimientoPosible(esMovimientoDeDamaPosible(origen, destino));
		System.out.println("Intentando Movimiento de Dama de color:" + color);
		System.out.println("Necesito vacías las Coordenadas:" + origen.coordenadasIntermedias(destino));
		requisitos.casillasLibresNecesariasParaMover(origen.coordenadasIntermedias(destino));
		return requisitos;
	}

	private boolean esMovimientoDeDamaPosible(Coordenada origen, Coordenada destino) {
		return origen.enMismaFila(destino) || origen.enMismaColumna(destino) || origen.enDiagonal(destino); 
	}
}
