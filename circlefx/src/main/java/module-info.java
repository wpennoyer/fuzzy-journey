module org.francis.circlefx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.francis.circlefx to javafx.fxml;
    exports org.francis.circlefx;
}