package chess;

import java.util.ArrayList;

public class RequisitosMovimiento {

	private boolean esMovimientoPosible;
	private ArrayList<Coordenada> casillasLibresNecesariasParaMover;
	private boolean necesitaPiezaRivalEnDestino;
	
	public RequisitosMovimiento() {
		super();
		this.esMovimientoPosible = true;
		this.casillasLibresNecesariasParaMover = null;
		this.necesitaPiezaRivalEnDestino = false;
	}

	public boolean esMovimientoPosible() {
		return esMovimientoPosible;
	}
	public ArrayList<Coordenada> casillasLibresNecesariasParaMover() {
		return casillasLibresNecesariasParaMover;
	}
	public boolean necesitaPiezaRivalEnDestino() {
		return necesitaPiezaRivalEnDestino;
	}


	public void esMovimientoPosible(boolean esMovimientoPosible) {
		this.esMovimientoPosible = esMovimientoPosible;
	}

	public void casillasLibresNecesariasParaMover(ArrayList<Coordenada>  casillasLibresNecesariasParaMover) {
		this.casillasLibresNecesariasParaMover = casillasLibresNecesariasParaMover;
	}

	public void necesitaPiezaRivalEnDestino(boolean necesitaPiezaRivalEnDestino) {
		this.necesitaPiezaRivalEnDestino = necesitaPiezaRivalEnDestino;
	}

}
