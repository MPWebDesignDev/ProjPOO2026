package objects;

import pt.iscte.poo.gui.ImageTile;
import pt.iscte.poo.utils.Point2D;

public class Bomb extends GeneralObject {

    public Bomb(String name, Point2D point2D) {
        super(name, point2D);
    }

    @Override
    public String getName() {
        return "bomb";
    }

    @Override
    public Point2D getPosition() {
        return super.getPosition();
    }

    @Override
    public int getLayer() {
        return 10;
    }
}
