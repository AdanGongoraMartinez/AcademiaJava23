package Pregunta1.v1;

public class Triangulo extends FiguraAbstract{
	
	public Triangulo(int x, int y) {
		//Hereda los Atributos de Figura Abstract
		super(x,y);
	}
	
	//Sobreescritura del método calcularArea
	@Override
	public int calcularArea() {
		return (getx()*gety())/2;
	}
	
	//Sobreescritura de nombre del objeto
	@Override
	public String toString() {
		return "Es un triangulo de "+ getx() +" de base y "+ gety() +" de altura";
	}
}
