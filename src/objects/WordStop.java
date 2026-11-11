package objects;

import pt.iscte.poo.utils.Point2D;

public class WordStop extends GeneralObject{
    public WordStop(String name, Point2D position) {
        super(name, position);
    }

    @Override
    public String getName() {
        return "word-stop";
    }
}
