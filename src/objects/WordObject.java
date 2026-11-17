package objects;

import pt.iscte.poo.utils.Direction;
import pt.iscte.poo.utils.Point2D;

public class WordObject extends MovableObject implements Pushable{

    public WordObject(String name, Point2D position) {
        super(name, position);
    }


    @Override
    public boolean canMove(BoxRules rule) {
        return true;
    }

    @Override
    public boolean move(Direction d) {
        if (d == null) {
            return false;
        }
        setPosition(getPosition().plus(d.asVector()));
        return true;
    }

}
