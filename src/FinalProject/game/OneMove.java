package FinalProject.game;

import FinalProject.common.FigureType;
import FinalProject.common.NotationType;
import FinalProject.common.UniversalFigure;

import java.lang.reflect.Field;

public class OneMove {
    boolean white_player;
    NotationType type;
    FigureType figure;
    String difference; //pokud je konflikt pri kratke notaci urcuje sloupec nebo radek
    String from;
    String to;
    FigureType change;
    String special;

    public OneMove(boolean white_player, NotationType type, FigureType figure, String difference,
                   String from, String to, FigureType change, String special){
        this.white_player = white_player;
        this.type = type;
        this.figure = figure;
        this.difference = difference;
        this.from = from;
        this.to = to;
        this.change = change;
        this.special = special;
    }

    public void print(){
        System.out.println("Bily hrac: " + this.white_player);
        System.out.println("Typ: " + this.type.name());
        System.out.println("Figurka: " + this.figure.name());
        System.out.println("Difference: " + this.difference);
        System.out.println("From: " + this.from);
        System.out.println("To: " + this.to);
        System.out.println("Change: " + this.change.name());
        System.out.println("Special: " + this.special);
        System.out.println();
    }

    public String printOnRow(){
        String ret = "";
        if (this.figure != null) ret+= this.figure;
        if (this.difference != null) ret+= this.difference;
        if (this.from != null) ret+= this.from;
        if (this.to != null) ret+= this.to;
        if (this.change != null) ret+= this.change;
        if (this.special != null) ret+= this.special;
        return ret;
    }
}
