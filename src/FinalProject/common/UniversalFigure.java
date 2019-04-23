package FinalProject.common;

import FinalProject.game.Board;
import FinalProject.game.BoardField;

public abstract class UniversalFigure {
    private BoardField boardField;
    private FigureType type;
    private boolean white;

    public UniversalFigure(BoardField boardField, boolean white, FigureType type) {
        this.boardField = boardField;
        this.white = white;
        this.type = type;
    }

    public BoardField getBoardField() {
        return this.boardField;
    }

    public void setBoardField(BoardField boardField){
        this.boardField = boardField;
    }

    protected boolean isWhite() {
        return this.white;
    }

    public FigureType getType() {
        return type;
    }

    public void assignBoardField(BoardField boardField, boolean white) {
        this.boardField = boardField;
        this.white = white;
    }

        //returns figure's position
    private String getPosition() {
        return getBoardField().getCol() + ":" + getBoardField().getRow();
    }

    public void printState() {
        String state = getType().name();
        if(isWhite()) {
            state += "[W]";
        }
        else {
            state += "[B]";
        }
        state += getPosition();
        System.out.println(state);
    }

    protected boolean checkWay(int start_col, int start_row,
                             int end_col, int end_row,
                             int change_col, int change_row) {
        Board board = this.getBoardField().getBoard();
        for(int col = start_col + change_col, row = start_row + change_row;
            col <= end_col && row <= end_row;
            col += change_col, row += change_row) {
            if(!board.getField(col, row).isEmpty() && col != end_col && row != end_row) {
                return false;
            }
        }
        return true;
    }

    public void removeBoardField(){
        this.boardField = null;
    }

    public abstract boolean canMove(BoardField boardField);
}