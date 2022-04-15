/**
 * <h1>Lab5</h1>
 * <h2>CISC 181-012  2022 </h2>
 * <h3>University of Delaware</h3>
 * <p>
 * The Lab5() program implements an application that covers
 * the following topics: Refactoring Code to Creating object hierarchies, Creating and Extending Abstract Classes,
 * Overriding methods for polymorphism, Implementing pre-defined Object method toString,
 * Two-Dimensional Arrays with Reference Types
 * The PIECE class will be a super class from which the other set pieces will
 * inheret propertites from in which polymorphism will take place
 *
 * @author  Eric Tlaseca, Ameer Abdelnasser,Tabetha Chubb
 * @since 2022-04-12
 */


abstract public class Piece {
    protected char symbol;
    protected String teamColor;
    protected boolean hidden;
    protected boolean original;

    //final public int MAX_NUM_ATTACKS = 3;

    /**
     * This will set as the constructor for the Piece class, with 4 parameters
     * @param symbol - char symbol of a set piece that they will hold
     * @param teamColor String - the color assigned to a certain piece to determine there team
     * @param hidden- boolean hidden, property to set if a piece is hidden
     * @param original- boolean original to set property if a piece is orignal
     */
    Piece(char symbol,String teamColor,boolean hidden,boolean original ){
        this.symbol = symbol;
        this.teamColor = teamColor;
        this.hidden = hidden;
        this.original = original;
    }



//getter for symbol
    public char getSymbol() {
        return symbol;
    }
    //getter for teamcolor
    public String getTeamColor() {
        return teamColor;
    }

    //getter for hidden property
    public boolean isHidden() {
            return hidden;
    }
    //getter for original property
    public boolean isOriginal() {
            return original;
        }

        // setter for symbol propertu
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    //setter for teamcolor property
    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }
// setter for hidden property
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
    //setter for original property
    public void setOriginal(boolean original) {
        this.original = original;
    }


    /**
     * All subclasses held a speak method,
     * this is abstract as they will all hold
     * diffrent values
     */
    abstract public void speak();


  //noting validMovePath
    /**
     * All subclasses held a spawn method,
     * this is abstract as they will all hold
     * diffrent values and properties
     */
    abstract public Piece spawn();
    /**
     * All subclasses held a canspawn method,
     * this is abstract as they will all hold
     * diffrent values and properties
     */

    abstract public boolean canSpawn();
    /**
     * All subclasses held a validMovePath method,
     * this is abstract as they will all hold
     * diffrent values and properties, in which all the same parameter where
     * the same throughout, but used diffrently with diffrent out comes in each subclass
     */

    abstract public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                          int toSquareRow, int toSquareCol);

    /**
     *  Override of toString method to Piece class.
     * @return  the teamColor
     *     followed by a single space followed by the symbol.
     */
    @Override
    public String toString(){
        return this.teamColor+ " " + this.symbol;
    }

}


