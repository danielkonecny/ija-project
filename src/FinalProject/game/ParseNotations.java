package FinalProject.game;

import FinalProject.common.FigureType;
import FinalProject.common.NotationType;

import java.util.ArrayList;
import java.util.List;

public class ParseNotations {
    public ParseNotations(){
    }

    public List<OneMove> parse(String file){
        List<OneMove> notation = new ArrayList<>();
        ReadFile reader = new ReadFile(file);
        String line = reader.getLine();
        while(line != null){
            //System.out.println(line);
            String[] parsed_line = line.split(" ");
            if(parsed_line.length < 2) {
                System.err.println("Spatny zapis notace.");
                System.exit(1);
            }
            notation.add(parseMove(parsed_line[1], true));
            notation.add(parseMove(parsed_line[2], false));
            line = reader.getLine();
        }
        return notation;
    }

    private OneMove parseMove(String moveStr, boolean white_player){
        OneMove move = new OneMove(white_player,null,null,
                null,null, null, null, null);
        int res = getMoveFigure(moveStr, move);
        moveStr = moveStr.substring(res);
        res = getMoveDifference(moveStr, move);
        moveStr = moveStr.substring(res);
        res = getFromTo(moveStr, move);
        moveStr = moveStr.substring(res);
        res = getChange(moveStr, move);
        moveStr = moveStr.substring(res);
        getSpecial(moveStr, move);
        return move;
    }

    private int getMoveFigure(String line, OneMove move){
        if(isUppercaseLetter(line.charAt(0))) {
            move.figure = FigureType.valueOf(Character.toString(line.charAt(0)));
            return 1;
        }
        else {
            move.figure = FigureType.p;
            return 0;
        }
    }

    private int getMoveDifference(String line, OneMove move){
        if((isLowercaseLetter(line.charAt(0)) || isDigit(line.charAt(0))) && isLowercaseLetter(line.charAt(1))) {
            move.difference = Character.toString(line.charAt(0));
            return 1;
        }
        return 0;
    }

    private boolean isUppercaseLetter(char letter){
        return (Character.isLetter(letter) && Character.isUpperCase(letter));
    }

    private boolean isLowercaseLetter(char letter){
        return (Character.isLetter(letter) && Character.isLowerCase(letter));
    }

    private boolean isDigit(char letter){
        return (Character.isDigit(letter));
    }

    private int getFromTo(String line, OneMove move){
        // Loading from and to
        if(line.length() > 3){
            if(isLowercaseLetter(line.charAt(0)) &&
                    isDigit(line.charAt(1)) &&
                    isLowercaseLetter(line.charAt(2)) &&
                    isDigit(line.charAt(3))) {
                move.from = line.substring(0,2);
                move.to = line.substring(2,4);
                move.type = NotationType.Long;
                return 4;
            }
        }
        // Loading only to
        else if(line.length() > 1){
            move.to = line.substring(0,2);
            move.type = NotationType.Short;
            return 2;
        }
        System.exit(1);
        return 0;
    }

    private int getChange(String line, OneMove move) {
        if(line.length() > 0) {
            if(isUppercaseLetter(line.charAt(0))) {
                move.change = FigureType.valueOf(line.substring(0,1));
                return 1;
            }
        }
        return 0;
    }

    private int getSpecial(String line, OneMove move){
        if(line.length() > 0){
            move.special = line.substring(0,1);
            return 1;
        }
        return 0;
    }
}
