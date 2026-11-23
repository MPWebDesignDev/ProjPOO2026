package objects;

import pt.iscte.poo.utils.Point2D;

public class Peach extends GeneralObject{
    public Peach(String name, Point2D position) {
        super(name, position);
    }


    @Override
    public String getName() {
        return "peach";
    }

}
