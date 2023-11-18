package dev.raimundkraemer.colorblind.graphics;

/**
 * RGB values in the range [0..1].
 */
public record Color(double r, double g, double b) {

    private static final Color MAGENTA = new Color(1, 0, 0.6);

    public static Color magenta() {
        return MAGENTA;
    }
}
