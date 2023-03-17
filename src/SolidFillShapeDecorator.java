public class SolidFillShapeDecorator extends ShapeDecorator{
    private String color;

    public SolidFillShapeDecorator(Shape decoratedShape, String color) {
        super(decoratedShape);
        this.color = color;
    }

    @Override
    public String toSvg(String parameters) {
        String output = String.format("fill=\"%s\" %s ", color, parameters);
        return super.toSvg(output);
    }
}
