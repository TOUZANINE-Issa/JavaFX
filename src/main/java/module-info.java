module appli.todolistfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens appli to javafx.fxml;
    exports appli;
    exports appli.acceuil;
    opens appli.acceuil to javafx.fxml;
}