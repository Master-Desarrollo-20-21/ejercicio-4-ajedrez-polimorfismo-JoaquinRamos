package chess;

public class Propiedades {
	public static final int LONGITUD_TABLERO = 8;
	
	public static final String MENSAJE_INTRODUZCA_MOVIMIENTO = "Introduzca movimiento en formato A2A4 \n";
	public static final String MENSAJE_QUIERECONTINUAR = "¿Quieres otra partida S/N?\n";
	
	public static final String MENSAJE_GANADOR_BLANCAS = "Ganaron las blancas"; 
	public static final String MENSAJE_GANADOR_NEGRAS = "Anda, que dejarte ganar por las negras, ya te vale."; 
	
	public static final String ERROR_LONGITUD = "Longitud Erronea, introduzca movimiento en formato A2A4 \n";
	public static final String ERROR_PRIMERA_LETRA = "Error: La primera letra está mal \n";
	public static final String ERROR_PRIMER_NUMERO = "Error: El primer número está mal \n";
	public static final String ERROR_SEGUNDA_LETRA = "Error: La segunda letra está mal \n";
	public static final String ERROR_SEGUNDO_NUMERO = "Error: El segundo número está mal \n";
	public static final String ERROR_NO_HAY_PIEZA_EN_ESA_CASILLA = "Error: No hay ninguna pieza en la casilla de origen \n";
	public static final String ERROR_PIEZA_EN_ESA_CASILLA_NO_ES_DE_TU_COLOR = "Error: Intentas mover una pieza que no es tuya, ¡¡no me hagas trampas, hooombre!! \n";
	public static final String ERROR_PIEZA_EN_CASILLA_DESTINO_ES_DE_TU_COLOR = "Error: Intentas mover una pieza donde ya hay otra pieza tuya, ¡¡lo flipo!! \n";
	public static final String ERROR_MOVIMIENTO_NO_POSIBLE = "Error: Movimiento no posible con esa pieza \n";
	public static final String ERROR_HAY_CASILLAS_OCUPADAS = "Error: Hay casillas ocupadas, movimiento no posible \n";
	
	public static final String[] reyBlanco = new String[] { "E1" };
	public static final String[] reyNegro = new String[] { "E8" };
	
	public static final String[] peonesBlancos = new String[] { "A2", "B2", "C2", "D2","E2", "F2", "G2", "H2" };
	public static final String[] peonesNegros = new String[] { "A7", "B7", "C7", "D7","E7", "F7", "G7", "H7" };

	public static final String[] caballosBlancos = new String[] { "B1", "G1" };
	public static final String[] caballosNegros = new String[] { "B8", "G8" };
	
	public static final String[] torresBlancas = new String[] { "A1", "H1" };
	public static final String[] torresNegras = new String[] { "A8", "H8" };
	
	public static final String[] alfilesBlancos = new String[] { "C1", "F1" };
	public static final String[] alfilesNegros = new String[] { "C8", "F8" };
}
