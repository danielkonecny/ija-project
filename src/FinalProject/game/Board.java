package FinalProject.game;

public class Board {
    public BoardField[][] field;

    //constructor
    public Board(int size){
        this.field = new BoardField[size][size];
        for(int col = 0; col < getSize(); col++) {
            for(int row = 0; row < getSize(); row++) {
                this.field[col][row] = new BoardField(this, col, row);
            }
        }
    }

        //returns field on position
    public BoardField getField(int col, int row) {
        if(col >= 1 && col <= getSize() && row >=1 && row <= getSize()) {
            return this.field[col-1][row-1];
        }
        return null;
    }

        //returns size of array
    public int getSize(){
        if(field != null && field[0] != null) {
            return field[0].length;
        }
        return 0;
    }
}
