package FinalProject;

import FinalProject.common.NotationType;
import FinalProject.common.UniversalFigure;
import FinalProject.game.*;

import java.util.*;

public class Chess {
    Board board;
    int moves;
    List<PlayersMove> notation;
    private Queue<UniversalFigure> figureQueue = new LinkedList<>();

    public Chess(Board board){
        notation = new ArrayList<PlayersMove>();
        this.board = board;
        int moves = 0;
        this.board.field[0][0].put(new Rook(true, this.board.field[0][0]));
        this.board.field[7][0].put(new Rook(true, this.board.field[7][0]));
        this.board.field[0][7].put(new Rook(false, this.board.field[0][7]));
        this.board.field[7][7].put(new Rook(false, this.board.field[7][7]));

        this.board.field[1][0].put(new Knight(true, this.board.field[1][0]));
        this.board.field[6][0].put(new Knight(true, this.board.field[6][0]));
        this.board.field[1][7].put(new Knight(false, this.board.field[1][7]));
        this.board.field[6][7].put(new Knight(false, this.board.field[6][7]));

        this.board.field[2][0].put(new Bishop(true, this.board.field[2][0]));
        this.board.field[5][0].put(new Bishop(true, this.board.field[5][0]));
        this.board.field[2][7].put(new Bishop(false, this.board.field[2][7]));
        this.board.field[5][7].put(new Bishop(false, this.board.field[5][7]));

        this.board.field[3][0].put(new Queen(true, this.board.field[3][0]));
        this.board.field[3][7].put(new Queen(false, this.board.field[3][7]));

        this.board.field[4][0].put(new King(false, this.board.field[4][0]));
        this.board.field[4][7].put(new King(false, this.board.field[4][7]));

        for(int i = 0; i < this.board.getSize(); i++){
            this.board.field[i][1].put(new Pawn(true, this.board.field[i][1]));
            this.board.field[i][6].put(new Pawn(false, this.board.field[i][6]));
        }

        for(int i = 0; i < this.board.getSize(); i++){
            for(int j = 0; j < this.board.getSize(); j++){
                this.figureQueue.add(this.board.field[i][j].get());
            }
        }
    }
        //call this when player moves figure manually
    public boolean manualMove(UniversalFigure figure, BoardField field){
        if (figure.canMove(field)){
            this.moves += 1;
            //if moves odd - white moving. Create PlayersMove and fill with white
            if (this.moves % 2 == 1){
                OneMove white = new OneMove(NotationType.Long, figure.getType(),
                        null, figure.getBoardField().getLocation(), field.getLocation());
                PlayersMove round = new PlayersMove(white, null);
                System.out.println("Debug");
                white.print();
                //TODO
                notation.add(round);
            }
            //black moving - get PlayersMove and add black
            else{
                OneMove black = new OneMove(NotationType.Long, figure.getType(),
                        null, figure.getBoardField().getLocation(), field.getLocation());
                PlayersMove round = notation.get(moves/2);
                round.setBlack(black);
            }
            this.move(figure,field);
            //test
            return true;
        }
        else{
            return false;
        }
    }

        //move figure
    public boolean move(UniversalFigure figure, BoardField field){
        if (figure.canMove(field)){
            figure.getBoardField().remove();
            figure.move(field);
            field.put(figure);
            return true;
        }
        return false;
    }
        //restart game - set figures to starting fields
    public void restart(){
        Queue<UniversalFigure> tmp = new LinkedList<>();

        Iterator<UniversalFigure> it = this.figureQueue.iterator();
        while(it.hasNext())  {
            tmp.add(it.next());
        }

        for(int i = 0; i < this.board.getSize(); i++){
            for(int j = 0; j < this.board.getSize(); j++){
                this.board.field[i][j].put(tmp.remove());
                if (this.board.field[i][j].get() != null){
                    this.board.field[i][j].get().move(this.board.field[i][j]);
                }
            }
        }
    }

    public void printBoard(){
        for(int i = 0; i < this.board.getSize(); i++){
            for(int j = 0; j < this.board.getSize(); j++){
                if (this.board.field[i][j].get() == null){
                    System.out.println("null");
                }
                else{
                    this.board.field[i][j].get().printState();
                }
            }
            System.out.println();
        }
    }

    public void printNotation(){
        int cnt = 1;
        for( PlayersMove playersMove : notation ) {
            OneMove white = playersMove.getWhite();
            OneMove black = playersMove.getBlack();
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
}
