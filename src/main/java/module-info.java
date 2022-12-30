module com.example.worddictionary {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.worddictionary to javafx.fxml;
    exports com.example.worddictionary;
}