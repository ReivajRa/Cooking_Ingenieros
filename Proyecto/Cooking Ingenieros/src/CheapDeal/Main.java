package CheapDeal;

import java.util.*;

import Interfaz.Login;



public class Main {
	public static Cliente clientes[] = new Cliente[10];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MAPA PARA ORDENACION DE OFERTAS
		HashSet<Categorias> cat = new HashSet<Categorias>();
		LinkedList<Oferta> OfertasCercanas= new LinkedList<Oferta>();
		Map<Integer,Tienda> tiendas = new HashMap<Integer, Tienda>();
		//2 cliente de prueba
		Cliente cliente1 = new Cliente("Juan","12345","juanito@gmail.com");
		Cliente cliente2 = new Cliente("Pepe","pepitoperez","pepeguapo@gmail.com");
		clientes[0] = cliente1;
		clientes[1] = cliente2;
		
		Login ventana = new Login();
		ventana.setVisible(true);
		
		//3 tiendas de prueba
		Tienda tienda1 = new Tienda("LaTiendaEnCasa", "Calle Ninja N� 13", "Roberto junior");
		Tienda tienda2 = new Tienda("El Corteingles","Calle Lolito Fernandez", "Silvia Charro");
		Tienda tienda3 = new Tienda("Ikea","Avenida El trabuco N� 4", "Luke Andador del cielo");
		tiendas.put(tienda1.getId_tienda(), tienda1);
		tiendas.put(tienda2.getId_tienda(), tienda2);
		tiendas.put(tienda3.getId_tienda(), tienda3);
		cat.add(Categorias.ELECTRODOMESTICOS);
		tienda1.anadirOferta("Termo mix", 40.00, 2999.00, 
				"Maquina de cocinar del siglo 22 increiblemente util, Doraemon approves", cat);
		cat.removeAll(cat);
		
		cat.add(Categorias.SONIDO);
		tienda2.anadirOferta("Auriculares SONY", 50.00, 60.00, 
				"Auriculares con sonido envolvente y maxima calidad", cat );
		cat.removeAll(cat);
		
		cat.add(Categorias.ROPA);
		tienda2.anadirOferta("Camiseta Nike", 25.00, 15.95, 
				"Camiseta marca Nike con tejido ultratranspirable y elasticidad maxima", cat );
		cat.removeAll(cat);
		
		cat.add(Categorias.MUEBLES);
		tienda3.anadirOferta("Mesa teka", 30.00, 599.00, 
				"Mesa de 8 personas con madera de pino moderna", cat );
		cat.removeAll(cat);
		
		cat.add(Categorias.MUEBLES);
		tienda3.anadirOferta("Sillon IkeaBasic", 30.00, 99.00, 
				"Sillon de interior de madera contrachapada de color negro", cat );
		cat.removeAll(cat);
		
		cat.add(Categorias.MUEBLES);
		tienda3.anadirOferta("Sofa de piel", 60.00, 2599.00, 
				"Sofa de color negro mate de 3 plazas y de maxima calidad", cat );
		cat.removeAll(cat);
		
		
		/*Ordenacion ord = new Ordenacion(tiendas);
 		OfertasCercanas = ord.getOfertasCercanas();
		for (Oferta of : OfertasCercanas) {
			of.toString();*/
		
	}

}











