package objects;

import pt.iscte.poo.utils.Direction;
import pt.iscte.poo.utils.Point2D;

public class Hole extends GeneralObject{
    public Hole(String name, Point2D position) {
        super(name, position);
    }


    @Override
    public String getName() {
        return "hole";
    }

    @Override
    public void move(Direction direction) {
        //Empty as the Hole is a static object
    }
}
