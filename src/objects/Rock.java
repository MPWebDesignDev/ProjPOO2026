package objects;

import pt.iscte.poo.utils.Direction;
import pt.iscte.poo.utils.Point2D;

public class Rock extends GeneralObject{
    public Rock(String name, Point2D position) {
        super(name, position);
    }

    @Override
    public Point2D getPoint2D() {
        return super.getPoint2D();
    }

    @Override
    public void setPosition(Point2D position) {
        super.setPosition(position);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public Point2D getPosition() {
        return super.getPosition();
    }

    @Override
    public int getLayer() {
        return super.getLayer();
    }

    @Override
    public void move(Direction direction) {

    }


}
