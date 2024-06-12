package manuel.cruz.demoproyecto.models;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class Inventory {
    String url = "jdbc:mysql://localhost:3306/shop?serverTimezone=UTC";
    String username = "root";
    String password = "upchiapas23";


    Connection connection;
    Statement statement;
    ResultSet resultSet;

    {
        try {
            connection = DriverManager.getConnection(url,username,password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM products");

            while (resultSet.next()){
                System.out.println(resultSet.getString("id") + " | " +
                        resultSet.getString("nombre") + " | " +
                        resultSet.getString("cantidad") + " | " +
                        resultSet.getString("caducidadCategoria") + " | " +
                        resultSet.getString("precio") + " | ");
            }
            connection.close();
            statement.close();
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private ArrayList <Product> products = new ArrayList<>();

    public ArrayList<Product> getProductos() {
        return products;
    }
    //EN ESTA FUNCION ES DONDE SE AGREGAN LOS DATOS DE LOS OBJETOS A LA BASE DE DATOS MYSQL
    public boolean addProduct(Product product) {
        products.add(product);
        //SE HACE LA SENTENCIA
        String sql = "INSERT INTO products (id, nombre, cantidad, caducidadCategoria, precio) VALUES (?, ?, ?, ?, ?)";
        //HACE LA CONECCION
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            //SETEA LOS DATOS PARA PODER MANDARLOS A LA BASE DE DATOS
            preparedStatement.setInt(1, Integer.parseInt(product.getId()));
            preparedStatement.setString(2, product.getNombre());
            preparedStatement.setInt(3, product.getCantidad());
            //SI ES DE UN TIPO DE OBJETO HACE X O Y COSA
            if (product instanceof HomeProduct){
                preparedStatement.setString(4, ((HomeProduct) product).getCategoria());
            } else if (product instanceof FoodProduct) {
                preparedStatement.setString(4, ((FoodProduct) product).getFechaCaducidad());
            }
            preparedStatement.setDouble(5, product.getPrecio());

            //EXECUTA LA SENTENCIA
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean delProducto(String id) {
        //PREPARA LA SENTENCIA PARA BORRAR EL CAMPO DE ACUERDO AL ID PROPORCIONADO
        String sql = "DELETE FROM products WHERE id = ?";
        //HACE LA CONEXION CON LA BASE DE DATOS
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, Integer.parseInt(id));

            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    //ESTA FUNCION ES LA QUE ACTUALIZA LOS DATOS
    public boolean updateProduct(Product product) {
        //PREPARA LA SENTENCIA SQL PARA LA ACTUALIZACION DE LOS DATOS...
        String sql = "UPDATE products SET nombre = ?, cantidad = ?, caducidadCategoria = ?, precio = ? WHERE id = ?";
            //SE CONECTA...
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            //SETEA LOS DATOS...
            preparedStatement.setString(1, product.getNombre());
            preparedStatement.setInt(2, product.getCantidad());
            if (product instanceof HomeProduct){
                preparedStatement.setString(3, ((HomeProduct) product).getCategoria()); // Corregido el índice a 3
            } else if (product instanceof FoodProduct) {
                preparedStatement.setString(3, ((FoodProduct) product).getFechaCaducidad()); // Corregido el índice a 3
            }
            preparedStatement.setDouble(4, product.getPrecio()); // Índice correcto para el precio
            preparedStatement.setInt(5, Integer.parseInt(product.getId()));

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Product getProductoPorId(String id) {
        for (Product product : products) {
            if (id.equals(product.getId())) {
                return product;
            }
        }
        return null;
    }
    public void reducirStock(String id) {
        Product product = getProductoPorId(id);
        if (product != null && product.getCantidad() > 0) {
            product.setCantidad(product.getCantidad() - 1);
        }
    }
    public void aumentarStock(String id) {
        Product product = getProductoPorId(id);
        if (product != null) {
            product.setCantidad(product.getCantidad() + 1);
        }
    }
}
