
package inventario;

public class GestorDeDescuentos {
  public double aplicarDescuento(Producto producto, Descuento descuento) {
        return descuento.aplicarDescuento(producto.calcularValor());
    }  
}
