package FinalProject.game;

import FinalProject.common.FigureType;
import FinalProject.common.NotationType;
import FinalProject.common.UniversalFigure;

import java.lang.reflect.Field;

public class OneMove {
    boolean white_player;
    NotationType type;
    FigureType figure;
    int source_col;         // In range 0-7.
    int source_row;         // In range 0-7.
    int destination_col;    // In range 0-7.
    int destination_row;    // In range 0-7.
    FigureType change;
    String special;

    public OneMove(boolean white_player, NotationType type, FigureType figure, int source_col, int source_row,
                   int destination_col, int destination_row, FigureType change, String special){
        this.white_player = white_player;
        this.type = type;
        this.figure = figure;
        this.source_col = source_col;
        this.source_row = source_row;
        this.destination_col = destination_col;
        this.destination_row = destination_row;
        this.change = change;
        this.special = special;
    }

    public boolean getWhitePlayer() {
        return white_player;
    }

    public FigureType getFigure() {
        return figure;
    }

    public int getSourceCol() {
        return source_col;
    }

    public int getSourceRow() {
        return source_row;
    }

    public int getDestinationCol() {
        return destination_col;
    }

    public int getDestinationRow() {
        return destination_row;
    }

    public void print(){
        System.out.println("Bily hrac: " + this.white_player);
        if(this.type != null) {
            System.out.println("Notace: " + this.type.name());
        }
        if(this.figure != null) {
            System.out.println("Figurka: " + this.figure.name());
        }
        if(this.source_col != -1) {
            System.out.println("From col: " + getCol(this.source_col));
        }
        if(this.source_row != -1) {
            System.out.println("From row: " + getRow(this.source_row));
        }
        if(this.destination_col != -1) {
            System.out.println("To col: " + getCol(this.destination_col));
        }
        if(this.destination_row != -1) {
            System.out.println("To row: " + getRow(this.destination_row));
        }
        if(this.change != null) {
            System.out.println("Change: " + this.change.name());
        }
        if(this.special != null) {
            System.out.println("Special: " + this.special);
        }
        System.out.println();
    }

    public String printOnRow(){
        String ret = "";
        if(this.figure != null) {
            ret+= this.figure;
        }
        if(this.source_col != -1) {
            ret += getCol(this.source_col);
        }
        if(this.source_row != -1) {
            ret += getRow(this.source_row);
        }
        if(this.destination_col != -1) {
            ret += getCol(this.destination_col);
        }
        if(this.destination_row != -1) {
            ret += getRow(this.destination_row);
        }
        if(this.change != null) {
            ret += this.change;
        }
        if(this.special != null) {
            ret += this.special;
        }
        return ret;
    }

    private String getCol(int col) {
        return Character.toString((char)(col + 65));
    }

    private String getRow(int row) {
        return Integer.toString(row + 1);
    }
}
