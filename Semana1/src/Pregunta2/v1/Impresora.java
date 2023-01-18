package Pregunta2.v1;

//Esta clase es el Singleton
public class Impresora {
	
	//Atributos de clase para regular el número de instancias
	static private Impresora impresora;
	static int contador;
	
	private String nombre;
	
	//Constructor que permite conocer el número de instancias creadas
	private Impresora(String nombre) {
		this.nombre=nombre;
		contador++;
	}
	
	//Método que controla la creación de objetos de la clase impresora
	static public Impresora getInstance() {
		//Si impresora no apunta a un objeto, se crea una instancia de Impresora
		if (impresora==null)
			impresora = new Impresora("HP0001");
		
		//Si impresora 
		return impresora;
	}
}
