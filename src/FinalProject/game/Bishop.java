package FinalProject.game;

import FinalProject.common.UniversalFigure;

public class Bishop extends UniversalFigure {
    public Bishop(boolean white, BoardField boardField) {
        super(white, boardField);
    }

    public String getType() {
        return "S";
    }

    public boolean canMove(BoardField boardField) {  // TODO
        return true;
    }
}
