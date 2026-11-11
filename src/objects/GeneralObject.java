package objects;

import pt.iscte.poo.gui.ImageTile;
import pt.iscte.poo.utils.Direction;
import pt.iscte.poo.utils.Point2D;

public abstract class GeneralObject implements ImageTile {

    private String name;
    private Point2D position;
    private boolean isIntransposible = true;

    public GeneralObject(String name, Point2D position) {
        this.name = name;
        this.position = position;
    }

    public Point2D getPoint2D() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Point2D getPosition() {
        return position;

    }

    @Override
    public int getLayer() {
        return 10;
    }

    public void move(Direction direction) {
        this.position = this.position.plus(direction.asVector()); //Moves object depending on the direction
    }

}
