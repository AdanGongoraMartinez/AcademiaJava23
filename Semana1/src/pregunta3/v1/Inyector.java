package pregunta3.v1;

public class Inyector {
	
	//variable de clase que permite seleccionar un premio al azar
	public static int random;
	
	//variables de referencia y objetos que representan los premios
	static Premio cel = new PremioCel();
	static Premio despensa = new PremioDespensa();
	static Premio auto = new PremioAuto();
	
	//método para elegir un premio aleatoriamente
	static void inyectarPremio(Participante par) {
		//asignar un valor aleatorio a random
		random = (int)(Math.random()*10);
		
		//Asignar el premio al participante
		if(random<6) {
			if(random <3)
				par.setPremio(auto);
			else
				par.setPremio(cel);
		}
		else
			par.setPremio(despensa);
	}
}
