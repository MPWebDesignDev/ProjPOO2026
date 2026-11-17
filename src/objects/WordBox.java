package objects;

import pt.iscte.poo.utils.Direction;
import pt.iscte.poo.utils.Point2D;

public class WordBox extends WordObject{
    public WordBox(String name, Point2D position) {
        super(name, position);
    }

    @Override
    public String getName() {
        return "word-box";
    }

    @Override
    public int getLayer(){
        return 11;
    }


}
