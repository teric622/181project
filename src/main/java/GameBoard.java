public class GameBoard{
    private int rows = 0;
    private int columns = 0;
    private BoardSquare[][] squares;

    public GameBoard(int row, int column){
        rows = row;
        columns = column;
        squares = new BoardSquare[row][column];
        //why can't resolve
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
    public boolean inBounds(int rowIndex, int columnIndex){
        //check the condition
        if (((rowIndex < rows) || (columnIndex < columns))&&
                ((rowIndex >=0 ) && (columnIndex >=0))){
            return true;
        } else {
            return false;
        }
    }
    private void setUpEmptyBoard(){
        for (int i = 0; i<rows; i++){
            for (int j =0; j<columns; j++){
                if(((i%2 == 0) && (j%2 == 0)) || ((i%2 == 1) && (j%2 == 1))) {
                    squares[i][j] = new BoardSquare("blue");
                } else {
                    squares[i][j] = new BoardSquare("black");
                }
            }
        }
    }
    public BoardSquare findRandomEmptySpace(){
        boolean flag = true;
        int row =0;
        int column=0;
        while(flag){
            row = (int)Math.random()*((rows-1)+1);
            column = (int)Math.random()*((columns-1)+1);
            if (squares[row][column].isEmpty()){
                flag = false;
            }
        }
        return squares[row][column];
    }
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