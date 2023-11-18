package dev.raimundkraemer.colorblind;

import dev.raimundkraemer.colorblind.graphics.Circle;
import dev.raimundkraemer.colorblind.graphics.Renderer;
import dev.raimundkraemer.colorblind.graphics.ReverseColorblindImage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

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
        final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        graphicsContext.setFill(toPaintColor(circle.color()));
        graphicsContext.fillOval(circle.x(), circle.y(), circle.radius(), circle.radius());
    }

    private Color toPaintColor(dev.raimundkraemer.colorblind.graphics.Color color) {
        return Color.color(color.r(), color.g(), color.b());
    }
}
