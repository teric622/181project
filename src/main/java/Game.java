import java.util.Collections;

//UNFINISHED CODE, MAIN PROBLEM IS WITH initializeGameBoard METHOD
//Main question is, how many pieces should we add to the board for each team

public class Game {
    private GameBoard board;
    private Team firstTeam;
    private Team secondTeam;
    private String turn;

    public GameBoard initializeGameBoard(int numRows, int numCol){
        board = new GameBoard(numRows, numCol);
        for (Piece pieceInTeam: firstTeam.getTeamPieces()){
            board.findRandomEmptySpace().setPiece(pieceInTeam);
        }
        for (Piece pieceInTeam: secondTeam.getTeamPieces()){
            board.findRandomEmptySpace().setPiece(pieceInTeam);
        }

        return board;
    }

    public Game(int numRows, int numCol, Team firstTeam, Team secondTeam){
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.turn = firstTeam.getTeamColor();
        initializeGameBoard(numRows, numCol);

    }

    public GameBoard getGameBoard(){
        return board;
    }

    public Team getCurrentTeam(){
        if (turn == firstTeam.getTeamColor()){
            return firstTeam;
        }
        else{
            return secondTeam;
        }
    }

    public Team getOpponentTeam(){
        if (turn == firstTeam.getTeamColor()){
            return secondTeam;
        }
        else{
            return firstTeam;
        }
    }

    public boolean isTurn(Team coolTeam){
        if (this.turn == coolTeam.getTeamColor()){
            return true;
        }
        else{
            return false;
        }
    }


    public BoardSquare[][] getBoardSquares(){
        return board.getSquares();
    }

    public void changeTurn(){
        if (turn == firstTeam.getTeamColor()){
            turn = secondTeam.getTeamColor();
        }
        else{
            turn = firstTeam.getTeamColor();
        }
    }



    public String toString(){
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getGameBoard().toString())
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getCurrentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getOpponentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\nIt is Team " + getCurrentTeam().getTeamColor() + "'s turn\n");
        return retString.toString();
    }


}