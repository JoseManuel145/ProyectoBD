package manuel.cruz.demoproyecto.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

    public class Ticket {
        private double total;
        private static int nextId = 0;
        private int id;
        private ArrayList<Product> productosVendidos;
        private LocalDateTime fechaCreacion;

        public Ticket() {
        }
        public Ticket(double total) {
            this.total = total;
            this.id = ++nextId;
            this.productosVendidos = new ArrayList<>();
            this.fechaCreacion = LocalDateTime.now();
        }

        public int getId() {
            return id;
        }

        public ArrayList<Product> getProductosVendidos() {
            return productosVendidos;
        }

        public LocalDateTime getFechaCreacion() {
            return fechaCreacion;
        }

        public double getTotal() {
            return total;
        }

        public void setProductosVendidos(ArrayList<Product> productosVendidos) {
            this.productosVendidos = productosVendidos;
        }
    }


