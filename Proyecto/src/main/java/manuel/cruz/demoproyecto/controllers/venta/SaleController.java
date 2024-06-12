package manuel.cruz.demoproyecto.controllers.venta;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import manuel.cruz.demoproyecto.App;
import manuel.cruz.demoproyecto.models.Product;
import manuel.cruz.demoproyecto.models.Sale;
import manuel.cruz.demoproyecto.models.Ticket;


public class SaleController {
    @FXML
    private TextField txtDineroIngreso;
    @FXML
    private Label cajaTotal;
    @FXML
    private ListView <String> productosVender;
    @FXML
    private Button agregPButton;
    @FXML
    private Button elimPButton;
    @FXML
    private Button venderButton;
    @FXML
    private Button volverButton;
    @FXML
    private Button actualizarButton;
    private double cambio;
    public void onMouseClickedActualizarButton(){
        Sale sale = App.getVenta();
        productosVender.getItems().clear();

        for (Product productos: sale.getProductosVender()){
            productosVender.getItems().add(productos.imprimirProducto());
        }
        cajaTotal.setText("Total: $" + sale.calcularTotal());
    }
    public void onMouseClickedAgregarButton(MouseEvent event){
        App.nuevaVentana(event,"/manuel/cruz/demoproyecto/venta/agregarP-venta", "Agrega un producto");
    }
    public void onMouseClickedVenderButton() {
        Sale sale = App.getVenta();

        if (sale.vacio()) {
            App.showAlert(Alert.AlertType.ERROR, "Error", "No hay productos agregados para vender.");
            return;
        }

        String input =  txtDineroIngreso.getText();

        if (input.isEmpty()) {
            App.showAlert(Alert.AlertType.ERROR, "Error", "Ingrese el dinero primero");
            return;
        }
        try {
            double dinero = Double.parseDouble(input);
            cambio = dinero - sale.getTotal();
            cajaTotal.setText("CAMBIO: $" + cambio);
        } catch (NumberFormatException e) {
            App.showAlert(Alert.AlertType.ERROR, "Error", "Ingrese un valor numérico válido para el dinero");
        }
        Ticket nuevoTicket = sale.finalizarVenta();
        App.getRegistroTickets().agregarTicket(nuevoTicket);
    }
    public void onMouseClickedEliminarButton(MouseEvent event){
        App.nuevaVentana(event, "/manuel/cruz/demoproyecto/venta/eliminarP-venta", "Elimina un producto");
    }
    public void onMouseClickedVolverButton(MouseEvent event){
        App.nuevaVentana(event, "menu-principal", "Menu principal");

    }
}