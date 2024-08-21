
package inventario;

public class Inventario {

    public static void main(String[] args) {
        Proveedor proveedor1 = new Proveedor("Proveedor A");
        Categoria electronica = new Categoria("Electrónica");

        Producto producto1 = new ProductoElectronico("Laptop", 1000.0, 5, proveedor1, 12);

        GestorDeInventario gestorDeInventario = new GestorDeInventario();
        gestorDeInventario.agregarProducto(producto1);
        gestorDeInventario.agregarCategoría(electronica);

        CalculadorDePrecio calculadorSinDescuento = new CalculadorDePrecioSinDescuento();
        CalculadorDePrecio calculadorConDescuento = new CalculadorDePrecioConDescuento(10.0);

        double totalSinDescuento = gestorDeInventario.calcularPrecioTotal(calculadorSinDescuento);
        double totalConDescuento = gestorDeInventario.calcularPrecioTotal(calculadorConDescuento);

        System.out.println("Total sin descuento: $" + totalSinDescuento);
        System.out.println("Total con descuento: $" + totalConDescuento);
    }
    
}
