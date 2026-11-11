package objects;

import pt.iscte.poo.utils.Point2D;

public class WordIs extends GeneralObject{

    public WordIs(String name, Point2D position) {
        super(name, position);
    }

    @Override
    public String getName() {
        return "word-is";
    }
}
