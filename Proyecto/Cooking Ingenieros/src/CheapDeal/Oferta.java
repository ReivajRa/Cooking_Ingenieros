package CheapDeal;
import java.awt.Image;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class Oferta {
	private static int id = 1;
	private int id_oferta;
	private String producto;
	private double descuento;
	private double precio;
	private double puntuacion;
	private Tienda tienda;
	private String descripcion;
	private Image foto;
	private Image codigoQR;
	private HashSet<Categorias> categoria;
	private Map<Integer, Opinion> opiniones;
	public Oferta(String p, double d, Tienda t, double pr, String des, HashSet<Categorias> cat)
	{
		this.id_oferta= id;
		this.producto = p.toUpperCase();
		this.descuento = d;
		this.tienda = t;
		this.precio = pr;
		foto = null;
		this.descripcion = des;
		codigoQR = null;
		categoria = new HashSet<Categorias>(cat);
		opiniones = new TreeMap<Integer, Opinion>();
		id++;
		
	}

	public int getId_oferta() {
		return this.id_oferta;
	}

	public String getProducto() {
		return this.producto;
	}
	
	public double getDescuento() {
		return this.descuento;
	}
	
	public double getPrecio() {
		return this.precio;
	}

	public double getPuntuacion() {
		return puntuacion/opiniones.size();
	}

	public Tienda getTienda() {
		return tienda;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public Image getFoto() {
		return this.foto;
	}	
	
	public Image getCodigoQR() {
		return codigoQR;
	}
	
	public HashSet<Categorias> getCategoria() {
		return categoria;
	}
	
	public Map<Integer, Opinion> getOpiniones() {
		return opiniones;
	}
	
	public void setProducto(String producto) {
		this.producto = producto;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setFoto(Image foto) {
		this.foto = foto;
	}

	public void setCodigoQR(Image codigoQR) {
		this.codigoQR = codigoQR;
	}
	
	public void setCategoria(HashSet<Categorias> cat) {
		categoria = cat;
	}
	
	public void setOpiniones(Map<Integer, Opinion> opiniones) {
		this.opiniones = opiniones;
	}
	
	public String mostrarCategorias() {
		StringBuilder aux = new StringBuilder();
		aux.append("Categorias: ");
		for(Categorias o: categoria) {
			aux.append(o.name()+", ");
		}
		return aux.toString();
	}
	
	public void aniadirCat(Categorias cat) {
		categoria.add(cat);
	}
	
	public void quitarCat(Categorias cat) {
		categoria.remove(cat);
	}
	
	public int aniadirOp(Cliente usu, String msj, int punt) {
		Opinion op = new Opinion(usu, msj, punt, this, this.getTienda());
		if(!(opiniones.containsKey(op.getUsuario().getId()))) {
			puntuacion += op.getPuntuacion();
			opiniones.put(op.getUsuario().getId(), op);
		}
		return op.getId();
	}
	
	public void eliminarOp(Integer id) {
		puntuacion -= opiniones.get(id).getPuntuacion();
		opiniones.remove(id);
	}

	public void mostrarOpiniones() {
		Set<Map.Entry<Integer, Opinion>> set = opiniones.entrySet();
		for(Map.Entry<Integer, Opinion> o: set) {
			System.out.println("Id_Opinion: " + o.getKey() + ". Opinion: " + o.getValue().toString() + ".");
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(precio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
		result = prime * result + ((tienda == null) ? 0 : tienda.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Oferta other = (Oferta) obj;
		if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		if (tienda == null) {
			if (other.tienda != null)
				return false;
		} else if (!tienda.equals(other.tienda))
			return false;
		return true;
	}

	public String toString() {
		String aux = "ID oferta: " + id_oferta + ". Producto: " + producto + ". Precio: " + precio
		+ ". Descuento: " + descuento + ". Descripción: " + descripcion + ". Categorias: " + mostrarCategorias() + ".";
		if(codigoQR!= null) {
			aux += "CodigoQR: " + codigoQR + ".";
		}
		if(foto != null) {
			aux +="Foto: " + foto+ ".";
		}
		return aux;
	}
}
