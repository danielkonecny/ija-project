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
            this.playerMoveNotation(line);
            line = reader.getLine();
        }
    }

    public void playerMoveNotation(String line){
        OneMove move = new OneMove(null,null,null,null, null);
        System.out.print("Bily: "+this.getWhite(line)+ "  ");
        System.out.println("Cerny: "+this.getBlack(line));
        System.out.println();
    }

    public String getWhite(String line){
        String[] ss=line.split(" ");
        return ss[1];
    }

    public String getBlack(String line){
        String[] ss=line.split(" ");
        return ss[2];
    }

    public void getMoveFigure(String line){
        System.out.println(line.charAt(0));
    }

    public String removeFirstChar(String line){
        return line.substring(1);
    }
}
