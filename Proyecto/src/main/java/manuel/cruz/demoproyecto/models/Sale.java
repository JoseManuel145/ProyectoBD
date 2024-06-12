package manuel.cruz.demoproyecto.models;

import manuel.cruz.demoproyecto.App;

import java.util.ArrayList;

public class Sale {
    double total;
    ArrayList<Product> productosVender = new ArrayList<>();
    public ArrayList<Product> getProductosVender() {
        return productosVender;
    }
    public boolean vacio() {
        return productosVender.isEmpty();
    }
    public double getTotal() {
        return total;
    }
    public boolean agregarProducto(String id) {
        Inventory inventory = App.getInventario();
        boolean agregado = false;
        Product productEnInventario = inventory.getProductoPorId(id);
        if (productEnInventario != null && productEnInventario.getCantidad() > 0) {
            productosVender.add(productEnInventario);
            agregado = true;
            inventory.reducirStock(id);
        }
        return agregado;
    }
    public boolean eliminarProducto(String idDel) {
        Inventory inventory = App.getInventario();
        boolean eliminado;
        eliminado=productosVender.removeIf(producto -> idDel.equals(producto.getId()));
        inventory.aumentarStock(idDel);
        return eliminado;
    }
    public double calcularTotal() {
        total = 0;
        for (Product product : productosVender) {
            total += product.getPrecio();
        }
        return total;
    }
    public Ticket finalizarVenta() {
        Ticket ticket = new Ticket(total);
        ticket.setProductosVendidos(new ArrayList<>(productosVender));
        productosVender.clear();
        return ticket;
    }
}
