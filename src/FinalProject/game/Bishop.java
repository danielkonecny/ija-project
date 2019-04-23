package FinalProject.game;

import FinalProject.common.UniversalFigure;

public class Bishop extends UniversalFigure {
    public Bishop(boolean white, BoardField boardField) {
        super(white, boardField);
    }

    public boolean canMove(BoardField boardField){
        return true;
    }

    public String getType() {
        return "S";
    }
}
