package manuel.cruz.demoproyecto.controllers.venta;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import manuel.cruz.demoproyecto.App;

public class DeleteSaleController {
    @FXML
    private Button elimPVentaButton;
    @FXML
    private TextField txtElimId;
    @FXML
    private Button volverButton;
    public void onMouseClickedEliminarButton(){
        String id = txtElimId.getText();
        boolean elimino = App.getVenta().eliminarProducto(id);
        if (elimino){
            App.showAlert(Alert.AlertType.INFORMATION,"Eliminar Product", "El producto se elimino correctamente");
        } else {
            App.showAlert(Alert.AlertType.ERROR,"Eliminar Product","Fallo al eliminar.\nNo se encontro el producto");
        }
    }

    public void onMouseClickedVolverButton(MouseEvent event){
        App.nuevaVentana(event,"/manuel/cruz/demoproyecto/venta/menu-venta","Punto de Sale");
    }
}