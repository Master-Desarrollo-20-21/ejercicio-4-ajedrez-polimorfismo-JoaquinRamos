package chess;

public class Chess {

	private Tablero tablero ;
	private Console consola = new Console();
	
	public void jugar() {
		do {
			this.tablero = new Tablero();
			this.tablero.jugar();
		}while(this.quiereContinuar());
		consola.write("Bye, Bye !!!");
	}
	
	private boolean quiereContinuar() {
		char continuar;
		continuar = consola.readChar(Propiedades.MENSAJE_QUIERECONTINUAR);
		return 'S' == continuar || 's' == continuar;
	}
	
	public static void main(String[] args) {
		new Chess().jugar();	
	}
}
