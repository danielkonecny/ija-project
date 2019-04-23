package FinalProject.game;

import FinalProject.common.UniversalFigure;

public class Knight extends UniversalFigure {
    public Knight(boolean white, BoardField boardField) {
        super(white, boardField);
    }

    public boolean canMove(BoardField boardField){
        return true;
    }

    public String getType() {
        return "J";
    }
}
