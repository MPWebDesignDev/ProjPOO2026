package objects;

import pt.iscte.poo.utils.Direction;

public interface Movable {

    boolean move(Direction direction);

    default boolean canBePushed(){
        return true;
    }
}
