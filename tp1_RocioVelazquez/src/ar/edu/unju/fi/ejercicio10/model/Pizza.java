package ar.edu.unju.fi.ejercicio10.model;

public class Pizza {
	private int diametro;
	private Float precio;
	private Double area;
	private boolean ingredientesEsp;
	private final int ADICIONAL_20 = 500;
	private final int ADICIONAL_30= 750;
	private final int ADICIONAL_40=1000;
	
	//CONSTRUCTORES
	public Pizza() {
		// TODO Auto-generated constructor stub
	}
	
	//METODOS
	
	public void mostrarDatos() {
		System.out.println("Diametro = "+ diametro);
		System.out.println("Ingredientes especiales = "+ ingredientesEsp);
		System.out.println("Precio Pizza = "+ precio+"$");
		System.out.println("Area de la pizza = "+ area);
	}
	
	public void calcularArea() {
		this.area = Math.PI * Math.pow((this.diametro/2.0), 2.0); 
	}
	
	public void calcularPrecio() {
		
		if(this.diametro == 20 && this.ingredientesEsp == false) {
			this.precio=4500f;
		}else if (this.diametro == 20 && this.ingredientesEsp == true){
			this.precio=4500f + ADICIONAL_20;	
		}else if (this.diametro == 30 && this.ingredientesEsp == false) {
			this.precio=4800f;
		}else if (this.diametro == 30 && this.ingredientesEsp == true) {
			this.precio=4800f+ ADICIONAL_30;
		}else if (this.diametro == 40 && this.ingredientesEsp == false) {
			this.precio=5500f;
		}else if (this.diametro == 40 && this.ingredientesEsp == true) {
			this.precio=5500f+ ADICIONAL_40;
		}
	}
	
	
	//METODOS ACCESORES
	
	public int getDiametro() {
		return diametro;
	}
	public void setDiametro(int diametro) {
		this.diametro = diametro;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public Double getArea() {
		return area;
	}
	public void setArea(Double area) {
		this.area = area;
	}
	public boolean isIngredientesEsp() {
		return ingredientesEsp;
	}
	public void setIngredientesEsp(boolean ingredientesEsp) {
		this.ingredientesEsp = ingredientesEsp;
	}

	public int getADICIONAL_20() {
		return ADICIONAL_20;
	}

	public int getADICIONAL_30() {
		return ADICIONAL_30;
	}

	public int getADICIONAL_40() {
		return ADICIONAL_40;
	}
	
	
	
}
