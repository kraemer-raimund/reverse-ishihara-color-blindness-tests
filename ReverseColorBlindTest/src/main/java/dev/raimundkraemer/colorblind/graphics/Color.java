package dev.raimundkraemer.colorblind.graphics;

/**
 * RGB values in the range [0..1].
 */
public record Color(double r, double g, double b) {

    private static final Color WHITE = new Color(1, 1, 1);
    private static final Color BLACK = new Color(0, 0, 0);
    private static final Color MAGENTA_PRIMARY = new Color(1, 0, 0.6);
    private static final Color MAGENTA_SECONDARY = new Color(1, 0, 0.66);

    public static Color white() {
        return WHITE;
    }

    public static Color black() {
        return BLACK;
    }

    public static Color magentaPrimary() {
        return MAGENTA_PRIMARY;
    }

    public static Color magentaSecondary() {
        return MAGENTA_SECONDARY;
    }
}
