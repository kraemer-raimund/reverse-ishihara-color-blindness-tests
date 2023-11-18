package dev.raimundkraemer.colorblind;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;

public class ColorblindController {

    @FXML
    Canvas canvas;

    public void initialize() {
        canvas.getGraphicsContext2D().fillOval(0, 0, 100, 100);
    }
}
