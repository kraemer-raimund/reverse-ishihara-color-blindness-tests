module dev.raimundkraemer.reversecolorblindtest {
    requires javafx.controls;
    requires javafx.fxml;


    opens dev.raimundkraemer.colorblind to javafx.fxml;
    exports dev.raimundkraemer.colorblind;
}
