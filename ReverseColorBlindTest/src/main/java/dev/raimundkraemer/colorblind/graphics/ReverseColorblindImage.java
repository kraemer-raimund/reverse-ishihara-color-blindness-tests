package dev.raimundkraemer.colorblind.graphics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class ReverseColorblindImage {

    private static final double MIN_RADIUS = 4;
    private static final double MAX_RADIUS = 12;

    private final List<Circle> circles;

    private ReverseColorblindImage(List<Circle> circles) {
        this.circles = circles;
    }

    public List<Circle> circles() {
        return circles;
    }

    public static ReverseColorblindImage generate(int width, int height, int circlesToGenerate) {
        final Circle hiddenShape = generateHiddenShape(width, height);
        final List<Circle> circles = new ArrayList<>();

        final var startTime = System.currentTimeMillis();

        IntStream.range(0, circlesToGenerate)
                .forEach(i -> addRandomCircle(width, height, circles, hiddenShape));

        final var endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime));
        System.out.println("Generated circles: " + circles.size());

        return new ReverseColorblindImage(circles);
    }

    private static Circle generateHiddenShape(int width, int height) {
        final var random = ThreadLocalRandom.current();
        return new Circle(
                random.nextDouble(0.1 * width, 0.9 * width),
                0.5 * height,
                0.33 * height
        );
    }

    private static void addRandomCircle(int imageWidth, int imageHeight, List<Circle> circles, Circle hiddenShape) {
        // Not the most efficient algorithm, but good enough for now. If the
        // randomly generated circle collides with any existing circle, we
        // simply try again up to some maximum number of attempts.
        // For a more efficient algorithm we might want to use an R-tree or
        // R*-tree for spatial partitioning.
        for (int attempts = 1000; attempts > 0; attempts--) {
            Circle circle = generateRandomCircle(imageWidth, imageHeight);
            if (!collidesWithAny(circle, circles)) {
                if (circle.intersects(hiddenShape)) {
                    circles.add(circle.copyWithColor(Color.magentaSecondary()));
                } else {
                    circles.add(circle.copyWithColor(Color.magentaPrimary()));
                }
                break;
            }
        }
    }

    private static Circle generateRandomCircle(int imageWidth, int imageHeight) {
        final Random random = ThreadLocalRandom.current();
        final double posX = random.nextDouble(0, imageWidth);
        final double posY = random.nextDouble(0, imageHeight);
        final double radius = random.nextDouble(MIN_RADIUS, MAX_RADIUS);
        return new Circle(posX, posY, radius);
    }

    private static boolean collidesWithAny(Circle subject, List<Circle> obstacles) {
        return obstacles.stream()
                .anyMatch(obstacle -> obstacle.overlaps(subject));
    }
}
