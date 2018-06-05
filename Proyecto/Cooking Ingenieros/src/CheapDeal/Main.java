package CheapDeal;

import java.util.*;

import Interfaz.Login;
import Interfaz.OfertaVista;


public class Main {
	public static Cliente clientes[] = new Cliente[2];
	//public static Ordenacion ords[] = new Ordenacion[2];
	public static Map<Integer,Tienda> tiendas = new HashMap<Integer, Tienda>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MAPA PARA ORDENACION DE OFERTAS
		HashSet<Categorias> cat = new HashSet<Categorias>();
		//LinkedList<Oferta> OfertasCercanas= new LinkedList<Oferta>();
		//2 cliente de prueba
		Cliente cliente1 = new Cliente("Juan","12345","juanito@gmail.com");
		Cliente cliente2 = new Cliente("Pepe","1234567","pepeguapo@gmail.com");
		clientes[0] = cliente1;
		clientes[1] = cliente2;
		clientes[0].actualizarUbicacion();
		clientes[1].actualizarUbicacion();
		
		
		
		//3 tiendas de prueba
		Tienda tienda1 = new Tienda("LaTiendaEnCasa", "Calle Ninja N� 13", "Roberto junior", 34.1235, 75.00);
		Tienda tienda2 = new Tienda("El Corteingles","Calle Lolito Fernandez", "Silvia Charro", 50.0, 50.0);
		Tienda tienda3 = new Tienda("Ikea","Avenida El trabuco N� 4", "Luke Andador del cielo", 0.00, 0.00);
		tiendas.put(tienda1.getId_tienda(), tienda1);
		tiendas.put(tienda2.getId_tienda(), tienda2);
		tiendas.put(tienda3.getId_tienda(), tienda3);
		cat.add(Categorias.ELECTRODOMESTICOS);
		tienda1.anadirOferta("Termo mix", 1800.00, 2999.00, 
				"Maquina de cocinar del siglo 22 increiblemente util, Doraemon approves", cat);
		cat.removeAll(cat);
		
		cat.add(Categorias.SONIDO);
		tienda2.anadirOferta("Auriculares SONY", 30.00, 60.00, 
				"Auriculares con sonido envolvente y maxima calidad", cat );
		cat.removeAll(cat);
		
		cat.add(Categorias.ROPA);
		tienda2.anadirOferta("Camiseta Nike", 12.00, 15.95, 
				"Camiseta marca Nike con tejido ultratranspirable y elasticidad maxima", cat );
		cat.removeAll(cat);
		
		cat.add(Categorias.MUEBLES);
		tienda3.anadirOferta("Mesa teka", 420.00, 599.00, 
				"Mesa de 8 personas con madera de pino moderna", cat );
		cat.removeAll(cat);
		
		cat.add(Categorias.MUEBLES);
		tienda3.anadirOferta("Sillon IkeaBasic", 69.30, 99.00, 
				"Sillon de interior de madera contrachapada de color negro", cat );
		cat.removeAll(cat);
		
		cat.add(Categorias.MUEBLES);
		tienda3.anadirOferta("Sofa de piel", 1040.00, 2599.00, 
				"Sofa de color negro mate de 3 plazas y de maxima calidad", cat );
		cat.removeAll(cat);
		
		
		cat.add(Categorias.MUEBLES);
		Oferta oferta = new Oferta("Mesa", 22.5, tienda1, 50, "Una mesa muy bonita", cat);
		oferta.aniadirOp(cliente1, "De puta pena", 7);
		
		  //Ordenacion ord = new Ordenacion();
 		  //OfertasCercanas = ord.getMaster();
		
		
		
		/*Ordenacion ord0 = new Ordenacion(tiendas, clientes[0].getPosY(), clientes[0].getPosX());
		Ordenacion ord1 = new Ordenacion(tiendas, clientes[1].getPosY(), clientes[1].getPosX());
		ords[0] = ord0;
		ords[1] = ord1;
		
		
		
		
		
		//clientes[selec].actualizarUbicacion();
		Ordenacion ord = new Ordenacion(tiendas, clientes[0].getPosY(), clientes[0].getPosX());
 		OfertasCercanas = ord.getOfertasCercanas();
		for (Oferta of : OfertasCercanas) {
			System.out.println(of.toString());
		}
		
		System.out.println("\n \n \n \n \n ");
		
		
		LinkedList<Oferta> OfertasCercanas2 = new LinkedList<Oferta>();
		Ordenacion ord2 = new Ordenacion(tiendas, clientes[1].getPosY(), clientes[1].getPosX());
		OfertasCercanas2 = ord2.getOfertasCercanas();
		for (Oferta of : OfertasCercanas2) {
			System.out.println(of.toString());
		}
		
		System.out.println("\n \n \n \n \n ");
		
		
		LinkedList<Oferta> OfertasCercanas3 = new LinkedList<Oferta>();
		//Ordenacion ord2 = new Ordenacion(tiendas, clientes[0].getPosY(), clientes[0].getPosX());
 		OfertasCercanas3 = ords[0].getOfertasCercanas();
		for (Oferta of : OfertasCercanas3) {
			System.out.println(of.toString());
		}
		
		System.out.println("\n \n \n \n \n ");
		
		
		LinkedList<Oferta> OfertasCercanas4 = new LinkedList<Oferta>();
		//Ordenacion ord2 = new Ordenacion(tiendas, clientes[0].getPosY(), clientes[0].getPosX());
 		OfertasCercanas4 = ords[1].getOfertasCercanas();
		for (Oferta of : OfertasCercanas4) {
			System.out.println(of.toString());
		}*/
		
		
		
		
		Login obj = new Login();
		obj.setVisible(true);
		
	}

}











