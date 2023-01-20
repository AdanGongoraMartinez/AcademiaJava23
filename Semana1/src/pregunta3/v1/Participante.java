package pregunta3.v1;

public class Participante {
	//Atributo del participante
	private String nombre;
	
	//Variable de referencia que apunta a la interfaz de premio
	private Premio premio;
	
	//Constructor
	public Participante(String nombre) {
		this.nombre=nombre;
	}
	
	//Nombre del objeto sobreescrito en la memoria
	@Override
	public String toString() {
		return "Participante "+ nombre;
	}
	
	//método para mostrar el premio obtenido
	void celebrar() {
		System.out.print("Felicidades "+nombre+" ");
		premio.ganaste();
	}

	//método para obtener el nombre
	public String getNombre() {
		return nombre;
	}

	//método para asignar el nombre
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//método para obtener el premio
	public Premio getPremio() {
		return premio;
	}

	//método para asignar el premio
	public void setPremio(Premio premio) {
		this.premio = premio;
	}
	
}
