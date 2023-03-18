import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class SvgScene {
    private List<String> defs = new ArrayList<>();
    private final List<Shape> shapes = new ArrayList<>();
    private SvgScene instance = null;

    public SvgScene getInstance() {
        if (instance == null) {
            this.instance = new SvgScene();
        }
        return this;
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
