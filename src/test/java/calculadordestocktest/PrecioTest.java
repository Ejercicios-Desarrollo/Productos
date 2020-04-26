package calculadordestocktest;

import calculadordestock.*;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.junit.Assert;
import org.junit.Test;

public class PrecioTest {

    @Test
    public void precioProductoSimpleTest(){
        ProductoSimple guantes = new ProductoSimple();
        guantes.setNombre("Guantes");
        guantes.setPrecio(600.00);
        guantes.setStock(10);

        ProductoSimple casco = new ProductoSimple();
        casco.setPrecio(1200.00);
        casco.setNombre("Casco");
        casco.setStock(8);

        ProductoSimple chaleco = new ProductoSimple();
        chaleco.setNombre("Chaleco");
        chaleco.setPrecio(400.00);
        chaleco.setStock(6);

        Combo basico = new Combo();
        basico.agregarProducto(guantes, casco, chaleco);

        ProductoSimple piloto = new ProductoSimple();
        piloto.setPrecio(500.00);
        piloto.setNombre("Piloto");
        piloto.setStock(5);

        Combo premium = new Combo();
        premium.agregarProducto(basico, piloto);

        // Precios base de combos
        Assert.assertEquals(2200, basico.precio(), 0.0);
        Assert.assertEquals(2700, premium.precio(), 0.0);

        // DescuentoFijo
        Decorado descuentoDe200Pe = new DescuentoFijo(basico, 200.00);
        Assert.assertEquals(2000, descuentoDe200Pe.precio(), 0.0);

        // Packaging
        Decorado caja = new Packaging(chaleco, 100.00);
        Assert.assertEquals(500, caja.precio(), 0.0);

        // DescuentoFijo y Packaging
        Decorado descuentoDe500Pe = new DescuentoFijo(premium, 500.00);
        Decorado cajon = new Packaging(descuentoDe500Pe, 200.00);
        Assert.assertEquals(2400, cajon.precio(), 0.0);

        // 10 guantes, 8 cascos, 6 chalecos = 6 combos basicos
        Assert.assertEquals(Integer.valueOf(6), basico.stock());

        // 10 guantes, 8 cascos, 6 chalecos, 5 pilotos = 5 combos basicos
        Assert.assertEquals(Integer.valueOf(5), premium.stock());

    }
}
