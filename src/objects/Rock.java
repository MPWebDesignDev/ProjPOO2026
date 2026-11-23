package objects;

import pt.iscte.poo.utils.Direction;
import pt.iscte.poo.utils.Point2D;

public class Rock extends MovableObject{
    public Rock(String name, Point2D position) {
        super(name, position);
    }

    @Override
    public String getName() {
        return "rock";
    }

    @Override
    public boolean canMove(BoxRules rules) {
        return true;
    }


}
