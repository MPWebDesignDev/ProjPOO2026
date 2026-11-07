package objects;

import pt.iscte.poo.utils.Direction;
import pt.iscte.poo.utils.Point2D;

public class Grass extends GeneralObject{

    public Grass(String name, Point2D position) {
        super(name, position);
    }

    @Override
    public void move(Direction direction) {
        //Empty as the Grass is a cosmetic object
    }
}
