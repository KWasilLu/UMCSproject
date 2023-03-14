import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
public class SvgScene {
    private final List<Shape> shapes = new ArrayList<>();
    public void add(Shape shape) {
        shapes.add(shape);
    }


    public void saveHtml(String path){
        try {
            FileWriter fw = new FileWriter(path);
            fw.write("<html> <body> <svg width=\"1000\" height=\"1000\">\n");
            for(var shape : shapes){
                fw.write(shape.toSvg()+"\n");
            }
            fw.write("</svg>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>");
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
