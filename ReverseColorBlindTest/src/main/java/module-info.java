module dev.raimundkraemer.reversecolorblindtest {
    requires javafx.controls;
    requires javafx.fxml;


    opens dev.raimundkraemer.reversecolorblindtest to javafx.fxml;
    exports dev.raimundkraemer.reversecolorblindtest;
}