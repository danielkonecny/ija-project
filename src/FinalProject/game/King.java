package FinalProject.game;

import FinalProject.common.UniversalFigure;

public class King extends UniversalFigure {
    public King(boolean white, BoardField boardField) {
        super(white, boardField);
    }

    public boolean canMove(BoardField boardField){
        return true;
    }

    public String getType() {
        return "K";
    }
}
