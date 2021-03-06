
public class Main {
	public static void main(String[] args) {
		//Deposito: lalala
		Articulo plancha = new Articulo(1,"Plancha para ropa arrugada",10,57.99); //id, descr, cant, precio
		Articulo arvejas = new Articulo(2,"Arvejas azules",80,9.99);
		Articulo mochila = new Articulo(3,"Mochila \"El Alumno Feliz\"",12,118.85);
		Articulo lentes = new Articulo(4,"Lentes de sol para noche",5,83.15);
		Articulo arbolDeNavidad = new Articulo(5,"Arbol de Navidad \"El gordo panzon\"",14,254.87);
		Articulo fertilizante = new Articulo(6,"Fertilizante \"U2\", ponele a Bono a tus plantas",27,42.42);
		
		//Llega cliente:
		Cliente cliente = new Cliente(1,"0123456789"); //id y razon social
		
		//Cliente quiere comprar, le hacemos 10% de dto por ser nuevo:
		Venta venta1 = new Venta(1,0.1); //nro factura y descuento
		
		//Cliente compra cosas varias
		venta1.addArticulo(plancha, 1);
		venta1.addArticulo(mochila, 1);
		venta1.addArticulo(fertilizante, 14);
		
		//pasa por caja
		cliente.addVenta(venta1); 
		
		//factura de venta1 
		
		System.out.println("Factura N"+venta1.getNroFactura());
		System.out.println("Cliente: "+cliente.getRazonSocial());
		System.out.println("Subtotal: $"+venta1.getTotalSinDto());
		System.out.println("Descuento: "+venta1.getPorcetajeDescuento()*100+"%");
		System.out.println("Total: $"+venta1.getTotal()+"\n\n");
		
		//Cliente vuelve, dice que somos caros, pide mas descuento		
		Venta venta2 = new Venta(2,0.25);
		
		//Cliente rata compra mas cosas:
		venta2.addArticulo(arvejas, 6);
		venta2.addArticulo(lentes, 2);
		venta2.addArticulo(arbolDeNavidad, 1);
		
		cliente.addVenta(venta2); //cliiin, caja
		
		//factura de venta2
		
		System.out.println("Factura N"+venta2.getNroFactura());
		System.out.println("Cliente: "+cliente.getRazonSocial());
		System.out.println("Subtotal: $"+venta2.getTotalSinDto());
		System.out.println("Descuento: "+venta2.getPorcetajeDescuento()*100+"%");
		System.out.println("Total: $"+venta2.getTotal()+"\n\n");
	}

}
