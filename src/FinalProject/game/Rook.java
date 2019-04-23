package FinalProject.game;

import FinalProject.common.UniversalFigure;

public class Rook extends UniversalFigure {
    public Rook(boolean white, BoardField boardField) {
        super(white, boardField);
    }

    public String getType() {
        return "V";
    }

    public boolean canMove(BoardField destination) {  // TODO
        BoardField source = this.getBoardField();

        if(destination.getCol() == source.getCol()) {
            if(destination.getRow() < source.getRow()) {
                for(int row = destination.getRow()+1; row < source.getRow(); row++) {
                    if(!destination.getBoard().getField(destination.getCol(), row).isEmpty()) {
                        return false;
                    }
                }
            }
            else if(destination.getRow() > source.getRow()) {
                for(int row = source.getRow()+1; row < destination.getRow(); row++) {
                    if(!destination.getBoard().getField(destination.getCol(), row).isEmpty()) {
                        return false;
                    }
                }
            }
            else {
                return false;
            }
            return true;
        }
        else if(destination.getRow() == source.getRow()) {
            if(destination.getCol() < source.getCol()) {
                for(int col = destination.getCol()+1; col < source.getCol(); col++) {
                    if(!destination.getBoard().getField(col, destination.getRow()).isEmpty()) {
                        return false;
                    }
                }
            }
            else if(destination.getCol() > source.getCol()) {
                for(int col = source.getCol()+1; col < destination.getCol(); col++) {
                    if(!destination.getBoard().getField(col, destination.getRow()).isEmpty()) {
                        return false;
                    }
                }
            }
            else {
                return false;
            }
            return true;
        }
        else {
            return false;
        }
    }
}
