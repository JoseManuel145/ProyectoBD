package manuel.cruz.demoproyecto.models;

public class HomeProduct extends Product {
    private String categoria;
    public HomeProduct(String id, String nombre, int cantidad, double precio, String categoria) {
        super(id, nombre, cantidad, precio);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return id + " " + nombre + " " + cantidad + " " + categoria + " $" + precio;
    }
}
