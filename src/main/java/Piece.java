
abstract public class Piece {
    protected char symbol;
    protected String teamColor;
    protected boolean hidden;
    protected boolean original;

    final public int MAX_NUM_ATTACKS = 3;

    Piece(char symbol,String teamColor,boolean hidden,boolean original ){
        this.symbol = symbol;
        this.teamColor = teamColor;
        this.hidden = hidden;
        this.original = original;
    }




    public char getSymbol() {
        return symbol;
    }
    public String getTeamColor() {
        return teamColor;
    }
    public boolean isHidden() {
            return hidden;
    }
    public boolean isOriginal() {
            return original;
        }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
    public void setOriginal(boolean original) {
        this.original = original;
    }

    public abstract void speak();


  //noting validMovePath

    abstract public Piece spawn();

    abstract public boolean canSpawn();

    abstract public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                          int toSquareRow, int toSquareCol);

    @Override
    public String toString(){
        return this.teamColor+ "--- " + this.teamColor;
    }

}


    //Override the toString method to Piece class that returns the teamColor
// followed by three dashes (---) a single space followed by the symbol.
       // Create a folder (can right click on the Piece class name/ select Generate/ select Test)
// for your JUnit Testing of your Piece classes. '
// Copy and paste the code from PieceTest.java class on Canvas.
// Please note that this test code only tests SOME aspects of your solution and NOT ALL of them.

