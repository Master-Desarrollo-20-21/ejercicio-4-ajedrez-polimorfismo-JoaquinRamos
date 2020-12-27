package chess;

public enum LetraColumna{
	A(0),
	B(1),
	C(2),
	D(3),
	E(4),
	F(5),
	G(6),
	H(7);

    private int clave;

    LetraColumna(int i) {
        this.clave = i;
    }

    public static LetraColumna obtenerObjetoLetra(int numero) {
        for (LetraColumna letra : LetraColumna.values()) {
            if (letra.clave == numero) {
                return letra;
            }
        }
        return null;
    }
 
    public static String obtenerLetra(int numero) {
        for (LetraColumna letra : LetraColumna.values()) {
            if (letra.clave == numero) {
                return letra.name();
            }
        }
        return "";
    }
    
    public static int obtenerNumero(String letra) {
        for (LetraColumna l : LetraColumna.values()) {
            if (l.getValor().equalsIgnoreCase(letra)) {
                return l.clave;
            }
        }
        return 0;
    }
    
	public static String getTodosNumerosDeFilaValidos() {
		String result = "";
		for(LetraColumna l : LetraColumna.values()) {
			result += l.getClave()+1;
		}
		return result;
	}
	
	public static String getTodasLetrasValidas() {
		String result = "";
		for(LetraColumna l : LetraColumna.values()) {
			result += l.getValor();
		}
		return result;
	}	

    public int getClave() {
        return this.clave;
    }
    
    public String getValor() {
        return this.toString();
    }
}