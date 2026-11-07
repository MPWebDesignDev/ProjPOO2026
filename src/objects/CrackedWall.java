package objects;

import pt.iscte.poo.utils.Direction;
import pt.iscte.poo.utils.Point2D;

public class CrackedWall extends Baba{
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
    public void move(Direction d) {
        //Its is static so move does nothing
    }

    public CrackedWall(Point2D position) {
        super(position);
    }
}
