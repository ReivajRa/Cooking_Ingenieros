package CheapDeal;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ordenacion {
	 private Map<Integer,Tienda> Master;
	 private LinkedList<Oferta> OfertasCercanas;
	 int filtro;
	 double posX, posY;
	 private LinkedList<Tienda> TiendasCercanas;
	 
	 public Ordenacion(Map<Integer,Tienda> tiendas, double posY, double posX) {
		 Master = new HashMap<Integer, Tienda>(tiendas);
		 OfertasCercanas = new LinkedList<Oferta>();
		 this.posX = posX;
		 this.posY = posY;
		 TiendasCercanas = new LinkedList<Tienda>(Master.values());
		 TiendasCercanas = TiendasCercanas.stream().map(new Function<Tienda, Tienda>() {
             public Tienda apply(Tienda t) {
            	t.actualizarDistancia(posY, posX);
                return t;
             }}).collect(Collectors.toCollection(LinkedList::new));
		 TiendasCercanas.sort(null);
		 
		 TiendasCercanas.stream().forEach(Tienda->OfertasCercanas.addAll(Tienda.getOfertas().values()));
	 }
	 
	 public LinkedList<Oferta> getOfertasCercanas() {
		 return OfertasCercanas;
	 }
	 
	 public LinkedList<Tienda> getTiendasCercanas() {
		 return TiendasCercanas;
	 }
	 
	 public LinkedList<Oferta> filtrarNombre(LinkedList<Oferta> lista, String nombre){
		 LinkedList<Oferta> OfertasporNombre;
		 OfertasporNombre = lista.stream()
				 .filter(Oferta->Oferta.getProducto().contains(nombre))
				 .collect(Collectors.toCollection(LinkedList::new));
		 
		 return OfertasporNombre;
	 }
	 public LinkedList<Oferta> filtrarCategoria(LinkedList<Oferta> lista, Categorias cat) {
		 LinkedList<Oferta> OfertasporCategoria;
		 OfertasporCategoria = lista.stream()
				 .filter(Oferta->Oferta.getCategoria().contains(cat))
				 .collect(Collectors.toCollection(LinkedList::new));

		 return OfertasporCategoria;
	 }
	 public LinkedList<Oferta> filtrarPrecio(LinkedList<Oferta> lista, double min, double max) {
		 LinkedList<Oferta> OfertasporPrecio;
		 OfertasporPrecio = lista.stream()
				 .filter(Oferta->Oferta.getDescuento() >= min && Oferta.getDescuento() <= max)
				 .collect(Collectors.toCollection(LinkedList::new));
		 return OfertasporPrecio;
	 }
	 
	 public LinkedList<Oferta> filtrarPuntuacion(LinkedList<Oferta> lista, double min) {
		 LinkedList<Oferta> OfertasporPrecio;
		 OfertasporPrecio = lista.stream()
				 .filter(Oferta->Oferta.getPuntuacion() >= min)
				 .collect(Collectors.toCollection(LinkedList::new));
		 return OfertasporPrecio;
	 }
	 
	 
	 
	 
	 public LinkedList<Tienda> filtrarTienda(String nombre) {
		 LinkedList<Tienda> TiendasPorNombre;
		 TiendasPorNombre = TiendasCercanas.stream()
				 .filter(Tienda->Tienda.getNombre().contains(nombre))
				 .collect(Collectors.toCollection(LinkedList::new));
		 return TiendasPorNombre;
	 }
}