package objects;

import java.util.List;
import pt.iscte.poo.game.GameEngine;
import pt.iscte.poo.gui.ImageTile;
import pt.iscte.poo.utils.Direction;
import pt.iscte.poo.utils.Point2D;

public enum BoxRules {

    DEFAULT, WIN, MOVE, STOP;

    private static final Direction[] DIRS = { Direction.RIGHT, Direction.DOWN };

    private static boolean hasWord(List<ImageTile> objects, Point2D pos, Class<? extends WordObject> type) {
        if (objects == null || pos == null) {
            return false;
        }
        for (ImageTile obj : objects) {
            if (obj != null && type.isInstance(obj) && pos.equals(obj.getPosition())) {
                return true;
            }
        }
        return false;
    }

    public static BoxRules fromRoom(List<ImageTile> objs) {
        if (objs == null) {
            return DEFAULT;
        }

        boolean win = false;
        boolean move = false;
        boolean stop = false;

        for (ImageTile obj : objs) {
            if (!(obj instanceof WordBox)) {
                continue;
            }
            Point2D pos = obj.getPosition();
            for (Direction d : DIRS) {
                Point2D isPos = pos.plus(d.asVector());
                Point2D propPos = isPos.plus(d.asVector());
                if (hasWord(objs, isPos, WordIs.class)) {
                    if (hasWord(objs, propPos, WordWin.class)) {
                        win = true;
                    }
                    if (hasWord(objs, propPos, WordMove.class)) {
                        move = true;
                    }
                    if (hasWord(objs, propPos, WordStop.class)) {
                        stop = true;
                    }
                }
            }
        }

        if (move && (stop || win)) {
            GameEngine.getInstance().restartLevel();
            return DEFAULT;
        }
        if (win) {
            return WIN;
        }
        if (move) {
            return MOVE;
        }
        if (stop) {
            return STOP;
        }
        return DEFAULT;
    }
}