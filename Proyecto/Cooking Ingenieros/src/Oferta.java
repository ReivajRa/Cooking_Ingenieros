import java.awt.Image;


public class Oferta {
	
	private int id_oferta;
	private String producto;
	private double descuento;
	private int tienda;
	private double precio;
	private Image foto;
	private String descripcion;
	private int codigoQR;
	Categorias categoria;
	
	public Oferta(String p, double d, int t, double pr, String des, Categorias cat)
	{
		this.id_oferta= (int)Math.random();
		this.producto = p;
		this.descuento = d;
		this.tienda = t;
		this.precio = pr;
		foto = null;
		this.descripcion = des;
		codigoQR = (Integer) null;
		categoria = cat;
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
	
	public int getTienda() {
		return this.tienda;
	}

	public double getPrecio() {
		return this.precio;
	}

	public Image getFoto() {
		return this.foto;
	}	
	
	public int getCodigoQR() {
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

	public void setCodigoQR(int codigoQR) {
		this.codigoQR = codigoQR;
	}

	/*public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}
	
	public void aniadirCat(String cat) {
		categoria.aniadirCat(cat);
	}
	
	public void quitarCat(String cat) {
		categoria.quitarCat(cat);
	}*/

	
	
	public boolean equals(Oferta obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Oferta other = (Oferta) obj;
		if (Double.doubleToLongBits(descuento) != Double.doubleToLongBits(other.descuento))
			return false;
		if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		if (tienda != other.tienda)
			return false;
		return true;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(descuento);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(precio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
		result = prime * result + tienda;
		return result;
	}
	
	public String verOferta()
	{
		System.out.println("Id: "+this.getId_oferta()+"; Producto: "+this.getProducto()
		+"; Descuento: "+this.getDescuento()+"; Tienda: "+this.getTienda()
		+"; Precio: "+this.getPrecio()+"; Foto: "+this.getFoto()+"; Descripcion: "
		+this.getDescripcion()+"; CodigoQR: "+this.getCodigoQR()+"; Categoria: "
		+this.getCategoria());
		return "";
	}

}
