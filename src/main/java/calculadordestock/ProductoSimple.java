package calculadordestock;

public class ProductoSimple extends Producto {
    private Double precio;
    private Integer stock;

    public Double precio() {
        return precio;
    }

    public Integer stock() {
        return stock;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
