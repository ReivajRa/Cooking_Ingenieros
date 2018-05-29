<<<<<<< HEAD:Proyecto/Cooking Ingenieros/src/Main.java
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
=======
package CheapDeal;

import java.util.HashSet;
>>>>>>> a07e99b2e23b74c7d2f61b6143b077515bae9af1:Proyecto/Cooking Ingenieros/src/CheapDeal/Main.java

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MAPA PARA ORDENACION DE OFERTAS
		Map<Integer,HashSet<Oferta>> OfertasCercanas = new HashMap<Integer, HashSet<Oferta>>();
		//2 cliente de prueba
		Cliente cliente1 = new Cliente("Juan","12345","juanito@gmail.com");
		Cliente cliente2 = new Cliente("Pepe","pepitoperez","pepeguapo@gmail.com");
		//3 tiendas de prueba
		HashSet<Categorias> cat = new HashSet<Categorias>();
		Tienda tienda1 = new Tienda("LaTiendaEnCasa", "Calle Ninja N� 13", "Roberto junior");
		Tienda tienda2 = new Tienda("El Corteingles","Calle Lolito Fernandez", "Silvia Charro");
		Tienda tienda3 = new Tienda("Ikea","Avenida El trabuco N� 4", "Luke Andador del cielo");
		
		cat.add(Categorias.ELECTRODOMESTICOS);
		tienda1.anadirOferta("Termo mix", 40.00, 2999.00, 
				"Maquina de cocinar del siglo 22 increiblemente util, Doraemon approves", cat);
		cat.removeAll(cat);
		
		tienda2.anadirOferta("Auriculares SONY", 50.00, 60.00, 
				"Auriculares con sonido envolvente y maxima calidad", Categorias.SONIDO );
		tienda2.anadirOferta("Camiseta Nike", 25.00, 15.95, 
				"Camiseta marca Nike con tejido ultratranspirable y elasticidad maxima", Categorias.ROPA );
		tienda3.anadirOferta("Mesa teka", 30.00, 599.00, 
				"Mesa de 8 personas con madera de pino moderna", Categorias.MUEBLES );
		tienda3.anadirOferta("Sillon IkeaBasic", 30.00, 99.00, 
				"Sillon de interior de madera contrachapada de color negro", Categorias.MUEBLES );
		tienda3.anadirOferta("Sofa de piel", 60.00, 2599.00, 
				"Sofa de color negro mate de 3 plazas y de maxima calidad", Categorias.MUEBLES );
		System.out.println();
		System.out.println();
		
		
	}

}
