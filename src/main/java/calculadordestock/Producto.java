package calculadordestock;

public abstract class Producto {
    private String marca;
    private String nombre;

    public abstract Double precio();
    public abstract Integer stock();

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
