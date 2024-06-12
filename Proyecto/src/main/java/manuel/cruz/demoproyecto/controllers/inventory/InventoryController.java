package manuel.cruz.demoproyecto.controllers.inventory;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import manuel.cruz.demoproyecto.App;
import manuel.cruz.demoproyecto.models.Inventory;
import manuel.cruz.demoproyecto.models.Product;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class InventoryController {
    @FXML
    private ListView<String> listProduct;
    @FXML
    private Button agregarButton;
    @FXML
    private Button eliminarButton;
    @FXML
    private Button volverButton;
    String url = "jdbc:mysql://localhost:3306/shop?serverTimezone=UTC";
    String username = "root";
    String password = "upchiapas23";
    public void onMouseClickedAgregarButton(MouseEvent event){
        App.nuevaVentana(event, "/manuel/cruz/demoproyecto/inventario/agregarP-inventario", "Categoria del producto");
    }

    public void onMouseClickedEliminarButton(MouseEvent event){
        App.nuevaVentana(event,"/manuel/cruz/demoproyecto/inventario/eliminarP-inventario", "Categoria del producto");
    }
    public void onMouseClickedVolverButton(MouseEvent event){
        App.nuevaVentana(event, "menu-principal", "Menu principal");
    }
    public void onMouseClickedActualizarButton(MouseEvent event){
        App.nuevaVentana(event, "/manuel/cruz/demoproyecto/inventario/updateProduct", "Menu principal");
    }
    @FXML
    public void initialize() {
        Inventory inventory = App.getInventario();

        listProduct.getItems().clear();

        for (Product product : inventory.getProductos()) {
            listProduct.getItems().add(product.toString());
        }
    }

    Connection connection;
    Statement statement;
    ResultSet resultSet;
    {
        try {
            //ESTE BLOQUE DE CODIGO ES LA QUE SE ENCARGA DE IMPRIMIR LA TABLA ENTERA DE LA BASE DE DATOS
            connection = DriverManager.getConnection(url,username,password);
            statement = connection.createStatement();
            //SELECCIONA TODOS LOS DATOS
            resultSet = statement.executeQuery("SELECT * FROM products");

            while (resultSet.next()){
                //MANDA A IMPRIMIR DE ACUERDO AL NOMBRE DE SU COLUMNA
                System.out.println(resultSet.getString("id") + " | " +
                        resultSet.getString("nombre") + " | " +
                        resultSet.getString("cantidad") + " | " +
                        resultSet.getString("caducidadCategoria") + " | " +
                        resultSet.getString("precio") + " | ");
            }
            //CIERRA TODO PARA EVITAR SATURACION DE DATOS
            connection.close();
            statement.close();
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
