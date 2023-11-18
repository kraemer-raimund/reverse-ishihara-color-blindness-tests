package dev.raimundkraemer.colorblind.graphics;

import java.util.List;

public class ReverseColorblindImage {

    public Iterable<Circle> circles() {
        return List.of(
                new Circle(400, 250, 20),
                new Circle(200, 100, 20),
                new Circle(100, 200, 20),
                new Circle(600, 400, 20)
        );
    }
}
