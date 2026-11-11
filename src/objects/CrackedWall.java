package objects;

import pt.iscte.poo.utils.Direction;
import pt.iscte.poo.utils.Point2D;

public class CrackedWall extends GeneralObject{
    public CrackedWall(String name, Point2D position) {
        super(name, position);
    }

    @Override
    public String getName() {
        return "cracked-wall";
    }

    @Override
    public void move(Direction direction) {
        //Empty as the CrackedWall is a static object
    }

    @Override
    public int getLayer() {
        return 10;
    }

}
