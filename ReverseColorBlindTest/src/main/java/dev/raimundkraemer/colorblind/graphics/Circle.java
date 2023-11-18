package dev.raimundkraemer.colorblind.graphics;

public record Circle(double x, double y, double radius, Color color) {

    public Circle(double x, double y, double radius) {
        this(x, y, radius, Color.white());
    }

    public Circle copyWithColor(Color color) {
        return new Circle(this.x, this.y, this.radius, color);
    }

    /**
     * True iff this circle has any area overlap with the other circle. This
     * includes the case where one of the circles is completely enclosed by
     * the other one.
     */
    public boolean overlaps(Circle other) {
        return (this.radius + other.radius) > midpointEulerDistance(other);
    }

    /**
     * True iff this circle has strictly partial area overlap with the other
     * circle, i.e., a completely enclosed circle is considered overlapping
     * but NOT intersecting.
     */
    public boolean intersects(Circle other) {
        return this.overlaps(other)
                && !this.isFullyEnclosedBy(other)
                && !other.isFullyEnclosedBy(this);
    }

    private double midpointEulerDistance(Circle other) {
        return Math.sqrt(
                Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2)
        );
    }

    private boolean isFullyEnclosedBy(Circle other) {
        return (midpointEulerDistance(other) + this.radius) < other.radius;
    }
}
