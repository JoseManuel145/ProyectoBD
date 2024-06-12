package manuel.cruz.demoproyecto.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import manuel.cruz.demoproyecto.App;

public class MenuController {
    @FXML
    private Button inventarioButton;
    @FXML
    private Button ticketsButton;
    @FXML
    private Button ventaButton;
    @FXML
    void onMouseClickedInventarioButton(MouseEvent event){
        App.nuevaVentana(event, "/manuel/cruz/demoproyecto/inventario/menu-inventario","Inventory");
    }
    @FXML
    void onMouseClickedTicketButton(MouseEvent event){
        App.nuevaVentana(event,"/manuel/cruz/demoproyecto/ticket/menu-ticket","Tickets");
    }
    @FXML
    void onMouseClickedVentaButton(MouseEvent event){
        App.nuevaVentana(event,"/manuel/cruz/demoproyecto/venta/menu-venta","Punto de venta");
    }
}