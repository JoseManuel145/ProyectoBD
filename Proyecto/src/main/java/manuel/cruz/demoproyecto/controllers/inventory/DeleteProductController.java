package manuel.cruz.demoproyecto.controllers.inventory;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import manuel.cruz.demoproyecto.App;

public class DeleteProductController {
    @FXML
    private Button eliminarButton;
    @FXML
    private TextField txtIdEliminar;
    @FXML
    private Button volverButton;
    public void onMouseClickedEliminarButton(){
        String id = txtIdEliminar.getText();
        Boolean elimino = App.getInventario().delProducto(id);
        if (elimino){
            App.showAlert(Alert.AlertType.INFORMATION,"Eliminar", "Se elimino correctamente");
        }else{
            App.showAlert(Alert.AlertType.ERROR, "Eliminar", "No se encontro el producto");
        }
    }
    public void onMouseClickedVolverButton(MouseEvent event){
        App.nuevaVentana(event, "/manuel/cruz/demoproyecto/inventario/menu-inventario","Inventory");
    }
}
