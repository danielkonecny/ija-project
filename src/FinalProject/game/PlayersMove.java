package FinalProject.game;

import FinalProject.common.NotationType;

public class PlayersMove {
    private OneMove white;
    private OneMove black;

    public PlayersMove(OneMove white, OneMove black){
        this.white = white;
        this.black = black;
    }

    public void setWhite(OneMove white){
        this.white = white;
    }

    public void setBlack(OneMove black){
        this.black = black;
    }

    public OneMove getBlack(){
        return this.black;
    }

    public OneMove getWhite(){
        return this.white;
    }
}
