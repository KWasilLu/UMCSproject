public abstract class Shape {
    protected Style style;

    public Shape() {
        style = new Style("none", "black", 1);
    }
    public Shape(Style style) {
        this.style = style;
    }
    public abstract String toSvg();
}