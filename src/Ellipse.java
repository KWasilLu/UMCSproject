import java.util.Locale;

public class Ellipse extends Shape {

    Point center;
    double rx,ry;

    public Ellipse(Style style, double rx, double ry, Point center) {
        super(style);
        this.ry = ry;
        this.rx = rx;
        this.center = center;

    }

    @Override
    public String toSvg() {
        return null;
    }
}