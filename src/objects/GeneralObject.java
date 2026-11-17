package objects;

import pt.iscte.poo.gui.ImageTile;
import pt.iscte.poo.utils.Direction;
import pt.iscte.poo.utils.Point2D;

public abstract class GeneralObject implements ImageTile {

    private String name;
    private Point2D position;

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

    public boolean move(Direction direction) {
        Point2D currentPosition = getPosition(); //Gets current position of the rock
        Point2D newPosition = currentPosition.plus(direction.asVector()); //Gets (up, down, left ou, right)
        setPosition(newPosition); //Sets new position of the rock
        return false;
    }

}
