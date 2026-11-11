package objects;

import pt.iscte.poo.utils.Point2D;

public class Flag extends GeneralObject{
    public Flag(String name, Point2D position) {
        super(name, position);
    }
    @Override
    public String getName() {
        return "flag";
    }

    @Override
    public int getLayer() {
        return 10;
    }
}
