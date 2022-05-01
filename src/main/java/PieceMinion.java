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




public class PieceMinion extends Piece implements Recruiter{


    private int numRecruits;
    private int numTimesSpawned;

    public static int MAX_NUM_SPAWNED = 3;
    /**
     * constructor for Minion object, which calls super class constructor. Also it calls update hungry which sets the hungry boolean value
     * @param symbol - char type parameter that represents the symbol
     * @param teamColor - string type that represents a teams color
     * @param numRecruits - int type that represents the number of recruits
     * @param numTimesSpawned - int type that represents the number of times a PieceMinion has spawned
     * @param hidden - boolean type that shows whether the PieceMinion is hidden or not
     * @param original - boolean type that shows whether or not the PieceMinion is original
     */
    public PieceMinion(char symbol, String teamColor,
                       int numRecruits, int numTimesSpawned,
                       boolean hidden, boolean original) {
        super(symbol,teamColor,hidden,original);
        this.numRecruits = numRecruits;
        this.numTimesSpawned = numTimesSpawned;
    }
    /**
     * A no parameter constructor  calls the 7 parameter
     * constructor of this class and creates a default a PieceMinion.
     */
    public PieceMinion(){
        this('M',"- -",
                0,0,
                false,true);
    }

//getter
    public int getNumRecruits() {
        return numRecruits;
    }
    //getter
    public int getNumTimesSpawned() {
        return numTimesSpawned;
    }
//setter
    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
    }
//setter
    public void setTeamColor(String teamColor){
        this.teamColor = teamColor;
    }

    /**
     * this method will update the amount of times a set minion has spawned increasing by 1
     * @param numTimesSpawned - current value of times the minion has spawned
     */
    public void addNumTimesSpawned(int numTimesSpawned){
        this.numTimesSpawned+=1;
    }
    /**
     *utilizes the abstract piece method speak from piece class which will print Bello!
     */
    public void speak(){
        System.out.println("Bello!");
    }




    /**
     * validmovepath()
     * implements validMovePath method that was abstract in piece superclass
     *  as the PieceMinion will have a diffrent path
     *   and properties, in which all the same parameter where
     * the same throughout, but used diffrently with diffrent out comes in each subclass
     */
    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        // You will implement this method in a later step
        // each Piece will have a different valid path
        return true;
    }



//pieceminion1 was there originally

    /**
     * this method will be used to spawn aka obtain a new piece minion
     * that will allow a piece to spawn another of this kind, by creating a new object
     * with set properties to make the spawned one diffrent from the originsl
     * @return it will return a new hen objetc (a copy of the orignal diffrent values)
     */
    public PieceMinion spawn(){
        return new PieceMinion(Character.toLowerCase(this.symbol),
                this.teamColor,1,
                0,
                false,
                false);
    }

    /**
     the canSpawn() that determins of a minion can spawn
     * @return if it is origianl and if the numtimes spawned is less than the max amount allowed
     *  based if the criteria is meant will determin if set piece can spawn
     */

    public boolean canSpawn(){
        return original && numTimesSpawned < MAX_NUM_SPAWNED;
    }



    public boolean validRecruitPath(int rowIndexRecruiting, int columnIndexRecruiting, int  rowIndexRecruted, int columnIndexRecruted){
        return true;
    }



}