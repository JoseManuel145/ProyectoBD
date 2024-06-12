package manuel.cruz.demoproyecto.models;

import java.util.Random;

public class Product {
    protected String id;
    protected String nombre;
    protected int cantidad;
    protected double precio;

    public Product() {
    }
    public Product(String id, String nombre, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public int getCantidad() {
        return cantidad;
    }
    public double getPrecio() {
        return precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String genId(){
        Random random = new Random();
        StringBuilder id = new StringBuilder();
        id.append(id);
        this.id = String.valueOf(1);
        for (int i = 0; i<4; i++){
            id.append(random.nextInt(10));
        }
        return id.toString();
    }
    public String imprimirProducto(){
        return id + "       " + nombre + "      $" + precio;
    }
}
