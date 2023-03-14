import java.util.Locale;

public class Polygon extends Shape{
    private Point[] arr;
//    Style style;

    public Polygon(int count, Style style) {
        super(style);
        arr = new Point[count];
//        this.style = style;
    }

    //    public Polygon(int count) {
//        arr = new Point[count];
//}
    public Polygon(int count) {
        this(count,new Style("transparent","black",1));
    }

    public void setPoint(int index, Point point) {
        arr[index] = point;
    }

    public void setPoints(Point[] points){
        arr = points;
    }

    public String toSvg() {
        String pointsString = "";
        for(Point point : arr)
            pointsString += point.x + "," + point.y + " ";

//        return String.format(Locale.ENGLISH,"<polygon points=\"%s\" />", pointsString);
        return String.format(Locale.ENGLISH,"<polygon points=\"%s\" />", pointsString,style.toSvg());
    }

    public static Polygon square(Segment line, Style style) {
        Point point = new Point((line.getP1().x + line.getP2().x)/2, (line.getP1().y+line.getP2().y)/2);
        Segment perpendicularLine = Segment.perpendicular(line,point)[0];
        Point[] arr = {line.getP1(),perpendicularLine.getP1(),line.getP2(),perpendicularLine.getP2()};
        Polygon resultSquare = new Polygon(4);
        resultSquare.setPoints(arr);
        return resultSquare;
    }



}
