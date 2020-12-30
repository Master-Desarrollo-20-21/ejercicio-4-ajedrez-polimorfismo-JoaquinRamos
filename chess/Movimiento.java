package chess;

import java.util.ArrayList;
import java.util.Iterator;

public class Movimiento {

	private Casilla [][] casillas;
	private String fichasQueMueven;
	private String jugadaEnFormatoLNLN;
	private Coordenada coordenadaOrigen;
	private Coordenada coordenadaDestino;
	private Boolean esJaqueMate;
	
	private Console consola = new Console();
	
	public Movimiento(Casilla [][] casillas, int numMovimiento) {
		this.casillas = casillas;
		esJaqueMate = false;
		fichasQueMueven = ((numMovimiento) % 2) == 0?"Blancas":"Negras";
		leer();
	}
	
	public void leer() {
		String movimientoLeido;
		String error;
		do {
			consola.write("Mueven las " + fichasQueMueven + "\n");
			movimientoLeido= consola.readString(Propiedades.MENSAJE_INTRODUZCA_MOVIMIENTO);
			error = chequeaError(movimientoLeido);
			if (error != null) {
				consola.write(error);
			}
				
		}while (error != null);
		this.jugadaEnFormatoLNLN = movimientoLeido;
		moverPieza();
	}

	private String chequeaError(String textoIntroducido) {
		
		String texto = textoIntroducido.toUpperCase();
		// Comprueba Longitud
		if (texto.length() != 4) {
				return Propiedades.ERROR_LONGITUD;
		}
		// Comprueba letras y números
		if ( !LetraColumna.getTodasLetrasValidas().contains(texto.substring(0,1))) {
			return Propiedades.ERROR_PRIMERA_LETRA;
		}
		if ( !LetraColumna.getTodosNumerosDeFilaValidos().contains(texto.substring(1,2))) {
			return Propiedades.ERROR_PRIMER_NUMERO;
		}
		if ( !LetraColumna.getTodasLetrasValidas().contains(texto.substring(2,3))) {
			return Propiedades.ERROR_SEGUNDA_LETRA;
		}
		if ( !LetraColumna.getTodosNumerosDeFilaValidos().contains(texto.substring(3,4))) {
			return Propiedades.ERROR_SEGUNDO_NUMERO;
		}
		
		// Traducir la letra de la columna a Numero
		int xOrigen = LetraColumna.obtenerNumero(texto.substring(0,1));
		int yOrigen = Integer.parseInt(texto.substring(1,2))-1; 
		int xDestino = LetraColumna.obtenerNumero(texto.substring(2,3));
		int yDestino = Integer.parseInt(texto.substring(3,4))-1; 
		
		coordenadaOrigen = new Coordenada(xOrigen, yOrigen);
		coordenadaDestino = new Coordenada( xDestino, yDestino);
		
		// Ver qué pieza hay en esa Casilla
		// Si hay pieza, mirar que sea de su color y que en destino no haya otra pieza suya
		if (casillas[xOrigen][yOrigen].getPieza()==null) {
			return Propiedades.ERROR_NO_HAY_PIEZA_EN_ESA_CASILLA;
		}
		if (!fichasQueMueven.equalsIgnoreCase(casillas[xOrigen][yOrigen].getPieza().getColor())) {
			return Propiedades.ERROR_PIEZA_EN_ESA_CASILLA_NO_ES_DE_TU_COLOR;
		}
		if (casillas[xDestino][yDestino].getPieza()!=null && casillas[xOrigen][yOrigen].getPieza().getColor().equals(casillas[xDestino][yDestino].getPieza().getColor())) {
			return Propiedades.ERROR_PIEZA_EN_CASILLA_DESTINO_ES_DE_TU_COLOR;
		}	
		
		// Si ha llegado hasta aquí es que en el origen hay una pieza del color del jugador que mueva
		// Si hay pieza y es de su color, ver que el movimiento es posible en función de la pieza
		RequisitosMovimiento rm = casillas[xOrigen][yOrigen].getPieza().esMovimientoPosible(coordenadaOrigen, coordenadaDestino);
		if (!rm.esMovimientoPosible()) {
			return Propiedades.ERROR_MOVIMIENTO_NO_POSIBLE;
		}
		else {
			//System.out.println("Movimiento.java:   Ver qué casillas libres necesita: " + rm.casillasLibresNecesariasParaMover().toString());
			//System.out.println("estanLasCasillasNecesariasVacias= " + estanLasCasillasNecesariasVacias(rm.casillasLibresNecesariasParaMover()));
			if (!estanLasCasillasNecesariasVacias(rm.casillasLibresNecesariasParaMover())) {
				return Propiedades.ERROR_HAY_CASILLAS_OCUPADAS;
			}
			// Comprobar si necesita pieza rival en el destino, como el Peon al avanzar en diagonal
			if (rm.necesitaPiezaRivalEnDestino()) {
				if (casillas[xDestino][yDestino].getPieza()==null || casillas[xOrigen][yOrigen].getPieza().getColor().equals(casillas[xDestino][yDestino].getPieza().getColor())) {
					return Propiedades.ERROR_PEON_MUEVE_EN_DIAGONAL;
				}
					
			}
		}
		
		return null;
	}

	private boolean estanLasCasillasNecesariasVacias(ArrayList<Coordenada> arrayList) {
		if (arrayList==null) return true;
		for (Iterator<Coordenada> iterator = arrayList.iterator(); iterator.hasNext();) {
			Coordenada coordenada = (Coordenada) iterator.next();
			if (casillas[coordenada.getX()][coordenada.getY()].getPieza()!=null) return false;
		}
		return true;
	}
	
	private void moverPieza() {
		esJaqueMate = casillas[coordenadaDestino.getX()][coordenadaDestino.getY()].getPieza()!= null && casillas[coordenadaDestino.getX()][coordenadaDestino.getY()].getPieza().tipo.equalsIgnoreCase("Rey");
		casillas[coordenadaDestino.getX()][coordenadaDestino.getY()].setPieza(casillas[coordenadaOrigen.getX()][coordenadaOrigen.getY()].getPieza());
		casillas[coordenadaOrigen.getX()][coordenadaOrigen.getY()].setPieza(null);
	}

	public Boolean esJaqueMate() {
		return esJaqueMate;
	}
}


