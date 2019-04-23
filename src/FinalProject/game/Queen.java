package FinalProject.game;

import FinalProject.common.UniversalFigure;

public class Queen extends UniversalFigure {
    public Queen(boolean white, BoardField boardField) {
        super(white, boardField);
    }

    public boolean canMove(BoardField boardField){
        return true;
    }

    public String getType() {
        return "D";
    }
}
