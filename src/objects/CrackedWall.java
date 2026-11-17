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
    public int getLayer() {
        return 10;
    }

}
