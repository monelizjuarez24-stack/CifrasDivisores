module com.mycompany.cifrasdivisores {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.cifrasdivisores to javafx.fxml;
    exports com.mycompany.cifrasdivisores;
}
