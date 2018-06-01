package CheapDeal;

import java.util.*;

public class Ordenacion {
	 public Map<Integer,Tienda> Master;
	 int filtro;
	 public LinkedList OfertasCercanas;
	 
	 public Ordenacion(double X, double Y, Map<Integer,Tienda> tiendas, int filtro) {
		 Master = new HashMap<Integer, Tienda>(tiendas);
		 //ordenacion
		 Master.forEach((k,v)->OfertasCercanas.add(v.getOfertas().values()));
	 }
}