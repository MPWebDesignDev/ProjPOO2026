package objects;

import pt.iscte.poo.gui.ImageTile;
import pt.iscte.poo.utils.Direction;
import pt.iscte.poo.utils.Point2D;


import java.util.Random;

public class Baba implements ImageTile {
    private Point2D position;
    private String direction = "r";

    public Baba(Point2D position) {
        this.position = position;
    }

    @Override
    public String getName() {
        return "baba-" + direction;
    }

    @Override
    public Point2D getPosition() {
        return position;
    }

    @Override
    public int getLayer() {
        return 10;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }


    public void move(Direction d) {
        if (d != null) {
            // Atualiza a direção com base na tecla premida (converte UP para "u", DOWN para "d", etc.)
            this.direction = d.name().substring(0, 1).toLowerCase();

            // Atualiza a posição somando o vetor correspondente à direção
            this.position = this.position.plus(d.asVector());
        }
    }

}
