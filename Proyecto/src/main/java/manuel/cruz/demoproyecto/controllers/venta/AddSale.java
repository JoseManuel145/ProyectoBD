package manuel.cruz.demoproyecto.controllers.venta;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import manuel.cruz.demoproyecto.App;

public class AddSale {
    @FXML
    private Button agregaPButton;
    @FXML
    private TextField txtId;
    @FXML
    private Button volverButton;
    public void onMouseClickedAgregarButton(){
        String id = txtId.getText();
        boolean agrego = App.getVenta().agregarProducto(id);
        if (agrego) {
            App.showAlert(Alert.AlertType.INFORMATION, "Product Agregado", "Product agregado correctamente");
        }else {
            App.showAlert(Alert.AlertType.ERROR, "Product Agregado", "Error al agregar producto.\nNo se encontro el producto o no hay suficiente Stock.");
        }
    }
    public void onMouseClickedVolverButton(MouseEvent event){
        App.nuevaVentana(event,"/manuel/cruz/demoproyecto/venta/menu-venta","Punto de Sale");
    }
}
