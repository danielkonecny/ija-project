package FinalProject.game;

import FinalProject.common.UniversalFigure;

public class Pawn extends UniversalFigure {
    public Pawn(boolean white, BoardField boardField) {
        super(white, boardField);
    }

    public boolean canMove(BoardField destination){
        // Move figure forward.
        if(destination.isEmpty()) {
            if(this.isWhite()) {
                return destination.getCol() == this.getBoardField().getCol() && destination.getRow() == this.getBoardField().getRow()+1;
            }
            else {
                return destination.getCol() == this.getBoardField().getCol() && destination.getRow() == this.getBoardField().getRow()-1;
            }
        }
        // Capture opponent's figure.
        else {
            if(this.isWhite()) {
                return destination.getCol() == this.getBoardField().getCol()+1 && destination.getRow() == this.getBoardField().getRow()+1 ||
                        destination.getCol() == this.getBoardField().getCol()-1 && destination.getRow() == this.getBoardField().getRow()+1;
            }
            else {
                return destination.getCol() == this.getBoardField().getCol()+1 && destination.getRow() == this.getBoardField().getRow()-1 ||
                        destination.getCol() == this.getBoardField().getCol()-1 && destination.getRow() == this.getBoardField().getRow()-1;
            }
        }
    }

    public String getType() {
        return "P";
    }
}
