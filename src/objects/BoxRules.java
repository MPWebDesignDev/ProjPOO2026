package objects;

import java.util.List;
import pt.iscte.poo.game.GameEngine;
import pt.iscte.poo.gui.ImageTile;
import pt.iscte.poo.utils.Direction;
import pt.iscte.poo.utils.Point2D;

public enum BoxRules {

    DEFAULT, WIN, MOVE, STOP; //Possible conditions for the enum

    private static final Direction[] DIRS = { Direction.RIGHT, Direction.DOWN }; //Keeps frase logic intact

    private static boolean hasWord(List<ImageTile> objects, Point2D pos, Class<? extends WordObject> type) {
        if (objects == null || pos == null) {
            return false;
        }
        for (ImageTile obj : objects) { //Goes over all the existing objects
            if (obj != null && type.isInstance(obj) && pos.equals(obj.getPosition())) { //
                return true;
            }
        }
        return false;
    }

    public static BoxRules fromRoom(List<ImageTile> objects) {
        if (objects == null) { //Base case for no objects
            return DEFAULT;
        }

        boolean win = false;
        boolean move = false;
        boolean stop = false; //All conditions starts as false until the sentence is made

        for (ImageTile obj : objects) {
            if (!(obj instanceof WordBox)) {
                continue;
            }

            Point2D pos = obj.getPosition(); //Gets objects position

            for (Direction d : DIRS) { //Checks for logic behind the formed phrase
                Point2D isPos = pos.plus(d.asVector()); //Checks if is is next in line
                Point2D propPos = isPos.plus(d.asVector()); //Checks if proposition is nect in line

                if (hasWord(objects, isPos, WordIs.class)) { //Checks only if IS is present
                    if (hasWord(objects, propPos, WordWin.class)) {
                        win = true;
                    }
                    if (hasWord(objects, propPos, WordMove.class)) {
                        move = true;
                    }
                    if (hasWord(objects, propPos, WordStop.class)) {
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