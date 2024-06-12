package manuel.cruz.demoproyecto.models;

public class FoodProduct extends Product {
    private String fechaCaducidad;
    public FoodProduct(String id, String nombre, int cantidad, double precio, String fechaCaducidad) {
        super(id, nombre, cantidad, precio);
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    @Override
    public String toString() {
        return id + " " + nombre + " " + cantidad + " " + fechaCaducidad + " $" + precio;
    }
}
