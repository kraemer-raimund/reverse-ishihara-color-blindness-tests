package dev.raimundkraemer.colorblind.graphics;

import java.util.List;

public class ReverseColorblindImage {

    public Iterable<Circle> circles() {
        return List.of(
                new Circle(400, 250, 20, new Color(0.2, 0.3, 0.5)),
                new Circle(200, 100, 20, new Color(0.6, 0.6, 0.1)),
                new Circle(100, 200, 20, new Color(0.8, 0.7, 0.3)),
                new Circle(600, 400, 20, new Color(0.0, 0.3, 0.3))
        );
    }
}
