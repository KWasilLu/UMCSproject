import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class SvgScene {
    private static SvgScene instance = null;
    private List<String> defs = new ArrayList<>();

    private List<Shape> shapes = new ArrayList<>();

    public void add(Shape shape){
        this.shapes.add(shape);
    }
    public void addDef(String def) { defs.add(def); }

    public void saveHtml(String path){
        FileWriter file;
        try{
            file = new FileWriter(path);
            file.write("<html> <body> <svg width=\"1000\" height=\"1000\">\n");
            for (Shape p: this.shapes) {
                file.write(p.toSvg("") + "\n");
            }
            file.write("</svg>\n</body>\n</html>");
            file.close();
        } catch(Exception cokolwiek) {
            throw new RuntimeException(cokolwiek);
        }

    }

    public static SvgScene getInstance() {
        if (instance == null) {
            instance = new SvgScene();
        }
        return instance;
    }
}
