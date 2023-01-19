package Pregunta2.v1;

public class Principal {

	public static void main(String[] args) {
		
		//Aqui creé variables de referencia que apunten a una sola instancia de la impresora
		Impresora imp = Impresora.getInstance();
		
		Impresora imp1 = Impresora.getInstance();
		Impresora imp2 = Impresora.getInstance();
		Impresora imp3 = Impresora.getInstance();
		Impresora imp4 = Impresora.getInstance();
		
		//Mi intneción aqui es comprobar que la variable apunte a la instancia de la impresora
		//por lo que imp4 podría haber sido cualquier otra variable de referencia
		System.out.println(imp4);
		
		//Este contador me permite validar que solo se halla creado una instancia de impresora
		System.out.println(Impresora.getContador()); //1

	}

}
