package FinalProject.game;

import FinalProject.common.NotationType;

import java.util.List;

public class ParseNonations {
    public ParseNonations(){
    }

    public void parse(List<PlayersMove> notation, String file){
        ReadFile reader = new ReadFile(file);
        String line = reader.getLine();
        while(line != null){
            //System.out.println(line);
            notation.add(this.playersMoveNotation(line));
            line = reader.getLine();
        }
    }

            //gets one line and parse it to structure
    private PlayersMove playersMoveNotation(String line){
        OneMove whiteMove = new OneMove(null,null,null,null, null, null, null);
        OneMove blackMove = new OneMove(null,null,null,null, null, null, null);
        PlayersMove playersMove = new PlayersMove(null, null);
        //System.out.print("Bily: "+this.getWhite(line)+ "  ");
        //System.out.println("Cerny: "+this.getBlack(line));
        //System.out.println();
        String whiteStr = this.getWhite(line);
        String blackStr = this.getBlack(line);

        this.parseMove(whiteStr, whiteMove);
        this.parseMove(blackStr, blackMove);

        playersMove.setBlack(blackMove);
        playersMove.setWhite(whiteMove);

        return playersMove;

    }

    private String getWhite(String line){
        String[] ss=line.split(" ");
        if (ss.length < 2){
            System.err.println("Spatny zapis notace.");
            System.exit(1);
        }
        return ss[1];
    }

    private String getBlack(String line){
        String[] ss=line.split(" ");
        if (ss.length < 2){
            System.err.println("Spatny zapis notace.");
            System.exit(1);
        }
        return ss[2];
    }

    private void parseMove(String moveStr, OneMove move){
        int res = getMoveFigure(moveStr, move);
        moveStr = moveStr.substring(res);
        res = getMoveDifference(moveStr, move);
        moveStr = moveStr.substring(res);
        res = getFromTo(moveStr, move);
        moveStr = moveStr.substring(res);
        res = getChange(moveStr, move);
        moveStr = moveStr.substring(res);
        res = getSpecial(moveStr, move);
        moveStr = moveStr.substring(res);

    }

    private int getMoveFigure(String line, OneMove move){
        if (isUppercaseLetter(line.charAt(0))){
            //System.out.println("Je velky pismeno");
            move.figure = Character.toString(line.charAt(0));
            return 1;
        }
        return 0;
    }

    private int getMoveDifference(String line, OneMove move){
        if ((isLowercaseLetter(line.charAt(0)) || isDigit(line.charAt(0))) && isLowercaseLetter(line.charAt(1))){
            move.difference = Character.toString(line.charAt(0));
            return 1;
        }
        return 0;
    }

    private boolean isUppercaseLetter(char letter){
        return ((Character.isLetter(letter)) && (Character.isUpperCase(letter)));
    }

    private boolean isLowercaseLetter(char letter){
        return ((Character.isLetter(letter)) && (Character.isLowerCase(letter)));
    }

    private boolean isDigit(char letter){
        return (Character.isDigit(letter));
    }
    private int getFromTo(String line, OneMove move){
        if(line.length() > 3){
            if(isLowercaseLetter(line.charAt(0)) && isDigit(line.charAt(1)) && isLowercaseLetter(line.charAt(2))
                    && isDigit(line.charAt(3))){
                //loading from and to
                move.from = line.substring(0,2);
                move.to = line.substring(2,4);
                move.type = NotationType.Long;
                return 4;
            }
        }
        if(line.length() > 1){
            //loading only to
            move.to = line.substring(0,2);
            move.type = NotationType.Short;
            return 2;
        }
        System.exit(1);
        return 0;
    }

    private int getChange(String line, OneMove move){
        if(line.length() > 0){
            if(isUppercaseLetter(line.charAt(0))){
                move.change = line.substring(0,1);
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

    public String removeFirstChar(String line){
        return line.substring(1);
    }
}
