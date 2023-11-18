package dev.raimundkraemer.colorblind;

import dev.raimundkraemer.colorblind.graphics.Circle;
import dev.raimundkraemer.colorblind.graphics.Renderer;
import dev.raimundkraemer.colorblind.graphics.ReverseColorblindImage;
import javafx.scene.canvas.Canvas;

final class CanvasRenderer implements Renderer {

    private final Canvas canvas;

    public CanvasRenderer(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void render(ReverseColorblindImage image) {
        image.circles().forEach(this::render);
    }

    private void render(Circle circle) {
        canvas.getGraphicsContext2D()
                .fillOval(
                        circle.x(),
                        circle.y(),
                        circle.radius(),
                        circle.radius()
                );
    }
}
