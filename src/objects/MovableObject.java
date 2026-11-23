package objects;

import pt.iscte.poo.utils.Direction;
import pt.iscte.poo.utils.Point2D;

public abstract class MovableObject extends GeneralObject implements Pushable{

    public MovableObject(String name, Point2D position) {
        super(name, position);
    }

    @Override
    public boolean move(Direction direction) {
        if (direction == null) {
            return false;
        }
        Point2D currentPosition = getPosition();
        Point2D newPosition = currentPosition.plus(direction.asVector());
        setPosition(newPosition);
        return true;
    }



}
