/**
 * GameBoard class represents a 2D ArrayList of BoardPieces.
 * This holds a variable to represent the rows, and columns, and
 * produces the ArrayList of BoardPieces.
 * @author Tabetha Chubb, Eric Tlaseca, Ameer Abdelnasser
 * @since 2022-04-12
 **/
public class GameBoard{
    private int rows;
    private int columns;
    private BoardSquare[][] squares;
//write one for gameboard constructor
    public GameBoard(int row, int column){
        rows = row;
        columns = column;
        squares = new BoardSquare[row][column];
        setUpEmptyBoard();
    }
    public int getNumRows(){
        return squares.length;
    }
    public int getNumColumns(){
        return squares[0].length;
    }
    public BoardSquare[][] getSquares(){
        return squares;
    }
    /**
     * inBounds checks if the coordinates put in are within the bounds of the GameBoard piece.
     * The bounds being referred to within the GameBoard piece are the length of the rows and columns in the
     *  created ArrayList.
     * @param  rowIndex - int that refers to the row placement of the piece
     * @param  columnIndex - int that refers to the column placement of the piece
     * @return returns a boolean statement that indicates whether the index stated is in the range of the GameBoard piece
     *
     **/
    public boolean inBounds(int rowIndex, int columnIndex){
        //if the rows and columns currently existing are greater than one
        //and less than the total amount of rows and collumns then it is
        //within bounds of the gameboard and return true
        if (((rowIndex < rows) || (columnIndex < columns))&&
                ((rowIndex >=0 ) && (columnIndex >=0))){
            return true;
        } else {
            //otherwise its out of range
            return false;
        }
    }
    /**
     * setUpEmptyBoard is a method that creates a GameBoard object that contains an ArrayList of empty BoardSquare objects.
     * There are no parameters
     * @return void - creates an empty GameBoard with BoardSquare objects that alternate in color.
     **/
    private void setUpEmptyBoard(){
        //first iteration through the rows
        for (int i = 0; i<rows; i++){
            //iterate through the columns
            for (int j =0; j<columns; j++){
                //formation of a block on checker board if its modulo is
                //0 or 1, fill set block as blue
                if(((i%2 == 0) && (j%2 == 0)) || ((i%2 == 1) && (j%2 == 1))) {
                    squares[i][j] = new BoardSquare("blue");
                } else {
                    //otherwise will it black
                    squares[i][j] = new BoardSquare("black");
                }
            }
        }
    }
    /**
     * findRandomEmptySpace creates a method that finds a random spot within the bounds of the GameBoard object,
     * determine if it is empty and cycles until it finds the BoardSquare that is empty and returns it.
     * There are no parameters
     * @return BoardSquare object that is empty.
     **/
    public BoardSquare findRandomEmptySpace(){
        int row;
        int column;
        //loop that is not broken until a valid value is found
        while(true){
            row = (int)(Math.random()*rows);
            column = (int)(Math.random()*columns);

            if (squares[row][column].isEmpty()) {
                //end the loop when this line executes
                return squares[row][column];
            }
        }
    }
    /**
     * toString prints out the current GameBoard, representing the rows and columns of GameBoard pieces.
     * The literal representations of the spaces, including empty BoardSquares and filled BoardSquares.
     * There are no parameters
     * @return it prints a string literal representation of the GameBoard object.
     **/
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for(int col = 0; col < squares[0].length; col++){
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for(int row = 0; row < squares.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < squares[row].length; col++){
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }

}