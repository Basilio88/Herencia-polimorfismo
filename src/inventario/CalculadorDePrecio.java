
package inventario;

import java.util.List;

public interface CalculadorDePrecio {
    double calcularPrecioTotal(List<Producto> productos);
}

// Implementación sin descuento
class CalculadorDePrecioSinDescuento implements CalculadorDePrecio {
    @Override
    public double calcularPrecioTotal(List<Producto> productos) {
        return productos.stream().mapToDouble(Producto::calcularValor).sum();
    }
}

// Implementación con descuento
class CalculadorDePrecioConDescuento implements CalculadorDePrecio {
    private double porcentajeDescuento;

    public CalculadorDePrecioConDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public double calcularPrecioTotal(List<Producto> productos) {
        double total = productos.stream().mapToDouble(Producto::calcularValor).sum();
        return total - (total * porcentajeDescuento / 100);
    }
}

// Implementación por Categoría
class CalculadorDePrecioPorCategoria implements CalculadorDePrecio {
    private Categoria categoria;

    public CalculadorDePrecioPorCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public double calcularPrecioTotal(List<Producto> productos) {
        return categoria.getProductos().stream().mapToDouble(Producto::calcularValor).sum();
    }
}
