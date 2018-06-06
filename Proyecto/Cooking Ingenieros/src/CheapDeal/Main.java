package CheapDeal;

import java.util.*;

import Interfaz.Login;
import Interfaz.OfertaVista;


public class Main {
	public static Cliente clientes[] = new Cliente[10];
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
		Cliente cliente4 = new Cliente("JeffBezos","1234567","pepeguapo@gmail.com");
		Cliente cliente5 = new Cliente("Mr. Googler","12345","juanito@gmail.com");
		Cliente cliente6 = new Cliente("Rosa","1234567","pepeguapo@gmail.com");
		Cliente cliente7 = new Cliente("Manu","12345","juanito@gmail.com");
		Cliente cliente8 = new Cliente("John","1234567","pepeguapo@gmail.com");
		clientes[0] = cliente1;
		clientes[1] = cliente2;
		clientes[2] = cliente4;
		clientes[3] = cliente5;
		clientes[4] = cliente6;
		clientes[5] = cliente7;
		clientes[6] = cliente8;
		clientes[0].actualizarUbicacion();
		clientes[1].actualizarUbicacion();
		
		
		
		//3 tiendas de prueba
		Tienda tienda1 = new Tienda("LaTiendaEnCasa", "Calle Ninja N� 13", "Roberto junior", 34.1235, 75.00);
		Tienda tienda2 = new Tienda("El Corteingles","Calle Lolito Fernandez", "Silvia Charro", 50.0, 50.0);
		Tienda tienda3 = new Tienda("Ikea","Avenida El trabuco N� 4", "Luke Andador del cielo", 0.00, 0.00);
		Tienda tienda4 = new Tienda("SpaceX","Camino Buzz Lightyear 7", "Francis Cano", 10.00, 10.00);
		Tienda tienda5 = new Tienda("El Rancho Tecnologico","Calle Rancho Fracaxo 15", "Pinchecu Liao", 20.00, 25.00);
		Tienda tienda6 = new Tienda("Fruteria Pera", "Calle Parque Jurasico 3", "Adolfo Llarte", 60.0, 40.0);
		tiendas.put(tienda1.getId_tienda(), tienda1);
		tiendas.put(tienda2.getId_tienda(), tienda2);
		tiendas.put(tienda3.getId_tienda(), tienda3);
		tiendas.put(tienda4.getId_tienda(), tienda4);
		tiendas.put(tienda5.getId_tienda(), tienda5);
		tiendas.put(tienda6.getId_tienda(), tienda6);
		
		
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
		
		
		/*cat.add(Categorias.MUEBLES);
		Oferta oferta = new Oferta("Mesa", 22.5, tienda1, 50, "Una mesa muy bonita", cat);
		oferta.aniadirOp(cliente1, "De puta pena", 7);
		cat.removeAll(cat);*/
		//Se pierde?
		
		int aux;

	    cat.add(Categorias.TRANSPORTE);
	    tienda4.anadirOferta("Queroseno", 80.00, 150.00,
	        "Queroseno para tu proximo viaje de alta calidad y gran combustion", cat);
	    cat.removeAll(cat);

	    cat.add(Categorias.TRANSPORTE);
	    aux = tienda4.anadirOferta("Falcon 9", 18900.00, 24900.00,
		        "Cohete precioso y con caida precisa", cat);
	    cat.removeAll(cat);
	    tienda4.getOfertas().get(aux).aniadirOp(cliente4, "Bro queria ver a mi primo el Buzz Lightyear y esa mierda no despego", 2);
	    

	    cat.add(Categorias.MOVIL);
	    tienda5.anadirOferta("Google Pixel 3 XL", 899.00, 959.00,
	        "Google Pixel 3 XL 64GB ROM, 6GB RAM, Snapdragon 850, 2K, Notch, Minecraft estable a 30fps", cat);
	    cat.removeAll(cat);

	    
	    
	    cat.add(Categorias.SONIDO);
	    aux = tienda5.anadirOferta("Pixel EarBuds", 99.00, 159.00, "Ahora con Google Assitant en espa�ol", cat);
	    tienda5.getOfertas().get(aux).aniadirOp(cliente5, "Pegan un parrao de la hostia", 10);
	    tienda5.getOfertas().get(aux).aniadirOp(cliente6, "No funciona muy bien y tiene muchos bugs", 2);
	    cat.removeAll(cat);

	    cat.add(Categorias.ILUMINACION);
	    aux = tienda5.anadirOferta("Bombillas Felipes IOT", 19.00, 25.00, "Ilumina tu chabola con tu voz", cat);
	    tienda5.getOfertas().get(aux).aniadirOp(cliente6, "Me he quedado muda con ese cachibache y no funca",4);
	    cat.removeAll(cat);

	    cat.add(Categorias.OCIO);
	    aux = tienda5.anadirOferta("Vape Smok G Priv", 119.00, 149.00, "Vapea hasta la enfermedad", cat);
	    tienda5.getOfertas().get(aux).aniadirOp(cliente7, "Vapeando en mi Falcon 9 no vi un asteroide y casi muero", 8);
	    cat.removeAll(cat);

	    cat.add(Categorias.FRUTA);
	    tienda6.anadirOferta("Tomacco", 1.00, 2.00,
	        "Tomacco identico al de los viejos tiempos cultivados por Da Homa", cat);
	    cat.removeAll(cat);

	    cat.add(Categorias.FRUTA);
	    aux = tienda6.anadirOferta("Pepinos de Africa", 2.00, 3.00, "Tama�o extralargo", cat);
	    tienda6.getOfertas().get(aux).aniadirOp(cliente8, "Impresionante no pensaba que fuesen tan grandes de verdad", 7);
	    cat.removeAll(cat);
		
		
		
		
		
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











