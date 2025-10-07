package ar.edu.unlp.oo1.ejercicio7_Figuras_Cuerpos;

public class Cuerpo3D {
	private double altura;
	private Figura CaraBasal;
	
	public Cuerpo3D() {}
	
	public Cuerpo3D(Figura caraBasal, double altura) {
		this.altura = altura;
		this.CaraBasal = caraBasal;
	}

	public double getAltura() {
		return this.altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public Figura getCaraBasal() {
		return this.CaraBasal;
	}

	public void setCaraBasal(Figura caraBasal) {
		CaraBasal = caraBasal;
	}
	
	public double getVolumen() {
		return this.CaraBasal.getArea() * this.altura;
	}
	
	public double getArea() {
		return (2 * this.CaraBasal.getArea() + (this.CaraBasal.getPerimetro() * this.altura));
	}
}
