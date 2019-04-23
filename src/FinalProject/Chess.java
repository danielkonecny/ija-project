package FinalProject;

import FinalProject.common.NotationType;
import FinalProject.common.UniversalFigure;
import FinalProject.game.*;

import java.util.*;

public class Chess {
    Board board;
    List<OneMove> notation;
    private Queue<UniversalFigure> figureQueue = new LinkedList<>();

    public Chess(Board board){
        this.notation = new ArrayList<>();
        this.board = board;
        this.board.field[0][0].setFigure(new Rook(this.board.field[0][0], true));
        this.board.field[7][0].setFigure(new Rook(this.board.field[7][0], true));
        this.board.field[0][7].setFigure(new Rook(this.board.field[0][7], false));
        this.board.field[7][7].setFigure(new Rook(this.board.field[7][7], false));

        this.board.field[1][0].setFigure(new Knight(this.board.field[1][0], true));
        this.board.field[6][0].setFigure(new Knight(this.board.field[6][0], true));
        this.board.field[1][7].setFigure(new Knight(this.board.field[1][7], false));
        this.board.field[6][7].setFigure(new Knight(this.board.field[6][7], false));

        this.board.field[2][0].setFigure(new Bishop(this.board.field[2][0], true));
        this.board.field[5][0].setFigure(new Bishop(this.board.field[5][0], true));
        this.board.field[2][7].setFigure(new Bishop(this.board.field[2][7], false));
        this.board.field[5][7].setFigure(new Bishop(this.board.field[5][7], false));

        this.board.field[3][0].setFigure(new Queen(this.board.field[3][0], true));
        this.board.field[3][7].setFigure(new Queen(this.board.field[3][7], false));

        this.board.field[4][0].setFigure(new King(this.board.field[4][0], false));
        this.board.field[4][7].setFigure(new King(this.board.field[4][7], false));

        for(int i = 0; i < this.board.getSize(); i++){
            this.board.field[i][1].setFigure(new Pawn(this.board.field[i][1], true));
            this.board.field[i][6].setFigure(new Pawn(this.board.field[i][6], false));
        }

        for(int i = 0; i < this.board.getSize(); i++){
            for(int j = 0; j < this.board.getSize(); j++){
                this.figureQueue.add(this.board.field[i][j].getFigure());
            }
        }
    }

    // Call this when player moves figure manually.
    public boolean manualMove(UniversalFigure figure, BoardField field){
        if(figure.canMove(field)){
            int index = this.notation.size();
            OneMove move = new OneMove(index % 2 == 0, NotationType.Long, figure.getType(),null,
                    figure.getBoardField().getLocation(), field.getLocation(), null, null);
            notation.add(move);
            this.moveFigure(figure, field);
            return true;
        }
        else {
            return false;
        }
    }

    private void moveFigure(UniversalFigure figure, BoardField field){
        figure.getBoardField().setFigure(null);
        figure.setBoardField(field);
        field.setFigure(figure);
    }

    public void restartGame(){
        Queue<UniversalFigure> tmp = new LinkedList<>();

        Iterator<UniversalFigure> it = this.figureQueue.iterator();
        while(it.hasNext())  {
            tmp.add(it.next());
        }

        for(int i = 0; i < this.board.getSize(); i++){
            for(int j = 0; j < this.board.getSize(); j++){
                this.board.field[i][j].setFigure(tmp.remove());
                if (this.board.field[i][j].getFigure() != null){
                    this.board.field[i][j].getFigure().setBoardField(this.board.field[i][j]);
                }
            }
        }
    }

    public void printBoard(){
        for(int i = 0; i < this.board.getSize(); i++){
            for(int j = 0; j < this.board.getSize(); j++){
                if (this.board.field[i][j].getFigure() == null){
                    System.out.println("null");
                }
                else{
                    this.board.field[i][j].getFigure().printState();
                }
            }
            System.out.println();
        }
    }

    /*
    public void debugNotation(){
        int cnt = 1;
        for(OneMove one_move: notation ) {
            if (one_move == null){
                return;
            }
            OneMove white = one_move;
            OneMove black = one_move;
            System.out.println("Poradi kola: " + cnt);
            cnt += 1;
            if(white != null){
                System.out.println("White");
                white.print();
            }
            if(black != null){
                System.out.println("Black");
                black.print();
            }
        }
    }
    */

    void parseNotations(String file){
        ParseNotations parser = new ParseNotations();
        this.notation = parser.parse(file);
    }

    //user-friendly variant of printNotation
    void printNotation(){
        int index = 0;
        while(index < this.notation.size()) {
            String output = Integer.toString(index / 2 + 1);
            output += ". ";
            output += this.notation.get(index).printOnRow();
            index += 1;
            if(index < this.notation.size()) {
                output += " ";
                output += this.notation.get(index).printOnRow();
                index += 1;
            }
            System.out.println(output);
        }
    }

    public void clearListFrom(int pos){
        for(int i = pos; i < notation.size(); i++){
            notation.set(i,null);
        }
    }
}
