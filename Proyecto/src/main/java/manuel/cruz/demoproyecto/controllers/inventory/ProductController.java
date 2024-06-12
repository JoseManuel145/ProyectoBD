package manuel.cruz.demoproyecto.controllers.inventory;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import manuel.cruz.demoproyecto.App;

public class ProductController {
    @FXML
    private Button alimentoButton;
    @FXML
    private Button hogarButton;
    @FXML
    private Button volverButton;
    public void onMouseClickedAlimentoButton(MouseEvent event){
        App.nuevaVentana(event,"/manuel/cruz/demoproyecto/inventario/agregarP-alimento", "Alimentos");
    }
    public void onMouseClickedHogarButton(MouseEvent event){
        App.nuevaVentana(event,"/manuel/cruz/demoproyecto/inventario/agregarP-hogar", "Hogar");
    }
    public void onMouseClickedVolverButton(MouseEvent event){
        App.nuevaVentana(event, "/manuel/cruz/demoproyecto/inventario/menu-inventario", "Menu principal");

    }
}
