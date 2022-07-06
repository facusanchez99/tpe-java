package arbol;

import java.util.ArrayList;
import java.util.List;

import accion.AccionEjecutable;

public class Nodo implements Elemento{

	private Elemento padre;
	private Elemento dato;
	private char identificador;
	private Elemento derecha;
	private Elemento izquierda;

	public Nodo(Elemento padre, Elemento dato) {
		this.padre = padre;
		this.dato = dato;
		this.derecha = null;
		this.izquierda = null;
	}

	/**
	 * @return the dato
	 */
	public Elemento getDato() {
		return dato;
	}

	/**
	 * @param dato the dato to set
	 */
	public void setDato(Elemento dato) {
		this.dato = dato;
	}

	/**
	 * @return the derecha
	 */
	public Elemento getDerecha() {
		return derecha;
	}

	/**
	 * @param derecha the derecha to set
	 */
	public void setDerecha(Elemento derecha) {
		this.derecha = derecha;
	}

	/**
	 * @return the izquierda
	 */
	public Elemento getIzquierda() {
		return izquierda;
	}

	/**
	 * @param izquierda the izquierda to set
	 */
	public void setIzquierda(Elemento izquierda) {
		this.izquierda = izquierda;
	}


	/**
	 * @return the identificador
	 */
	public char getIdentificador() {
		return identificador;
	}

	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(char identificador) {
		this.identificador = identificador;
	}

	@Override
	public Elemento insertarIzquierda(Elemento dato) {
		if(this.getIzquierda() != null) {
			return null;
		}
		Nodo n = new Nodo(this.getDato(),dato);
		n.setIdentificador('I');
		this.setIzquierda(n);
		return n;
	}

	@Override
	public Elemento insertarDerecha(Elemento dato) {
		if(this.getDerecha() != null) {
			return null;
		}
		Nodo n = new Nodo(this.getDato(),dato);
		n.setIdentificador('D');
		this.setDerecha(n);
		return n;
	}

	@Override
	public List<Object> buscarElemento(AccionEjecutable accion) {
		List<Object> result = new ArrayList<Object>();
		result.add(this.getDato()+" "+this.getIdentificador());
		if(this.getIzquierda() != null) {
			result.addAll(this.getIzquierda().buscarElemento(accion));
		}
		if(this.getDerecha() != null) {
			result.addAll(this.getDerecha().buscarElemento(accion));
		}
		return result;
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		return 0;
	}

	
	@Override
	public String toString() {
		return "\nPadre: " + padre + ", Identificador: " + identificador + ", Dato: " + dato + ", Derecha= " + derecha  +" \nIzquierda= " + izquierda + "\n";
	}


}