package dev.raimundkraemer.colorblind.graphics;

public record Circle(double x, double y, double radius, Color color) {

    public Circle(double x, double y, double radius) {
        this(x, y, radius, Color.white());
    }

    /**
     * True iff this circle has any area overlap with the other circle. This
     * includes the case where one of the circles is completely enclosed by
     * the other one.
     */
    public boolean overlaps(Circle other) {
        return (this.radius + other.radius) > midpointEulerDistance(other);
    }

    private double midpointEulerDistance(Circle other) {
        return Math.sqrt(
                Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2)
        );
    }
}
