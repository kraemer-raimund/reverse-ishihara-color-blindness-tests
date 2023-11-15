package dev.raimundkraemer.colorblind;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ColorblindController {

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
