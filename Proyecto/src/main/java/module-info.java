module manuel.cruz.demoproyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    exports manuel.cruz.demoproyecto.models to javafx.fxml;
    opens manuel.cruz.demoproyecto.models;

    opens manuel.cruz.demoproyecto to javafx.fxml;
    exports manuel.cruz.demoproyecto;
    opens manuel.cruz.demoproyecto.controllers to javafx.fxml;
    exports manuel.cruz.demoproyecto.controllers;
    exports manuel.cruz.demoproyecto.controllers.venta;
    opens manuel.cruz.demoproyecto.controllers.venta to javafx.fxml;
    exports manuel.cruz.demoproyecto.controllers.inventory;
    opens manuel.cruz.demoproyecto.controllers.inventory to javafx.fxml;
    exports manuel.cruz.demoproyecto.controllers.ticket;
    opens manuel.cruz.demoproyecto.controllers.ticket to javafx.fxml;
}