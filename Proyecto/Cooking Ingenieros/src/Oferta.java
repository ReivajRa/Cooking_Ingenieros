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
	Coleccion_categoria categoria;
	
	public Oferta(String p, double d, int t, double pr, String des, Coleccion_categoria cat)
	{
		this.id_oferta= (int)Math.random();
		this.producto = p;
		this.descuento = d;
		this.tienda = t;
		this.precio = pr;
		this.descripcion = des;
		categoria = new Coleccion_categoria();
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
	
	public Coleccion_categoria getCategoria() {
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

	public void setCategoria(Coleccion_categoria categoria) {
		this.categoria = categoria;
	}
	
	public void aniadirCat(String cat) {
		categoria.aniadirCat(cat);
	}
	
	public void quitarCat(String cat) {
		categoria.quitarCat(cat);
	}

	public boolean equals(Object o)
	{
		boolean res = o instanceof Oferta;
		Oferta of = res ? (Oferta)o: null;
		return res && this.id_oferta==of.id_oferta;
		
	}
	public int hashCode()
	{
		return this.id_oferta;
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
