package chess;

import java.util.ArrayList;

public class Tablero {
	
	protected static int longitudTablero = Propiedades.LONGITUD_TABLERO;
	private Casilla [][] casillas;
	private ArrayList<Movimiento> movimientos;
	private int numJugada;
	
	private Console consola = new Console();
	
	public Tablero(){
		
		casillas = new Casilla[longitudTablero][longitudTablero];
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas.length; j++) {
				casillas[i][j] = new Casilla(i, j);
			}
		}
		movimientos = new ArrayList<Movimiento>();
		numJugada = 0;
		colocarPiezasIniciales();
	}

	public void jugar() {
		boolean hayJaqueMate = false;
		imprimir();
		do {
			movimientos.add(new Movimiento(casillas, numJugada));
			numJugada++;
			imprimir();
		} while (!hayJaqueMate);
		
		if (hayJaqueMate) {
			consola.write(Propiedades.MENSAJE_GANADOR_BLANCAS);
			
		}
		else {
			consola.write(Propiedades.MENSAJE_GANADOR_NEGRAS)  ;
		}
	}

	public void imprimir() {
		consola.write("\n\n\n\n\n\n\n\n\n\n\n\n\nTablero:\n\n");
		consola.write("    ----- ----- ----- ----- ----- ----- ----- -----\n");
		for (int y = casillas.length-1; y >= 0 ; y--) {
			consola.write(y+1 + "  |");
			for (int x = 0; x < casillas.length; x++) {
				consola.write(casillas[x][y].toString()+ "|");
			}
			consola.write("\n");
			consola.write("    ----- ----- ----- ----- ----- ----- ----- -----\n");
		}
		consola.write("    ");
		for (int x = 0; x < casillas.length; x++) {
			consola.write( "  " + casillas[x][0].getLetraY() + "   ");
		}
		consola.write("\n");
	}
	
	private void colocarPiezasIniciales() {
		colocarPiezas(Propiedades.reyBlanco, "Rey", "Blancas");
		colocarPiezas(Propiedades.reyNegro, "Rey", "Negras");
		colocarPiezas(Propiedades.peonesBlancos, "Peon", "Blancas");
		colocarPiezas(Propiedades.peonesNegros, "Peon", "Negras");
		colocarPiezas(Propiedades.caballosBlancos, "Caballo", "Blancas");
		colocarPiezas(Propiedades.caballosNegros, "Caballo", "Negras");
		colocarPiezas(Propiedades.torresBlancas, "Torre", "Blancas");
		colocarPiezas(Propiedades.torresNegras, "Torre", "Negras");
		colocarPiezas(Propiedades.alfilesBlancos, "Alfil", "Blancas");
		colocarPiezas(Propiedades.alfilesNegros, "Alfil", "Negras");
	}
	
	private void colocarPiezas(String[] piezas, String tipo, String color) {
		for (String s : piezas) {
			int xOrigen = LetraColumna.obtenerNumero(s.substring(0,1));
			int yOrigen = Integer.parseInt(s.substring(1,2))-1; 
			
			casillas[xOrigen][yOrigen].colocarPieza(tipo, color);
		}
	}
}
