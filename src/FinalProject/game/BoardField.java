package FinalProject.game;

import FinalProject.common.UniversalFigure;

public class BoardField {
    private Board board;
    private UniversalFigure figure;
    private int col;
    private int row;

        //construktor
    BoardField(Board board, int col, int row){
        this.board = board;
        this.col = col;
        this.row = row;
    }

    Board getBoard() {
        return this.board;
    }

    //returns figure on board
    public UniversalFigure get(){
        return this.figure;
    }

        //put figure on board
    public UniversalFigure put(UniversalFigure figure){
        return this.figure = figure;
    }

        //return col
    public int getCol() {
        return this.col+1;
    }

        //return row
    public int getRow() {
        return this.row+1;
    }

        //if empty returns true
    boolean isEmpty() {
        return this.figure == null;
    }

        //removes figure from board and set figure's board to null
    public void remove() { //myslim ze neni potreba kontrolovat jestli je to empty a jestli tam je spravna figurka
        this.figure = null;
    }

    public String getLocation(){
        String ret = String.valueOf((char)(row + 64));
        ret = ret + (col + 1);
        return ret;
    }
}


