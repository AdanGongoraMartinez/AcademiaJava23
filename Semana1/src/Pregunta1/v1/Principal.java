package Pregunta1.v1;

import java.util.ArrayList;

//Algoritmo en el que implemento clases abstractas e interfaces para explicar el polimorfismo

public class Principal {

	public static void main(String[] args) {
		
		//Creación de una lista para almacenar las figuras
		ArrayList<Figura> lista = new ArrayList<>();
		
		//Añado instancias de rectangulo y triangulo a la lista
		lista.add(new Rectangulo(2,4));
		lista.add(new Triangulo(2,4));
		
		show(lista);
		
	}
	
	
	//Cíclo que permite mostrar el nombre de los objetos y ejecutar el método calcularArea()
	static void show(ArrayList<Figura> lista) {
		for(int i=0; i<lista.size(); i++) {
			
			//Variable de referencia que apunta a los objetos de la lista
			Figura fig = lista.get(i);
			
			//Imprime el nombre del objeto
			System.out.println(fig);
			
			//Como este método se encuentra en la clase padre "Figura" se puede heredar a sus
			//clases hijas, y ellas pueden ejecutar su propia versión del método
			//para hacer distintos cálculos
			System.out.println(fig.calcularArea());
		}
	}
	

}
