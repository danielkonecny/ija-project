package FinalProject.game;

import FinalProject.common.NotationType;
import FinalProject.common.UniversalFigure;

import java.lang.reflect.Field;

public class OneMove {
    NotationType type;
    String figure;
    String difference; //pokud je konflikt pri kratke notaci urcuje sloupec nebo radek
    String from;
    String to;

    public OneMove(NotationType type, String figure, String difference, String from, String to){
        this.type = type;
        this.figure = figure;
        this.difference = difference;
        this.from = from;
        this.to = to;
    }

    public void print(){
        System.out.println("Typ: "+this.type);
        System.out.println("Figurka: "+this.figure);
        System.out.println("Difference: "+this.difference);
        System.out.println("From: "+this.from);
        System.out.println("To: "+this.to);
        System.out.println();
    }
}