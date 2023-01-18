package Pregunta1.v1;

public abstract class FiguraAbstract implements Figura{

		//Atributos
		int x=0, y=0;
		
		public FiguraAbstract(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		//Como esta clase hereda el metodo abstracto calcularArea, las clases hijas tambien lo heredan
		//como el mpetodo es abstracto no hace falta declararlo en esta clase
	
}
