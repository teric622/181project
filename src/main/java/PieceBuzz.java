/**
 * <h1>Lab5</h1>
 * <h2>CISC 181-012  2022 </h2>
 * <h3>University of Delaware</h3>
 * <p>
 * The Lab5() program implements an application that covers
 * the following topics: Refactoring Code to Creating object hierarchies, Creating and Extending Abstract Classes,
 * Overriding methods for polymorphism, Implementing pre-defined Object method toString,
 * Two-Dimensional Arrays with Reference Types
 * This  class will be a sub class from the super class piece which will
 * inheret propertites from in which polymorphism will take place
 *
 * @author  Eric Tlaseca, Ameer Abdelnasser,Tabetha Chubb
 * @since 2022-04-12
 */




public class PieceBuzz extends Piece implements Attacker{

    private int numAttacks;
    private int numTimesBeenAttacked;
    private boolean workingLaser;



    /**
     *  PieceBlueHen multiple parameter constructor that calls the super class’ constructor.
     *
     * @param symbol - char type parameter that represents the symbol
     * @param teamColor - string type that represents a teams color
     * @param numAttacks - int type that represents the number of attacks that have been used
     * @param numTimesBeenAttacked - int type that represents the number of times this piece has been attacked
     * @param workingLaser - boolean type that shows whether the PieceBuzz's lazer property is able to be used
     * @param hidden - boolean type that shows whether the PieceBuzz is hidden or not
     * @param original - boolean type that shows whether or not the PieceBuzz is original
     */
    public PieceBuzz(char symbol,
                     String teamColor,
                     int numAttacks,
                     int numTimesBeenAttacked,
                     boolean workingLaser,
                     boolean hidden,
                     boolean original) {
        super(symbol,teamColor,hidden,original);
        this.numAttacks = numAttacks;
        this.numTimesBeenAttacked = numTimesBeenAttacked;
        this.workingLaser = workingLaser;
    }


    /**
     * A no parameter constructor  calls the 7 parameter
     * constructor of this class and creates a default a PieceBuzz.
     */
    public PieceBuzz(){
        this('B',"- -",
                0,0,
                true, false, true);
    }

//getter
    public int getNumAttacks() {
        return numAttacks;
    }
    //getter
    public int getNumTimesBeenAttacked() {
        return numTimesBeenAttacked;
    }
    //getter
    public boolean canAttack(){
        return workingLaser;
    }
//setter
    public void setWorkingLaser(boolean workingLaser) {
        this.workingLaser = workingLaser;
    }
//setter
    public void setNumAttacks(int numAttacks)  {
        this.numAttacks = numAttacks;
    }

    /**
     * this method will update the amount of times
     * the pieceBuzz has been attacked, as soon as
     * the piece is attacked, its lazer stops working and is set to false
     */
    public void updateNumTimesBeenAttacked(){
        this.numTimesBeenAttacked += 1;
        this.workingLaser = false;
    }
    /**
     *utilizes the abstract piece method speak from piece class which will print go ud
     */
    public void speak(){
        System.out.println("To Infinity and Beyond!");
    }
    /**
     * validmovepath()
     * implements validMovePath method that was abstract in piece superclass
     *  as the PieceBuzz will have a diffrent path
     *   and properties, in which all the same parameter where
     * the same throughout, but used diffrently with diffrent out comes in each subclass
     */
    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        // You will implement this method in a later step
        // each Piece will have a different valid path
        return true;
    }

    /**
     * the piece buzz doe not hold the ability to spawn, this method assures
     * that the any instance of the  PiceBuzz
     * can never spawn as it is set to null as the super class holds
     * this as an abstract method
     * @return null
     */
    public Piece spawn(){
        return null;
    }
    /**
    the canSpawn() method sets the value of buzz spawning to false
     * @return null
     */
    public boolean canSpawn(){
        return false;
    }

    public boolean validAttackPath(int rowIndexAttacking, int columnIndexAttacking, int  rowIndexAttacked, int columnIndexAttacked){
        return true;
    }



}