package pregunta3.v1;

public class Principal {

	public static void main(String[] args) {
		
		//Creación del primer participante
		Participante participante1 = new Participante("Carlos");
		//Asignación aleatoria del premio
		Inyector.inyectarPremio(participante1);
		//Muestra el premio obtenido
		participante1.celebrar();
		
		//Creación del primer participante
		Participante participante2 = new Participante("Ricardo");
		//Asignación aleatoria del premio
		Inyector.inyectarPremio(participante2);	
		//Muestra el premio obtenido
		participante2.celebrar();
		
		
	}

}
