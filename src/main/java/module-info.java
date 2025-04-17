module com.example.regpagehw {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.regpagehw to javafx.fxml;
    exports com.example.regpagehw;
}