package dev.raimundkraemer.colorblind;

import dev.raimundkraemer.colorblind.graphics.Renderer;
import dev.raimundkraemer.colorblind.graphics.ReverseColorblindImage;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;

public class ColorblindController {

    @FXML
    Canvas canvas;

    public void initialize() {
        final var circlesToGenerate = 4000;
        final var image = ReverseColorblindImage.generate(
                (int)canvas.getWidth(),
                (int)canvas.getHeight(),
                circlesToGenerate
        );

        Renderer renderer = new CanvasRenderer(canvas);
        renderer.render(image);
    }
}
