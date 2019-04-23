package FinalProject.game;

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
        OneMove whiteMove = new OneMove(null,null,null,null, null);
        OneMove blackMove = new OneMove(null,null,null,null, null);
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
        getMoveFigure(moveStr, move);
    }

    private void getMoveFigure(String line, OneMove move){
        if ((Character.isLetter(line.charAt(0))) && (Character.isUpperCase(line.charAt(0)))){
            //System.out.println("Je velky pismeno");
            move.figure = Character.toString(line.charAt(0));
        }
    }

    //private void getFromTo(String line, )

    public String removeFirstChar(String line){
        return line.substring(1);
    }
}
