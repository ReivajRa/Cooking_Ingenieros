package CheapDeal;
import java.awt.Image;
import java.util.HashSet;
import java.util.LinkedList;


public class Oferta {
	
	private int id_oferta;
	private String producto;
	private double descuento;
	private double precio;
	private Image foto;
	private String descripcion;
	private Image codigoQR;
	Categorias categoria;
	HashSet<Opinion> opiniones;
	private Tienda tienda;
	
	public Oferta(String p, double d, Tienda t, double pr, String des, Categorias cat)
	{
		this.id_oferta= (int)Math.random();
		this.producto = p;
		this.descuento = d;
		this.tienda = t;
		this.precio = pr;
		foto = null;
		this.descripcion = des;
		codigoQR = null;
		categoria = cat;
		opiniones = new HashSet<Opinion>();
		
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
	
	public Tienda getTienda() {
		return tienda;
	}

	public double getPrecio() {
		return this.precio;
	}

	public Image getFoto() {
		return this.foto;
	}	
	
	public Image getCodigoQR() {
		return codigoQR;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public Categorias getCategoria() {
		return this.categoria;
	}
	
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setFoto(Image foto) {
		this.foto = foto;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setCodigoQR(Image codigoQR) {
		this.codigoQR = codigoQR;
	}

	public void setCategoria(Categorias cat) {
		this.categoria = cat;
	}
	
	/*public void aniadirCat(String cat) {
		categoria
	}
	
	public void quitarCat(String cat) {
		categoria.quitarCat(cat);
	}*/
	
	public String toString() {
		String aux = "ID oferta: " + id_oferta + ". Producto: " + producto + ". Precio: " + precio
		+ ". Descuento: " + descuento + ". Descripción: " + descripcion + ". Categorias: " + categoria + ".";
		if(codigoQR!= null) {
			aux += "CodigoQR: " + codigoQR + ".";
		}
		if(foto != null) {
			aux +="Foto: " + foto+ ".";
		}
		return aux;
	}
	
	public void mostrarOpiniones() {
		for(Opinion o: opiniones) {
			System.out.println(o.toString());
		}
	}
	
	public HashSet<Opinion> getOpiniones() {
		return opiniones;
	}

	public void setOpiniones(HashSet<Opinion> opiniones) {
		this.opiniones = opiniones;
	}
	
	public void aniadirOp(Opinion op) {
		opiniones.add(op);
	}
	
	public void eliminarOp(Opinion op) {
		opiniones.remove(op);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_oferta;
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
		if (id_oferta != other.id_oferta)
			return false;
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

}
