package objects;

import pt.iscte.poo.utils.Direction;
import pt.iscte.poo.utils.Point2D;

public abstract class MovableObject extends GeneralObject implements Pushable{

    public MovableObject(String name, Point2D position) {
        super(name, position);
    }

    public boolean move(Direction direction) {
        Point2D currentPosition = getPosition(); //Gets current position of the rock
        Point2D newPosition = currentPosition.plus(direction.asVector()); //Gets (up, down, left ou, right)
        setPosition(newPosition); //Sets new position of the rock
        return false;
    }

}
