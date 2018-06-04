package CheapDeal;

import java.util.*;
import java.util.stream.Collectors;

public class Ordenacion {
	 public Map<Integer,Tienda> Master;
	 public LinkedList<Oferta> OfertasCercanas;
	 int filtro;
	 
	 public Ordenacion(Map<Integer,Tienda> tiendas) {
		 Master = new HashMap<Integer, Tienda>(tiendas);
		 //ordenacion
		 Master.forEach((Integer,Tienda)->OfertasCercanas.addAll(Tienda.getOfertas().values()));
	 }
	 public LinkedList<Oferta> getOfertasCercanas() {
		 return OfertasCercanas;
	 }
	 
	 public LinkedList<Oferta> filtrarNombre(String nombre){
		 LinkedList<Oferta> OfertasporNombre;
		 OfertasporNombre = OfertasCercanas.stream()
				 .filter(Oferta->Oferta.getProducto().contains(nombre))
				 .collect(Collectors.toCollection(LinkedList::new));
		 
		 return OfertasporNombre;
	 }
	 public LinkedList<Oferta> filtrarCategoria(Categorias cat) {
		 LinkedList<Oferta> OfertasporCategoria;
		 OfertasporCategoria = OfertasCercanas.stream()
				 .filter(Oferta->Oferta.getCategoria().contains(cat))
				 .collect(Collectors.toCollection(LinkedList::new));

		 return OfertasporCategoria;
	 }
	 public LinkedList<Oferta> filtrarPrecio(double min, double max) {
		 LinkedList<Oferta> OfertasporPrecio;
		 OfertasporPrecio = OfertasCercanas.stream()
				 .filter(Oferta->Oferta.getDescuento() >= min && Oferta.getDescuento() <= max)
				 .collect(Collectors.toCollection(LinkedList::new));
		 return OfertasporPrecio;
	 }
}