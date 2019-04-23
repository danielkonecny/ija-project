package FinalProject.game;

import FinalProject.common.UniversalFigure;

public class Queen extends UniversalFigure {
    public Queen(boolean white, BoardField boardField) {
        super(white, boardField);
    }

    public String getType() {
        return "D";
    }

    public boolean canMove(BoardField boardField) {  // TODO
        return true;
    }
}
