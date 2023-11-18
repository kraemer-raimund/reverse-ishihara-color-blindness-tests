package dev.raimundkraemer.colorblind.graphics;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class ReverseColorblindImage {

    private static final int MIN_RADIUS = 5;
    private static final int MAX_RADIUS = 15;

    private final Iterable<Circle> circles;

    private ReverseColorblindImage(List<Circle> circles) {
        this.circles = circles;
    }

    public Iterable<Circle> circles() {
        return circles;
    }

    public static ReverseColorblindImage generate(int width, int height, int circlesToGenerate) {
        final List<Circle> circles = new ArrayList<>();

        IntStream.range(0, circlesToGenerate)
                .forEach(i -> addRandomCircle(width, height, circles));

        return new ReverseColorblindImage(circles);
    }

    private static void addRandomCircle(int imageWidth, int imageHeight, List<Circle> circles) {
        Circle randomCircle = generateRandomCircle(imageWidth, imageHeight, Color.magenta());
        circles.add(randomCircle);
    }

    private static Circle generateRandomCircle(int imageWidth, int imageHeight, Color color) {
        final double posX = ThreadLocalRandom.current().nextDouble(0, imageWidth);
        final double posY = ThreadLocalRandom.current().nextDouble(0, imageHeight);
        final double radius = ThreadLocalRandom.current().nextDouble(MIN_RADIUS, MAX_RADIUS + 1);
        return new Circle(posX, posY, radius, color);
    }
}
