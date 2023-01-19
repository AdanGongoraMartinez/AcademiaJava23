package Pregunta1.v1;

public abstract class FiguraAbstract implements Figura{

		//Atributos
		private int x=0, y=0;
		
		public FiguraAbstract(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		//Como esta clase hereda el metodo abstracto calcularArea, las clases hijas tambien lo heredan
		//como el mpetodo es abstracto no hace falta declararlo en esta clase
		
		//Método para poder obtener el valor de x
		public int getx() {
			return x;
		}
		
		//Método para poder asignarle un valor a x
		public void setx(int x) {
			this.x=x;
		}
		
		////Método para poder obtener el valor de y
		public int gety() {
			return y;
		}
		
		//Método para poder asignarle un valor a y
		public void sety(int y) {
			this.y=y;
		}
}
