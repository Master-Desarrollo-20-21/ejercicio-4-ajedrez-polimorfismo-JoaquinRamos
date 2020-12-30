package chess;

public final class Alfil extends Pieza {

	public Alfil(String color) {
		super("Alfil", color);
		if (color.equalsIgnoreCase("Blancas")) {
			this.setSimbolo(new String(Character.toChars(9815)));
		}
		else {
			this.setSimbolo(new String(Character.toChars(9821)));
		}
	}

	@Override
	public RequisitosMovimiento esMovimientoPosible(Coordenada origen, Coordenada destino) {
		RequisitosMovimiento requisitos = new RequisitosMovimiento();
		requisitos.esMovimientoPosible(esMovimientoDeAlfilPosible(origen, destino));
		if (!requisitos.esMovimientoPosible()) {
			return requisitos;
		}
		requisitos.casillasLibresNecesariasParaMover(origen.coordenadasIntermedias(destino));
		//System.out.println("Intentando Movimiento de Alfil de color:" + color);
		//System.out.println("Necesito vac�as las Coordenadas:" + origen.coordenadasIntermedias(destino));
		return requisitos;
	}

	private boolean esMovimientoDeAlfilPosible(Coordenada origen, Coordenada destino) {
		return origen.enDiagonal(destino) ; 
	}
}
