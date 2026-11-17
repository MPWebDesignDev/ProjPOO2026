package objects;

import pt.iscte.poo.utils.Point2D;

public abstract class MovableObject extends GeneralObject implements Movable{

    public MovableObject(String name, Point2D position) {
        super(name, position);
    }


}
