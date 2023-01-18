package Pregunta1.v1;

public class Rectangulo extends FiguraAbstract{
	
	public Rectangulo(int x, int y) {
		//Hereda los Atributos de Figura Abstract
		super(x, y);
	}
	
	//Sobre escritura del método calcularArea
	@Override
	public int calcularArea() {
		return x*y;
	}
	
	//Sobreescritura de nombre del objeto
	@Override
	public String toString() {
		return "Es un rectangulo de "+ x +" y "+ y +" por lado";
	}
}
