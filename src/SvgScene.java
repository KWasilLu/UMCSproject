import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class SvgScene {
    private final List<String> defs = new ArrayList<>();
    private final List<Shape> shapes = new ArrayList<>();
    private static SvgScene instance = null;

    public static SvgScene getInstance() {
        if (instance == null) {
            instance = new SvgScene();
        }
        return instance;
    }
    public void addDef(String def) {
        this.defs.add(def);
    }
    public void addShape(Shape shape){
        this.shapes.add(shape);
    }

    public void saveHtml(String path){
        FileWriter file;
        try{
            file = new FileWriter(path);
            file.write("<html> <body> <svg width=\"1000\" height=\"1000\">\n");
            if (defs != null && defs.size() > 0) {
                file.write("<defs>\n");
                for (String def : defs) {
                    file.write(def + "\n");
                }
                file.write("<defs>\n");
            }
            for (Shape p: this.shapes) {
                file.write(p.toSvg("") + "\n");
            }
            file.write("</svg>\n</body>\n</html>");

            file.close();
        } catch(Exception whatever) {
            throw new RuntimeException(whatever);
        }

    }
}
