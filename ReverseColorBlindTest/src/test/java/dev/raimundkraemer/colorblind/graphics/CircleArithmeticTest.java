package dev.raimundkraemer.colorblind.graphics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleArithmeticTest {

    @Test
    void equalCircles_doOverlap() {
        Circle a = new Circle(0, 0, 10);
        Circle b = new Circle(0, 0, 10);

        assertTrue(a.overlaps(b));
    }

    @Test
    void bigCirclesThatAreCloseTogether_doOverlap() {
        // Distance is 2, sum of radii is 25.
        Circle a = new Circle(5, 1, 10);
        Circle b = new Circle(5, -1, 15);

        assertTrue(a.overlaps(b));
    }

    @Test
    void smallCirclesThatAreFarApart_doNotOverlap() {
        // Distance is 10, sum of radii is 6.
        Circle a = new Circle(10, 0, 4);
        Circle b = new Circle(0, 0, 2);

        assertFalse(a.overlaps(b));
    }

    @Test
    void equallySizedCirclesWithDistanceEqualToTheirRadii_doIntersect() {
        Circle a = new Circle(-10, 0, 20);
        Circle b = new Circle(10, 0, 20);

        assertTrue(a.intersects(b));
    }

    @Test
    void aSmallCircleFullyEnclosedInABigCircle_doesNotIntersect() {
        Circle a = new Circle(0, 0, 2);
        Circle b = new Circle(0, 0, 20);

        assertFalse(a.intersects(b));
    }
}
