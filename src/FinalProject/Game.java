package FinalProject;

import FinalProject.common.UniversalFigure;
import FinalProject.game.Board;
import FinalProject.game.BoardField;
import FinalProject.game.ReadFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Game {
    public static void main(String[] args) {
        Board board = new Board(8);
        Chess chess = new Chess(board);

            //Filip test===================================u666
//        chess.printBoard();
//
//        System.out.println("==========================================================");
//
//        BoardField boardField = board.field[0][2];
//        UniversalFigure figure = board.field[0][1].get();
//        //chess.move(figure, boardField);
//
//        //chess.printBoard();
//
//        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//        //chess.restart();
//        //chess.print();
//
//        chess.manualMove(figure,boardField);
//        chess.printBoard();
//        System.out.println("Notace");
        //chess.printNotation();
            //
            //testik
        //
        ///
        //
        //

        if(args.length != 1) {
            System.err.println("Dej si do Run->Edit Configuration->Program arguments -> ./input.txt)");
            System.exit(1);
        }

        //System.out.println(args[0]);

        chess.parseNonations(args[0]);
            //==============================================


    }
}
