package chess;

public final class Torre extends Pieza {

	public Torre(String color) {
		super("Torre", color);
		if (color.equalsIgnoreCase("Blancas")) {
			this.setSimbolo(new String(Character.toChars(9814)));
		}
		else {
			this.setSimbolo(new String(Character.toChars(9820)));
		}
	}

	@Override
	public RequisitosMovimiento esMovimientoPosible(Coordenada origen, Coordenada destino) {
		RequisitosMovimiento requisitos = new RequisitosMovimiento();
		
		requisitos.esMovimientoPosible(esMovimientoDeTorrePosible(origen, destino));
		if (!requisitos.esMovimientoPosible()) {
			return requisitos;
		}
		
		requisitos.casillasLibresNecesariasParaMover(origen.coordenadasIntermedias(destino));
		System.out.println("Intentando Movimiento de Torre de color:" + color);
		System.out.println("Necesito vacías las Coordenadas:" + origen.coordenadasIntermedias(destino));
		return requisitos;
	}

	private boolean esMovimientoDeTorrePosible(Coordenada origen, Coordenada destino) {
		return origen.enMismaFila(destino) || origen.enMismaColumna(destino); 
	}
	
}
