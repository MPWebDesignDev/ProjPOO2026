package objects;

import pt.iscte.poo.utils.Direction;
import pt.iscte.poo.utils.Point2D;

public class StaticObject extends GeneralObject implements Movable {

    public StaticObject(String name, Point2D position) {
        super(name, position);
    }

    @Override
    public boolean move(Direction direction) {
        return false;
    }


}
