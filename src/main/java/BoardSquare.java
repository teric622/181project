/**
 * BoardSquare class represents a space on a game board.
 * It uses a marker variable to indicate if it is empty,
 * a variable to represent what piece is in the BoardSquare space,
 * and has a color dedicated to it's piece.
 * This space can have Piece objects moved on and off of the space.
 * @author Tabetha Chubb, Eric Tlaseca, Ameer Abdelnasser
 * @since 2022-04-12
 **/
public class BoardSquare {
    private boolean empty;
    private Piece pieceInSquare;
    private String color;

    /**
     * constructor for boardsquare class
     * @param col  takes in a string for the color propert
     *             sets empty space to true
     */
    public BoardSquare(String col){
        color = col;
        empty = true;
    }

    public Piece getPiece(){
        return pieceInSquare;
    }
    public boolean isEmpty(){
        return empty;
    }
    public String getSquareColor(){
        return color;
    }

    public void setPiece(Piece gamePiece){
        pieceInSquare = gamePiece;
        empty = false;
    }
    /**
     * removePiece removes whatever piece is occupying the BoardSquare
     * it resets the space to empty
     * No parameters
     * @return Piece - represents the piece that is being removed
     **/
    public Piece removePiece(){
        Piece removedPiece;
        removedPiece = pieceInSquare;
        pieceInSquare = null;
        empty = true;
        return removedPiece;
    }
    /**
     * toString prints out a string literal represent the BoardSquare object
     * No parameters
     * @return void - instead prints out string literals with representations of
     *   BoardSquare item
     **/
    @Override
    public String toString(){
        if (pieceInSquare == null){
            //empty piece
            return "-------";
        }
        else {
            //returns piece in place
            return "-" + pieceInSquare.toString() + "-";
        }

    }
}