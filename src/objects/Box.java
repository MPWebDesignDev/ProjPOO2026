package objects;

import pt.iscte.poo.utils.Point2D;

public class Box extends MovableObject implements Pushable{

    public Box(String name, Point2D position) {
        super(name, position);
    }

    @Override
    public String getName() {
        return "box";
    }

    @Override
    public int getLayer() {
        return 11;
    }


    @Override
    public boolean canMove(BoxRules rule) {
        return rule == BoxRules.MOVE;
    }

}
