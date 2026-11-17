package objects;

import com.sun.source.tree.DirectiveTree;
import pt.iscte.poo.utils.Direction;
import pt.iscte.poo.utils.Point2D;

public interface Pushable {
    boolean canMove(BoxRules rules);
    boolean move(Direction d);
}
