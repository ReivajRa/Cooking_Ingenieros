package Interfaz;

import java.util.HashSet;

import CheapDeal.Categorias;
import CheapDeal.Cliente;
import CheapDeal.Oferta;
import CheapDeal.Tienda;

public class main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Categorias> cat = new HashSet<Categorias>();
		Cliente cliente1 = new Cliente("Juan","12345","juanito@gmail.com");
		Tienda tienda1 = new Tienda("LaTiendaEnCasa", "Calle Ninja N� 13", "Roberto junior", 34.1235, 75.00);

		cat.add(Categorias.MUEBLES);
		Oferta oferta = new Oferta("Mesa", 22.5, tienda1, 50, "Una mesa muy bonita", cat);
		oferta.aniadirOp(cliente1, "De puta pena", 7);
		
		
		
		OfertaVista obj = new OfertaVista(cliente1, oferta);
		obj.setVisible(true);

	}

}
