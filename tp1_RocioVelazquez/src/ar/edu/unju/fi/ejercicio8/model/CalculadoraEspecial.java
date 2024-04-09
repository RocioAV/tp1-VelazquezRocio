package ar.edu.unju.fi.ejercicio8.model;

public class CalculadoraEspecial {
	private int n;

	//CONSTRUCTORES
	public CalculadoraEspecial() {
		// TODO Auto-generated constructor stub
	}
	
	//METODOS
	public int calcularSumatoria() {
		int r=0;
		for (int i = 1; i <=this.n ; i++) {
			r += Math.pow((i * (i + 1)) / 2, 2);
		}
		
		return r;
	}
	
	public int calcularProductoria() {
		int r=1;
		
		for (int i = 1; i <=this.n ; i++) {
			r *= (i * (i + 4));
		}
		
		return r;
	}
	
	
	
	//METODOS ACCESORES
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	
}
