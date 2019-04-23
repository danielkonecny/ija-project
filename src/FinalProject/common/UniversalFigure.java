package FinalProject.common;

import FinalProject.game.BoardField;

public abstract class UniversalFigure {
    private BoardField boardField;
    private boolean white;

    public UniversalFigure(boolean white, BoardField boardField) {
        this.boardField = boardField;
        this.white = white;
    }

    public BoardField getBoardField() {
        return this.boardField;
    }

    protected boolean isWhite() {
        return this.white;
    }

    public void assignBoardField(BoardField boardField, boolean white) {
        this.boardField = boardField;
        this.white = white;
    }

        //set figure's boardField
    public void move(BoardField boardField){
        this.boardField = boardField;
    }

        //returns figure's position
    private String getPosition() {
        return getBoardField().getCol() + ":" + getBoardField().getRow();
    }

    public void printState() {
        String state = getType();
        if(isWhite()) {
            state += "[W]";
        }
        else {
            state += "[B]";
        }
        state += getPosition();
        System.out.println(state);
    }

    public void removeBoardField(){
        this.boardField = null;
    }

    public abstract boolean canMove(BoardField boardField);

    public abstract String getType();


}