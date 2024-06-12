package manuel.cruz.demoproyecto.controllers.inventory;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import manuel.cruz.demoproyecto.App;
import manuel.cruz.demoproyecto.models.FoodProduct;
import manuel.cruz.demoproyecto.models.HomeProduct;
import manuel.cruz.demoproyecto.models.Inventory;
import manuel.cruz.demoproyecto.models.Product;

public class UpdatePController {

    @FXML
    private Button agregarButton;

    @FXML
    private TextField idTxt;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtFecha;

    @FXML
    private TextField txtFecha1;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPrecio;

    @FXML
    private Button volverButton;

    @FXML
    void onMouseClickedAgregarButton(MouseEvent event) {
        Inventory inventory = App.getInventario();
        String id = idTxt.getText();
        String nombre = txtName.getText();
        int cantidad = Integer.parseInt(txtCantidad.getText());
        String caducidad = txtFecha.getText();
        String categoria = txtFecha1.getText();
        double precio = Double.parseDouble(txtPrecio.getText());

        boolean updated = false;

        // Iterar sobre los productos de tipo HomeProduct
        for (Product product : inventory.getProductos()) {
            if (product instanceof HomeProduct && id.equals(product.getId())) {
                // Crear un nuevo objeto HomeProduct con los datos actualizados
                HomeProduct productToUpdate = new HomeProduct(id, nombre, cantidad, precio, categoria);
                updated = inventory.updateProduct(productToUpdate);
                break; // Salir del bucle una vez que se actualiza el producto
            }
        }

        // Si no se ha actualizado el producto en el bucle anterior, continuar con los productos de tipo FoodProduct
        if (!updated) {
            for (Product product : inventory.getProductos()) {
                if (product instanceof FoodProduct && id.equals(product.getId())) {
                    // Crear un nuevo objeto FoodProduct con los datos actualizados
                    FoodProduct productToUpdate = new FoodProduct(id, nombre, cantidad, precio, caducidad);
                    updated = inventory.updateProduct(productToUpdate);
                    break; // Salir del bucle una vez que se actualiza el producto
                }
            }
        }

        // Verificar si la actualización fue exitosa y mostrar un mensaje
        if (updated) {
            System.out.println("Producto actualizado correctamente.");
        } else {
            System.out.println("Error: Producto no encontrado o no reconocido.");
        }
    }



    @FXML
    void onMouseClickedVolverButton(MouseEvent event) {
        App.nuevaVentana(event, "/manuel/cruz/demoproyecto/inventario/menu-inventario","Inventory");
    }

}
