package FinalProject.game;

import FinalProject.common.UniversalFigure;

public class Pawn extends UniversalFigure {
    public Pawn(boolean white, BoardField boardField) {
        super(white, boardField);
    }

    public String getType() {
        return "P";
    }

    public boolean canMove(BoardField destination) {
        BoardField source = this.getBoardField();
        // Move figure forward.
        if(destination.isEmpty()) {
            // White can move only up.
            if(this.isWhite()) {
                return destination.getCol() == source.getCol() && destination.getRow() == source.getRow()+1;
            }
            // Black can move only down.
            else {
                return destination.getCol() == source.getCol() && destination.getRow() == source.getRow()-1;
            }
        }
        // Capture opponent's figure.
        else {
            // White can move only up.
            if(this.isWhite()) {
                return  destination.getCol() == source.getCol()+1 && destination.getRow() == source.getRow()+1 ||
                        destination.getCol() == source.getCol()-1 && destination.getRow() == source.getRow()+1;
            }
            // Black can move only down.
            else {
                return  destination.getCol() == source.getCol()+1 && destination.getRow() == source.getRow()-1 ||
                        destination.getCol() == source.getCol()-1 && destination.getRow() == source.getRow()-1;
            }
        }
    }
}
