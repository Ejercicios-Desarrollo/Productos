package calculadordestock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Combo extends Producto {

    private List<Producto> productos;

    public Combo(){
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto ... productos){
        Collections.addAll(this.productos, productos);
    }

    @Override
    public Double precio() {
        return this.productos.stream().mapToDouble(p -> p.precio()).sum();
    }

    @Override
    public Integer stock() {
        List<Integer> stocks = this.productos.stream().map(p -> p.stock()).collect(Collectors.toList());
        return Collections.min(stocks);
    }
}
