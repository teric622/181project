public class BoardSquare {
    private boolean empty;
    private Piece pieceInSquare;
    private String color;

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
    }

    public Piece removePiece(){
        Piece removedPiece;
        removedPiece = pieceInSquare;
        pieceInSquare = null;
        return pieceInSquare;
    }

    public String toString(){
        if (pieceInSquare == null){
            return "-------";
        }
        else {
            return "-" + pieceInSquare.toString() + "-";
        }

    }
}
