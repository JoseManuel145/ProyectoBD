package manuel.cruz.demoproyecto.models;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TicketManager {
    ArrayList <Ticket> tickets = new ArrayList<>();
    public ArrayList<Ticket> getTickets() {
        return tickets;
    }
    public void agregarTicket(Ticket ticket){
        tickets.add(ticket);
    }
    public String imprimirTicket(Ticket ticket) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return ticket.getId() + "   " + dtf.format(ticket.getFechaCreacion()) + "    $" + ticket.getTotal();
    }
    public String imprimirTicketConPrecio(Ticket ticket) {
        StringBuilder ticketInfo = new StringBuilder();
        ticketInfo.append("Título: Ticket de Sale\n");
        ticketInfo.append("ID del Ticket: ").append(ticket.getId()).append("\n");
        ticketInfo.append("Productos Vendidos:\n");
        for (Product product : ticket.getProductosVendidos()) {
            ticketInfo.append("- ").append(product.getNombre()).append(" - Precio: $").append(product.getPrecio()).append("\n");
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        ticketInfo.append("Fecha de creación: ").append(dtf.format(ticket.getFechaCreacion())).append("\n");
        ticketInfo.append("Total: $").append(ticket.getTotal()).append("\n");

        return ticketInfo.toString();
    }
}
