import java.util.Collections;

/**
 * <h1>Lab5</h1>
 * <h2>CISC 181-012  2022 </h2>
 * <h3>University of Delaware</h3>
 * <p>
 * The Lab5() program implements an application that covers
 * the following topics: Refactoring Code to Creating object hierarchies, Creating and Extending Abstract Classes,
 * Overriding methods for polymorphism, Implementing pre-defined Object method toString,
 * Two-Dimensional Arrays with Reference Types
 *
 * @author Ameer Abdelnasser, Eric Tlaseca - Morales, Tabetha Chubb
 * @since 2022-04-12
 */

public abstract class Game {
    protected GameBoard board;
    protected Team firstTeam;
    protected Team secondTeam;
    protected String turn;

    /**
     * This method creates a new Gameboard object and sets both teams pieces on the board
     * @param numRows - an int parameter that is taken in by the method and represents the number of rows for each board
     * @param numCol - an int parameter that is taken in by the method and represents the number
     *              columns for each board
     * @return - returns a new Gameboard with pieces on it from each team
     */


    public Game(int numRows, int numCol, Team firstTeam, Team secondTeam){
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.turn = firstTeam.getTeamColor();
        initializeGameBoard(numRows, numCol);

    }

    public GameBoard initializeGameBoard(int numRows, int numCol){
        board = new GameBoard(numRows, numCol);
        //for loop goes through each piece for team1, finds random empty spaces and places pieces on those spaces
        for (Piece pieceInTeam: firstTeam.getTeamPieces()){
            board.findRandomEmptySpace().setPiece(pieceInTeam);
        }
        //Same functionality as the for loop prior to this one except it executes the same process on
        //team 2 for their pieces
        for (Piece pieceInTeam: secondTeam.getTeamPieces()){
            board.findRandomEmptySpace().setPiece(pieceInTeam);
        }

        return board;
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

    /**
     *checks team that is entered as parameter, and sees if that team is supposed to have their turn
     * @param coolTeam - Team type that is entered and checked to see if it equals the current turn variable
     * @return - returns a boolean that says whether or not said team is supposed to have their turn
     */
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

    /**
     * Does not have any parameters or return anything.
     * The purpose of this method is to change which team gets to go.
     * In others words, changing who's turn it is.
     */
    public void changeTurn(){
        //if the turn of the first team has passed, then its
        //the seconds team turn, the one with a diffrent team color
        if (turn == firstTeam.getTeamColor()){
            turn = secondTeam.getTeamColor();
        }
        //otherwise its the firstteam turn
        else{
            turn = firstTeam.getTeamColor();
        }
    }

//lab7

    /*
    To your Game Class from Lab 5, add the following abstract methods:
isAWinner- that has no parameters and returns a boolean
getWinner – that has no parameters and returns a Team
isGameEnded – that has no parameters and returns a boolean
Modify the header of your class to allow for these abstract methods.
     */
    public abstract boolean isAWinner();
    public abstract Team getWinner();
    public abstract boolean isGameEnded();



    /**
     * updated toString method from lab instructions
     * @return - returns the updated toString method
     */
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