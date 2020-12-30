package chess;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Casilla {
	private int x;
	private int y;
	private String letraY;
	private Pieza pieza;
	
	public Casilla(int x, int y) {
		this.x = x;
		this.y = y;
		this.setLetraY(LetraColumna.obtenerLetra(x));
	}
	
	public void colocarPieza(String tipo, String color){
		try {
			Constructor<?> constr = Class.forName(tipo).getConstructor(String.class);
			pieza = (Pieza) constr.newInstance(color) ;
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}	
	}
	

	public String toString(){
		//System.out.println("x=" + x + " e y=" + y + "  y el MOD="+ ((x+y) % 2) );
		if (pieza == null) {
			if (((x+y) % 2) == 0 )
				return " " + new String(Character.toChars(9866)) + " ";//new String(Character.toChars(32));
			else
				return " " + new String(Character.toChars(9867)) + " ";
		}	
		else {
			
			return " " + pieza.getSimbolo() + " ";
		}
	}

	
	public String getLetraY() {
		return letraY;
	}

	public void setLetraY(String letraY) {
		this.letraY = letraY;
	}

	public Pieza getPieza() {
		return pieza;
	}

	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}


}
