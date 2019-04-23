package FinalProject.game;

import FinalProject.common.UniversalFigure;

public class King extends UniversalFigure {
    public King(boolean white, BoardField boardField) {
        super(white, boardField);
    }

    public String getType() {
        return "K";
    }

    public boolean canMove(BoardField destination) {
        BoardField source = this.getBoardField();
        return  destination.getCol() == source.getCol()   && destination.getRow() == source.getRow()+1 ||
                destination.getCol() == source.getCol()+1 && destination.getRow() == source.getRow()+1 ||
                destination.getCol() == source.getCol()+1 && destination.getRow() == source.getRow()   ||
                destination.getCol() == source.getCol()+1 && destination.getRow() == source.getRow()-1 ||
                destination.getCol() == source.getCol()   && destination.getRow() == source.getRow()-1 ||
                destination.getCol() == source.getCol()-1 && destination.getRow() == source.getRow()-1 ||
                destination.getCol() == source.getCol()-1 && destination.getRow() == source.getRow()   ||
                destination.getCol() == source.getCol()-1 && destination.getRow() == source.getRow()+1;
    }
}
