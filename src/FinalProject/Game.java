package FinalProject;

import FinalProject.game.Board;

public class Game {
    public static void main(String[] args) {
        Board board = new Board(8);
        Chess chess = new Chess(board);

        if(args.length != 1) {
            System.err.println("Dej si do Run->Edit Configuration->Program arguments -> ./input.txt");
            System.exit(1);
        }

        chess.printBoardReadable();
        chess.loadFile(args[0]);
        chess.printNotation();

        for(int i = 0; i < chess.getMoves().size(); i++){
            chess.performMove();
        }

        chess.printBoardReadable();
    }
}
