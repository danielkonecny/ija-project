package FinalProject;

import FinalProject.common.NotationType;
import FinalProject.common.UniversalFigure;
import FinalProject.game.*;

import java.util.*;

public class Chess {
    private Board board;
    private List<OneMove> notation;
    private Queue<UniversalFigure> figureQueue = new LinkedList<>();

    Chess(Board board){
        this.notation = new ArrayList<>();
        this.board = board;
        this.board.getBoard()[0][0].setFigure(new Rook(this.board.getBoard()[0][0], true));
        this.board.getBoard()[7][0].setFigure(new Rook(this.board.getBoard()[7][0], true));
        this.board.getBoard()[0][7].setFigure(new Rook(this.board.getBoard()[0][7], false));
        this.board.getBoard()[7][7].setFigure(new Rook(this.board.getBoard()[7][7], false));

        this.board.getBoard()[1][0].setFigure(new Knight(this.board.getBoard()[1][0], true));
        this.board.getBoard()[6][0].setFigure(new Knight(this.board.getBoard()[6][0], true));
        this.board.getBoard()[1][7].setFigure(new Knight(this.board.getBoard()[1][7], false));
        this.board.getBoard()[6][7].setFigure(new Knight(this.board.getBoard()[6][7], false));

        this.board.getBoard()[2][0].setFigure(new Bishop(this.board.getBoard()[2][0], true));
        this.board.getBoard()[5][0].setFigure(new Bishop(this.board.getBoard()[5][0], true));
        this.board.getBoard()[2][7].setFigure(new Bishop(this.board.getBoard()[2][7], false));
        this.board.getBoard()[5][7].setFigure(new Bishop(this.board.getBoard()[5][7], false));

        this.board.getBoard()[3][0].setFigure(new Queen(this.board.getBoard()[3][0], true));
        this.board.getBoard()[3][7].setFigure(new Queen(this.board.getBoard()[3][7], false));

        this.board.getBoard()[4][0].setFigure(new King(this.board.getBoard()[4][0], true));
        this.board.getBoard()[4][7].setFigure(new King(this.board.getBoard()[4][7], false));

        for(int i = 0; i < this.board.getSize(); i++){
            this.board.getBoard()[i][1].setFigure(new Pawn(this.board.getBoard()[i][1], true));
            this.board.getBoard()[i][6].setFigure(new Pawn(this.board.getBoard()[i][6], false));
        }

        for(int i = 0; i < this.board.getSize(); i++){
            for(int j = 0; j < this.board.getSize(); j++){
                this.figureQueue.add(this.board.getBoard()[i][j].getFigure());
            }
        }
    }

    // Call this when moves are performed automatically.
    public boolean automaticMove(OneMove move){
        UniversalFigure figure = getFigureFromNotation(move);
        BoardField field = getFieldFromNotation(move);
        if(figure != null){
            moveFigure(figure, field);
            return true;
        }
        else {
            return false;
        }
    }

    private UniversalFigure getFigureFromNotation(OneMove move) {
        ArrayList<UniversalFigure> figures = board.getFiguresOfType(move.getFigure(), move.getWhitePlayer());
        for(UniversalFigure figure: figures) {
            if(figure.canMove(board.getField(move.getDestinationCol(), move.getDestinationRow()))) {
                if((move.getSourceCol() == -1 || move.getSourceCol() == figure.getBoardField().getCol()) &&
                        (move.getSourceRow() == -1 || move.getSourceRow() == figure.getBoardField().getRow())) {
                    return figure;
                }
            }
        }
        return null;
    }

    private BoardField getFieldFromNotation(OneMove move) {
        return this.board.getField(move.getDestinationCol(), move.getDestinationRow());
    }

    // Call this when player moves figure manually.
    public boolean manualMove(UniversalFigure figure, BoardField field){
        if(figure.canMove(field)){
            int index = this.notation.size();   // TODO - nebude se pocitat jako konec pole, ale podle aktualni pozice v pruchodu notaci
            // TODO - smazat nasledujici notaci
            OneMove move = new OneMove(index % 2 == 0, NotationType.Long, figure.getType(),
                    figure.getBoardField().getCol(), figure.getBoardField().getRow(),
                    field.getCol(), field.getRow(),null, null);
            notation.add(move);
            moveFigure(figure, field);
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
        Queue<UniversalFigure> tmp = new LinkedList<>(this.figureQueue);

        /* Zkratil jsem, ale nevim, jestli funguje, prijde mi, ze to nemuze fungovat, ani v puvodnim pripade, protoze ta fronta nebude naplnena.
        Queue<UniversalFigure> tmp = new LinkedList<>();
        Iterator<UniversalFigure> it = this.figureQueue.iterator();
        while(it.hasNext())  {
            tmp.add(it.next());
        }
        */

        for(int i = 0; i < this.board.getSize(); i++){
            for(int j = 0; j < this.board.getSize(); j++){
                this.board.getBoard()[i][j].setFigure(tmp.remove());
                if (this.board.getBoard()[i][j].getFigure() != null){
                    this.board.getBoard()[i][j].getFigure().setBoardField(this.board.getBoard()[i][j]);
                }
            }
        }
    }

    public void printBoard(){
        for(int i = 0; i < this.board.getSize(); i++){
            for(int j = 0; j < this.board.getSize(); j++){
                if (this.board.getBoard()[i][j].getFigure() == null){
                    System.out.println("null");
                }
                else{
                    this.board.getBoard()[i][j].getFigure().printState();
                }
            }
            System.out.println();
        }
    }

    public void debugNotation(){
        for(OneMove move: notation) {
            move.print();
        }
    }

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
